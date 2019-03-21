import java.util.Random;
import java.util.Scanner;

public class BlockChain {
	private Block head = new Block (); // start the chain with the Genesis block
	private Block tail = head;
	private String courseName = "NotEntered";
	
	public BlockChain ( String courseName) {
		this.courseName = new String (courseName);
	}
	
	public void printBlockChain() {
		Block temp = head;
		while(temp!=null) {
			System.out.println(temp);
			temp = temp.next();
		}
		
		// you will write the code for this method here
	}
	
	public boolean verifyChain() {
		Block temp = head;
		boolean value=true;
		
		// you will write the code for this method here.....
		while(temp.next() !=null) {
			if(temp.next().isEqual(temp)) {
				temp = temp.next();
			}else {
				value = false;
				break;
			}
		}
		return value;
	}
	
	public void addBlock(Scanner keyboard) {
		Block newOne = new Block();
		if (newOne.addInfoToBlock(keyboard, tail.getCurrentHash())){
			// add to chain at tail
			tail.updateNext(newOne);
			tail = newOne;			
		}
		// you will write the code for this method here.....
		
	}
	
	public void addBadBlock(Scanner keyboard) {
		Random random = new Random();
		Block newOne = new Block();
		if (newOne.addInfoToBlock(keyboard, random.nextFloat())){
			// add to chain at tail
			tail.updateNext(newOne);
			tail = newOne;			
		}
		
	}
	
	
}
