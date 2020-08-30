import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String words = "abcde";
        String[] words_list = words.split("");

        doPermutation(words_list, 0, 3);
    }

    public static void doPermutation(String[] arr, int depth, int r) { // n 은 총 길이, r는 몇개를 뽑을건지
        if (depth == r) {
            String aString = "";
            for (int i = 0; i < r; i++) {
                aString += arr[i];
            }
            System.out.println(aString);
            return;
        }
        for (int i = depth; i < arr.length; i++) {
            swap(arr, depth, i);
            doPermutation(arr, depth + 1, r);
            swap(arr, depth, i);
        }
    }

    public static void swap(String[] arr, int depth, int i) {
        String temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }
}