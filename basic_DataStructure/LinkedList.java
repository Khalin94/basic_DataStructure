package dataStructure_basic;

public class LinkedList {
	Node header;

	static class Node {
		Object data;
		Node next = null;
		
		Node(){
			
		}
		
		Node(Object data){
			this.data = data;
			next = null;
		}
	}

	LinkedList() {
		header = new Node();
	}

	public void append(Object data) {
		Node end = new Node();
		end.data = data;
		Node node = header;

		while (node.next != null) {
			node = node.next;
		}
		node.next = end;
	}
	void remove(Object data) {
		Node node = header;
		
		while(node.next != null) {
			if(node.next.data == data) {
				node.next = node.next.next;
			}
			node = node.next;
		}
	}

	void print() {
		Node node = header.next;
		while (node.next != null) {
			System.out.print(node.data + "->");
			node = node.next;
		}
		System.out.println(node.data);
	}

	Node node(int index) {
		Node node = header;
		
		for(int i = 0; i < index; i++) {
			node = node.next;
		}
		return node;
	}
	 Node get(int index) {
	 Node node = node(index);
	 return node;
	/*
	 * Node node = header; int count = 0;
	 * 
	 * while (node.next != null) { count++; if (count == index) { return node.next;
	 * } node = node.next; } return node;
	 */
	 }
	 
	 static boolean palindrome(Node head) {
		 Node reverse = reverseAndClone(head);
		 return isEquals(head, reverse);
		 
	 }
	 
	 static Node reverseAndClone(Node node) {
		Node head = null;
		while(node.next != null) {
			Node n = new Node(node.data);
			n.next = head;
			head = n;
			node = node.next;
		}
		return head;
	 }
	 
	 static boolean isEquals(Node n1, Node n2) {
		while(n1 != null && n2!= null) {
			if(n1.data != n2.data) {
				return false;
			}
			n1 = n1.next;
			n2 = n2.next;
		}
		return n1 == null && n2 == null;
	 }

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.append(5);
		ll.append(3);
		ll.append(4);
		ll.append(2);
		ll.print();
		ll.remove(3);
		ll.print();
		System.out.println(ll.node(2).data);
		// System.out.println(ll.get(6).data);
		System.out.println(ll.get(1));
		System.out.println("--------------");
		LinkedList ll1 = new LinkedList();
		ll1.append("a");
		ll1.append("b");
		ll1.append("c");
		ll1.append("b");
		ll1.append("a");
		ll1.print();
		System.out.println(palindrome(ll1.get(1)));
		System.out.println(ll1.get(1).data);
	}
}
