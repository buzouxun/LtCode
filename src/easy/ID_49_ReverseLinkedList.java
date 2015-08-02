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
			ListNode newHeader = null;
			ListNode newTailer = null;
			while(head != null) {
				ListNode tmp = head.next;
				newHeader = head;
				newHeader.next = newTailer;
				newTailer = newHeader;
				head = tmp;
			}			
			return newHeader;
		}

		private ListNode reverseListRecursive(ListNode head) {
			ListNode res = null;
			if(head == null || head.next == null) {
				res = head;
			}
			else {
				ListNode head_next = head.next;
				ListNode tmp = reverseListRecursive(head_next);
				head_next.next = head;		
				head_next.next.next = null;
				res = tmp;
			}
			return res;
		}
	}

	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

}
