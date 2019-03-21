import java.util.Scanner;
/*************************************************************************************************************
 Name: Minh Duc Pham
 Student number: 040905103
 Assignment number: #1
 Date: October 2nd, 2018

Purpose:  This class will model a simple date by keeping day, month and year information.   Leap years are NOT
               accommodated in this class.
Author:  Linda Crane and Minh Duc Pham
Course: F2018 - CST8130
Lab Section: 303

Data members:  day : int - value between 1 and 31 inclusive (depending on value in month)
               month: int - value between 1 and 12 inclusive
               year: int - positive value
Methods: default constructor - sets date to Jan 1, 2018
         parameterized constructor - pass value of another MyDate object
         parameterized constructor - pass day, month and year value
         toString (): String - prints date in year/month/day format
         inputDate(Scanner): boolean - reads a valid date from the Scanner parameter and returns through
                                       boolean success or not
         addOne(): void - adds one to the day field and then adjusts month and year as needed.
         isEqual(MyDate): boolean - compares the values of the parameter object MyDate and the object being
                                    called on and return true if equal, else returns false
         isGreaterThan(MyDate): boolean - compares the values of the parameter object MyDate and the object being
                                          called on and returns true if the one being acted on is greater than
                                          the parameter object, else return false

 *************************************************************************************************************/
public class MyDate {
	private int day = 1;
	private int month = 1;
	private int year = 2018;

	public MyDate() {
	}
	
	public MyDate(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public MyDate(MyDate d) {
		this.day = d.day;
		this.month = d.month;
		this.year = d.year;
	}
	
	public String toString() {   
		return "" + year + "/" + month + "/" + day;
	}

	public boolean inputDate(Scanner in) {
		this.month = 0; 
		this.day = 0; 
		this.year = 0;

		//month input
		do {

			System.out.print ("Enter month - between 1 and 12: ");
			if (in.hasNextInt())
				this.month = in.nextInt();
			else {
				System.out.println ("Invalid month input");
				in.next();
			}
		} while (this.month <= 0 || this.month > 12);

		//day input
		do {

			System.out.print ("Enter day - between 1 and 31: ");
			if (in.hasNextInt())
				this.day = in.nextInt();
			else {
				System.out.println ("Invalid day input");
				in.next();
			}
		} while (this.day <= 0 || this.day > 31 || (this.month == 2 && this.day > 29) || (this.day > 30 && (this.month == 9 ||this.month == 4 ||this.month == 6 ||this.month == 11) ) );

		//year input
		do {
			System.out.print ("Enter year: ");
			if (in.hasNextInt())
				this.year = in.nextInt();
			else {
				System.out.println ("Invalid day input");
				in.next();
			}
		} while (this.year <= 0);

		return true;		
	}// end of inputDate method

	public void addOne (){

		switch (this.month) {
		//months have 30 days
		case 9: case 4: case 6: case 11:
			this.day++;
			if (this.day>30) {
				this.day = 1;
				this.month += 1;
			}
		break;

		//months have 31 days
		case 1: case 3: case 5: case 7: case 8: case 10:
			this.day++;
			if (this.day>31) {
				this.day = 1;
				this.month +=1;
			}
		break;

		//December
		case 12:
			this.day++;
			if (this.day > 31) {
				this.month = 1;
				this.day = 1;
				this.year += 1;
			}
		break;
		
		//February
		case 2:
			this.day++;
			if (this.day > 28) {
				this.month = 3;
				this.day = 1;
			}
		break;

		}// end of switch loop

	}// end of addOne method

	public boolean isEqual(MyDate date) {
		if(this.year == date.year && this.month == date.month && this.day == date.day) {
			return true;
		}else 
			return false;
	}// end of isEqual method
	
	public boolean isGreaterThan(MyDate date) {
		if(this.year < date.year) {
			return true;
		}else if(this.year == date.year && this.month < date.month) {
			return true;
		}else if(this.year == date.year && this.month == date.month && this.day < date.day) {
			return true;
		}else
			return false;
	}// end of isGreaterThan method
	
}// end of MyDate class

