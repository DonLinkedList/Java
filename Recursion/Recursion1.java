package lab4_Recursion;

public class Recursion1 {
	//Lab A
	public static int vowels(String aString) {
		aString = aString.toLowerCase();
		if(aString.length() == 0) {
			return 0;
		}
		else if(aString.charAt(0) == 'a' || aString.charAt(0) == 'e' || aString.charAt(0) == 'i' || aString.charAt(0) == 'o' || aString.charAt(0) == 'u') {
			return (1 + vowels(aString.substring(1)));
		}
		else {
			return vowels(aString.substring(1));
		}
	}
	//Lab B
	public static String palindrome(String aString) {
		aString = aString.toLowerCase();
		if (aString.length() == 1 || aString.length() == 0) {
			return "true";
		}
		else if(aString.charAt(0) != aString.charAt(aString.length() - 1)) {
			return "false";
		}
		else {
			return palindrome(aString.substring(1, aString.length() - 1));
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String hello = "Palindrome";
		System.out.println(vowels(hello));
		System.out.println(palindrome(hello));
	}

}
