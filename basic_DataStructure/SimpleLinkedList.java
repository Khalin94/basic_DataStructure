package dataStructure_basic;

public class SimpleLinkedList {
	Node header;

	static class Node {
		int data;
		Node next = null;
	}

	public SimpleLinkedList() {
		header = new Node();
	}

	public void append(int data) {
		Node nodeEnd = new Node();
		nodeEnd.data = data;
		Node node = header;
		while (node.next != null) {
			node = node.next;
		}
		node.next = nodeEnd;
	}

	public void remove(int data) {
		Node node = header;
		while (node.next != null) {
			if (node.next.data == data) {
				node.next = node.next.next;
			}
			node = node.next;
		}
	}

	public void print() {
		Node node = header.next;
		while (node.next != null) {
			System.out.print(node.data + "->");
			node = node.next;
		}
		System.out.println(node.data);
	}

	public void removeSameValue() {
		Node node = header;
		while (node != null && node.next != null) {
			Node runner = node;
			while (runner.next != null) {
				if (node.data == runner.next.data) {
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}
			node = node.next;
		}
	}
	public static Node sumLists(Node ll1, Node ll2, int carry) {
			if(ll1 == null && ll2 == null && carry == 0 ) {
				return null;
			}
			
			Node result = new Node();
			int value = carry;
			
			if(ll1 != null) {
				value += ll1.data;
			}
			if(ll2 != null) {
				value += ll2.data;
			}
			result.data = value % 10;
			
			if(ll1 != null || ll2 != null) {
				Node next = sumLists(ll1 == null ? null : ll1.next, ll2 == null ? null : ll2.next,
									 value >= 10 ? 1 : 0);
				result.next = next;
			}
			return result;
			
		}

	/*Node get(int data) {
		Node node = header;
		while (node.next != null) {
			if (node.next.data == data) {
				node = node.next;
				return node;
			}
			node = node.next;
		}
		return null;
	}*/
	
	Node get(int index) {
		Node node = header;
		int count = 0;
		while(node.next != null) {
			if(count == index) {
				return node;
			}
			count++;
			node = node.next;
		}
		return node;
	}

	public static Node kthToLast(Node first, int k) {
		Node node = first;
		int total = 1;
		while (node.next != null) {
			total++;
			node = node.next;
		}
		node = first;

		for (int i = 1; i < total - k + 1; i++) {
			node = node.next;
		}
		return node;
	}

	// deleteMiddleNode()
	// 중간에 있는 노드를 삭제함
	// 첫번째 노드와 마지막 노드는 삭제 불가!
	// (첫번째 노드가 어디있는지 모른다고 가정할 때)
	boolean deleteMidleNode(Node node) {
		if(node == null || node.next == null) {
			return false;
		}
		
		Node next = node.next;
		node.data = next.data;
		node.next = next.next;
		
		return true;
	}
	Node groupping(Node node, int x) {
		Node head = node;
		Node tail = node;
		
		while(node != null) {
			Node next = node.next;
			if(node.data < x) {
				node.next = head;
				head = node;
			}else {
				tail.next = node;
				tail = node;
			}
			node = next;
		}
		tail.next = null;
		
		return head;
	}

	public static void main(String[] args) {
		SimpleLinkedList ll = new SimpleLinkedList();
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
		SimpleLinkedList ll2 = new SimpleLinkedList();
		ll2.append(2);
		ll2.append(2);
		ll2.append(2);
		ll2.print();
		ll2.removeSameValue();
		ll2.print();
		System.out.println(" header : " + ll2.header.data);
		System.out.println("---------------");
		SimpleLinkedList kthToLastLl = new SimpleLinkedList();
		kthToLastLl.append(1);
		kthToLastLl.append(2);
		kthToLastLl.append(3);
		kthToLastLl.append(4);
		kthToLastLl.append(5);
		kthToLastLl.print();
		System.out.println(kthToLast(kthToLastLl.header, 2).data);
		System.out.println("header " + kthToLastLl.header.data);
		System.out.println("---------------");
		SimpleLinkedList ll3 = new SimpleLinkedList();
		ll3.append(5);
		ll3.append(7);
		ll3.append(3);
		ll3.append(1);
		ll3.append(4);
		ll3.print();
		System.out.println(ll3.get(4).data);
		
		SimpleLinkedList l1 = new SimpleLinkedList();
		l1.append(9);
		l1.append(1);
		l1.append(4);
		l1.print();
//		System.out.println(l1.get(1).data);
		SimpleLinkedList l2 = new SimpleLinkedList();
		l2.append(6);
		l2.append(4);
		l2.append(9);
		l2.append(7);
		l2.print();
		System.out.println("---------------");
		Node n = sumLists(l1.get(1), l2.get(1), 0);
		while(n.next != null) {
			System.out.print(n.data + "->");
			n = n.next;
		}
		System.out.println(n.data);
	}
}
