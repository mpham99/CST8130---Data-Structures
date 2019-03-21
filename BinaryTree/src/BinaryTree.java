
public class BinaryTree {
	BinaryTreeNode root = null;

	public void insertInTree (int newData) {
		if (root == null) 
			root = new BinaryTreeNode(newData);
		else root.insert(newData);
	}


	public void displayInOrder () {
		displayInOrder (root);
	}
	
	public void preOrderTraversal () {
		preOrderTraversal (root);
	}
	
	public void postOrderTraversal () {
		postOrderTraversal (root);
	}

	public int calculateHeight () {
		return calculateHeight (root);
	}
	
	public void displayInOrder (BinaryTreeNode subRoot){
		if (subRoot == null)   return;
		displayInOrder (subRoot.getLeft());
		System.out.print(" " + subRoot.getData() + " ");
		displayInOrder (subRoot.getRight());
	}
	
	public void preOrderTraversal(BinaryTreeNode subRoot) {
		if(subRoot ==  null) return; 
		System.out.print(" " + subRoot.getData() + " ");
		preOrderTraversal(subRoot.getLeft());
		preOrderTraversal(subRoot.getRight());
	}
	
	public void postOrderTraversal(BinaryTreeNode subRoot) {
		if(subRoot ==  null)  return;
		postOrderTraversal(subRoot.getLeft());
		postOrderTraversal(subRoot.getRight());
		System.out.print(" " + subRoot.getData() + " ");
	}

	public int calculateHeight(BinaryTreeNode subRoot) {
		if(subRoot ==  null)  return 0;
		
		int height;
		int maxLeft = calculateHeight(subRoot.getLeft());
		int maxRight = calculateHeight(subRoot.getRight());
		
		height = Math.max(maxLeft, maxRight) + 1;
		return height;
	}
}//end of class
