import java.util.*;

public class Solution {
	static int realanswer = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = {1, 1, 1, 1, 1};
		int target = 3;
		System.out.print(solution(numbers, target));
		
    }
    public static int solution(int[] numbers, int target) {
    	int answer = 0;
    	int[] plusminus = { 1, -1 };
    	for (int i = 0; i < plusminus.length; i++) {
			answer += dfs(numbers, target, plusminus[i]*numbers[0], 0, 1);
		}
    	return answer;
    }
    public static int dfs(int[] numbers, int target, int subValue, int answer, int trial) {
    	if(subValue == target && trial == numbers.length) {
    		answer++;
    		return answer;
    	}
    	if(trial == numbers.length) {
    		return answer;
    	}
    	return dfs(numbers, target, subValue + numbers[trial], answer, trial + 1) + 
    			dfs(numbers, target, subValue + -1*numbers[trial], answer, trial + 1);
    }
}