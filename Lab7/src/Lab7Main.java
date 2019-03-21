import java.util.Scanner;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
/*************************************************************************************************************
 Name: Minh Duc Pham
 Student number: 040905103
 Assignment number: #2
 Date: October 28th, 2018

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
public class Lab7Main {
	
	public static void main (String[]args) throws NoSuchFileException, IOException {
	
		String option;
		Scanner keyboard = new Scanner(System.in);
		List obj = new List();
		
		do {
			System.out.print("\nEnter 1 to clear dictionary, \n"
					+ "   2 to add text from keyboard, \n"
					+ "   3 to add text from a file, \n"
			        + "   4 to search for a word count, \n"
			        + "   5 to display number of nodes, \n"
			        + "   6 to quit \n");
		
			option = keyboard.next();
			
			switch(option) {
			case "1":
				obj.clear();
				break;
				
			case "2":
				obj.addText(keyboard);
				break;
				
			case "3":
				obj.readFile(keyboard);
				break;
				
			case "4":
				String word;
				System.out.println("Enter word to search for: ");
				word = keyboard.next();
				obj.countWords(word);
				break;
				
			case "5":
				obj.countNode();
				break;
				
			case "6":
				System.out.println("Good Bye!");
				break;
				
			default:
				System.out.println("Invalid selection ! Please try again");
			}//end of switch
			
		}while(!option.equals("6"));
		
		
	}//end of main

}//end of class
