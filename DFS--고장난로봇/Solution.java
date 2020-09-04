import java.util.*;

public class Solution {
    static boolean[][] grid = new boolean[100][100];
    static int vx[] = { 1, -1, 0, 0 };
    static int vy[] = { 0, 0, 1, -1 };

    static double[] prob = new double[4];

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int n = 2;
        int east = 25, west = 25, south = 25, north = 25;
        System.out.println(getProbability(n, east, west, south, north));
    }

    public static double getProbability(int n, int east, int west, int south, int north) {
        prob[0] = east / 100.0;
        prob[1] = west / 100.0;
        prob[2] = south / 100.0;
        prob[3] = north / 100.0;

        return dfs(50, 50, n);
    }

    public static double dfs(int x, int y, int n) {
        if (grid[x][y])
            return 0;
        if (n == 0)
            return 1;

        grid[x][y] = true;
        double ret = 0;
        for (int i = 0; i < 4; i++) {
            ret += dfs(x + vx[i], y + vy[i], n - 1) * prob[i];
        }
        grid[x][y] = false;
        return ret;
    }
}