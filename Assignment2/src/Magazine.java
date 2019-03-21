import java.util.Scanner;
/*************************************************************************************************************
 Name: Minh Duc Pham
 Student number: 040905103
 Assignment number: #2
 Date: October 28th, 2018

Purpose: This class will be inherited from Resource and contains the data member for a magazine
Author:  Minh Duc Pham
Course: F2018 - CST8130
Lab Section: 303

Data members:  edition: MyDate - edition of the Magazine
Methods: Default Constructor: - initialize overdueCost
         inputResource (Scanner, MyDate): boolean - reads from the Scanner object passed in and uses MyDate as
                                          today’s date and fills the data member fields with valid data; method
                                          returns true if successfully reads in all fields else returns false
         toString(): String - display information related to the borrowed magazine
         printString():String - print resources data to a .txt file
         inputMagazine(MyDate): boolean - pass the edition date data from .txt file
 *************************************************************************************************************/
public class Magazine extends Resource {
	
	protected MyDate edition;
	
	public Magazine() {
		edition = new MyDate();
		overdueCost = 1;
	}// end of constructor
		
	public boolean inputResource(Scanner scan, MyDate date) {
		super.inputResource(scan, date);
		System.out.print("Enter the edition date: ");
		edition.inputDate(scan);
		dueDate = new MyDate(date);
		
		for (int i=0; i<=6; i++) {
			dueDate.addOne();
		}
		return true;
	}// end of inputResource
	
	@Override 
	public String toString() {
		String print = " edition " + edition.toString() + " " + borrower + " has " + title + " due on " + dueDate + " and if late " + overdueCost + super.toString();
		return print;
	}// end of toString

	@Override
	public String printString() {
		return "m " + title + " " + borrower + dueDate.printString() + " " + overdueCost + " " + edition.printString() + super.printString();
	}
	
	public boolean inputMagazine(MyDate edition) {
		if(!super.inputMagazine(edition)) {
			return false;
		}
		this.edition = new MyDate(edition);
		return true;
	}//end of inputMagazine
	
}// end of class


