import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String[] pattern = { ".X", ".." };
        int time = 1;
        System.out.println(occurrencesNumber(pattern, time));
    }

    public static String getstring(int T) {
        if (T == 0)
            return "X";
        String c = getstring(T - 1);
        String s = "";
        for (int i = 0; i < c.length(); i++) {
            s += " ";
        }
        return c + s + c;
    }

    public static int occurrencesNumber(String[] pattern, int time) {
        int M = pattern.length, N = pattern[0].length(); // 가로 세로 길이
        boolean[] a = new boolean[M], b = new boolean[N]; // 각 행과 열에 X를 포함할지 여부
        String C = getstring(time); // getstring 함수에서 프랙탈 1줄을 생성
        int L = C.length(); // 프랙탈 한 변의 길이
        int p = 0, q = 0; // p가 가로 패턴 일치 수, q가 세로 패턴 일치 수
        boolean flag = false; // 각 행과 열이 'X'를 포함하고 있는지 여부
        int x, y, k;
        for (x = 0; x < M; x++)
            for (y = 0; y < N; y++)
                if (pattern[x].charAt(y) == 'X')
                    a[x] = b[y] = flag = true; // 모순이 있으면 포함하지 않는 것이므로 0을 리턴
        for (x = 0; x < M; x++)
            for (y = 0; y < N; y++)
                if ((pattern[x].charAt(y) == 'X') != (a[x] && b[y]))
                    return 0;

        // 가로의 일치 수를 확인
        // C#이라면 IndexOf, 사용해도 됨
        for (k = 0; k + M <= L; k++) {
            for (x = 0; x < M; x++) {
                if ((C.charAt(k + x) == 'X') != a[x])
                    break;
                if (x == M)
                    ++p;
            }
        }

        // 세로에 대해서도 같은 처리를 수행
        for (k = 0; k + N <= L; k++) {
            for (y = 0; y < N; y++) {
                if ((C.charAt(k + y) == 'X') != b[y])
                    break;
                if (y == N)
                    ++q;
            }
        }

        if (flag)
            return (p * q); // 'X'를 포함하는 경우
        else
            return (p * (L - N + 1) + (L - M + 1) * q - p * q); // 'X'를 포함하지 않는 경우
    }
}
