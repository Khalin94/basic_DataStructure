package dataStructure_basic;

public class Groupping {
	
	public static void main(String[] args) {
		SimpleLinkedList ll = new SimpleLinkedList();
		ll.append(7);
		ll.append(2);
		ll.append(8);
		ll.append(5);
		ll.append(3);
		ll.append(4);
		ll.print();
		dataStructure_basic.SimpleLinkedList.Node node = ll.groupping(ll.get(1), 5);
		while(node.next != null) {
			System.out.print(node.data + "->");
			node = node.next;
		}
		System.out.println(node.data);
		
	}
	
	/*static Node groupping(Node node, int x) {
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
	}*/

}
