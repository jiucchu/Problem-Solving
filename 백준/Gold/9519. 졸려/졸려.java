import java.io.*;
import java.util.*;

class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<Character> arr = new ArrayList<>();
    static Stack<Character> stack = new Stack<>();
    static ArrayList<Character> ecarr = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(buffer.readLine());
        char[] carr = buffer.readLine().toCharArray();
        for (int i = 0 ; i < carr.length ; i++) {
            arr.add(carr[i]);
            ecarr.add(carr[i]);
        }
        
        int l = 1;

        while(true){
            ArrayList<Character> tempList = new ArrayList<>();

            for (int i = 0 ; i < arr.size() ; i++) {
                if (i % 2 == 0) {
                    tempList.add(arr.get(i));
                } else {
                    stack.add(arr.get(i));
                }
            }

            while(!stack.isEmpty()) {
                tempList.add(stack.pop());
            }

            if (ecarr.equals(tempList)){
                break;
            }
            arr = new ArrayList<>(tempList);
            l++;
        }

        for (int i = 0 ; i < n % l + 1 ; i++) {
             ArrayList<Character> tempList = new ArrayList<>();

            for (int j = 0 ; j < arr.size() ; j++) {
                if (j % 2 == 0) {
                    tempList.add(arr.get(j));
                } else {
                    stack.add(arr.get(j));
                }
            }

            while(!stack.isEmpty()) {
                tempList.add(stack.pop());
            }

            arr = new ArrayList<>(tempList);
        }
        

        StringBuilder sb = new StringBuilder();
        for (Character c : arr) {
            sb.append(c);
        }
        System.out.println(sb.toString());
    }
}