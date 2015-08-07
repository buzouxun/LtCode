package medium;

public class ID_061_SwapNodesInPairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class Solution {
		public ListNode swapPairs(ListNode head) {
			ListNode node = new ListNode(-1);
			node.next = head;
			ListNode tmp = node;
			while(tmp != null && tmp.next != null && tmp.next.next != null) {
				//swap  1 -> 2 -> 3  ---> 1 -> 3 -> 2
				ListNode nodeAfterNode3 = tmp.next.next.next;
				ListNode node3 = tmp.next.next;
				ListNode node2 = tmp.next;
				tmp.next = node3;
				tmp.next.next = node2;
				tmp.next.next.next = nodeAfterNode3;
				tmp = tmp.next.next;				
			}			
			return node.next;
		}
	}

	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

}
