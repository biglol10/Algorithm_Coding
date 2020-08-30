import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String key = "aba";
        String text = "ababacccababa";
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();
        int start = 0;
        int end = text.length() - 1;
        boolean isRemove = false;

        while (start <= end) {

            if (!isRemove) {
                left.push(text.charAt(start++));
                if (left.size() >= key.length() && left.peek() == key.charAt(key.length() - 1)) {
                    int keyLen = key.length() - 1;
                    boolean check = true;
                    for (int j = left.size() - 1; j >= left.size() - key.length(); j--) {
                        if (left.get(j) != key.charAt(keyLen--)) {
                            check = false;
                            break;
                        }
                    }
                    if (check) {
                        isRemove = true;
                        for (int j = 0; j < key.length(); j++) {
                            left.pop();
                        }

                    }
                }
            }
            if (isRemove && start <= end) {
                String keyRev = new StringBuilder(key).reverse().toString();
                right.push(text.charAt(end--));
                if (right.size() >= key.length() && right.peek() == keyRev.charAt(key.length() - 1)) {
                    int keyLen = key.length() - 1;
                    boolean check = true;
                    for (int j = right.size() - 1; j >= right.size() - key.length(); j--) {
                        if (right.get(j) != keyRev.charAt(keyLen--)) {
                            check = false;
                            break;
                        }
                    }
                    if (check) {
                        for (int j = 0; j < key.length(); j++) {
                            right.pop();
                        }
                        isRemove = false;
                    }

                }
            }

        }
        int leftSize = left.size();
        for (int i = 0; i < leftSize; i++) {
            right.push(left.pop());
        }
        StringBuilder sb = new StringBuilder();
        while (!right.isEmpty()) {
            sb.append(right.pop());
        }
        while (true) {
            int idx = sb.indexOf(key);
            if (idx < 0)
                break;
            sb.delete(idx, idx + key.length());
        }
        System.out.println(sb.toString());

    }
}