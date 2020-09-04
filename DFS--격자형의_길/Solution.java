import java.util.*;

public class Solution {
    static int h = 5;
    static int w = 4;
    static int[][] dp = new int[h + 1][w + 1];

    public static void main(String[] args) {
        System.out.println(dfs(0, 0));
    }

    public static int dfs(int nowh, int noww) {
        if (nowh > h || noww > w)
            return 0;
        if (nowh == h && noww == w) {
            return 1;
        }
        if (dp[nowh][noww] != 0)
            return dp[nowh][noww];
        return dp[nowh][noww] = dfs(nowh + 1, noww) + dfs(nowh, noww + 1);
    }
}