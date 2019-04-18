package arraysAndStrings;

class ArrayList{
	private Object[] data;
	private int size;
	private int index;
	
	ArrayList(){
		this.size = 1;
		this.data = new Object[this.size];
		this.index = 0;
	}
	
	public void add(Object data) {
		System.out.println("------add------------");
		System.out.println("data size : " + this.data.length + " size : " + size + " index : " + index);
		if(this.index == this.size-1) {
			doubling();
		}
		this.data[this.index] =  data;
		this.index++;
	}
	
	private void doubling() {
		this.size = this.size * 2;
		Object[] newData = new Object[this.size];
		for(int i =0; i <data.length; i++) {
			newData[i] = this.data[i];
		}
		
		this.data = newData;
		System.out.println("-------doubling---------");
		System.out.println("data size : " + this.data.length + " size : " + size + " index : " + index);
	}
	
	public Object get(int index) {
		if(index > this.index - 1) {
			System.out.println("ArrayIndexOutOfBound");
		}else if(index < 0) {
			System.out.println("Wrong index");
		}
		
		return this.data[index];
	}
	
	public void remove(int index) throws Exception {
		if(index > this.index-1) {
			throw new Exception("ArrayOutOfBound");
		}else if(index < 0) {
			throw new Exception("Wrong index");
		}
		
		for(int i = index ; i < this.data.length -1 ; i++) {
			this.data[i] = this.data[i +1];
		}
		
		this.index--;
		System.out.println("--------remove----------");
		System.out.println("data size : " + this.data.length + " size : " + size + " index : " + index);
	}
}

public class ArrayListTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ArrayList al = new ArrayList();
		al.add(0);
		al.add(1);
		al.add(2);
		al.add(3);
		al.add(4);
		al.add(5);
		al.add(6);
		al.add(7);
		al.add(8);
		al.add(9);
		System.out.println(al.get(5));
		al.remove(5);
		System.out.println(al.get(5));
	}

}
