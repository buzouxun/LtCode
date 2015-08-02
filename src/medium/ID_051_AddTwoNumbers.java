package medium;

public class ID_051_AddTwoNumbers {

	public static void main(String[] args) {
		ID_051_AddTwoNumbers problem = new ID_051_AddTwoNumbers();
		
		System.out.println("[5], [5] -> [0] = " + problem.new Solution().addTwoNumbers(problem.new ListNode(5), problem.new ListNode(5)).next.val);

	}

	class Solution {
		public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
			ListNode res = new ListNode(-1);
			if(l1 == null) {
				res.next = l2;
			}
			else if(l2 == null) {
				res.next = l1;
			}
			else {
				ListNode start = res;
				int addOne = 0;
				while(l1 != null && l2 != null) {
					int sum = l1.val + l2.val + addOne;
					addOne = 0;
					if(sum >= 10) addOne = 1;
					start.next = new ListNode(sum % 10);
					start = start.next;
					l1 = l1.next;
					l2 = l2.next;
				}
				int sum = 0;
				ListNode notNullNode = null;
				if(l1 == null && l2 == null && addOne == 1) {
					start.next = new ListNode(1);
				}
				else if(l1 == null && l2 == null && addOne == 0) {
					// do nothing
				}
				else if(l1 == null) {
//					sum = l2.val + addOne;
//					start.next = new ListNode(sum % 10);
//					start = start.next;
					notNullNode = l2;
				}
				else if(l2 == null) {
//					sum = l1.val + addOne;
//					start.next = new ListNode(sum % 10);
//					start = start.next;
					notNullNode = l1;
				}
				while(notNullNode != null) {
					sum = notNullNode.val + addOne;
					addOne = 0;
					if(sum >= 10) addOne = 1;
					start.next = new ListNode(sum % 10);
					start = start.next;
					notNullNode = notNullNode.next;
				}
				if(addOne == 1) start.next = new ListNode(1);
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
