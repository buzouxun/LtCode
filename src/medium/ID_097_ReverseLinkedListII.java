package medium;

public class ID_097_ReverseLinkedListII {

	public static void main(String[] args) {
		ID_097_ReverseLinkedListII problem = new ID_097_ReverseLinkedListII();

		ListNode head = problem.new ListNode(3);
		head.next = problem.new ListNode(5);
		System.out.println(problem.new Solution().reverseBetween(head, 1, 2).next.val);
	}

	class Solution {
		// 1->2->3->4->5->NULL
		// 1->2
		// 1->3->2
		// 1->4->3->2
		public ListNode reverseBetween(ListNode head, int m, int n) {
			//			if(head == null) return null;
			//			ListNode res = new ListNode(0); // create a dummy node to mark the head of this list
			//			res.next = head;
			//			ListNode pre = res; // make a pointer pre as a marker for the node before reversing
			//			for(int i = 0; i< m-1; i++) pre = pre.next;
			//
			//			ListNode start = pre.next; // a pointer to the beginning of a sub-list that will be reversed
			//			ListNode then = start.next; // a pointer to a node that will be reversed
			//
			//			// 1 - 2 -3 - 4 - 5 ; m=2; n =4 ---> pre = 1, start = 2, then = 3
			//			// dummy-> 1 -> 2 -> 3 -> 4 -> 5
			//
			//			for(int i=0; i<n-m; i++)
			//			{
			//				start.next = then.next;
			//				then.next = pre.next;
			//				pre.next = then;
			//				then = start.next;
			//			}
			//
			//			// first reversing : dummy->1 - 3 - 2 - 4 - 5; pre = 1, start = 2, then = 4
			//			// second reversing: dummy->1 - 4 - 3 - 2 - 5; pre = 1, start = 2, then = 5 (finish)
			//
			//			return res.next;

			ListNode res = new ListNode(-1);
			res.next = head;
			int i = 0;
			ListNode tmp = head;
			ListNode start = res;
			ListNode r_tail = null;
			ListNode r_head = null;
//			for(int i = )
			return res.next;
		}
	}

	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

}
