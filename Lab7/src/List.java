import java.util.TreeMap;
import java.util.Scanner;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
public class List {

	TreeMap<String, Integer> tree = new TreeMap<String, Integer>();
	
	public void clear() {
		tree.clear();
		System.out.println("Dictionary is cleared");
	}//end of clear method
	
	public void addText(Scanner sc) {
		String word = "";
		System.out.print("Enter word to add to the library: ");
		word = sc.next().toLowerCase().replaceAll("[^a-zA-Z0-9]","");
		if(!tree.containsKey(word))
            tree.put(word, 1);
        else
            tree.put(word, tree.get(word) + 1);
	}
	
	public void readFile(Scanner sc) {
		String word = "";
		System.out.print("Enter name of file to process: ");
		String filename = sc.next();
		
		try {
			sc = new Scanner(Paths.get(filename));
			while(sc.hasNext()) {
				word = sc.next().toLowerCase().replaceAll("[^a-zA-Z0-9]","");
				if(tree.containsKey(word))
                    tree.put(word, tree.get(word) + 1);
                else
                    tree.put(word, 1);

			}//end of while
			sc.close();
		} catch (NoSuchFileException e) {
			System.out.println("No file is found");
			
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			
		}
	}//end of readFile method

	public void countWords(String word) {
		boolean found = false;
		for(String entry : tree.keySet()) {
			//System.out.println(entry + " : " + tree.get(entry) );
			if (word.equals(entry)) {
				found = true;
				System.out.println(entry + " occurs " + tree.get(entry) + " times ");
			}
		}
		if (!found)
			System.out.println("Word does not exist in the dictionary"); 
	}//end of countWords method

	public void countNode() {
		int count = 0;
		for(String entry : tree.keySet()) 
			count ++;
		System.out.println("There are " + count + " nodes ");
		
	}//end of count node
	
}//end of class
