package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
	
	Stack<TreeNode> stack = new Stack<>();
	List<Integer> elementsInOrder = new ArrayList<Integer>();
	
	public List<Integer> inorderTraversal(TreeNode root) {
    	if ( root == null ) {
    		return elementsInOrder;
    	}
    	inorderTraversal(root.left);
    	elementsInOrder.add(root.val);
		inorderTraversal(root.right);
		return elementsInOrder;
    }
	
	
	//[2, 1, 3, 5, 4]
	public List<Integer> inorderTraversal1(TreeNode root) {
		elementsInOrder = new ArrayList<>();
		if ( root == null ) {
    		return elementsInOrder;
    	}
    	Stack<TreeNode> stack = new Stack<>();
    	TreeNode curr = root;
    	TreeNode pre = curr;
    	while ( curr != null ) {
    		System.out.println("Curr value : " + curr.val);
			if ( curr.left == null ) {
    			//System.out.println("IF curr value : " + curr.val);
    			elementsInOrder.add(curr.val);
    			if ( !stack.isEmpty() ) {
	    			pre = stack.pop();
	    			System.out.println("Pre val : " + pre.val);
	    			elementsInOrder.add(pre.val);
    			}
    			curr = curr.right;
    			System.out.println("Post IF pre : " + pre.val);
    			if ( curr == null ) {
    				curr = pre;
    				curr.left = null;
    			}
    			System.out.println("Post IF curr value : " + curr.val);
    		} else if ( curr.left != null ) {
    			//System.out.println("ELIF curr vale : " + curr.val);
    			stack.push(curr);
        		pre = curr;
        		curr = curr.left;
        		//System.out.println("Curr : " + curr.val);
    		}
    	}
		return elementsInOrder;
    }
	
	//[2, 1, 3, 5, 4]
	public List<Integer> inorderTraversal2(TreeNode root) {
		elementsInOrder = new ArrayList<>();
		TreeNode curr = root;
		while ( curr != null ) {
			if ( curr.left == null ) {
				elementsInOrder.add(curr.val);
				curr = curr.right;
			} else {
				TreeNode pre = curr.left; 					//pre = 6 = 3.left
				while ( pre.right != null ) {				//loop skipped
					pre = pre.right;
				}
				pre.right = curr;							//pre.right = 6.right = 3
				TreeNode temp = curr; // store cur node		// temp = curr = 3
                curr = curr.left; // move cur to the top of the new tree	//curr = 3.left = 6
                temp.left = null;
			}
		}
		return elementsInOrder;
	}
	
	public static void main(String[] args) {
		BinaryTreeInorderTraversal traversal = new BinaryTreeInorderTraversal();
		TreeNode tree = traversal.new TreeNode(1);
		TreeNode l1 = traversal.new TreeNode(2);
		TreeNode r1 = traversal.new TreeNode(3);
		TreeNode r2 = traversal.new TreeNode(4);
		TreeNode l3 = traversal.new TreeNode(5);
		tree.left = l1;
		tree.right = r1;
		tree.right.right = r2;
		tree.right.right.left = l3;
		//1 2 
		List<Integer> elementsInOrder = traversal.inorderTraversal(tree);
		System.out.println("1: " + elementsInOrder);
		List<Integer> elementsInOrder1 = traversal.inorderTraversal2(tree);
		System.out.println("2: " + elementsInOrder1);
		
	}
	
	public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode() {}
	    TreeNode(int val) { this.val = val; }
	    TreeNode(int val, TreeNode left, TreeNode right) {
	        this.val = val;
	        this.left = left;
	        this.right = right;
	    }
	}
}
