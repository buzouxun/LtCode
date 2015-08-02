package easy;

import java.util.Stack;

public class ID_49_ReverseLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class Solution {
		public ListNode reverseList(ListNode head) {
			return reverseListIterative(head);
			//			return reverseListRecursive(head);
		}

		private ListNode reverseListIterative(ListNode head) {
			ListNode newHeader = new ListNode(-1);
			ListNode newTailer = null;
			newHeader.next = newTailer;
			while(head != null) {
				newHeader = head;
				newHeader.next = newTailer;
				newTailer = newHeader;
			}			
			return newHeader;
		}

		private ListNode reverseListRecursive(ListNode head) {
			ListNode res = null;

			return res;
		}
	}

	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

}
