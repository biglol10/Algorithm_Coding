import java.util.*;

public class Solution {
	static ArrayList<String> permvalues = new ArrayList<String>();
    public static void main(String[] args) {
    	int[] problem = { 0, 1, 2, 3, 4 };
        int[] answer = new int[4];
        doCombination(problem, answer, 0, 0);
    }
    public static void doCombination(int[] problem, int[] answer, int n, int idx) {
    	// n 은 arr의 index, idx는 problem의 index
    	if(n==answer.length) {
    		for (int i = 0; i < answer.length; i++) {
				System.out.print(answer[i]);
			}
    		System.out.println();
    		return;
    	}
    	if(idx==problem.length) {
    		return;
    	}
    	answer[n] = problem[idx];
    	doCombination(problem, answer, n+1, idx+1);
    	doCombination(problem, answer, n, idx+1);
    }
}
