package medium;

public class ID_093_PartitionList {

	public static void main(String[] args) {
		ID_093_PartitionList problem = new ID_093_PartitionList();
		ListNode test = problem.new ListNode(1);
		System.out.println(problem.new Solution().partition(test, 0));
	}

	class Solution {
		public ListNode partition(ListNode head, int x) {
			ListNode small = new ListNode(x);
			ListNode large = new ListNode(x - 1);
			ListNode small_head = small;
			ListNode large_head = large;
			ListNode tmp = head;
			while(tmp != null) {
				int value = tmp.val;
				if(value < x) {
					small.next = tmp;
					small = small.next;
				}
				else {
					large.next = tmp;
					large = large.next;
				}
				tmp = tmp.next;
			}
			ListNode res = new ListNode(-1);
			if(small.val != x && large.val != x - 1) {
				res.next = small_head.next;
				small.next = large_head.next;
				large.next = null;
			}
			else if(small.val != x) {
				res.next = small_head.next;
				small.next = null;
			}
			else if(large.val != x - 1) {
				res.next = large_head.next;
				large.next = null;
			}
			else {
				// do nothing
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
