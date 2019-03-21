import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.Scanner;
import java.io.IOException;
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
	private int maxNum;

	public DueDates() {

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

	public boolean readFile(String filename, Scanner sc) {


		try {
			sc = new Scanner(Paths.get(filename));

			while(sc.hasNext()) {

				maxNum = sc.nextInt();

				dueDates = new MyDate[maxNum];

				for (int i = 0; i<maxNum; i++) {
					dueDates[i] = new MyDate();
					dueDates[i].inputDate(sc.nextInt(), sc.nextInt(), sc.nextInt());
				}

				System.out.println("The due dates are: ");
				for (int i = 0; i<maxNum; i++) {
					String s = ""; 
					s += i + 1 + ": ";
					s += dueDates[i].toString();
					s += "\n";
					System.out.print(s);
				}

			}

		} catch (FileNotFoundException e) {
			System.out.println("No file found");
			return false;
		}
		catch (Exception ex) {
			System.err.println(ex);
			return false;
		}
		finally {
			if (sc != null)
				sc.close();
		}
		return true;
	}// end of readFile

	public boolean printFile(Scanner input, int maxNum) throws IOException {
		String fileName = "";
		System.out.print("Enter name of the file to write to: ");
		fileName = input.next();
		FileWriter file = new FileWriter(fileName);
		PrintWriter printer = new PrintWriter(file);
		for (int i = 0; i<maxNum; i++) {
			String s = ""; 
			s += maxNum;
			s += "\n";
			s += dueDates[i].printString();
			printer.println(s);
		}
			printer.close();
			return true;
	}// end of printFile
	


}