package dataStructure_basic;

public class DeleteMiddleNode {
	
	public static void main(String[] args) {
		SimpleLinkedList ll = new SimpleLinkedList();
		ll.append(1);
		ll.append(2);
		ll.append(3);
		ll.append(4);
		ll.print();
		//System.out.println(ll.get(1));
		//deleteMidleNode(ll.get(3));
		ll.deleteMidleNode(ll.get(2));
		ll.print();
	}
	// 중간에 있는 노드를 삭제함
	// 첫번째 노드와 마지막 노드는 삭제 불가!
	// (첫번째 노드가 어디있는지 모른다고 가정할 때)
	 /*static boolean deleteMidleNode(Node node) {
		if(node == null || node.next == null) {
			return false;
		}
		
		Node next = node.next;
		node.data = next.data;
		node.next = next.next;
		
		return true;
	}*/

}
