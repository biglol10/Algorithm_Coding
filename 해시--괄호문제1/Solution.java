import java.util.*;

public class Solution {
    public static void main(String[] args) {
        // 괄호 짝 개수, 짝을 이루는지 확인
        String problem = "(((()(()()))(())()))(()())";

        Stack<String> aStack = new Stack<String>();

        String[] string_array = problem.split("");

        Integer answer = 0;
        for (int i = 0; i < string_array.length; i++) {
            if (string_array[i].equals("(")) {
                aStack.push(string_array[i]);
            } else {
                aStack.pop();
                if (string_array[i - 1].equals("("))
                    answer += aStack.size();
                else
                    answer++;
            }
        }

        if (aStack.size() > 0) {
            System.out.println("size>0: " + answer);
        } else {
            System.out.println("size<0: " + answer);
        }
    }
}