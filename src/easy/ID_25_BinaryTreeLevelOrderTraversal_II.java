package easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class ID_25_BinaryTreeLevelOrderTraversal_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class Solution {
		public List<List<Integer>> levelOrderBottom(TreeNode root) {
			List<List<Integer>> traversals = new ArrayList<List<Integer>>();
			Stack<List<Integer>> stack = new Stack<>();
			if(root == null) {
				// do nothing
			}
			else {
				Queue<TreeNode> queue = new LinkedList<TreeNode>();
				queue.add(root);
				while(!queue.isEmpty()) {
					List<Integer> traversal = new ArrayList<Integer>();
					int numNodes = queue.size();
					for(int i = 0; i < numNodes; i++) {
						TreeNode node = queue.poll();
						traversal.add(node.val);
						if(node.left != null) {
							queue.add(node.left);
						}
						if(node.right != null) {
							queue.add(node.right);
						}
					}
					stack.add(traversal);
				}
				while(!stack.isEmpty()) {
					traversals.add(stack.pop());
				}
			}
			return traversals;
		}
	}

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

}
