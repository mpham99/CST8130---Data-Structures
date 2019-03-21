import java.util.Scanner;
import java.util.ArrayList;
/*************************************************************************************************************
Name: Minh Duc Pham
Student number: 040905103
Assignment number: #3
Date: November 15th, 2018

Purpose: This class hold an ArrayList of BlockChain, which used to store course's grade. It interacts with method
		 inside the BlockChain class
Author:  Minh Duc Pham
Course: F2018 - CST8130
Lab Section: 303

Data members:  college: ArrayList<BlockChain> - an ArrayList which hold object of BlockChain type
			   newCourse: BlockChain - object of BlockChain class
			   collegeName: String - name of the college
Methods: default constructor - initialize class's data members
		 display(): void - display course grades stored in the ArrayList
		 addCourse(Scanner): void - enter new course into the ArrayList
		 addBlock(Scanner): void - enter new grade into a course's grade block chain
		 verify(): void - verify each course's grade block chain in the ArrayList
		 fix(Scanner): void - remove a bad block in course's grade block chain
*************************************************************************************************************/
public class College {
	private ArrayList <BlockChain> college;
	BlockChain newCourse;
	private String collegeName;

	public College() {
		college = new ArrayList <BlockChain>(1000);
		collegeName = "Algonquin";
	}//end of constructor
	
	public void display() {
		System.out.println("For college: " + collegeName);
		
		for(BlockChain course: college)
			course.printBlockChain();
	}//end of display
	
	public void addCourse(Scanner keyboard) {
		String name;
		boolean duplicate = false;
		
		System.out.println("Enter name of course to add: ");
		name = keyboard.next();
		
		for(BlockChain course: college) {
			if(name.equals(course.toString()))
				duplicate = true;
		}
		
		if(duplicate == true)
			System.out.println("Course with that name already exists in the list !");
		else {
			newCourse = new BlockChain(name);
			college.add(newCourse);
		}
	}//end of addCourse
	
	public void addBlock(Scanner keyboard) {
		int index = -1;
		String option2;
		if(college.isEmpty())
			System.out.println("There is no course in the database !");
		else {
			do {
				System.out.println("Enter which course to add: ");
				int i = 0;
				for(BlockChain course: college) {
					System.out.println(i + " " + course);
					i+=1;
				}
				if (keyboard.hasNextInt())
					index = keyboard.nextInt();
				else {
					System.out.println ("Invalid course index input !\n");
					keyboard.next();
				}
				if (index >= college.size())
					System.out.println ("Course index is out of range !\n");
			} while (index < 0 || index >= college.size());
			

			System.out.println("Add good block or bad? (g for good, anything else for bad)");
			option2 = keyboard.next();
			
			switch (option2.charAt(0)) {
				case 'g':college.get(index).addBlock(keyboard);
						 break;
				default: college.get(index).addBadBlock(keyboard);
			}
		}
		
	}//end of addBlock
	
	public void verify() {
		if(college.isEmpty())
			System.out.println("There is no course in the database !");
		else {
			for(BlockChain course: college) {
				if (course.verifyChain() == true)
					System.out.println ("Chain for " + course + " is verified");
				else  
					System.out.println ("Chain for " + course + " is not verified");
			}
		}
	}//end of verify
	
	public void fix(Scanner keyboard) {
		int index = -1;
		boolean fixed = false;
		
		if(college.isEmpty())
			System.out.println("There is no course in the database !");
		else {
			do {
				System.out.println("Enter which course to fix: ");
				int i = 0;
				for(BlockChain course: college) {
					System.out.println(i + " " + course);
					i+=1;
				}
				if (keyboard.hasNextInt())
					index = keyboard.nextInt();
				else {
					System.out.println ("Invalid course index input !\n");
					keyboard.next();
				}
				if (index >= college.size())
					System.out.println ("Course index is out of range !\n");
			} while (index < 0 || index >= college.size());
			
			
			while(college.get(index).verifyChain() == false) {
				college.get(index).removeBadBlocks();
				fixed = true;
			}
			
			if(fixed == true)
				System.out.println("Course is fixed ");
			else
				System.out.println("Course doesn't need to be fixed ");
		}
		
	}//end of fix
	
}//end of class
