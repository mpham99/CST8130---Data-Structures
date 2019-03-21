import java.util.Scanner;
/*************************************************************************************************************
 Name: Minh Duc Pham
 Student number: 040905103
 Assignment number: #2
 Date: October 28th, 2018

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
         toString():String - display information related to the borrowed resource
         printString():String - print resources data to a .txt file
         isOverDue (MyDate today): boolean - returns true if the dueDate is greater than the parameter today's date,
                                             else returns false
         displayOverDue(): displays the borrower and cost for over due resource
         inputResource (String, String, MyDate, float): boolean - reads title, borrower, due date and over due cost from .txt
         inputBook(String): boolean - pass the author data from .txt file
         inputDVD(String): boolean - pass the DVD type data from .txt file
         inputMagazine(MyDate): boolean - pass the edition date data from .txt file
 *************************************************************************************************************/
public class Resource {
	
	protected String title;
	protected String borrower;
	protected MyDate dueDate;
	protected float overdueCost;
	
	public Resource() {
		dueDate = new MyDate();
	}// end of constructor
	
	public boolean inputResource(Scanner scan, MyDate date) {
		
		System.out.print("Enter title being borrowed: ");
		title = scan.next();
		System.out.print("Enter borrower name (no spaces): ");
		borrower = scan.next();
		return true;
	}
	
	public String toString() {
		return "";
	}// end of toString
	
	public String printString() {
		return "";
	}// end of printString
	
	public boolean isOverDue(MyDate today) {
		if(dueDate.isGreaterThan(today) == true)
			return true;
		else
			return false;
	}// end of isOverDue method
	
	public void displayOverDue() {
		System.out.print( "This resource is overdue - $"  + overdueCost + " is owed by borrower. \n" );
	}// end of displayOverDue
	
	public boolean inputResource(String title, String borrower, MyDate dueDate, float overdueCost) {
		this.title = title;
		this.borrower = borrower;
		this.dueDate = new MyDate(dueDate);
		this.overdueCost = overdueCost;
		return true;
	}
	
	public boolean inputBook(String author) {
		return true;
	}
	
	public boolean inputDVD(String type) {
		return true;
	}
	
	public boolean inputMagazine(MyDate edition) {
		return true;
	}
}// end of class
