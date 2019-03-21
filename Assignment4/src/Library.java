import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList; 
/*************************************************************************************************************
 Name: Minh Duc Pham
 Student number: 040905103
 Assignment number: #2
 Date: November 26th, 2018
 
Purpose:  This class replicate the Library, contain an dynamically allocated array of Resource and contain method
          interact with the resource
Author:  Minh Duc Pham
Course: F2018 - CST8130
Lab Section: 303

Data members:  resourcesBorrowed: ArrayList<LinkedList<Resource>> - an ArrayList of LinkedList<Resource> type
               numResources: int - the index in the array
               option: char - type of resource being borrowed (d/D, m/M and b/B)
               delOption: int - choose resource to delete in borrowed list
               error: boolean - indicate whether there is error or not
               print: String - output for user
Methods: Default Constructor
         inputResource (Scanner, MyDate ): void - adds a resource to the resourcesBorrowed array – (uses polymorphism
                                             to  call inputResource method  in the correct derived Resource class
                                             for input of the fields of the Resource)
         toString(): String - display output for user
         resourcesOverDue (MyDate today): String - returns the list of resources that are overdue
         deleteResource(MyDate): void - displays a numbered list of resources currently in array and prompts user to
                                  enter number correlating to the resource to delete
         viewResource(Scanner): String - view a specific resources by enter its title
 *************************************************************************************************************/
public class Library {

	protected static ArrayList<LinkedList<Resource>> resourcesBorrowed;
	Resource newResource;
	protected int numResources; 

	private char option;
	private boolean error = false;
	private String print;

	public Library() {
		resourcesBorrowed = new ArrayList<LinkedList<Resource>>(1000);
		for(int i = 0; i<1000; i++)
			resourcesBorrowed.add(new LinkedList<Resource>());
		numResources = 0;
	}// end of constructor

	public void inputResource(Scanner scan, MyDate date) {
		int index;
		
		System.out.println("Enter type of the resource being borrowed - D for DVD, M for Magazine and B for Book: ");
		do {
			option = scan.next().toLowerCase().charAt(0);

			switch(option) {
			case 'b':
				newResource = new Book();
				newResource.inputResource(scan, date);
				index = newResource.calculateHash();
				resourcesBorrowed.get(index).add(newResource);
				numResources ++;
				error = false;
				break;
			case 'd':
				newResource = new DVD();
				newResource.inputResource(scan, date);
				index = newResource.calculateHash();
				resourcesBorrowed.get(index).add(newResource);
				numResources ++;
				error = false;
				break;
			case 'm':
				newResource = new Magazine();
				newResource.inputResource(scan, date);
				index = newResource.calculateHash();
				resourcesBorrowed.get(index).add(newResource);
				numResources ++;
				error = false;
				break;
			default:
				System.out.println("Invalid input ! Please try again");
				error = true;
				break;
			}// end of switch
		}while(error == true);

	}// end of inputResource method

	public String toString() {
		print = "";
		int index = 0;
		for (LinkedList<Resource> res : resourcesBorrowed) {
			index ++;
			if(!res.isEmpty()) {
				print += index + ":" + " ";
				print += res.toString() + "\n";
			}//end of if
		}//end of for

		System.out.println(print);
		return print;
	}// end of toString method

	public String resourcesOverDue(MyDate today) {
		print = "Items currently borrowed from libray that are overdue as of " + today.toString() + " are: \n\n";
		for (LinkedList<Resource> res : resourcesBorrowed) {
			for(int i = 0; i<res.size(); i++) {
				if(res.get(i).isOverDue(today) == true) {
					print += resourcesBorrowed.indexOf(res) + 1 + ":" + " ";
					print += res.get(i).toString() + "\n";
				}
			}
		}
		System.out.println(print);
        return print;
	}//end of resourcesOverDue method

	public void deleteResource(Scanner scan, MyDate date) {
		print = "";
		String delTitle = " ";
		int index = 0;
		

		System.out.print("Enter the title to delete: ");
		delTitle = scan.next();
		Resource obj = new Resource(delTitle);
		index = obj.calculateHash();

		LinkedList<Resource> res = resourcesBorrowed.get(index);
		if(res.size()>0) {
			for(int i = 0; i<res.size(); i++)
				if(res.get(i).compareTitle(delTitle.toLowerCase())) {
					if(res.get(i).isOverDue(date))
						res.get(i).displayOverDue();
					System.out.println("Resource deleted");
					res.remove(i);
				}
		}else 
			System.out.println("Resource with this title is not found");
	}// end of deleteResource

	public String viewResource(Scanner scan) {
		print = "";
		String viewTitle = " ";
		int index = 0;
		
		
		if(resourcesBorrowed.isEmpty()) {
			System.out.println("No resources to view");
		}else {
			System.out.print("Enter the title to search for: ");
			viewTitle = scan.next();
			Resource obj = new Resource(viewTitle);
			index = obj.calculateHash();
		}

		LinkedList<Resource> res = resourcesBorrowed.get(index);
		if(res.size()>0) {
			for(int i = 0; i<res.size(); i++)
				if(res.get(i).compareTitle(viewTitle.toLowerCase()))
					return res.get(i).toString();
		}else
			return "Resource with this title is not found";
		return null;
	}//end of viewResource
	
	
}//end of class
