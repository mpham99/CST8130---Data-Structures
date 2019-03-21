
public class BinaryTreeExample {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		
		tree.insertInTree(6);
		tree.insertInTree(3);
		tree.insertInTree(9);
		tree.insertInTree(1);
		tree.insertInTree(15);
		tree.insertInTree(7);
		
		tree.displayInOrder();
		System.out.println();
		tree.preOrderTraversal();
		System.out.println();
		tree.postOrderTraversal();
		System.out.println();
		System.out.println("The height of the tree is " + tree.calculateHeight());
	}

}
