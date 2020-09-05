import java.util.*;

public class Solution {
	static long[][][] ways = new long[100][100][55];
	static int[] dx = new int[] {1,1,1,0,-1,-1,-1,0,2,1,-1,-2,-2,-1,1,2};
	static int[] dy = new int[] {1,0,-1,-1,-1,0,1,1,-1,-2,-2,-1,1,2,2,1};
    public static void main(String[] args) {
        int numRed = 2;
        int numBlue = 3;
        int onlyRed = 100;
        int onlyBlue = 400;
        int bothColors = 300;
        System.out.print(getMaximum(numRed, numBlue, onlyRed, onlyBlue, bothColors));
    }
    public static int getMaximum(int numRed, int numBlue, int onlyRed, int onlyBlue, int bothColors) {
    	int ans = Integer.MIN_VALUE;
    	int change = Math.min(numRed, numBlue);
    	
    	for (int i = 0; i <= change; i++) {
			int myscore = (numRed-i)*onlyRed+(numBlue-i)*onlyBlue+2*i*bothColors;
			ans = Math.max(ans, myscore);
		}
    	return ans;
    }
}