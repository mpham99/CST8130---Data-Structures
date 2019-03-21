import java.util.Scanner;
/*************************************************************************************************************
Name: Minh Duc Pham
Student number: 040905103
Assignment number: #3
Date: November 15th, 2018

Purpose: This class contains common datas and methods for a Block
Author:  Minh Duc Pham & Linda Crane
Course: F2018 - CST8130
Lab Section: 303

Data members:  date: MyDate - object of MyDate
			   studentNumber: int - the student number
			   grade: int - student's grade
			   previousHash: float - Hash of previous block
			   currentHash: float - Hash of the current block
Methods: Default Constructor - Initialize data members
		 calculateHash(): float - generate the hash for a block
		 toString(): String - print data of a block
		 getCurrentHash():float - return value of current block's hash
		 isEqual(Block): boolean - check previous hash value of the current block with the hash of previous block
		 				 return true if equal, false if not
		 updatePreviousHash(float): void - update current block previous hash
		 addInfoToBlock(Scanner, float): boolean - take user input for data members and pass parameter value to
		                                 previousHash
*************************************************************************************************************/
public class Block {
	private MyDate date;  // part of data - in month day year format  (eg) 2152018
	private int studentNumber; // part of data
	private int grade;  // part of data
	private float previousHash;
	private float currentHash;
	
	public Block() {
		// create the Genesis block
		date = new MyDate(15,10,2018);
		studentNumber = 0;
		grade = 100;
		previousHash = 0f;
		currentHash = calculateHash();
	}
	
	public float calculateHash() {
		return (date.toInt()+studentNumber+grade)/88;   
	}
	
	public String toString() {
		return "" + studentNumber + " " + grade + " " + date +  " current: " + currentHash + " previous: " + previousHash ;
	}
	
	
	public float getCurrentHash() {
		return currentHash;
	}
	
	public boolean isEqual (Block temp) {
		return (previousHash == temp.currentHash);
	}
	
	public void updatePreviousHash(float prevHash) {
		previousHash = prevHash;
	}
	
	public boolean addInfoToBlock(Scanner keyboard, float previousHash) {
		System.out.print ("Enter date: ");
		date.inputDate(keyboard);
		
		System.out.print ("Enter student number: ");
		while (!keyboard.hasNextInt())  {
			System.out.print ("Invalid...enter an int for student number: ");
			keyboard.next();
		}
		studentNumber = keyboard.nextInt();
		
		
		System.out.println ("Enter grade: ");
		while (!keyboard.hasNextInt())  {
			System.out.print ("Invalid...enter an int for grade: ");
			keyboard.next();
		}
		grade = keyboard.nextInt();
		
		currentHash = calculateHash();
		this.previousHash = previousHash;
		return true;
	}
	
}
