
public class 트리 {

	static char[] tree = new char[] { '\0', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 0, 0, 'H', 'I' };

	public static void main(String[] args) {
//		preorder(1);
//		inorder(1);
		postorder(1);
	}

	// 전위순회
	// VLR
	static void preorder(int i) {

		if (tree.length <= i || tree[i] == 0) {
			return;
		}

		// 부모
		System.out.print(tree[i] + " ");
		// 왼쪽자식
		preorder(i * 2);
		// 왼쪽자식
		preorder(i * 2 + 1);
	}
	
	//중위 순회
	//LVR
	static void inorder(int i) {
		
		if (tree.length <= i || tree[i] == 0) {
			return;
		}
		// 왼쪽자식
		inorder(i * 2);
		// 부모
		System.out.print(tree[i] + " ");
		// 왼쪽자식
		inorder(i * 2 + 1);
	}
	
	
	//후위 순회
	//LRV
	static void postorder(int i) {
		
		if (tree.length <= i || tree[i] == 0) {
			return;
		}
		// 왼쪽자식
		postorder(i * 2);
		// 왼쪽자식
		postorder(i * 2 + 1);
		// 부모
		System.out.print(tree[i] + " ");
	}	
}
