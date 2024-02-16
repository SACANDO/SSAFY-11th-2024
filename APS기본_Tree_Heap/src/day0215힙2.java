import java.util.Scanner;

public class day0215힙2 {
	static int[] Heap;
	static int heapSize;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();

		for (int t = 1; t <= tc; t++) {
			
			System.out.print("#" + t + " ");
			int n = sc.nextInt();
			Heap = new int[n+1];
			heapSize=0;
			for (int i = 0; i < n; i++) {
				
				int k = sc.nextInt();
				switch (k) {
				case 1:
					int x = sc.nextInt();
					heapPush(x);
					break;

				case 2:

					if (heapSize==0) {
						System.out.print("-1 ");
					} else {
						System.out.print(heapPop() + " ");
					}
					break;
				}
			}
			System.out.println();
		}

	}

	static void heapPush(int data) {
		Heap[++heapSize] = data;

		int ch = heapSize;
		int p = heapSize / 2;

		while (p > 0 && Heap[ch] > Heap[p]) {
			swap(ch, p);

			ch = p;
			p = ch / 2;
		}
	}

	static void swap(int a, int b) {
		int tmp = Heap[a];
		Heap[a] = Heap[b];
		Heap[b] = tmp;
	}

	static int heapPop() {
		int pop = Heap[1];

		Heap[1] = Heap[heapSize--];

		int p = 1;
		int ch = p * 2;

		// ch가 존재할 때 까지 & 크면
		while ((ch <= heapSize && Heap[p] < Heap[ch]) || ch + 1 <= heapSize && Heap[p] < Heap[ch + 1]) {

			if (ch + 1 <= heapSize && Heap[ch] < Heap[ch + 1]) {
				ch++;
			}

			swap(p, ch);
			p = ch;
			ch = p * 2;
		}

		return pop;
	}
}
