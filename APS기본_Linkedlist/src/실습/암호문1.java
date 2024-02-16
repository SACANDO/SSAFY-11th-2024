package 실습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 암호문1 {
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
			String[] line_all = br.readLine().split("I ");
			
			
			
			for (int i = 1; i <= pn; i++) {
				String[] line = line_all[i].split(" ");
				for (int j = 0; j < Integer.parseInt(line[1]); j++) {
					list.add(j + Integer.parseInt(line[0]), line[2 + j]);
				}
			}
			
			System.out.print("#"+t+" ");
			list.printList(10);
			
		}

	}

}
//
//class Node {
//	String data;
//	Node link;
//
//	Node() {
//	}
//
//	Node(String data) {
//		this.data = data;
//	}
//}
//
//class SinglyLinkedList {
//	Node head;
//	int size;
//
//	SinglyLinkedList() {
//		head = new Node();
//	}
//
//	// 삽입
//	void addFirst(String data) {
//		Node newNode = new Node(data);
//
//		newNode.link = head.link;
//		head.link = newNode;
//		size++;
//
//	}
//
//	void addLast(String data) {
//		Node newNode = new Node(data);
//
//		Node curr = head;
//
//		while (curr.link != null) {
//			curr = curr.link;
//		}
//		curr.link = newNode;
//
//		size++;
//	}
//
//	// 중간삽입
//	void add(int idx, String data) {
//		if (idx < 0 || getSize() < idx) {
//			System.out.println("범위를 벗어났습니다");
//			return;
//		}
//
//		Node curr = head;
//		for (int i = 0; i < idx; i++) {
//			curr = curr.link;
//		}
//		Node newNode = new Node(data);
//
//		newNode.link = curr.link;
//		curr.link = newNode;
//
//		size++;
//	}
//
//	// 삭제
//	void remove(int idx) {
//		if (idx < 0 || getSize() <= idx) {
//			System.out.println("범위를 벗어났습니다");
//			return;
//		}
//
//		Node curr = head;
//		for (int i = 0; i < idx; i++) {
//			curr = curr.link;
//		}
//		curr.link = curr.link.link;
//		size--;
//	}
//
//	
//	//데이터 조회
//	void printList(int idx) {
//		Node curr = head.link;
//		for(int i=0; i<idx; i++) {
//			System.out.print(curr.data + " ");
//			curr = curr.link;
//		}
//		System.out.println();
//	}
//
//	int getSize() {
//		Node curr = head;
//		int size = 0;
//		while (curr.link != null) {
//			curr = curr.link;
//			size++;
//		}
//		return size;
//	}
//
//}
