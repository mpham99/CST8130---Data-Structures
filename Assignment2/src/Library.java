import java.util.Scanner;
import java.util.ArrayList;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
/*************************************************************************************************************
 Name: Minh Duc Pham
 Student number: 040905103
 Assignment number: #2
 Date: October 28th, 2018
 
Purpose:  This class replicate the Library, contain an dynamically allocated array of Resource and contain method
          interact with the resource
Author:  Minh Duc Pham
Course: F2018 - CST8130
Lab Section: 303

Data members:  resourcesBorrowed: Resource - an ArrayList of Resource type
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
         readFile(Scanner): read resources from a file
         printFile(Scanner): save the current resource to a file
         viewResource(Scanner): view a specific resources by enter its title
         binarySearch(ArrayList<Resource>, int, int, String): using binary search for title of resource, return 
                                                              the index
         sorting(Resource): using binary search to sort the Resource title alphabetically
 *************************************************************************************************************/
public class Library {

	protected static ArrayList<Resource> resourcesBorrowed;
	Resource newResource;
	protected int numResources;

	private char option;
	private int delOption;
	private boolean error = false;
	private String print;

	public Library() {
		resourcesBorrowed = new ArrayList<Resource>(1000);
		numResources = 0;
	}// end of constructor

	public void inputResource(Scanner scan, MyDate date) {
		System.out.println("Enter type of the resource being borrowed - D for DVD, M for Magazine and B for Book: ");
		do {
			option = scan.next().toLowerCase().charAt(0);

			switch(option) {
			case 'b':
				newResource = new Book();
				newResource.inputResource(scan, date);
				sorting(newResource);
				numResources ++;
				error = false;
				break;
			case 'd':
				newResource = new DVD();
				newResource.inputResource(scan, date);
				sorting(newResource);
				numResources ++;
				error = false;
				break;
			case 'm':
				newResource = new Magazine();
				newResource.inputResource(scan, date);
				sorting(newResource);
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
		for (Resource res : resourcesBorrowed) {
			if(res != null) {
				print += "[" + (index + 1) + "]" + ":" + " ";
				print += res.toString() + "\n";
				index++;
			}//end of if
		}//end of for

		System.out.println(print);
		return print;
	}// end of toString method

	public String resourcesOverDue(MyDate today) {
		int index = 0;
		print = "Items currently borrowed from libray that are overdue as of " + today.toString() + " are: \n\n";
		for (Resource res : resourcesBorrowed) {
			if(res.isOverDue(today) == true) {
				print += "[" + (index + 1) + "]" + ":" + " ";
				print += res.toString() + "\n";
			}
			index++;
		}
		System.out.println(print);
        return print;
	}//end of resourcesOverDue method

	public void deleteResource(Scanner scan, MyDate date) {
		print = "";
		int index = 0;
		if(resourcesBorrowed.isEmpty()) {
			System.out.println("No resources to delete");
		}else {
			System.out.println("List of resource check out from the library: ");
			for (Resource res : resourcesBorrowed) {
				print += "[" + (index + 1) + "]" + ":" + " ";
				print += res.toString() + "\n";
				index++;
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

			if(resourcesBorrowed.get(k).isOverDue(date) == true) {
				resourcesBorrowed.get(k).displayOverDue();
			}//end of if
			
			//delete from list
			resourcesBorrowed.remove(k);
		}// end of if else loop

	}// end of deleteResource
	
	public boolean readFile(Scanner sc) {
		String title, borrower, author, type;
		MyDate dueDate, edition;
		int day, month, year;
		float overdueCost;
		
		System.out.print("Enter name of file to process: ");
		String filename = sc.next();
		
		try {
			sc = new Scanner(Paths.get(filename));
			while(sc.hasNext()) {
				char option = sc.next().toLowerCase().charAt(0);
				
				if(option == 'b') {
					newResource = new Book();
					
					title = sc.next();
					borrower = sc.next();
					
					month = sc.nextInt();
					day = sc.nextInt();
					year = sc.nextInt();
					if(day <= 0 || day > 31 || month == 2 && day > 29 || (day > 30 && (month == 9 ||month == 4 ||month == 6 ||month == 11) ) ) {
						throw new Exception("Invalid day input! Please check your file data");
					}
					if (month <= 0 || month > 12) {
						throw new Exception("Invalid month input! Please check your file data");
					}
					if (year <= 0) {
						throw new Exception("Invalid year input! Please check your file data");
					}
					dueDate = new MyDate(day, month, year);
					
					overdueCost = sc.nextFloat();
					if(overdueCost != 2)
						throw new Exception("Invalid overdue cost input! Please check your file data");
					
					author = sc.next();
					
					newResource.inputResource(title, borrower, dueDate, overdueCost);
					newResource.inputBook(author);
				}else if(option == 'd') {
					newResource = new DVD();
					
					title = sc.next();
					borrower = sc.next();
					
					month = sc.nextInt();
					day = sc.nextInt();
					year = sc.nextInt();
					if(day <= 0 || day > 31 || month == 2 && day > 29 || (day > 30 && (month == 9 ||month == 4 ||month == 6 ||month == 11) ) ) {
						throw new Exception("Invalid day input! Please check your file data");
					}
					if (month <= 0 || month > 12) {
						throw new Exception("Invalid month input! Please check your file data");
					}
					if (year <= 0) {
						throw new Exception("Invalid year input! Please check your file data");
					}
					dueDate = new MyDate(day, month, year);
					
					overdueCost = sc.nextFloat();
					if(overdueCost != 1)
						throw new Exception("Invalid overdue cost input! Please check your file data");
					
					type = sc.next();
					
					newResource.inputResource(title, borrower, dueDate, overdueCost);
					newResource.inputDVD(type);
				}else if(option == 'm') {
					newResource = new Magazine();
					
					title = sc.next();
					borrower = sc.next();
					
					month = sc.nextInt();
					day = sc.nextInt();
					year = sc.nextInt();
					if(day <= 0 || day > 31 || month == 2 && day > 29 || (day > 30 && (month == 9 ||month == 4 ||month == 6 ||month == 11) ) ) {
						throw new Exception("Invalid day input! Please check your file data");
					}
					if (month <= 0 || month > 12) {
						throw new Exception("Invalid month input! Please check your file data");
					}
					if (year <= 0) {
						throw new Exception("Invalid year input! Please check your file data");
					}
					dueDate = new MyDate(day, month, year);
					
					overdueCost = sc.nextFloat();
					if(overdueCost != 1)
						throw new Exception("Invalid overdue cost input! Please check your file data");
					
					month = sc.nextInt();
					day = sc.nextInt();
					year = sc.nextInt();
					if(day <= 0 || day > 31 || month == 2 && day > 29 || (day > 30 && (month == 9 ||month == 4 ||month == 6 ||month == 11) ) ) {
						throw new Exception("Invalid day input! Please check your file data");
					}
					if (month <= 0 || month > 12) {
						throw new Exception("Invalid month input! Please check your file data");
					}
					if (year <= 0) {
						throw new Exception("Invalid year input! Please check your file data");
					}
					edition = new MyDate(day, month, year);
					
					newResource.inputResource(title, borrower, dueDate, overdueCost);
					newResource.inputMagazine(edition);
				}else {
					System.out.println("Invalid resource option");
					continue;
				}
				
				sorting(newResource);
				numResources++;
				
			}//end of while
			return true;
		} catch (NoSuchFileException e) {
			System.out.println("No file is found");
			return false;
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}

	}// end of readFile
	
	public boolean printFile(Scanner scan) throws IOException {
		String fileName = "";
		
		System.out.print("Enter name of the file to write to: ");
		fileName = scan.next();
		FileWriter file = new FileWriter(fileName);
		PrintWriter printer = new PrintWriter(file);
		
		for (Resource res : resourcesBorrowed) {
			String s = ""; 
			s += res.printString();
			printer.println(s);
		}
		
		printer.close();
		return true;	
	}
	
	public String viewResource(Scanner scan) {
		String str;
		int index;
		int left = 0;
		int right = resourcesBorrowed.size() - 1;
		
		if(resourcesBorrowed.isEmpty()) {
			return "No resources to view ";
		}else {
			System.out.print("Enter the title to search for: ");
			str = scan.next();
			index = binarySearch(resourcesBorrowed, left, right, str);
		}
		if(index != -1) 
			return resourcesBorrowed.get(index).toString(); 
		else
			return "Resource with this title is not found";
	}//end of viewResource
	
	public int binarySearch(ArrayList<Resource> list, int left, int right, String str ) {
		int middle;
		
		while(left<=right) {
			middle = (left+right)/2;

			if(list.get(middle).title.compareToIgnoreCase(str) == 0)
				return middle;

			if(list.get(middle).title.compareToIgnoreCase(str) < 0)
				left = middle + 1;
			else
				right = middle - 1;
		}// end of while loop
		return -1;
	}//end of binarySearch
	
	public void sorting (Resource temp) { 
		int left = 0;
        int right = resourcesBorrowed.size()-1;
        int middle;

        while(left <= right)  {
            middle = (left + right)/2;
            int result = resourcesBorrowed.get(middle).title.compareToIgnoreCase(temp.title);
       
            if(result < 0) { //If e is lower
            	left = middle + 1;
            } else { //If e is higher
            	right = middle - 1;
            }
        }
	    resourcesBorrowed.add(left, temp);
	}//end of sorting
	
}//end of class
