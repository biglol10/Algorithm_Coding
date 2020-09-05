import java.util.*;

public class Solution {
    static long[][][] ways = new long[100][100][55];
    static int[] dx = new int[] { 1, 1, 1, 0, -1, -1, -1, 0, 2, 1, -1, -2, -2, -1, 1, 2 };
    static int[] dy = new int[] { 1, 0, -1, -1, -1, 0, 1, 1, -1, -2, -2, -1, 1, 2, 2, 1 };

    public static void main(String[] args) {
        int size = 3;
        int start[] = { 0, 0 };
        int end[] = { 0, 0 };
        int numMoves = 2;
        System.out.print(howMany(size, start, end, numMoves));
    }

    public static long howMany(int size, int[] start, int[] end, int numMoves) {
        int sx = start[0], sy = start[1], ex = end[0], ey = end[1];
        ways[sy][sx][0] = 1;

        for (int i = 1; i <= numMoves; i++) {
            for (int x = 0; x < size; x++) {
                for (int y = 0; y < size; y++) {
                    for (int j = 0; j < dx.length; j++) {
                        int nx = x + dx[j];
                        int ny = y + dy[j];
                        if (nx < 0 || nx >= size || ny < 0 || ny >= size)
                            continue;
                        ways[ny][nx][i] += ways[y][x][i - 1];
                    }
                }
            }
        }
        return ways[ey][ex][numMoves];
    }
}