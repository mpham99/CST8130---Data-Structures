import java.util.Scanner;

public class Lab3 {
	
	public String reverse(String string) {     
		if ((string==null)||(string.length() <= 1) )
			return string;
		return reverse(string.substring(1)) + string.charAt(0);
	}
	
	public boolean testPalindrome(String string1, String string2) {
		if(string2.compareTo(string1) == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		Lab3 object1 = new Lab3();
		String input;
		String inputReversed;
		String print;
		
		
		for(;;) {

			System.out.print("Enter a string: ");
			input = keyboard.nextLine().toLowerCase();
			input = input.replaceAll("\\s", "");

			inputReversed = object1.reverse(input);

			if(object1.testPalindrome(input, inputReversed)) {
				print = input + " is a palindrome";
				System.out.println(print);
			}else {
				print = input + " is not a palindrome";
				System.out.println(print);
			}
		}// end of for loop
		
	}// end of main

}// end of class
