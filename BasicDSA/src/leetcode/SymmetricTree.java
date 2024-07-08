package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.BinaryTreeInorderTraversal.TreeNode;

public class SymmetricTree {
	
	public boolean isSymmetric(TreeNode root) {
		boolean isSymmetric = false;
		isSymmetric = root == null || isMirrorImage(root.left, root.right);
		return isSymmetric;
    }
	
	public boolean isMirrorImage(TreeNode left, TreeNode right) {
		if ( left == null && right == null ) {
			return true;
		}
		if ( left == null || right == null ) {
			return false;
		}
		if ( left.val != right.val) {
			return false;
		}
		return (isMirrorImage(left.left, right.right) && isMirrorImage(left.right, right.left));
	}
	
	public boolean isSymmetricBFS(TreeNode root) {
		boolean isSymmetric = (root == null);
		if ( root == null ) {
			return isSymmetric;
		}
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		while ( !q.isEmpty() ) {
			int size = q.size();
			List<Integer> nums = new ArrayList<>();
			for ( int i = 0; i < size; i++ ) {
				TreeNode curr = q.poll();
				if ( curr == null ) {
					nums.add(null);
				} else {
					nums.add(curr.val);
					q.offer(curr.left);
					q.offer(curr.right);
				}
			}
			isSymmetric = checkListSymmetry(nums);
			if ( !isSymmetric ) {
				return isSymmetric;
			}
		}
		return isSymmetric;
    }
	
	public boolean checkListSymmetry(List list) {
		System.out.println("list: " + list);
		int left = 0;
		int right = list.size() - 1;
		while ( left < right ) {
			if ( list.get(left++) != list.get(right--) ) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		SymmetricTree traversal = new SymmetricTree();
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
		/*
		boolean isSymmetric = traversal.isSymmetricBFS(tree);
		System.out.println("isSymmetric :: " + isSymmetric);
		
		boolean isSymmetric1 = traversal.isSymmetricBFS(tree1);
		System.out.println("isSymmetric :: " + isSymmetric1);
		*/
		boolean isSymmetric2 = traversal.isSymmetricBFS(tree2);
		System.out.println("isSymmetric :: " + isSymmetric2);
		
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
