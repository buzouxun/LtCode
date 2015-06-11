package easy;

public class ID_21_SameTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class Solution {

		boolean same = true;

		public boolean isSameTree(TreeNode p, TreeNode q) {
			if(p == null && q == null) {
				// do nothing
			}
			else if(p != null && q == null) {
				same = false;
			}
			else if(p == null && q != null) {
				same = false;
			}
			else if(p.val != q.val) {
				same = false;
			}
			else {
				same = same && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
			}			
			return same;
		}
	}

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

}
