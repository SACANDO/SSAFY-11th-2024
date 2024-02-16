package stack연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ17413 {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] chararr = br.readLine().toCharArray();
		int len = chararr.length;
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		
		
		for(int i=0; i<len; i++) {
			if (chararr[i]=='<') {
				while(i<len-1&&chararr[i]!='>') {
					sb.append(chararr[i++]);
				}
				sb.append(chararr[i]);
			} else if (chararr[i]==' ') {
				sb.append(' ');
			} else {
				while (i<len&&chararr[i]!=' '&&chararr[i]!='<') {
					stack.push(chararr[i++]);
				}
				while(!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				i--;
				
			}
		}
		System.out.println(sb);
	}
}
