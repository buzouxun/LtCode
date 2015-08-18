package medium;

public class ID_092_RemoveDuplicatesfromSortedListII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class Solution {
		public ListNode deleteDuplicates(ListNode head) {
			ListNode res = new ListNode(-1);
			ListNode newHead = res;
			ListNode first = null;
			ListNode second = null;
			ListNode tmp = head;
			while(tmp != null) {
				if(first == null) {
					first = tmp;
				}
				else {
					if(tmp.val == first.val) {
						second = tmp;
					}
					else {
						if(second == null) {
							newHead.next = first;
							first.next = null;
							newHead = newHead.next;
						}
						first = tmp;
						second = null;
					}
				}
				tmp = tmp.next;
			}
			if(first != null && second == null) {
				newHead.next = first;
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
