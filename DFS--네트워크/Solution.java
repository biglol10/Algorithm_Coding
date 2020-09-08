import java.util.*;

public class Solution {
	static boolean[] visitedComputers = new boolean[200];
	static int N = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
		int[][] computers = {
				{1,1,0},
				{1,1,0},
				{0,0,1}
		};
		System.out.print(solution(n, computers));
    }
    public static int solution(int n, int[][] computers) {
    	for (int i = 0; i < computers.length; i++) {
			if(!visitedComputers[i]) {
				dfs(i, computers);
				N++;
			}
		}
    	return N;
    }
    public static void dfs(int seq, int[][] computers) {
    	if(visitedComputers[seq]) return;
    	visitedComputers[seq] = true;
    	for (int i = 0; i < computers[seq].length; i++) {
			if(computers[seq][i] != 0) {
				dfs(i, computers);
			}
		}
    }
    
}