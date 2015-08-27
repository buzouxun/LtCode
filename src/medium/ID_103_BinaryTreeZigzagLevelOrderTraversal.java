package medium;

import java.util.*;

public class ID_103_BinaryTreeZigzagLevelOrderTraversal {

	public static void main(String[] args) {
		ID_103_BinaryTreeZigzagLevelOrderTraversal problem = new ID_103_BinaryTreeZigzagLevelOrderTraversal();

		TreeNode root = problem.new TreeNode(1);
		root.left = problem.new TreeNode(2);
		root.right = problem.new TreeNode(3);
		root.left.left = problem.new TreeNode(4);
		root.left.right = problem.new TreeNode(5);
		System.out.println(problem.new Solution().zigzagLevelOrder(root));
	}

	class Solution {
		public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
			List<List<Integer>> res = new ArrayList<List<Integer>> ();
			if(root == null) {

			}
			else {
				Stack<TreeNode> s = new Stack<TreeNode>();
				long i = 0;
				s.push(root);
				while(!s.isEmpty()) {
					if(i % 2 == 0) {
						// left to right, now
						List<Integer> list = new ArrayList<Integer>(s.size());
						Stack<TreeNode> new_s = new Stack<TreeNode>();
						while(!s.isEmpty()) {
							TreeNode node = s.pop();
							list.add(node.val);
							if(node.left != null) new_s.push(node.left);
							if(node.right != null) new_s.push(node.right);
						}
						res.add(list);
						s = new_s;
					}
					else {
						// right to left, now
						List<Integer> list = new ArrayList<Integer>(s.size());
						Stack<TreeNode> new_s = new Stack<TreeNode>();
						while(!s.isEmpty()) {
							TreeNode node = s.pop();
							list.add(node.val);
							if(node.right != null) new_s.push(node.right);
							if(node.left != null) new_s.push(node.left);
						}
						res.add(list);
						s = new_s;
					}
					i ++;
				}
			}
			return res;
		}
	}

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

}
