package dataStructure_basic;

public class SinglyLinkedListLastk {

	public static void main(String[] args) {
		Nodek node = new Nodek(1);
		node.append(2);
		node.append(3);
		node.append(4);
		node.print();
		Nodek nodek = kthToLast(node, 1);
		System.out.println("use totalCounter");
		System.out.println(nodek.data);

		System.out.println("--------------------");
		System.out.println("use Recursive");
		kthToLastRec(node, 2);
		System.out.println("--------------------");
		
		Reference r = new Reference();
		Nodek nodek1 =  kthToLastNodeRec(node, 3, r);
		System.out.println(nodek1.data);
		
		System.out.println("--------------------");
		System.out.println("use NodePointer");
		Nodek nodek2 = kthToLastNodePointer(node, 1);
		System.out.println(nodek2.data);
		
		
	}
	
	static Nodek kthToLast(Nodek first, int k){
		Nodek node = first;
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
	static int kthToLastRec(Nodek node, int k) {
		if(node == null) {
			return 0;
		}
		
		int count  = kthToLastRec(node.next, k) +1;
		if(count == k) {
			System.out.println(node.data);
		}
		return count;
	}
	private static Nodek kthToLastNodeRec(Nodek node, int k, Reference r) {

		if(node == null) {
			return null;
		}
		
		Nodek found = kthToLastNodeRec(node.next, k, r) ;
		r.count++;
		if(r.count == k) {
			return node;
		}
		return found;
	}
	
	static Nodek kthToLastNodePointer(Nodek first, int k) {
		Nodek node1 = first;
		Nodek node2 = first;;
		
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

class Nodek{
	int data;
	Nodek next = null;
	
	public Nodek(int data) {
		this.data = data;
	}
	
	void append(int data) {
		Nodek nodeEnd = new Nodek(data);
		Nodek node = this;
		while(node.next != null) {
			node = node.next;
		}
		node.next = nodeEnd;
	}
	
	void remove(int data) {
		Nodek node = this;
		while(node.next !=null) {
			if(node.next.data == data) {
				node.next = node.next.next;
			}
			node = node.next;
		}
	}
	
	void print() {
		Nodek node = this;
		while(node.next != null) {
			System.out.print(node.data + "->");
			node = node.next;
		}
		System.out.println(node.data);
	}
	
		
}
