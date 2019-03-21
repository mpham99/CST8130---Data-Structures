import java.util.Scanner;
/************************************************************************************************************
Purpose:  This class will model a simple date by keeping day, month and year information.   Leap years are NOT
               accommodated in this class.
Author:  Linda Crane and Minh Duc Pham
Course: F2018 - CST8130
Lab Section: 303
Data members:  day : int - value between 1 and 31 inclusive (depending on value in month)
               month: int - value between 1 and 12 inclusive
               year: int - positive value
Methods: default constructor - sets date to Jan 1, 2018
         toString (): String - prints date in year/month/day format
         inputDate(Scanner): boolean - reads a valid date from the Scanner parameter and returns through
                                       boolean success or not
         addOne(): void - adds one to the day field and then adjusts month and year as needed.                                              


 *************************************************************************************************************/
public class MyDate {
	private int day = 1;
	private int month = 1;
	private int year = 2018;
	private String strMonth;

	public MyDate() {
	}

	public String toString() {   
		return "" + strMonth + " " + day + ", " + year;
	}

	public String printString() {
		return strMonth + " " + day + " " + year;
	}
	
	public String sortingString() {   
		return "" + year + "-" + month + "-" + day;
	}
	

	public boolean inputDate(Scanner in) {
		this.month = 0; 
		this.day = 0; 
		this.year = 0;
		
		//month input
		do {
			System.out.print ("Enter month: ");
			strMonth = in.next();
			strMonth = strMonth.substring(0,1).toUpperCase() + strMonth.substring(1).toLowerCase();
			switch(strMonth) {
			case "Jan":
				this.month = 1;
				break;
			case "Feb":
				this.month = 2;
				break;
			case "Mar":
				this.month = 3;
				break;
			case "Apr":
				this.month = 4;
				break;
			case "May":
				this.month = 5;
				break;
			case "June":
				this.month = 6;
				break;
			case "July":
				this.month = 7;
				break;
			case "Aug":
				this.month = 8;
			    break;
			case "Sept":
				this.month = 9;
				break;
			case "Oct":
				this.month = 10;
				break;
			case "Nov":
				this.month = 11;
				break;
			case "Dec":
				this.month = 12;
				break;
			default:
				System.out.println("Invalid value ! Please enter again: ");
			}
		} while (this.month <= 0 || this.month > 12);

		//day input
		do {

			System.out.print ("Enter day: ");
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

	public boolean inputDate(String m, int d, int y) {
		this.year = y;
		strMonth = m;
		this.day = d;
		switch(strMonth.toLowerCase()) {
		case "jan":
			this.month = 1;
			break;
		case "feb":
			this.month = 2;
			break;
		case "mar":
			this.month = 3;
			break;
		case "apr":
			this.month = 4;
			break;
		case "may":
			this.month = 5;
			break;
		case "june":
			this.month = 6;
			break;
		case "july":
			this.month = 7;
			break;
		case "aug":
			this.month = 8;
		    break;
		case "sept":
			this.month = 9;
			break;
		case "oct":
			this.month = 10;
			break;
		case "nov":
			this.month = 11;
			break;
		case "dec":
			this.month = 12;
			break;
		}//end of switch
		return true;
	}

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

