package medium;

import java.util.*;

public class ID_114_WordLadder {

	public static void main(String[] args) {
		ID_114_WordLadder problem = new ID_114_WordLadder();

		Set<String> wordDict = new HashSet<String>();
		//		wordDict.addAll(Arrays.asList("hot","dot","dog","lot","log"));
		//		System.out.println(problem.new Solution().ladderLength("hit", "cog", wordDict));
		wordDict.addAll(Arrays.asList("si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"));
		//		wordDict.addAll(Arrays.asList("si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma"));
		//		wordDict.addAll(Arrays.asList("si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","zz"));
		long start = System.currentTimeMillis();
		System.out.println(problem.new Solution().ladderLength("qa", "sq", wordDict));
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}

	class Solution {

		public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
			boolean loopDict = wordDict.size() < beginWord.length() * 25 ? true : false;		
			int minLength = 0;
			Queue<String> q = new LinkedList<String>();
			Set<String> newDict = new HashSet<String>(wordDict);
			int currLength = 1;
			String newBeginWord = "";
			q.add(beginWord);
			newDict.remove(beginWord);
			while(!q.isEmpty()) {
				currLength ++;
				int size = q.size();
				if(loopDict) {
					for(int i = 0; i < size; i++) {
						newBeginWord = q.poll(); 
						if(diff(newBeginWord, endWord) == 1) {
							minLength = currLength;
							break;
						}
						String[] words = newDict.toArray(new String[newDict.size()]);
						for(String word: words) {
							if(diff(newBeginWord, word) == 1) {
								q.add(word);
								newDict.remove(word);
							}
						}
					}
					if(diff(newBeginWord, endWord) == 1) {
						minLength = currLength;
						break;
					}
				}
				else {
					for(int i = 0; i < size; i++) {
						newBeginWord = q.poll(); 
						if(diff(newBeginWord, endWord) == 1) {
							minLength = currLength;
							break;
						}
						else {
							// find all other words from this beginWord
							for(int j = 0; j < newBeginWord.length(); j++) {
								for(char k = 'a'; k <= 'z'; k++) {
									if(k != newBeginWord.charAt(j)) {
										char[] tmpChars = newBeginWord.toCharArray();
										tmpChars[j] = k;
										String tmpWord = new String(tmpChars);
										if(newDict.contains(tmpWord)) {
											q.add(tmpWord);
											newDict.remove(tmpWord);
										}
									}
								}
							} // end j loop
						}
					} // end i loop
					if(minLength != 0) {
						minLength = currLength;
						break;
					}
				}
			}
			return minLength;
		}

		public int ladderLength2(String beginWord, String endWord, Set<String> wordDict) {
			int[] minLength = new int[]{Integer.MAX_VALUE};
			helper(beginWord, endWord, wordDict, 1, minLength);
			if(minLength[0] == Integer.MAX_VALUE) {
				minLength[0] = 0;
			}
			return minLength[0];
		}

		private void helper(String beginWord, String endWord, Set<String> dict, int currLength, int[] minLength) {
			// reject
			if(currLength > minLength[0]) {
				return;
			}

			// accept
			if(diff(beginWord, endWord) == 1) {
				int tmpLength = currLength + 1;
				if(tmpLength < minLength[0]) {
					minLength[0] = tmpLength;
				}
				return;
			}

			for(String word: dict) {
				if(diff(beginWord, word) == 1) {
					String newBeginWord = new String(word);
					Set<String> newDict = new HashSet<String>(dict);
					//System.out.println(newBeginWord);
					newDict.remove(word);
					helper(newBeginWord, endWord, newDict, currLength + 1, minLength);
				}
			}
		}

		private int diff(String s1, String s2) {
			int diff = 0;
			char[] s1_chars = s1.toCharArray();
			char[] s2_chars = s2.toCharArray();
			for(int i = 0; i < s1_chars.length; i++) {
				if(s1_chars[i] != s2_chars[i]) {
					diff ++;
				}
				if(diff > 1) {
					break;
				}
			}
			return diff;
		}

		public int ladderLengths(String start, String end, Set<String> dict) {
			if (dict == null || dict.size() == 0) return 0;

			Queue<String> queue = new LinkedList<String>();
			queue.add(start);
			dict.remove(start);
			int length = 1;

			while (!queue.isEmpty()) {
				int count = queue.size(); // get current level size
				for (int i = 0; i < count; i++){
					String word = queue.poll(); // get word from queue
					if (word.equals(end)) return length; // end when word is found
					for (int j = 0; j < word.length(); j++) {
						for (char c = 'a'; c <= 'z'; c++) { // build new word
							char[] ch = word.toCharArray();
							if (ch[j] == c) continue;
							ch[j] = c;
							String newWord = new String(ch);
							if (dict.contains(newWord)){ // new word in dict
								queue.add(newWord); // add to queue
								dict.remove(newWord); // remove from dict
							}
						}
					}
				}
				length++;
			}
			return 0;
		}

	}
}
