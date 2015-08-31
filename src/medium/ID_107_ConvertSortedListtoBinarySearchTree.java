package medium;

public class ID_107_ConvertSortedListtoBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class Solution {
		public TreeNode sortedListToBST(ListNode head) {
			int length = getLength(head);
			if(length == 0) {
				return null;
			}
			else {
				ListNode[] newHead = new ListNode[]{head};
				//				int[] size = new int[]{0};
				//				return helper(length, 1, size, newHead);
				return helper(length, newHead);
			}
		}

		private TreeNode helper(int length, ListNode[] head) {
			TreeNode node = new TreeNode(-1);
			if(length == 0) {
				return null;
			}
			else {
				node.left = helper(length / 2, head);
				node.val = head[0].val;
				head[0] = head[0].next;
				node.right = helper(length - length / 2 - 1, head);
			}
			return node;
		}

		private int getLength(ListNode node) {
			int length = 0;
			while(node != null) {
				length ++;
				node = node.next;
			}
			return length;
		}
	}

	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

}
