package easy;

public class ID_20_MergeSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class Solution {
		public void merge(int[] nums1, int m, int[] nums2, int n) {
			// merge from behind
			if(n == 0) {
				// do nothing
			}
			else {
				while(m > 0 && n >0) {
					if(nums1[m - 1] < nums2[n -1]) {
						nums1[m + n - 1] = nums2[n - 1];
						n --;
					}
					else {
						nums1[m + n - 1] = nums1[m - 1];
						m --;
					}
				}
				if(n > 0) {
					while(n > 0) {
						nums1[n - 1] = nums2[n - 1];
						n --;
					}
				}
			}
			// merge starting small to large
			/*
			if(m == 0) {
				for(int j = 0; j < n; j++) {
					nums1[j] = nums2[j];
				}
			}
			else if(n == 0) {
				// do nothing
			}
			else {
				int i = 0;
				while(i < m) {
					if(nums1[i] < nums2[0]) {
						i ++;
					}
					else {
						switch2(nums1, i, nums2, 0);
						reSort(nums2, n);
						i ++;
					}
				}
				for(int j = 0; j < n; j++) {
					nums1[m + j] = nums2[j];
				}
			}
			 */
		}
		/*
		private void switch2(int[] nums1, int i, int[] nums2, int j) {
			int tmp = nums1[i];
			nums1[i] = nums2[j];
			nums2[j] = tmp;
		}
		private void reSort(int[] nums, int n) {
			if(n < 2) {
				// do nothing
			}
			else {
				for(int i = 0; i < n - 1; i++) {
					if(nums[i] > nums[i + 1]) {
						switch2(nums, i, nums, i + 1);
					}
				}
			}
		}
		 */
	}
}
