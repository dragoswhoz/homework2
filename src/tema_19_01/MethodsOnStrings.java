package tema_19_01;

public class MethodsOnStrings {
	private String string;
	
	public MethodsOnStrings() {
		
	}
	
	public MethodsOnStrings(String string) {
		this.string = string;
		
	}
	
	
	public int indexOf(char c) {
		char[] chars = string.toCharArray();
		int index = -1;
		int i = 0;
		while (i < chars.length) {
		
			if(c == chars[i]) {
				index = i;
				return index;
			}
			i++;
		}
		return index;
	}
	
	public boolean isPalindrome(String string) {
		StringBuilder sbString= new StringBuilder(string);
		sbString = sbString.reverse();
		return string.equalsIgnoreCase(sbString.toString()) ? true : false;
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	
}
