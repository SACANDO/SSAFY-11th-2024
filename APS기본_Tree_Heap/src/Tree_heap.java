
public class Tree_heap {

	static int[] heap = new int[100];
	static int heapSize;

	public static void main(String[] args) {

		heapPush(55);
		heapPush(56);
		heapPush(54);
		heapPush(32);
		heapPush(1);
		heapPush(11);
		heapPush(50);

		System.out.println(heapPop());
		System.out.println(heapPop());
		System.out.println(heapPop());
		System.out.println(heapPop());
		System.out.println(heapPop());
		System.out.println(heapPop());

	}

	// 삽입
	static void heapPush(int data) {
		// 마지막 위치에 노드 추가
		heap[++heapSize] = data;

		// 부모와 비교하면서 swap
		int ch = heapSize;
		int p = heapSize / 2;

		// swap
		// p=0은 더미 노드이기 때문에 비교하지 않는다.
		while (p > 0 && heap[p] < heap[ch]) {
			swap(p,ch);

			ch = p;
			p = ch / 2;
		}

	}
	
	//swap
	static void swap(int a, int b) {
		int tmp = heap[a];
		heap[a] = heap[b];
		heap[b] = tmp;
	}

	// 삭제
	static int heapPop() {

		int popItem = heap[1];

		heap[1] = heap[heapSize--];

		int p = 1;
		int ch = p * 2;


		// 리프노드로 가면 자식이 없을 수도 있으니 ch가 heapSize 이하인지 확인
		while (ch <= heapSize && heap[p] < heap[ch]) {
			
			if (ch + 1 <= heapSize && heap[ch] < heap[ch + 1]) {
				ch++;
			}
			
			swap(p,ch);
			p = ch;
			ch = p * 2;

			
		}

		return popItem;
	}
}
