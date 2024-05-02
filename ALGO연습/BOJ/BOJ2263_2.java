public class BOJ2263 {
	
	static int[] tree = {0,1,2,3,4,5,6,7,8};
	
	public static void main(String[] args) {
		
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


