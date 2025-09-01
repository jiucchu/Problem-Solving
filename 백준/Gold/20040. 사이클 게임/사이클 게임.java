import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer str;
	
	static int n, m;
	static int parent[];
	
	static void printParent() {
		System.out.println("==========");
		for (int i = 0 ; i < n ; i++) {
			System.out.println(i + ": " + parent[i]);
		}
		System.out.println("==========");

	}
	
	static int find(int x) {
		
		if (parent[x] != x) {
			parent[x] = find(parent[x]);
		}
		
		return parent[x];
	}
	
	// 사이클 발생 여부 및 유니온 실행 함수
	static boolean union(int x, int y) {
		
		x = find(x);
		y = find(y);
		
		// 이미 유니온이 되어있다면 false 리턴 -> (사이클 발생으로 유니온 실패)
		if(x==y) {
			return false;
		}
		
		// 아니라면 둘을 union 해준다.
		if (x >= y) {
			parent[y] = x;
		} else {
			parent[x] = y;
		}
		
//		printParent();
		return true;
	}
	
	
	public static void main(String[] args) throws IOException{
		str = new StringTokenizer(buffer.readLine());
		n = Integer.parseInt(str.nextToken());
		m = Integer.parseInt(str.nextToken());
		
		// 문제 핵심
		// 이미 union이 되어있는데 또 union 시키면 -> 사이클 발생
		
		parent = new int[n];
		for (int i = 0 ; i < n ; i++) {parent[i] = i;}
		
		int answer = 0;
		
		for (int i = 0 ; i < m ; i++) {
			str = new StringTokenizer(buffer.readLine());
			int s = Integer.parseInt(str.nextToken());
			int e = Integer.parseInt(str.nextToken());
			
			// 사이클 발생 이후에도 입력은 받을 수 있도록 처리
			if (answer != 0) {
				continue;
			}
						
			if (!union(s, e)) {
				// 유니온 실패 == 사이클 발생 -> answer을 현재 값으로 갱신
				answer = i+1;
			} 
			
		}
		
		System.out.println(answer);

	}

}
