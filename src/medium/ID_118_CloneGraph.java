package medium;

import java.util.*;

public class ID_118_CloneGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class Solution {
		public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
			if(node == null) {
				return node;
			}
			else {
				UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
				if(node.neighbors.size() > 0) {
					Queue<UndirectedGraphNode> neighborsUnclonedNodes = new LinkedList<UndirectedGraphNode>(); 
					Queue<UndirectedGraphNode> originalNodes = new LinkedList<UndirectedGraphNode>();	
					Map<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();			
					// initialize
					neighborsUnclonedNodes.add(newNode);
					originalNodes.add(node);
					map.put(newNode.label, newNode);
					// loop till none in queue
					while(originalNodes.size() > 0) {
						int size = originalNodes.size();
						for(int i = 0; i < size; i++) {
							UndirectedGraphNode neighborsUnclonedNode = neighborsUnclonedNodes.poll();
							UndirectedGraphNode originalNode = originalNodes.poll();
							for(int j = 0; j < originalNode.neighbors.size(); j++) {
								// add neighbors
								if(map.containsKey(originalNode.neighbors.get(j).label)) {
									neighborsUnclonedNode.neighbors.add(map.get(originalNode.neighbors.get(j).label));
								}
								else {
									UndirectedGraphNode tmpNode = new UndirectedGraphNode(originalNode.neighbors.get(j).label);
									neighborsUnclonedNode.neighbors.add(tmpNode);
									// reset
									neighborsUnclonedNodes.add(neighborsUnclonedNode.neighbors.get(j));
									originalNodes.add(originalNode.neighbors.get(j));
									map.put(tmpNode.label, neighborsUnclonedNode.neighbors.get(j));
								}
							}
						}
					} // end while loop
				}
				return newNode;
			}
		}
	}

	/**
	 * Definition for undirected graph.
	 */
	class UndirectedGraphNode {
		int label;
		List<UndirectedGraphNode> neighbors;
		UndirectedGraphNode(int x) { 
			label = x; 
			neighbors = new ArrayList<UndirectedGraphNode>(); 
		}
	};


}
