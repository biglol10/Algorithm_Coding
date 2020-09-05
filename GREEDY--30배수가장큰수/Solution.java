import java.util.*;

public class Solution {
    public static int[] numCountArr;
    public static long strLen;

    public static void main(String[] args) {
        String str = "80875542";
        strLen = str.length();

        numCountArr = new int[10];

        long total = 0;

        for (int i = 0; i < strLen; i++) {

            int tNum = Integer.parseInt(str.substring(i, i + 1));

            numCountArr[tNum] += 1;

            total += tNum;
        }

        // 0이 존재하지 않으면 30배수 조차도 될 수 없다
        // 각 자리수의 총 합이 3의 배수가 아니면 종료해야 한다.
        if (!str.contains("0") || total % 3 != 0) {
            System.out.println("-1");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            while (numCountArr[i] > 0) {
                sb.append(i);
                numCountArr[i]--;
            }
        }
        System.out.println(sb.toString());
    }
}