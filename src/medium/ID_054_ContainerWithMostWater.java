package medium;

public class ID_054_ContainerWithMostWater {

	public static void main(String[] args) {
		ID_054_ContainerWithMostWater problem = new ID_054_ContainerWithMostWater();

		System.out.println("[2,3,10,5,7,8,9] -> " + problem.new Solution().maxArea(new int[]{2, 3, 10, 5, 7, 8, 9}));

	}

	class Solution {
		public int maxArea(int[] height) {
			int maxArea = 0;
			int length = height.length;
			if(length <= 1) {
				// do nothing
			}
			else {
				// 4 conditions
				// assuming height[left] < height[right]
				// I:    left < lefter -> unknown
				// II:   left >= lefter -> area decreases
				// III:  right < righter -> area decreases 
				// IV:   right > righter -> area decreases
				// loop when changing index, which from shorter line
				int left = 0;
				int right = length - 1;
				int direction = -1;	// 0 -> left, 1 -> right
				while(left < right) {
					int tmpArea = 0;
					if(direction == -1) {
						// first time
						tmpArea = getArea(height, left, right);
					}
					else if(direction == 0) {
						// come from left
						if(height[left - 1] >= height[left]) {
							// area will definitely decrease, so do nothing
						}
						else {
							tmpArea = getArea(height, left, right);
						}
					}
					else if (direction == 1) {
						// come from right
						if(height[right + 1] >= height[right]) {
							// do nothing
						}
						else {
							tmpArea = getArea(height, left, right);
						}
					}
					maxArea = Math.max(maxArea, tmpArea);
					if(height[left] < height[right]) {
						left ++;
					}
					else {
						right --;
					}					
				}				
			}
			return maxArea;
		}

		private int getArea(int[]height, int left, int right) {
			int y = Math.min(height[left], height[right]);
			int x = right - left;
			return x * y;
		}
	}

}
