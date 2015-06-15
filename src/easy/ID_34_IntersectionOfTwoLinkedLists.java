package easy;

public class ID_34_IntersectionOfTwoLinkedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class Solution {
		public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
			ListNode mergedNode = null;
			if(headA == null || headB == null) {
				// do nothing
			}
			else {
				int listALength = getLength(headA);
				int listBLength = getLength(headB);
				if(listALength > listBLength) {
					int diff = listALength - listBLength;
					while(diff > 0) {
						headA = headA.next;
						diff --;
					}
				}
				else {
					int diff = listBLength - listALength;
					while(diff > 0) {
						headB = headB.next;
						diff --;
					}
				}				
				while(headA != null && headB != null) {
					if(headA.hashCode() == headB.hashCode()) {
						mergedNode = headA;
						break;
					}
					else {
						headA = headA.next;
						headB = headB.next;
					}
				}				
			}
			return mergedNode;
		}
		private int getLength(ListNode node) {
			int length = 0;
			while(node != null) {
				length ++;
				node = node.next;
			}
			return length;
		}
	}

	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}

}
