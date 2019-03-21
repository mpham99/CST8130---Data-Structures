import java.util.Scanner;

public class LinkedListExample {

	public static void main(String[] args) {
		LList list = new LList();
		Scanner scan = new Scanner(System.in);
		int option;
		
		do {
			System.out.println("1. Add to head\n"
					+ "2. Delete from head\n"
					+ "3. Display the linked list\n"
					+ "4. Delete a string\n"
					+ "5. Quit");
			System.out.println("Please enter your option: ");
			option = scan.nextInt();
			
			switch(option) {
			case 1:
				System.out.println("Enter string to add: ");
				String str = scan.next();
				list.addAtHead(str);
				break;
			case 2:
				System.out.println("String at head is deleted");
				list.deleteAtHead();
				break;
			case 3:
				System.out.println("The list is ");
				list.display();
				break;
			case 4:
				list.deleteNode(scan);
				break;
			case 5:
				System.out.println("Goodbye");
				break;
			default:
				System.out.println("Invalid input ! Please try again");
				break;
			}
		}while(option != 5);

	}//end of main
}//end of class
