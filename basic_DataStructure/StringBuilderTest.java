package arraysAndStrings;

class StringBuilder{
	char[] ch; 
	int size;
	int index;
	
	StringBuilder(){
		size = 1;
		ch = new char[size];
		index = 0;
	}	
	
	public void append(String str) {
		if(str == null) {
			str = "null";
		}
		int len = str.length();
		
		ensureCapacity(len);
		
		for(int i = 0; i < str.length(); i++) {
			ch[index] = str.charAt(i);
			index++;
		}
		
	}
	
	public String toString() {
		return new String(ch, 0, index);
	}
	
	private void ensureCapacity(int len) {
		if(len + index > size) {
			size = (size + len) * 2;
			char[] newCh = new char[size];
			for(int i=0; i < ch.length; i++) {
				newCh[i] = ch[i];
			}
			ch = newCh;
		}
		
	}
}

class Again{
	char[] ch;
	int size;
	int index;
	
	Again(){
		size = 1;
		ch = new char[size];
		index = 0;
	}
	
	public void append(String str) {
		if(str == null) {
			str =  "null";
		}
		
		int len = str.length();
		ensureCapacity(len);
		for(int i = 0; i < str.length(); i++) {
			ch[index] = str.charAt(i);
			index++;
		}
		System.out.println("size : " + size + " index : " + index + " len : " + len);

	}
	
	private void ensureCapacity(int len) {
		if(len + index > size ) {
			size = (len + size) * 2;
			char[] newCh = new char[size];
			for(int i = 0 ; i< ch.length; i++) {
				newCh[i] = ch[i];
			}
			ch = newCh;
		}
	}
	
	public String toString() {
		return new String(ch, 0, index);
	}
}

public class StringBuilderTest {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		sb.append("abc");
		sb.append(" def ");
		sb.append(" ghi ");
		System.out.println(sb.toString());
		
		Again a = new Again();
		a.append("jack");
		a.append(" is");
		a.append(" pirate");
		System.out.println(a.toString());
		
	}

}
