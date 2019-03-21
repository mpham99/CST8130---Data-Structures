import java.util.Scanner;

public class LinkedListExample {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		LList list = new LList();
		String str = new String();
		
		for(;;) {
			System.out.print("Enter an expression: ");
			str = scan.nextLine();
			
			for(int i = 0; i<str.length(); i++) {
				if(str.charAt(i) == '{' || str.charAt(i) == '(' ) {
					list.addAtHead(str.charAt(i));
				}
				
				if(str.charAt(i) == '}') {
					if(list.getHead().getData() == '{' ) 
						list.deleteAtHead();
				}
				
				if(str.charAt(i) == ')') {
					if(list.getHead().getData() == '(' ) 
						list.deleteAtHead();
				}
		        
			}//end of for loop
			
		    if(list.isEmpty() == false)
		    	System.out.println("The expression is NOT balanced");
		    else
		    	System.out.println("The expression is balanced");

		}
	}//end of main

}//end of class
