import java.util.*;

public class Solution {
    static ArrayList<String> permvalues = new ArrayList<String>();

    public static void main(String[] args) {
        String numbers = "011";
        System.out.print(solution(numbers));
    }

    public static int solution(String numbers) {
        int answer = 0;
        var numTArray = numbers.toCharArray();
        for (int i = 1; i <= numTArray.length; i++) {
            doPermutation(numTArray, 0, i);
        }
        ArrayList<Integer> toInt = new ArrayList<Integer>();
        for (int i = 0; i < permvalues.size(); i++) {
            if (!toInt.contains(Integer.parseInt(permvalues.get(i))))
                toInt.add(Integer.parseInt(permvalues.get(i)));
        }
        for (int i = 0; i < toInt.size(); i++) {
            if (checkPrime(toInt.get(i).toString()))
                answer++;
        }
        return answer;
    }

    public static void doPermutation(char[] problem, int depth, int r) {
        if (depth == r) {
            String aString = "";
            for (int i = 0; i < r; i++) {
                aString += problem[i];
            }
            permvalues.add(aString);
            return;
        }
        for (int i = depth; i < problem.length; i++) {
            swap(problem, depth, i);
            doPermutation(problem, depth + 1, r);
            swap(problem, depth, i);
        }
    }

    public static void swap(char[] problem, int depth, int i) {
        var temp = problem[depth];
        problem[depth] = problem[i];
        problem[i] = temp;
    }

    public static boolean checkPrime(String value) {
        int aValue = Integer.parseInt(value);
        if (aValue == 1 || aValue == 0)
            return false;
        int n = aValue / 2;

        for (int i = 2; i <= n; i++) {
            if ((aValue % i) == 0)
                return false;
        }
        return true;
    }
}