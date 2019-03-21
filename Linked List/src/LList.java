import java.util.Scanner;

public class LList {
	private LLNode head;
	
	public LList() {
		head = null;
	}
	public void addAtHead (String newData) {
		LLNode newNode = new LLNode (newData);
		newNode.updateNode(head);
		head = newNode;
	}
	
	public void display() {
		LLNode temp = head;
		while (temp != null) {
			System.out.println (temp);
			temp = temp.getNext();
		}
	}
	
	public LLNode deleteAtHead ( ) {
		LLNode removedOne = head;
		head = head.getNext();
		return removedOne;
	}
	
	public void deleteNode(Scanner scan) {
		LLNode current = head;
		LLNode previous = head;
		
		if(head != null) {
			System.out.println("Enter the string you want to delete: ");
			String str = scan.next();

			if(current.toString().equals(str)){
				deleteAtHead();
			}else {
				current = current.getNext();
				
				while(current != null) {
					if(current.getNext() != null) {
						if (current.toString().equals(str)) {
							current = current.getNext();
							previous.updateNode(current);
						} else {
							previous = current;
							current = current.getNext();
						}
					}else {
						previous.updateNode(null);
						current = null;
					}
				}
				
			}
			
		}else
			System.out.println("The linked list is empty");
	}//end of deleteNode

}//end of LList
