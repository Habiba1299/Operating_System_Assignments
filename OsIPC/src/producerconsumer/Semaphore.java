package producerconsumer;

public class Semaphore {

    private int initialValue = 0;
    private int bound = 0;
    private String name = null;

    public Semaphore(int initialValue,int upperBound,String name){
        this.bound = upperBound;
        this.initialValue = initialValue;
        this.name = name;
    }

    public synchronized void up () throws InterruptedException{
        while (this.initialValue == bound){
            System.out.println(Thread.currentThread().getName()+" is waiting up for " + name +":");
            wait();
        }
        this.initialValue++;
        System.out.println(Thread.currentThread().getName()+" performed up for " + name +":");
        this.notify();
    }

    public synchronized void down () throws InterruptedException{
        while (this.initialValue == 0){
            System.out.println(Thread.currentThread().getName()+" is waiting in down " + name +":");
            wait();
        }
        this.initialValue--;
        System.out.println(Thread.currentThread().getName()+" performed down for " + name +":");
        this.notify();
    }
}
