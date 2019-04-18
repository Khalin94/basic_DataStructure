package arraysAndStrings;

public class OnetimeChangedTest {
	public static void main(String[] args) {
		System.out.println(oneTimeChaged("bale", "pale"));
		System.out.println(oneTimeChaged("pale", "pal"));
		System.out.println(oneTimeChaged("ple", "pale"));
		
		System.out.println(oneTimeChaged("pale", "bake"));
		System.out.println(oneTimeChaged("pale", "paless"));
		System.out.println(oneTimeChaged("pale", "plg"));
	}

	private static boolean oneTimeChaged(String str1, String str2) {
		String ss = "";
		String ls = "";

		if (str1.length() > str2.length()) {
			ls = str1;
			ss = str2;
		} else if (str1.length() < str2.length()) {
			ls = str2;
			ss = str1;
		}

		if (ls.length() - ss.length() > 1) {
			return false;
		}

		boolean flag = false;

		for (int i = 0, j = 0; i < ss.length(); i++, j++) {
			if (ss.charAt(i) != ls.charAt(j)) {
				if (flag) {
					return false;
				}
				flag = true;
				if (ss.length() != ls.length()) {
					j++;
				}
			}
		}
		return true;
	}

}
