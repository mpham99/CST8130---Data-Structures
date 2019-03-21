import java.util.Scanner;
import java.io.IOException;
/************************************************************************************************************
Purpose:  This class is the method main for Lab 2
Author:  Linda Crane and Minh Duc Pham
Course: F2018 - CST8130
Lab Section: 303
                                             
         

*************************************************************************************************************/


public class Lab2 {

	public static void main(String[] args) throws IOException {
		
		Scanner keyboard = new Scanner (System.in);
        String answer = "y";
        String file = "";
        int num;
        
	
		DueDates obj1 = new DueDates();
		System.out.println("Enter name of file to import or the word null to bypass: ");
		file = keyboard.next();
		
		if(!file.equals("null")) {
			obj1.readFile(file, keyboard);
		}
		else if(file.equals("null")) {
			System.out.println("You choose to bypass this step....continuing");
		}
		
		do {
			
			do {
				System.out.print("How many assessments in this course - must be greater than 0?");
            	while (!keyboard.hasNextInt()) {
        			System.out.println("Invalid input. Please try again:");
        			keyboard.next();
        		}
        	   num = keyboard.nextInt();
			}while (num<0);
			
		  DueDates object = new DueDates(num);
		  
		  System.out.println("Enter due dates: ");
		  object.inputDueDates(keyboard);
		  
		  System.out.println("The due dates are: ");
		  System.out.println(object.toString()); 
		  
		  System.out.println("Due Dates with one day added are");
		  System.out.println("The due dates are: ");
		  object.addOne();
		  System.out.println(object.toString()); 
		  
		  do {
			  System.out.print("Do another (y/n) ?");
			  answer = keyboard.next();
		  }while (!answer.equals("y") && !answer.equals("n")); 
		  
		  if(answer.equals("n")) {
			  object.printFile(keyboard, num);
		  }
			
		}while (answer.equals("y"));
		
	}
}
