import java.util.Random;
import java.util.Scanner;
import java.util.LinkedList;
/*************************************************************************************************************
Name: Minh Duc Pham
Student number: 040905103
Assignment number: #3
Date: November 15th, 2018

Purpose: This class contains a LinkedList of Block, which is a Block Chain of course's grade. It interacts with
 		 the methods in the Block class
Author:  Minh Duc Pham & Linda Crane
Course: F2018 - CST8130
Lab Section: 303

Data members:  blockChain: LinkedList<Block> - a LinkedList contains objects of Block type, which is course's grades
			   courseName: String - name of the course
Methods: parameterized constructor - initialize data members using passed value for courseName
		 printBlockChain(): void - print block inside a block chain
		 verifyChain(): boolean - return true if block chain is verified, false when it is not verified
		 addBlock(Scanner): void - add new block to the LinkedList
		 addBadBlock(Scanner): void - add a bad block to the LinkedList
		 removeBadBlocks(): boolean - remove a bad block in the linked list, return true if removed, return false
		  					if not
		 toString(): String - return the course name
*************************************************************************************************************/
public class BlockChain {
	private LinkedList <Block> blockChain = new LinkedList <Block>();
	private String courseName = "NotEntered";
	 
	public BlockChain (String courseName) {
		this.courseName = new String (courseName);
		blockChain.add(new Block());
	}//end of constructor
	
	
	public void printBlockChain() {
		System.out.println ("\nFor course: " + courseName);
		for(Block b:blockChain)
			System.out.println(b);
	}//end of printBlockChain
	
	public boolean verifyChain() {
		boolean value = true;
		for(int i=1; i<blockChain.size(); i++) {
			Block previousBlock = blockChain.get(i-1);
			Block currentBlock = blockChain.get(i);
			if (!currentBlock.isEqual(previousBlock)) 
				value = false;
		}
		return value;
	}//end of verifyChain

	public void addBlock(Scanner keyboard) {
		Block newOne = new Block();
		newOne.addInfoToBlock(keyboard, blockChain.getLast().getCurrentHash());	
		blockChain.add(newOne);
		
	}//end of addBlock
	
	public void addBadBlock(Scanner keyboard) {
		Random random = new Random();
		Block newOne = new Block();
		if (newOne.addInfoToBlock(keyboard, random.nextFloat()))
			blockChain.add(newOne);		
		
	}//end of addBadBlock
	
	public boolean removeBadBlocks() {
		boolean value = false;
		for(int i=1; i<blockChain.size(); i++) {
			Block previousBlock = blockChain.get(i-1);
			Block currentBlock = blockChain.get(i);
			if (!currentBlock.isEqual(previousBlock)) {
				blockChain.remove(currentBlock);
				value = true;
			}	
		}
		return value;
	}//end of removeBadBlocks
	
	public String toString() {
		return courseName;
	}//end of toString
	
}//end of class
