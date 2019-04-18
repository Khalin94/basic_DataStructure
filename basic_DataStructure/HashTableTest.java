package arraysAndStrings;

import java.util.LinkedList;

class HashTable{
	class Node{
		String key;
		String value;
		
		Node(String key, String value){
			this.key = key;
			this.value = value;
		}
		
		String value() {
			return value;
		}
		void value(String value) {
			this.value = value;
		}
	}
	LinkedList<Node>[] data;
	
	@SuppressWarnings("unchecked")
	HashTable(int size){
		this.data = new LinkedList[size];
	}
	
	int getHashcode(String key) {
		int hashcode = 0;
		
		for(char ch : key.toCharArray()) {
			hashcode += ch;
		}
		
		return hashcode;
	}
	
	int convertToIndex(int hashcode) {
		return hashcode % data.length;
	}
	
	Node searchKey(LinkedList<Node> list, String key) {
		if(list == null) {
			return null;
		}
		for(Node node : list) {
			if(node.key.equals(key)) {
				return node;
			}
		}
		return null;
	}
	
	void put(String key, String value) {
		int hashcode  = getHashcode(key);
		int index = convertToIndex(hashcode);
		System.out.println("key : " + key + " hashcode : " + hashcode + " index : " + index);
		LinkedList<Node> list = data[index];
		if(list == null) {
			list = new LinkedList<>();
			data[index] = list;
		}
		
		Node node = searchKey(list, key);
		if(node == null) {
			list.addLast(new Node(key, value));
		}else {
			node.value(value);
		}
	}
	
	String get(String key) {
		int hashcode = getHashcode(key);
		int index = convertToIndex(hashcode);
		LinkedList<Node> list = data[index];
		Node node = searchKey(list, key);
		return node == null ? "not found" : node.value;
	}
	
}

public class HashTableTest {
	
	public static void main(String[] args) {
		HashTable h = new HashTable(3);
		
		h.put("jack", "sparrow");
		h.put("turner", "jack's friends");
		h.put("actor", "hollywood");
		h.put("jack", "pirate");
		
		System.out.println(h.get("jack"));
		System.out.println(h.get("turner"));
		System.out.println(h.get("actor"));
		System.out.println(h.get("abc"));
	}

}
