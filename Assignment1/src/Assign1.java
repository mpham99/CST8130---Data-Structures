import java.util.Scanner;
/*************************************************************************************************************
 Name: Minh Duc Pham
 Student number: 040905103
 Assignment number: #1
 Date: October 2nd, 2018

Purpose:  This class contain the main method, which hold the program's menu.
Author:  Minh Duc Pham
Course: F2018 - CST8130
Lab Section: 303

Data members:  todayDate: MyDate - store the default date
               lib: Library - object of Library class
               option: String - menu options - value from 1 to 6
               keyboard: Scanner - object of Scanner class
Methods: main  - menu processing which contain the field todayDate (MyDate)

 *************************************************************************************************************/
public class Assign1 {
	
	public static void main (String[]args) {
		
		MyDate todayDate = new MyDate(15,9,2018);
		Library lib = new Library();
		String option;
		Scanner keyboard = new Scanner(System.in);
		
		do {
			System.out.print("\nEnter 1 to add to resources borrowed, \n"
					+ "   2 to display overdue items, \n"
					+ "   3 to display all resources borrowed, \n"
			        + "   4 to delete a resource, \n"
			        + "   5 to change today date, \n"
			        + "   6 to quit: ");
		
			option = keyboard.next();
			
			switch(option) {
			case "1":
				lib.inputResource(keyboard, todayDate);
				break;
				
			case "2":
				lib.resourcesOverDue(todayDate);
				break;
				
			case "3":
				System.out.println("Items currently borrowed from the library are: \n");
				lib.toString();
				break;
				
			case "4":
				lib.deleteResource(keyboard, todayDate);
				break;
				
			case "5":
				System.out.println("Enter a new date for today's date");
				todayDate.inputDate(keyboard);
				break;
				
			case "6":
				System.out.println("Good Bye!");
				System.exit(0);
				break;
				
			default:
				System.out.println("Ivalid selection ! Please try again");
			}//end of switch
			
		}while(option!="6");
		
	}//end of main

}//end of class
