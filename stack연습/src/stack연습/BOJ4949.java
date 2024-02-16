package stack연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BOJ4949 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Map<Character, Character> map = new HashMap<>();
		map.put('(', ')');
		map.put('[', ']');
		
		while(true) {
			Stack<Character> stack = new Stack<>();
			char[] line = br.readLine().toCharArray();
			int len = line.length;
			if(len==1&&line[0]=='.') {
				break;
			}
			boolean flag = true;
			for(int i=0; i<len; i++) {
				if(line[i]=='('|| line[i]=='[') {
					stack.push(line[i]);
				} else if(line[i]==']'||line[i]==')'){
					if(stack.isEmpty()) {
						flag=false;
						break;
					} else if(line[i]==map.get(stack.peek())){
						stack.pop();
					} else {

						break;
					}
				} 
				
			}
			if(stack.isEmpty()&&flag) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}

	}
}
