package easy;

public class ID_46_RemoveLinkedListElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class Solution {
		public ListNode removeElements(ListNode head, int val) {
			ListNode res = new ListNode(-1);
			res.next = head;
			ListNode node = res;
			while(node != null && node.next != null) {
				if(node.next.val == val) {
					node.next = node.next.next;
				}
				else {
					node = node.next;				
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
