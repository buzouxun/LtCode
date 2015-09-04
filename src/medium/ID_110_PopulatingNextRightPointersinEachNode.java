package medium;

public class ID_110_PopulatingNextRightPointersinEachNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class Solution {

		/*
		 *           1
		 *      2           3
		 *   4    5      6     7
		 *  8 9 10 11  12 13 14 15
		 */

		public void connect(TreeLinkNode root) {
			if(root == null) {

			}
			else {
				root.next = null;
				TreeLinkNode left = root;
				while(left.left != null) {
					TreeLinkNode tmp = left;
					while(tmp.next != null) {
						tmp.left.next = tmp.right;
						tmp.right.next = tmp.next.left;
						tmp = tmp.next;
					}
					// when tmp.next == null
					tmp.left.next = tmp.right;
					tmp.right.next = null;
					left = left.left;
				}
			}
		}
	}

	class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;
		TreeLinkNode(int x) { val = x; }
	}

}
