import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Integer[] problem = { 0, 1, 2, 3, 4 };
        Integer[] answer = new Integer[4];
        doCombination(problem, answer, 0, 0);
    }

    public static void doCombination(Integer[] full, Integer[] arr, int n, int idx) { // n 은 arr의 index, idx는 problem의
                                                                                      // index
        if (n == arr.length) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i]);
            }
            System.out.println("");
            return;
        }
        if (idx == full.length) {
            return;
        }
        arr[n] = full[idx];
        doCombination(full, arr, n + 1, idx + 1);
        doCombination(full, arr, n, idx + 1);
    }
}