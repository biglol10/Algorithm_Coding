import java.util.*;

public class Solution {
	static int value = 0;
	static String startWord = "";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String begin = "hit";
		String target = "cog";
		String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
		//solution(begin, target, words);
		System.out.println(solution(begin, target, words));
    }
	public static int solution(String begin, String target, String[] words) {
        int answer = 0;
        startWord = begin;
        if(!Arrays.stream(words).anyMatch(target::equals)) {
        	return 0;
        }
        Map<String,Boolean> wordMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
			wordMap.put(words[i],false);
		}
        dfs(begin, target, words, 0, wordMap);
        
        answer = value;
        
        return answer;
    }
	public static void dfs(String begin, String target, String[] words, int count, Map<String, Boolean> aMap) {
		if(begin==target) {
			value = count;
			return;
		}
		if(startWord != begin && aMap.get(begin)) return;
		aMap.put(begin, true);
		for (int i = 0; i < words.length; i++) {
			if(begin != words[i] && !aMap.get(words[i]) && CompareWords(begin, words[i])) {
				dfs(words[i],target, words, count+1,aMap);
			}
		}
	}
	public static boolean CompareWords(String a, String b) {
		int match = 0;
		for (int i = 0; i < a.length(); i++) {
			if(a.charAt(i) != b.charAt(i)) {
				match++;
			}
		}
		boolean result = (match == 1) ? true : false;
		return result;
	}
}