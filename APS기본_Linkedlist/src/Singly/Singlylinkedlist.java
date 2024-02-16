package Singly;

public class Singlylinkedlist {
	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		
		list.addFirst("1");
		list.addLast("2");
		list.addFirst("3");
		
		list.printList();
		
		list.remove(1);
		
		list.printList();
	}
}


class Node {
	String data;
	Node link;
	
	Node() {}
	Node(String data){
		this.data = data;
	}
}

class SinglyLinkedList {
	Node head;
	int size;

	SinglyLinkedList() {
		head = new Node();
	}

	//삽입
	void addFirst(String data) {
		Node newNode = new Node(data);
		
		newNode.link = head.link;
		head.link = newNode;
		size++;
		
	}
	void addLast(String data) {
		Node newNode = new Node(data);
		
		Node curr = head;
		
		while(curr.link != null) {
			curr = curr.link;
		}
		curr.link = newNode;
		
		size++;
	}
	
	//중간삽입
	void add(int idx, String data) {
		if (idx<0 || getSize() <idx) {
			System.out.println("범위를 벗어났습니다");
			return;
		}
		
		Node curr = head;
		for(int i =0; i<idx; i++) {
			curr = curr.link;
		}
		Node newNode = new Node(data);
		
		newNode.link=curr.link;
		curr.link=newNode;	
		
		size++;
	}

	//삭제
	void remove(int idx) {
		if (idx<0 || getSize() <= idx) {
			System.out.println("범위를 벗어났습니다");
			return;
		}
		
		Node curr = head;
		for(int i =0; i<idx; i++) {
			curr = curr.link;
		}
		curr.link=curr.link.link;
		size--;
	}
	
	
	//조회
	
	//모든 데이터 조회
	void printList() {
		Node curr = head.link;
		while (curr!=null) {
			System.out.println(curr.data + " ->");
			curr = curr.link;
		}
		System.out.println();
	}

	int getSize() {
		Node curr = head;
		int size =0;
		while(curr.link != null) {
			curr = curr.link;
			size++;
		}
		return size;
	}

}

