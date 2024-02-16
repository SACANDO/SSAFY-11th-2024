import java.util.Scanner;

public class 연습문제 {
	
	static Node[] nodes = new Node[14];
	static int[] count = new int[14];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int i=1; i<14; i++) {
			nodes[i] = new Node();
			nodes[i].data = i;
		}
		
		int V = sc.nextInt();
		for( int i=0; i<V-1; i++) {
			int parent = sc.nextInt();
			int child = sc.nextInt();
			
			count[child]++;
			
			if(nodes[parent].left ==null) {
			nodes[parent].left = nodes[child];
			} else {
				nodes[parent].right = nodes[child];
			}
		}
		
		int root = -1;
		for (int i=1; i<14; i++) {
			if (count[i] == 0) {
				root=i;
				break;
			}
		}
		preorder(nodes[root]);
		
	}
	static void preorder(Node node) {
		if(node ==null) {
			return;
		}
		
		System.out.println(node.data);
		preorder(node.left);
		preorder(node.right);
	}
}



//class Node {
//	int data;
//	Node left;
//	Node right;
//	
//	Node() {}
//	Node(int data) {
//		this.data = data;
//	}
//}
