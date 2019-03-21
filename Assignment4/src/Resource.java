import java.util.Scanner;
/*************************************************************************************************************
 Name: Minh Duc Pham
 Student number: 040905103
 Assignment number: #2
 Date: November 26th, 2018
 
Purpose: This class contains all common data of resources.
Author:  Minh Duc Pham
Course: F2018 - CST8130
Lab Section: 303

Data members:  title: String - Title of resources
               borrower: String - Name of borrower
               dueDate: MyDate - the due date of borrowed resources
               overdueCost: float - overdue cost that borrower have to pay
Methods: Default Constructor: - initialize dueDate object
         inputResource (Scanner, MyDate): boolean - reads from the Scanner object passed in and uses MyDate as
                                          today's date and fills the data member fields with valid data; method
                                          returns true if successfully reads in all fields else returns false
         calculateHash(): int - use the title of resource to calculate and return the hash
         toString():String - display information related to the borrowed resource
         isOverDue (MyDate today): boolean - returns true if the dueDate is greater than the parameter today's date,
                                             else returns false
         displayOverDue(): displays the borrower and cost for over due resource
         compareTitle(): boolean - return true if the two title is the same, false if not
 *************************************************************************************************************/
public class Resource {
	
	protected String title;
	protected String borrower;
	protected MyDate dueDate;
	protected float overdueCost;
	
	public Resource() {
		dueDate = new MyDate();
	}// end of constructor
	
	public Resource(String t) {
		dueDate = new MyDate();
		title = t;
	}// end of constructor
	
	public boolean inputResource(Scanner scan, MyDate date) {
		
		System.out.print("Enter title being borrowed: ");
		title = scan.next();
		System.out.print("Enter borrower name (no spaces): ");
		borrower = scan.next();
		return true;
	}
	
	public int calculateHash() {
		int hash = 0;
		int charValue = 0;
		for(int i = 0; i<title.length(); i++)
			charValue += (int)(title.toUpperCase().charAt(i));
		hash = charValue%1000;
		return hash;
	}
	
	public String toString() {
		return " \n";
	}// end of toString
	
	public boolean isOverDue(MyDate today) {
		if(dueDate.isGreaterThan(today) == true)
			return true;
		else
			return false;
	}// end of isOverDue method
	
	public void displayOverDue() {
		System.out.print( "This resource is overdue - $"  + overdueCost + " is owed by borrower.  " );
	}// end of displayOverDue
	
	public boolean compareTitle (String t) {
		if(title.toLowerCase().equals(t))
			return true;
		else 
			return false;
	}//end of compareTitle
	
}// end of class
