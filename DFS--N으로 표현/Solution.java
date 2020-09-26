import java.util.*;

public class Solution {
    static int result;
    static int[] nnn = new int[8];

    public static void main(String[] args) {
        showCode();
    }

    public static void showCode() {
        System.out.println("START DAY N으로 표현");
        int N = 5;
        int number = 12;
        System.out.println("결과: " + solution(N, number));
    }

    public static int solution(int N, int number) {
        result = -1;
        for (int i = 0; i < 8; i++) {
            nnn[i] = Integer.parseInt(Integer.toBinaryString((int) Math.pow(2, i + 1) - 1)) * N;
        }
        DFS(0, 0, number);
        return result;
    }

    public static void DFS(int count, int num, int number) {
        if (count > 8)
            return;

        if (num == number) {
            if (count < result || result == -1)
                result = count;
            return;
        }
        for (int i = 0; i < 8; i++) {
            int NN = nnn[i]; // 5, 55, 555, 5555 ...
            int cnt = i + 1; // 1,2,3,4 ...

            // 0 +-*/ 5 -> ..... -> 0 +-*/ 55555555
            // (0 + 5): 5 +-*/ 5 -> ..... -> 5 +-*/ 55555555
            // (5 + 5): 10 +-*/ 5 -> ..... -> 10 +-*/ 55555555
            // (5 / 5): 1 +-*/ 5 -> ..... -> 1 +-*/ 55555555
            // ...........
            DFS(count + cnt, num + NN, number);
            DFS(count + cnt, num - NN, number);
            DFS(count + cnt, num * NN, number);
            DFS(count + cnt, num / NN, number);
        }
    }
}
