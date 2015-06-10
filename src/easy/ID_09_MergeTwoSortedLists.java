package easy;

public class ID_09_MergeTwoSortedLists {

	public static void main(String[] args) {
		ID_09_MergeTwoSortedLists problem = new ID_09_MergeTwoSortedLists();
		ListNode test = null;
		ListNode input1 = null;
		ListNode input2 = null;

		// [5], [1,2,4] -> [1,2,4,5]
		input1 = problem.new ListNode(5);
		input2 = problem.new ListNode(1);
		input2.next = problem.new ListNode(2);
		input2.next.next = problem.new ListNode(4);
		test = problem.new Solution().mergeTwoLists(input1, input2);
		System.out.println("[5], [1,2,4] -> [" + test.val + ", " + test.next.val + ", " + 
				test.next.next.val + ", " + test.next.next.next.val + "] ");


	}

	class Solution {

		public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
			// recursive
			ListNode mergedListNode = null;
			if(l1 == null) { 
				mergedListNode = l2;
			}
			else if(l2 == null) {
				mergedListNode = l1;
			}
			else if(l1.val < l2.val) {
				l1.next = mergeTwoLists(l1.next, l2);
				mergedListNode = l1;
			}
			else {
				l2.next = mergeTwoLists(l1, l2.next);
				mergedListNode = l2;
			}

			return mergedListNode;
			/*
			// iterative
			ListNode mergedListNode = null;
			if(l1 == null) { 
				mergedListNode = l2;
			}
			else if(l2 == null) {
				mergedListNode = l1;
			}
			else {
				ListNode l1Node = l1;
				ListNode l2Node = l2;
				ListNode tmpNode = null;

				if(l1Node.val < l2Node.val) {
					mergedListNode = l1;
					tmpNode = mergedListNode;
					l1Node = l1Node.next;
				}
				else {
					mergedListNode = l2;
					tmpNode = mergedListNode;
					l2Node = l2Node.next;
				}

				while(l1Node != null && l2Node != null) {
					if(l1Node.val < l2Node.val) {
						tmpNode.next = l1Node;
						tmpNode = tmpNode.next;
						l1Node = l1Node.next;
					}
					else {
						tmpNode.next = l2Node;
						tmpNode = tmpNode.next;
						l2Node = l2Node.next;						
					}
				}

				if(l1Node == null) {
					tmpNode.next = l2Node;
				}
				else {
					tmpNode.next = l1Node;
				}
			}
			return mergedListNode;
			 */
		}
	}

	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
}
