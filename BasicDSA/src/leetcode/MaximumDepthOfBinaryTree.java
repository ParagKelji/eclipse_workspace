package leetcode;

import java.util.LinkedList;
import java.util.Queue;

import leetcode.SymmetricTree.TreeNode;

public class MaximumDepthOfBinaryTree {
	
	public int maxDepth(TreeNode root) {
		if ( root == null ) {
			return 0;
		}
		int depth = 1;
		depth = binaryTraversal(root);
		return depth;
    }
	public int binaryTraversal(TreeNode node) {
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(node);
		int depth = (node == null) ? 0 : 1;
		while ( !q.isEmpty() ) {
			int n = q.size();
			for ( int i = 0; i < n; i++ ) {
				TreeNode curr = q.poll();
				if ( curr == null ) {
					
				} else {
					q.offer(curr.left);
					//q.offer(curr.right);
					depth++;
				}
			}
		}
		return depth;
	}
	
	public static void main(String[] args) {
		MaximumDepthOfBinaryTree traversal = new MaximumDepthOfBinaryTree();
		TreeNode tree = traversal.new TreeNode(1);
		TreeNode l1 = traversal.new TreeNode(2);
		TreeNode r1 = traversal.new TreeNode(2);
		TreeNode l11 = traversal.new TreeNode(3);
		TreeNode r12 = traversal.new TreeNode(4);
		TreeNode l21 = traversal.new TreeNode(4);
		TreeNode r22 = traversal.new TreeNode(3);
		tree.left = l1;
		tree.right = r1;
		tree.left.left = l11;
		tree.left.right = r12;
		tree.right.left = l21;
		tree.right.right = r22;
		
		//[1,2,2,2,null,2]
		TreeNode tree1 = traversal.new TreeNode(1);
		TreeNode l1_1 = traversal.new TreeNode(2);
		TreeNode r1_1 = traversal.new TreeNode(2);
		TreeNode l11_1 = traversal.new TreeNode(2);
		//TreeNode r12_1 = traversal.new TreeNode(null);
		TreeNode l21_1 = traversal.new TreeNode(2);
		//TreeNode r22_1 = traversal.new TreeNode(2);
		tree1.left = l1_1;
		tree1.right = r1_1;
		tree1.left.left = l11_1;
		//tree.left.right = r12_1;
		tree1.right.left = l21_1;
		//tree1.right.right = r22_1;
		
		//[1,0]
		TreeNode tree2 = traversal.new TreeNode(1);
		TreeNode l1_2 = traversal.new TreeNode(0);
		tree2.left = l1_2;
		
		
		int depth = traversal.maxDepth(tree);
		System.out.println("depth :: " + depth);
		
		int depth1 = traversal.maxDepth(tree1);
		System.out.println("depth :: " + depth1);
		
		int depth2 = traversal.maxDepth(tree2);
		System.out.println("depth :: " + depth2);
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
