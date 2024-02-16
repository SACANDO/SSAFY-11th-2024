import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 실습2 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			int n = Integer.parseInt(br.readLine());
			Node[] nodes = new Node[n+1];
			for(int i=0; i<n+1; i++) {
				nodes[i]=new Node();
			}
			
			for(int i=1; i<=n; i++) {
				String[] line = br.readLine().split(" ");
				if (line.length==4) {
					nodes[i].data = line[1];
					nodes[i].left= nodes[Integer.parseInt(line[2])];
					nodes[i].right= nodes[Integer.parseInt(line[3])];
					

				} else{
					nodes[i].data = line[1];
				} 
			}
			System.out.print("#"+t +" ");
			System.out.println(inorder(nodes[1]));
			for(int i=0; i<n+1; i++) {
				System.out.println(nodes[i]);
			}
			
			
		}
	}
	
	//LRV
	static int inorder(Node node) {
		if(node ==null) {
			return 0;
		}else if(node.data.equals("/")) {
			return inorder(node.left)/inorder(node.right);
		}else if(node.data.equals("*")) {
			return inorder(node.left)*inorder(node.right);
		}else if(node.data.equals("+")) {
			return inorder(node.left)+inorder(node.right);
		}else if(node.data.equals("-")) {
			return inorder(node.left)-inorder(node.right);
		}else {
			return Integer.parseInt(node.data);
		}
	}
}


//class Node {
//	String data;
//	Node left;
//	Node right;
//	
//	Node() {}
//	Node(String data) {
//		this.data = data;
//	}
//	@Override
//	public String toString() {
//		return "Node [data=" + data + ", left=" + left + ", right=" + right + "]";
//	}
//	
//	
//}
//
