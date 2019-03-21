import java.util.Scanner;
/************************************************************************************************************
Purpose:  This class will model a due dates for assessments in a course
Author:  Linda Crane and Minh Duc Pham
Course: F2018 - CST8130
Lab Section: 303
Data members:  

Methods:                                             
         

*************************************************************************************************************/

public class DueDates {
	private MyDate[] dueDates ;
	
	public DueDates() {
		dueDates = new MyDate[10];
	}
	
	public DueDates(int max) {
		dueDates = new MyDate[max];
	}
	
	public boolean inputDueDates(Scanner in) {
		for (int i=0; i<dueDates.length; i++) {
			System.out.println(i + 1 + ": ");
			dueDates[i] = new MyDate();
			dueDates[i].inputDate(in);
		}
		return true;
	}
	
	public void addOne () {
		for (int i=0; i<dueDates.length; i++) {
			dueDates[i].addOne();
		}
	}
	
	public String toString() {
		String s = ""; 
		for (int i=0; i<dueDates.length; i++) {
			s += i + 1 + ": ";
			s += dueDates[i].toString();
			s += "\n";
		}
		return s;
	}

}