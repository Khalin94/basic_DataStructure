package dataStructure_basic;

public class SimpleSinglyLinkedList {
	public static void main(String[] args) {
		Node node = new Node(1);
		node.append(2);
		node.append(3);
		node.append(4);
		node.print();
		node.delete(2);
		node.print();
		node.delete(1); //시작 노드(HEADER)를 지우지 못함!
		node.print();
		
		node.append(3);
		node.append(2);
		node.append(1);
		node.append(4);
		node.print();
//		node.deleteMiddleNode(node)
		node.deleteMiddleNode(node.get(4));
		node.print();
		node.deleteMiddleNode(node.get(2));
		node.print();
//		Node group = node.groupping(node.get(1), 5);
	}

}

class Node{
	int data;
	Node next;
	
	public Node(int data) {
		this.data = data;
	}
	
	//마지막에 data를 추가함
	void append(int data) {
		Node nodeEnd = new Node(data);
		Node node = this;
		while(node.next != null) {
			node = node.next;
		}
		node.next = nodeEnd;
	}
	
	void delete(int data) {
		Node node = this;
		while(node.next != null) {
			if(node.next.data == data) {
				node.next = node.next.next;
			}else {
				node = node.next;
			}
		}
	}
	
	void print() {
		Node node = this;
		while(node.next != null) {
			System.out.print(node.data + "->");
			node = node.next;
		}
		System.out.println(node.data);
	}
	
	boolean deleteMiddleNode(Node node) {
		if(node == null || node.next == null) {
			return false;
		}
		
		Node next = node.next;
		node.data = next.data;
		node.next = next.next;
		return true;
	}
	/*Node get(int data) {
		Node node = this;
		while(node.next != null) {
			if(node.next.data == data) {
				return node.next;
			}
			node = node.next;
		}
		return null;
	}*/
	
	Node get(int index) {
		Node node = this;
		int count = 0;
		while(node.next != null) {
			if(index == count) {
				return node.next;
			}
			count++;
			node = node.next;
		}
		return null;
	}
/*	
	Node groupping(Node node, int x) {
		Node head = node;
		Node tail = node;
		
		while(node != null) {
			if(node.data < x) {
				node.next = head;
				head = node;
			}else {
				tail.next = node;
				tail = node;
			}
			node = node.next;
		}
		
		tail.next = null;
		return head;
	} */
}
