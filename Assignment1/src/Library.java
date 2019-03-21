import java.util.Scanner;
import java.util.Arrays;
/*************************************************************************************************************
 Name: Minh Duc Pham
 Student number: 040905103
 Assignment number: #1
 Date: October 2nd, 2018

Purpose:  This class replicate the Library, contain an dynamically allocated array of Resource and contain method
          interact with the resource
Author:  Minh Duc Pham
Course: F2018 - CST8130
Lab Section: 303

Data members:  resourcesBorrowed: Resource - an dynamically allocated array of Resource type
               numResources: int - the index in the array
               option: char - type of resource being borrowed (d/D, m/M and b/B)
               delOption: int - choose resource to delete in borrowed list
               error: boolean - indicate whether there is error or not
               print: String - output for user
Methods: Default Constructor
         inputResource (Scanner, MyDate ): – adds a resource to the resourcesBorrowed array – (uses polymorphism
                                             to  call inputResource method  in the correct derived Resource class
                                             for input of the fields of the Resource)
         String toString(): - display output for user
         resourcesOverDue (MyDate today): String – returns the list of resources that are overdue
         deleteResource(MyDate): – displays a numbered list of resources currently in array and prompts user to
                                  enter number correlating to the resource to delete
 *************************************************************************************************************/
public class Library {

	protected Resource [] resourcesBorrowed = new Resource[1];
	protected int numResources;

	private char option;
	private int delOption;
	private boolean error = false;
	private String print;

	public Library() {
	}// end of constructor

	public void inputResource(Scanner scan, MyDate date) {
		numResources = resourcesBorrowed.length-1;
		System.out.println("Enter type of the resource being borrowed - D for DVD, M for Magazine and B for Book: ");
		do {
			option = scan.next().toLowerCase().charAt(0);

			switch(option) {
			case 'b':
				resourcesBorrowed[numResources] = new Book();
				resourcesBorrowed[numResources].inputResource(scan, date);
				error = false;
				break;
			case 'd':
				resourcesBorrowed[numResources] = new DVD();
				resourcesBorrowed[numResources].inputResource(scan, date);
				error = false;
				break;
			case 'm':
				resourcesBorrowed[numResources] = new Magazine();
				resourcesBorrowed[numResources].inputResource(scan, date);
				error = false;
				break;
			default:
				System.out.println("Invalid input ! Please try again");
				error = true;
				break;
			}// end of switch
		}while(error == true);

		//dynamically allocated array
		resourcesBorrowed = Arrays.copyOf(resourcesBorrowed, resourcesBorrowed.length+1);

	}// end of inputResource method

	public String toString() {
		print = "";
		for (numResources=0; numResources<(resourcesBorrowed.length-1); numResources++) {
			if(resourcesBorrowed[numResources] != null) {

				print += "[" + (numResources + 1) + "]" + ":" + " ";
				print += resourcesBorrowed[numResources].toString() + "\n";
			}//end of if
		}//end of for

		System.out.println(print);
		return print;
	}// end of toString method

	public String resourcesOverDue(MyDate today) {
		print = "Items currently borrowed from libray that are overdue as of " + today.toString() + " are: \n\n";
		for (numResources=0; numResources<resourcesBorrowed.length-1; numResources++) {
			if(resourcesBorrowed[numResources].isOverDue(today) == true) {
				print += "[" + (numResources + 1) + "]" + ":" + " ";
				print += resourcesBorrowed[numResources].toString() + "\n";
			}
		}
		System.out.println(print);
        return print;
	}//end of resourcesOverDue method

	public void deleteResource(Scanner scan, MyDate date) {
		print = "";
		if(resourcesBorrowed[0]==null) {
			System.out.println("No resources to delete");
		}else {
			System.out.println("List of resource check out from the library: ");
			for (numResources=0; numResources<resourcesBorrowed.length-1; numResources++) {
				print += "[" + (numResources + 1) + "]" + ":" + " ";
				print += resourcesBorrowed[numResources].toString() + "\n";
			}
			System.out.println(print);

			do {
				try {
					System.out.print("Which resource to delete: ");
					delOption = scan.nextInt();

					if(delOption>numResources || delOption <= 0){
						error = true;
					}else {
						error = false;
					}
				}catch (Exception e) {
					System.out.print("Invalid value ! Please enter an integer value: ");
					scan.next();
					error = true;
				}
			}while(error==true);

			int k = delOption-1;

			if(resourcesBorrowed[k].isOverDue(date) == true) {
				resourcesBorrowed[k].displayOverDue();
			}//end of if

			// shifting elements in array
			for(int j = k; j < resourcesBorrowed.length - 1; j++){
				resourcesBorrowed[j] = resourcesBorrowed[j+1];
			}//end of for loop

			resourcesBorrowed = Arrays.copyOf(resourcesBorrowed, resourcesBorrowed.length-1);
		}// end of if else loop

	}// end of deleteResource

}//end of class
