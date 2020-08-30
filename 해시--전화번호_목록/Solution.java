import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String[] phone_book = new String[] { "123", "456", "789" };
        boolean answer = true;
        TestClass aClass = new TestClass();
        aClass.getSmth();
        Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].contains(phone_book[i])) {
                answer = false;
                break;
            }
        }
        System.out.println(answer);
    }

    public static class TestClass {
        String smth = "asdf";

        public String getSmth() {
            return smth;
        }
    }
}