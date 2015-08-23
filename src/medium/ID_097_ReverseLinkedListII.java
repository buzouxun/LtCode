package medium;

public class ID_097_ReverseLinkedListII {

	public static void main(String[] args) {
		ID_097_ReverseLinkedListII problem = new ID_097_ReverseLinkedListII();

		ListNode head = problem.new ListNode(9);
		head.next = problem.new ListNode(11);
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
//			ListNode start = pre.next; // a pointer to the beginning of a sub-list that will be reversed
//			ListNode then = start.next; // a pointer to a node that will be reversed
//			// 1 - 2 -3 - 4 - 5 ; m=2; n =4 ---> pre = 1, start = 2, then = 3
//			// dummy-> 1 -> 2 -> 3 -> 4 -> 5
//			for(int i=0; i<n-m; i++)
//			{
//				start.next = then.next;
//				then.next = pre.next;
//				pre.next = then;
//				then = start.next;
//			}
//			// first reversing : dummy->1 - 3 - 2 - 4 - 5; pre = 1, start = 2, then = 4
//			// second reversing: dummy->1 - 4 - 3 - 2 - 5; pre = 1, start = 2, then = 5 (finish)
//			return res.next;
			
//			if(head == null) return null;
//			ListNode rs = new ListNode(0);
//			rs.next = head;
//			ListNode st = rs;
//			for(int i = 0; i< m-1; i++) {
//				st = st.next;
//			}
//			ListNode r_h = st.next;
//			ListNode r_t = r_h.next;
//			for(int i=0; i<n-m; i++) {
//				r_h.next = r_t.next;
//				r_t.next = st.next;
//				st.next = r_t;
//				r_t = r_h.next;
//			}
//			return rs.next;

			ListNode rs = new ListNode(0);
			rs.next = head;
			ListNode st = rs;
			for(int i = 0; i < m - 1; i++) {
				st = st.next;
			}
			ListNode r_t = st.next;
			ListNode r_h = r_t.next;
			for(int i = 0; i < n - m; i++) {				
				r_t.next = r_h.next;
				r_h.next = st.next;
				st.next = r_h;
				r_h = r_t.next;
			}
			return rs.next;
		}
	}

	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

}
