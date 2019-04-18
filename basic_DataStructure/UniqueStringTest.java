package arraysAndStrings;

import java.util.HashMap;

public class UniqueStringTest {
	
	public static void main(String[] args) {
		String str = "abcdefghi";
		String str1 = "abcdefgghi";
		System.out.println(isUnique(str));
		System.out.println(isUnique(str1));
		
		if(isUnique(str)) {
			System.out.println("true");
		}else {
			System.out.println("false");
		}
		
		if(isUnique(str1)) {
			System.out.println("true");
		}else {
			System.out.println("false");
		}
		System.out.println("hash ------------ j");
		System.out.println(hashMapUnique(str));
		System.out.println(hashMapUnique(str1));
		
		System.out.println("bit-----------------");
		
		System.out.println(bitOperationUnique(str));
		System.out.println(bitOperationUnique(str1));
		
	}
	
	static boolean isUnique(String str) {
		if(str.length() > 128) {
			return false;
		}
		
		boolean[] charSet = new boolean[128];
		
		for(int i =0; i < str.length(); i++) {
			int val = str.charAt(i);
			if(charSet[val]) {
				return false;
			}
			charSet[val] = true;
		}
		return true;
	}
	
	static boolean hashMapUnique(String str) {
		HashMap<Integer, Boolean> hashMap = new HashMap<>();
		
		for(int i = 0 ; i<str.length(); i++) {
			int val = str.charAt(i);
			if(hashMap.containsKey(val)) {
				return false;
			}
			hashMap.put(val, true);
		}
		return true;
	}
	
	static boolean bitOperationUnique(String str) {
		int checker = 0;

		for(int i =0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a';
			if((checker & (1 << val)) > 0 ) {
				return false;
			}
			checker = checker|(1 <<val);
		}
			return true;
	}

}
