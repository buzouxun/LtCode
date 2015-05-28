package easy;

public class ID_07_RemoveNthNodeFromEndOfList {

	public static void main(String[] args) {
		ID_07_RemoveNthNodeFromEndOfList problem = new ID_07_RemoveNthNodeFromEndOfList();
		ListNode test;
		ListNode head;

		// 1->2->3->4 and n = 2, return 1->2->4
		head = problem.new ListNode(1);
		head.next = problem.new ListNode(2);
		head.next.next = problem.new ListNode(3);
		head.next.next.next = problem.new ListNode(4);
		test = problem.new Solution().removeNthFromEnd(head, 2);
		System.out.println("return 1->2->4 = " + head.val + "->" + head.next.val + "->" + head.next.next.val);




	}
	class Solution {
		public ListNode removeNthFromEnd(ListNode head, int n) {
			/*
			ListNode sol;
			// length of linked list
			int listLength = 1;
			ListNode tmpNode = head;
			while(tmpNode.next != null) {
				listLength ++;
				tmpNode = tmpNode.next;
			}
			// remove nth
			tmpNode = head;
			if(listLength - n == 0) {
				head = head.next;
			}
			else {
				for(int nth = 1; nth < listLength; nth++) {
					if(nth == listLength - n) {
						tmpNode.next = tmpNode.next.next;
						break;
					}
					else {
						tmpNode = tmpNode.next;
					}
				}
			}
			sol = head;
			return sol;
			 */

			ListNode sol;
			ListNode pre = new ListNode(0);
			pre.next = head;
			ListNode n1 = pre;
			ListNode n2 = pre;			
			for(int i = 0; i < n; i++) {
				n2 = n2.next;
			}			
			while(n2.next != null) {
				n1 = n1.next;
				n2 = n2.next;
			}			
			n1.next = n1.next.next;			
			sol = pre.next;			
			return sol;
		}
	}

	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

}
