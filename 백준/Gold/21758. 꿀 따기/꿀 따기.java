import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer str;
    static int n;
    static int[] arr;
    static int[] asc;
    static int[] desc;
    static int[][] dp;

    public static void printarr(int[] arr, int n) {
        for (int i = 0 ; i < n; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.print("\n");

    }


    public static void print2darr(int[][] arr, int n, int m) {
        for (int i = 0 ; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(buffer.readLine());
        arr = new int[n];
        asc = new int[n];
        desc = new int[n];

        int result = 0;
       str = new StringTokenizer(buffer.readLine());

       for (int i = 0 ; i < n ; i++){
        arr[i] = Integer.parseInt(str.nextToken());
       }
       
       asc[0] = arr[0];
       desc[n-1] = arr[n-1];

       for (int i = 1; i < n; i++) {
        asc[i] = asc[i-1] + arr[i];
       }

       
       for (int i = n-2; i > -1; i--) {
        desc[i] = desc[i+1] + arr[i];
       }

       for (int i = 1 ; i < n-1; i++){
            result = Math.max(result, desc[0] - arr[n-1] - arr[i] + asc[i-1]);
       }     

       for (int i = 1 ; i < n-1; i++){
            result = Math.max(result, asc[n-1] - arr[0] - arr[i] + desc[i+1]);
       }     
       
       for (int i = 1 ; i < n-1 ; i++) {
            result = Math.max(result, asc[i] - arr[0] + desc[i] - arr[n-1]);
       }    


      System.out.println(result);
    }

}
