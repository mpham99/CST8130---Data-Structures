import java.util.Scanner;
/*************************************************************************************************************
 Name: Minh Duc Pham
 Student number: 040905103
 Assignment number: #2
 Date: October 28th, 2018

Purpose: This class will be inherited from Resource and contains the data member for a Book
Author:  Minh Duc Pham
Course: F2018 - CST8130
Lab Section: 303

Data members:  author: String - name of the author of the book
Methods: Default Constructor: - initialize overdueCost
         inputResource (Scanner, MyDate): boolean - reads from the Scanner object passed in and uses MyDate as
                                          today's date and fills the data member fields with valid data; method
                                          returns true if successfully reads in all fields else returns false
         toString():String - display information related to the borrowed Book
         printString():String - print resources data to a .txt file
         inputBook(String): boolean - pass the author data from .txt file
 *************************************************************************************************************/
public class Book extends Resource {
	
	protected String author;
	
	public Book() {
		overdueCost = 2;
	}// end of constructor
	
	public boolean inputResource(Scanner scan, MyDate date) {
		super.inputResource(scan, date);
		System.out.print("Enter the author name (no spaces): ");
		author = scan.next();
		dueDate = new MyDate(date);
		
		for (int i=0; i<=13; i++) {
			dueDate.addOne();
		}
		return true;
	}// end of inputResource
	
	@Override 
	public String toString() {
		String print = " author " + author + " " + borrower + " has " + title + " due on " + dueDate + " and if late "+ overdueCost + super.toString();
		return print;
	}// end of toString

	@Override
	public String printString() {
		return "b "+ title + " " + borrower + dueDate.printString() + " " + overdueCost + " " + author + super.printString();
	}
	
	public boolean inputBook(String author) {
		if(!super.inputBook(author)) {
			return false;
		}
		this.author = author;
		return true;
	}//end of inputBook
	
}//end of class
