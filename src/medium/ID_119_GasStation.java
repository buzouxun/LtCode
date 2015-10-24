package medium;

public class ID_119_GasStation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class Solution {
		public int canCompleteCircuit(int[] gas, int[] cost) {
			int res = -1;
			int tank = 0;
			int startIdx = gas.length - 1;
			int breakIdx = -1;
			// start to travel
			while(startIdx != breakIdx && startIdx >= 0) {		
				// fill oil at start index
				if(gas[startIdx] < cost[startIdx]) {
					startIdx --;
				}
				else {
					tank += gas[startIdx];
					tank -= cost[startIdx];
					// test breakpoint
					if(tank < 0) {
						startIdx --;
					}
					else {
						// initialize the break index
						if(breakIdx == -1) {
							breakIdx = startIdx;
						}
						// breakIdx + 1 -> startIdx - 1
						for(int i = (breakIdx + 1)%gas.length; i != startIdx; i=(i+1)%gas.length) {
							tank += gas[i];
							tank -= cost[i];
							if(tank < 0) {
								breakIdx = i;
								startIdx --;
								break;
							}
						}
					}
					// finish the circle
					if(tank >= 0) {
						break;
					}
				}
			}
			if(tank >= 0) {
				res = startIdx;
			}
			return res;
		}
	}

}
