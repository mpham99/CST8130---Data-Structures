import java.util.Scanner;
/************************************************************************************************************
Purpose:  This class is the method main for Lab 1 
Author:  Linda Crane and Minh Duc Pham
Course: F2018 - CST8130
Lab Section: 303
                                             
         

*************************************************************************************************************/


public class Lab1 {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner (System.in);
        String answer="y";
        int num;
	
		
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
		  System.out.println(object.toString()); //You didn't put the System.out.println
		  
		  System.out.println("Due Dates with one day added are");
		  System.out.println("The due dates are: ");
		  object.addOne();
		  System.out.println(object.toString()); //You didn't put the System.out.println
		  
		  do {
			  System.out.print("Do another (y/n) ?");
			  answer = keyboard.next();
		  }while (!answer.equals("y") && !answer.equals("n")); 
		  
			
		}while (answer.equals("y"));

	}
}
