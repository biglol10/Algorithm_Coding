import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        String answer = "";
        int[] numbers = { 0, 3, 30, 34, 5, 9 };
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            list.add(numbers[i]);
        }
        // Collections.sort(list, (a, b) -> {
        // return b - a; // 내림차순... a-b 는 오름차순
        // });
        Collections.sort(list, (a, b) -> {
            String string_a = a.toString();
            String string_b = b.toString();
            return -Integer.compare(Integer.parseInt(string_a + string_b), Integer.parseInt(string_b + string_a));
        });

        List<Integer> checkZeros = list.stream().filter(p -> p == 0).collect(Collectors.toList());
        if (checkZeros.size() == numbers.length) {
            answer = "0";
        } else {
            for (int i = 0; i < list.size(); i++) {
                answer += list.get(i).toString();
            }
        }

        System.out.println(answer);
    }
}