import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int m = 4;
        int n = 3;
        int[][] puddles = { { 2, 2 } };
        int[][] map = new int[n + 1][m + 1];
        for (int[] puddle : puddles) {
            map[puddle[1]][puddle[0]] = -1;
        }
        map[1][1] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (map[i][j] == -1) {
                    map[i][j] = 0;
                    continue;
                }
                if (i != 1) {
                    map[i][j] += map[i - 1][j] % 1000000007;
                }
                if (j != 1) {
                    map[i][j] += map[i][j - 1] % 1000000007;
                }
            }
        }
        System.out.println(map[n][m] % 1000000007);
    }
}