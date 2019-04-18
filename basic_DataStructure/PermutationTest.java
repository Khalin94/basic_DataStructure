package arraysAndStrings;

public class PermutationTest {
	
	public static void main(String[] args) {
		String s = "ABC";
		String s1 = "BCA";
		String a = "BCD";
		String a1 = "BCA";
		String b = "ABC";
		String b1 = "BCAA";
		
		System.out.println(permutation(s, s1));
		System.out.println(permutation(a, a1));
		System.out.println(permutation(b, b1));
		System.out.println("--------------------");
		System.out.println(permutationAskii(s, s1));
		System.out.println(permutationAskii(a, a1));
		System.out.println(permutationAskii(b, b1));
	}
	
	private static String sort(String str) {
		char[] ch = str.toCharArray();
		java.util.Arrays.sort(ch);
		
		return new String(ch);
	}
	
	private static boolean permutation(String str, String str1 ) {
		if(str.length() != str1.length()) {
			return false;
		}

		return sort(str).equals(sort(str1));
	}
	
	private static boolean permutationAskii(String str, String str1) {
		if(str.length() != str1.length()) {
			return false;
		}
		
		int[] index = new int[128];
		
		for(int i = 0; i <str.length(); i++) {
			index[str.charAt(i)]++;
		}
		
		for(int i = 0 ; i<str1.length(); i++) {
			index[str1.charAt(i)]--;
			if(index[str1.charAt(i)] < 0 ) {
				return false;
			}
		}
		return true;
	}
}
