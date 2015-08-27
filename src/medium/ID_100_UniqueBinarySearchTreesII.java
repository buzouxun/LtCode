package medium;

import java.util.*;

public class ID_100_UniqueBinarySearchTreesII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class Solution {
		public List<TreeNode> generateTrees(int n) {
			List<TreeNode> res = helper(1, n);
			return res;
		}

		private List<TreeNode> helper(int start, int end) {
			// 1, 1 -> new TreeNode(1);
			// 1, 2 -> new TreeNode(1).right = new TreeNode(2), new TreeNode(2).left = new TreeNode(1)
			List<TreeNode> res = new ArrayList<TreeNode>();
			if(start > end) {
				res.add(null);
			}
			else {
				// left : (1,0), (1,1), (1,2), (1,3) ... (1, n - 1)
				List<TreeNode> lefts = null;
				// right: (2, n), (3, n), (4, n), ....(n, n), (n + 1, n)
				List<TreeNode> rights = null;
				for(int i = start; i <= end; i++) {
					lefts = helper(start, i - 1);
					rights = helper(i + 1, end);
					for(TreeNode left : lefts) {
						for(TreeNode right: rights) {
							TreeNode root = new TreeNode(i);
							root.left = left;
							root.right = right;
							res.add(root);
						}
					}
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
