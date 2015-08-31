package medium;

import java.util.*;

public class ID_108_PathSumII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class Solution {
		public List<List<Integer>> pathSum(TreeNode root, int sum) {
			List<List<Integer>> res = new ArrayList<List<Integer>> ();
			if(root == null) {

			}
			else { 
				int target = sum;
				int tmpSum = root.val;
				List<Integer> path = new ArrayList<Integer>();
				path.add(root.val);
				helper(root, target, tmpSum, res, path);
			}
			return res;
		}

		private void helper(TreeNode node, int target, int tmpSum, List<List<Integer>> res, List<Integer> path) {
			if(tmpSum == target && node.left == null && node.right == null) {
				res.add(path);
			}
			else if(tmpSum != target && node.left == null && node.right == null) {
				return;
			}
			else {
				if(node.left != null) {
					int newTmpSum = tmpSum + node.left.val;
					List<Integer> newPath = new ArrayList<Integer>(path);
					newPath.add(node.left.val);
					helper(node.left, target, newTmpSum, res, newPath);
				}
				if(node.right != null) {
					int newTmpSum = tmpSum + node.right.val;
					List<Integer> newPath = new ArrayList<Integer>(path);
					newPath.add(node.right.val);
					helper(node.right, target, newTmpSum, res, newPath);
				}
			}
		}
		
	}

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

}
