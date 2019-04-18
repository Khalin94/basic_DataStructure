
public class SinglyLinkedListFindLastK {

	public static void main(String[] args) {
		Node node = new Node(1);
		node.append(2);
		node.append(3);
		node.append(4);
		node.print();
		Node nodek = kthToLast(node, 1);
		System.out.println("use totalCounter");
		System.out.println(nodek.data);

		System.out.println("--------------------");
		System.out.println("use Recursive");
		kthToLastRec(node, 2);
		System.out.println("--------------------");
		
		Reference r = new Reference();
		Node nodek1 =  kthToLastNodeRec(node, 3, r);
		System.out.println(nodek1.data);
		
		System.out.println("--------------------");
		System.out.println("use NodePointer");
		Node nodek2 = kthToLastNodePointer(node, 1);
		System.out.println(nodek2.data);
		
		
	}
	
	static Node kthToLast(Node first, int k){
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
	static int kthToLastRec(Node node, int k) {
		if(node == null) {
			return 0;
		}
		
		int count  = kthToLastRec(node.next, k) +1;
		if(count == k) {
			System.out.println(node.data);
		}
		return count;
	}
	private static Node kthToLastNodeRec(Node node, int k, Reference r) {

		if(node == null) {
			return null;
		}
		
		Node found = kthToLastNodeRec(node.next, k, r) ;
		r.count++;
		if(r.count == k) {
			return node;
		}
		return found;
	}
	
	static Node kthToLastNodePointer(Node first, int k) {
		Node node1 = first;
		Node node2 = first;;
		
		for(int i = 0; i < k; i++) {
			if(node1 == null) {
				return  null;
			}
			node1 = node1.next;
		}
		
		while(node1 != null) {
			node1 = node1.next;
			node2 = node2.next;
		}
		return node2;
	}

}
class Reference{
	int count;
}

class Node{
	int data;
	Node next = null;
	
	public Node(int data) {
		this.data = data;
	}
	
	void append(int data) {
		Node nodeEnd = new Node(data);
		Node node = this;
		while(node.next != null) {
			node = node.next;
		}
		node.next = nodeEnd;
	}
	
	void remove(int data) {
		Node node = this;
		while(node.next !=null) {
			if(node.next.data == data) {
				node.next = node.next.next;
			}
			node = node.next;
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
	
		
}

