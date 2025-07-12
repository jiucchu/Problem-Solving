import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer str;
  static int n;
  static int k;
  static long answer;
  static int[] list;

  public static void main(String[] args) throws IOException{
    str = new StringTokenizer(buffer.readLine());
    n = Integer.parseInt(str.nextToken());
    k = Integer.parseInt(str.nextToken());

    list = new int[n];
    answer = 0;
    long min = Integer.MAX_VALUE;
    long max = Integer.MAX_VALUE;


    for (int i = 0; i < n ; i++) {
      list[i] = Integer.parseInt(buffer.readLine());
      min = Math.min(min, list[i]);
    }

    while (min <= max) {
      long mid = (min+max) / 2;
      long sum = 0;

      for (int i = 0 ; i < n ; i++) {
        if (mid>=list[i]) {
          sum += mid-list[i];
        }
      }

      if (sum <= k) {
        answer = Math.max(answer, mid);
        min = mid + 1;
      } else {
        max = mid - 1;
      }

    }

    System.out.println(answer);
    // for (int i = 0 ; i < n ; i++) {
    //   System.out.print(list[i] +" ");
    // }

  }
}