package medium;

import java.util.LinkedList;
import java.util.Queue;

public class ID_078_RotateList {

	public static void main(String[] args) {
		ID_078_RotateList problem = new ID_078_RotateList();

		// Given 1->2->3->4->5->NULL and k = 2,
		// return 4->5->1->2->3->NULL.

		ListNode one = problem.new ListNode(1);
		one.next = problem.new ListNode(2);
		System.out.println("[1,2], 1 -> " + problem.new Solution().rotateRight(one, 1).next.val);
	}

	class Solution {
		public ListNode rotateRight(ListNode head, int k) {
			ListNode res = new ListNode(-1);
			res.next = head;
			if(k == 0 || head == null || head.next == null) {
				// do nothing
			}
			else {
				ListNode tmp = head;
				// simplify k
				int length = 0;
				while(tmp != null) {
					length ++;
					tmp = tmp.next;
				}
				k = k % length;
				if(k == 0) {

				}
				else {
					// put them into boxes
					ListNode new_head_pre = null;
					ListNode old_tail = null;
					int new_head_pre_idx = 0;
					int new_tail_idx = 0;
					int index = 0;
					tmp = head;
					while(tmp != null) {
						if(new_head_pre == null) {
							new_head_pre = tmp;
							new_head_pre_idx = index;
						}
						else if(old_tail == null) {
							new_tail_idx = index;
							if(new_tail_idx - new_head_pre_idx == k) {
								old_tail = tmp;
							}
						}
						else {
							old_tail = tmp;
							new_head_pre = new_head_pre.next;
							new_head_pre_idx ++;
							new_tail_idx ++;
						}
						if(tmp.next == null) {
							break;
						}
						else {
							tmp = tmp.next;
							index ++;
						}
					}
					ListNode new_head = new_head_pre.next;
					old_tail.next = head;
					new_head_pre.next = null;
					res.next = new_head;	
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
