package arraysAndStrings;

public class SpaceEncodingTest {
	public static void main(String[] args) {
		String str = "mr john smith    ";
		System.out.println(urlify(str, 13));
	}

	private static String urlify(String str, int len) {
		return urlify(str.toCharArray(), len);
	}

	private static String urlify(char[] str, int len) {
		int space = 0;

		for (int i = 0; i < len; i++) {
			if (str[i] == ' ') {
				space++;
			}

		}
		int index = len + space * 2 - 1;
		for (int j = len - 1; j >= 0; j--) {
			if (str[j] == ' ') {
				str[index--] = '0';
				str[index--] = '2';
				str[index--] = '%';
			} else {
				str[index--] = str[j];
			}
		}
		return new String(str);
	}

}
