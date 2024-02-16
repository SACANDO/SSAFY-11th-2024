import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class 실습3 {
	static int cnt = 0;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			List<Node> list1 = new LinkedList<>();
			List<Node> list2 = new LinkedList<>();

			int n = sc.nextInt();
			Node[] nodes = new Node[n + 1];
			int line = sc.nextInt();

			int t1 = sc.nextInt();
			int t2 = sc.nextInt();

			for (int i = 1; i < n + 1; i++) {
				nodes[i] = new Node(i);
			}

			for (int i = 0; i < line; i++) {
				int parent = sc.nextInt();
				int child = sc.nextInt();

				if (nodes[parent].left == null) {
					nodes[parent].left = nodes[child];
				} else {
					nodes[parent].right = nodes[child];
				}
				nodes[child].parent = nodes[parent];
			}

			Node parent1 = nodes[t1];
			while (parent1 != null) {
				parent1 = findParent(parent1);
				if (parent1 == null) {
					break;
				}
				list1.add(parent1);
			}

			Node parent2 = nodes[t2];
			while (parent2 != null) {
				parent2 = findParent(parent2);
				if (parent2 == null) {
					break;
				}
				list2.add(parent2);
			}

			int ans = 0;
			boolean flag = false;
			for (int i = 0; i < list1.size(); i++) {
				if (flag) {
					break;
				}
				for (int j = 0; j < list2.size(); j++) {
					if (list1.get(i).data == list2.get(j).data) {
						ans = list1.get(i).data;
						flag = true;
						break;
					}
				}
			}
			cnt = 0;
			inorder(nodes[ans]);
			System.out.println("#" + t + " " + ans + " " + cnt);

		}

	}

	static Node findParent(Node node) {
		if (node.parent == null) {
			return null;
		}
		return node.parent;
	}

	static void inorder(Node node) {
		if (node == null) {
			return;
		}
		cnt++;
		inorder(node.left);
		inorder(node.right);
	}
}

class Node {
	int data;
	Node left;
	Node right;
	Node parent;

	Node() {
	}

	Node(int data) {
		this.data = data;
	}
}
