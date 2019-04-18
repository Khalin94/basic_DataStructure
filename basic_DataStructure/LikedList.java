 class LinkedList {
	Node header;
	
	class Node{
		int data;
		Node next = null;
	}	
	
	public LinkedList() {
		header = new Node();
	}
	
	public void append(int data) {
		Node nodeEnd = new Node();
		nodeEnd.data = data;
		Node node = header;
		while(node.next != null) {
			node = node.next;
		}
		node.next = nodeEnd;
	}
	
	public void remove(int data) {
		Node node = header;
		while(node.next != null) {
			if(node.next.data == data) {
				node.next = node.next.next;
			}
			node = node.next;
		}
	}
	
	public void print() {
		Node node = header.next;
		while(node.next != null) {
			System.out.print(node.data + "->");
			node = node.next;
		}
		System.out.println(node.data);
	}
	
	public void removeSameValue() {
		Node node = header;
		while(node != null && node.next != null) {
			Node runner = node;
			while(runner.next != null) {
				if(node.data == runner.next.data) {
					runner.next = runner.next.next;
				}else {
					runner = runner.next;
				}
			}
			node = node.next;
		}
	}
	
	public static Node kthToLast(Node first, int k ) {
		Node node = first;
		int total = 1;
		while(node.next != null) {
			total++;
			node = node.next;
		}
		node = first;
		
		for(int i = 1; i < total - k +1; i++) {
			node = node.next;
		}
		return node;
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.append(1);
		ll.append(2);
		ll.append(3);
		ll.append(4);
		ll.print();
		ll.remove(1);
		ll.remove(3);
		ll.print();
		System.out.println("-------------------");
		ll.append(1);
		ll.append(2);
		ll.append(3);
		ll.append(2);
		ll.append(4);
		ll.append(2);
		ll.append(5);
		ll.append(2);
		ll.print();
		ll.removeSameValue();
		ll.print();
		LinkedList ll2 = new LinkedList();
		ll2.append(2);
		ll2.append(2);
		ll2.append(2);
		ll2.print();
		ll2.removeSameValue();
		ll2.print();
		System.out.println(" header : " + ll2.header.data);
		System.out.println("---------------");
		LinkedList kthToLastLl = new LinkedList();
		kthToLastLl.append(1);
		kthToLastLl.append(2);
		kthToLastLl.append(3);
		kthToLastLl.append(4);
		kthToLastLl.append(5);
		kthToLastLl.print();
		System.out.println(kthToLast(kthToLastLl.header, 2).data);
		System.out.println("header " +kthToLastLl.header.data);
		

	}
}


