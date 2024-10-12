import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;


class Process{

    int arrivalTime,duration,time ;
    String name ;


    public Process(String name,int duration, int arrivalTime,int time){
        this.name = name ;
        this.arrivalTime = arrivalTime ;
        this.duration = duration ;
        this.time = time;

    }



}





class Sort implements Comparator<Process> {

    public int compare(Process a,Process b)
    {
        return a.time- b.time;
    }
}

class FCFS {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);



        ArrayList<Process> pr = new ArrayList<Process>();

            int globalTime = 0;
            int serial =1;



            for (int i = 0; i < 4; i++) {
                System.out.println("name:");
                String name = sc.next();
                System.out.println("duration:");
                int duration = sc.nextInt();
                System.out.println("arrival time:");
                int arrivalTime = sc.nextInt();
                int time = duration + arrivalTime ;
                pr.add(new Process( name, duration, arrivalTime,time));
            }

            Collections.sort(pr, new Sort());




            Iterator itr=pr.iterator();

            String [] pArr = new String [20];

            while(itr.hasNext()){

                Process pt=(Process) itr.next();
                if( serial == 1) {
                    System.out.println("  "+serial + "  " + pt.name+ "  " + globalTime + "-" + pt.duration + "   "+ pt.duration);
                    globalTime = globalTime + pt.duration;
                    pArr[serial-1] = pt.name;
                }
                else {
                    int turnaround = globalTime + pt.duration - pt.arrivalTime;
                    int timeline = globalTime + pt.duration;
                    System.out.println("  "+serial + "  " + pt.name+ "  "+ globalTime + "-" + timeline+ "  " + turnaround);
                    globalTime = globalTime + pt.duration;
                    pArr[serial-1] = pt.name;
                }

                serial++ ;
            }

            for (int i = 0; i < 4; i++) {
                if (i == 3)
                    System.out.println(pArr[i]);
                else
                    System.out.print(pArr[i] + "->");
            }



    }
}
