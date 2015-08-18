package easy;

public class ID_19_RemoveDuplicatesFromSortedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class Solution {
		public ListNode deleteDuplicates(ListNode head) {
			ListNode res = new ListNode(-1);
			res.next = head;
			if(head != null) {
				ListNode unique = head;
				int uniqueVal = unique.val;
				ListNode tmp = head.next;
				unique.next = null;
				while(tmp != null) {
					if(tmp.val == uniqueVal) {
						// ignore duplicates
						tmp = tmp.next;
					}
					else {
						unique.next = tmp;
						unique = unique.next;
						uniqueVal = unique.val;
						tmp = tmp.next;
						unique.next = null;
					}
				}	
			}
			return res.next;
		}
	}

	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

}
