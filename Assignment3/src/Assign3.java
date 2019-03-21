import java.util.Scanner;
/*************************************************************************************************************
Name: Minh Duc Pham
Student number: 040905103
Assignment number: #3
Date: November 15th, 2018

Purpose: This class contains the main method, which hold the program's menu
Author:  Minh Duc Pham & Linda Crane
Course: F2018 - CST8130
Lab Section: 303

Data members:  keyboard: Scanner - object of Scanner class
			   obj: College - object of College course
			   menuChoice: String - menu options - from 1 to 6
Methods: main  - menu processing which call method from College class
*************************************************************************************************************/
public class Assign3 {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner (System.in);
		College obj = new College();
		String menuChoice = "a";
		
		while (menuChoice.charAt(0) != '6') {
			System.out.println ("\nEnter 1 to display the chain: ");
			System.out.println ("2 to add a new course: ");
			System.out.println ("3 to add a block: ");
			System.out.println ("4 to verify chain: ");
			System.out.println ("5 to fix a chain: ");
			System.out.println ("6 to quit: ");
			menuChoice = keyboard.next();
			
			switch (menuChoice.charAt(0)) {
				case '1': obj.display();
					  break;
				case '2': obj.addCourse(keyboard);
			          break;
				case '3': obj.addBlock(keyboard);
			  		  break;
				case '4': obj.verify();
	          		  break;
				case '5': obj.fix(keyboard);
    		  		  break;
				case '6': System.out.println ("Goodbye");
					  break;
				default:  System.out.println ("Invalid menu option !");
			}
		}
	
	}//end of main

}//end of class

