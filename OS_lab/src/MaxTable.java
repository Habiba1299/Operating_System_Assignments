import java.util.*;

class MaxTable {

    static int maxOccupied(double a[],double d[],int n)
    {

        int occupied = 1,max_occupied = 1;
        int i =1,j = 0;

        while (i < n && j < n) {
            if (a[i] < d[j]) {
                occupied++;
                i++;
            }
            else if (a[i] == d[j]) {
                i++;
                j++;
            }
            else if (a[i] > d[j]) {
                occupied--;
                j++;
            }
            if (occupied > max_occupied)
                max_occupied = occupied;
        }

        return max_occupied;
    }


    public static void main(String[] args)
    {
        double arrival[] = {2.00, 2.10, 3.00, 3.20, 3.50, 5.00};
        double deperture[] = {2.30, 3.40, 3.20, 4.30, 4.00, 5.20};
        int n = arrival.length;

        Arrays.sort(arrival);
        Arrays.sort(deperture);

        int res = maxOccupied(arrival,deperture,n);
        System.out.println(res);
    }
}
