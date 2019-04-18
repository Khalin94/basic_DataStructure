package arraysAndStrings;

import java.lang.StringBuilder;

public class CompressStringTest {
	public static void main(String[] args) {
		String str = "aaaabbbbcc";
		String str1 = "aabcd";
		System.out.println(compressString(str));
		System.out.println(compressString(str1));
		System.out.println(compressStringNoGetTotal(str));
		System.out.println(compressStringNoGetTotal(str1));
	}
	
	private static String compressString(String str) {
		String newStr = compress(str);
		return str.length() < newStr.length() ? str : newStr;
	}

	
	private static String compress(String str) {
		int count = 0;
		StringBuilder newStr = new StringBuilder(getTotal(str));
		
		for(int i = 0; i <str.length(); i++) {
			count++;
			if(i+1 >= str.length() || str.charAt(i) != str.charAt(i+1)) {
				newStr.append(str.charAt(i));
				newStr.append(count);
				count = 0;
			}
		}
		return newStr.toString();
	}
	
	private static int getTotal(String str) {
		int total = 0;
		int	count = 0;
		
		for(int i = 0; i <str.length(); i++) {
			count++;
			if(i+1 >= str.length() || str.charAt(i) != str.charAt(i+1)) {
				total += 1 + String.valueOf(count).length();
				count = 0;
			}
		}
		return total;
	}

	private static String compressNoGetTotal(String str) {
		int count = 0;
		StringBuilder newStr = new StringBuilder();
		
		for(int i = 0; i <str.length(); i++) {
			count++;
			if(i+1 >= str.length() || str.charAt(i) != str.charAt(i+1)) {
				newStr.append(str.charAt(i));
				newStr.append(count);
				count = 0;
			}
		}
		return newStr.toString();
	}

	private static String compressStringNoGetTotal(String str) {
		String newStr = compressNoGetTotal(str);
		return str.length() < newStr.length() ? str : newStr;
	}

}
