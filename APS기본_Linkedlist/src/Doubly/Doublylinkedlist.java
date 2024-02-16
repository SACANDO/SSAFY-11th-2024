package Doubly;

public class Doublylinkedlist {
	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();
		
	}
}

class Node {
	String data;
	Node prev;
	Node next;
	
	Node() {
		
	}
	Node(String data){
		this.data = data;
	}
	
}

class DoublyLinkedList {
	Node head;
	Node tail;
	int size;
	
	DoublyLinkedList() {
		head = new Node();
		tail = new Node();
		head.next = tail;
		tail.prev = head;
	}
	
	void addLast(String data) {
		
		Node newNode = new Node(data);
	
		newNode.next = tail;
		newNode.prev = tail.prev;
		
		newNode.next.prev = newNode;
		newNode.prev.next = newNode;
		
		size++;
	}
	
	void remove(int idx) {
		if(!(0 <= idx && idx < size)) { 
			System.out.println("삭제할 수 없는 범위입니다.");
			return;
		}
		
		Node rmNode = head.next;
		
		for (int i=0; i<idx; i++) {
			rmNode = rmNode.next;
		}
		
		rmNode.prev.next = rmNode.next;
		rmNode.next.prev = rmNode.prev;
		
		size--;
		
		
	}
}