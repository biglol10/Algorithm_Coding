import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int width = 3;
        int height = 3;
        System.out.println(maxStones(width, height));
    }

    public static int maxStones(int width, int height) {
        int i, j;
        // 판의 형태를 저장. 조금 더 크게 잡아줌
        int[][] board = new int[1005][1005];
        int res = 0;
        // 보초병 방법으로 예외를 처리
        for (i = 2; i < width + 2; i++) {
            for (j = 2; j < height + 2; j++) {
                if (board[i - 2][j] == 0 && board[i][j - 2] == 0) {
                    res++;
                    board[i][j] = 1;
                    System.out.print("O");
                } else
                    System.out.print("+");
            }
            System.out.println();
        }
        return res;
    }
}