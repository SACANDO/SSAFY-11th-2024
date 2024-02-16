package 실습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 암호문2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			SinglyLinkedList list = new SinglyLinkedList();
			int n = Integer.parseInt(br.readLine());
			String[] line1 = br.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				list.addLast(line1[i]);
			}
			
			int pn = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int i=0; i<pn; i++) {
				String ID = st.nextToken();
				
				

				switch (ID) {
				case "I" :
					int idx = Integer.parseInt(st.nextToken());
					int n2 = Integer.parseInt(st.nextToken());
					
					for (int j=0; j<n2; j++) {

						list.add(idx+j, st.nextToken());
						
					}
					break;
				case "D" : 
					int idx2 = Integer.parseInt(st.nextToken());
					int n3 = Integer.parseInt(st.nextToken());
					
					for (int j=0; j<n3; j++) {

						list.remove(idx2);
						
					}
					break;
					
				case "A" :
					int n4 = Integer.parseInt(st.nextToken());
					for (int j=0; j<n4; j++) {

						list.addLast(st.nextToken());
						
					}
					break;
				}
			}
			
			System.out.print("#"+t+" ");
			list.printList(10);
			
		}

	}

}

class Node {
	String data;
	Node link;

	Node() {
	}

	Node(String data) {
		this.data = data;
	}
}

class SinglyLinkedList {
	Node head;
	int size;

	SinglyLinkedList() {
		head = new Node();
	}


	void addLast(String data) {
		Node newNode = new Node(data);

		Node curr = head;

		while (curr.link != null) {
			curr = curr.link;
		}
		curr.link = newNode;

		size++;
	}

	// 중간삽입
	void add(int idx, String data) {
		if (idx < 0 || size < idx) {
			System.out.println("범위를 벗어났습니다");
			return;
		}

		Node curr = head;
		for (int i = 0; i < idx; i++) {
			curr = curr.link;
		}
		Node newNode = new Node(data);

		newNode.link = curr.link;
		curr.link = newNode;

		size++;
	}

	// 삭제
	void remove(int idx) {
		if (idx < 0 || getSize() <= idx) {
			System.out.println("범위를 벗어났습니다");
			return;
		}

		Node curr = head;
		for (int i = 0; i < idx; i++) {
			curr = curr.link;
		}
		curr.link = curr.link.link;
		size--;
	}

	
	//데이터 조회
	void printList(int idx) {
		Node curr = head.link;
		for(int i=0; i<idx; i++) {
			System.out.print(curr.data + " ");
			curr = curr.link;
		}
		System.out.println();
	}

	int getSize() {
		Node curr = head;
		int size = 0;
		while (curr.link != null) {
			curr = curr.link;
			size++;
		}
		return size;
	}

}
