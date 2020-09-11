import java.util.*;

public class Solution {
    static ArrayList<String> permvalues = new ArrayList<String>();

    public static void main(String[] args) {
        // 최대값과 최소값이 나오면 Heap 트리를 먼저 생각하는 것이 좋습니다. 마지막에 한번에 정렬해서 뽑아내는 것이라면
        // 정렬함수를 사용해도 무방하겠지만 중간중간 요소가 변하면서 계속 최대값과 최소값을 뽑아내기 위해서는 힙트리 구조를
        // 이용해야 시간 복잡도를 줄일 수 있습니다.

        // String[] operations = {"I 16","D 1"};
        String[] operations = { "I 7", "I 5", "I -5", "D -1" };

        int[] answer = new int[] {};

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < operations.length; i++) {
            String a = operations[i];
            char order = a.charAt(0);
            int num = Integer.parseInt(a.substring(2));

            if (order == 'I') {
                maxHeap.add(num);
                minHeap.add(num);
            } else if (!maxHeap.isEmpty()) {
                if (num == 1) {
                    int max = maxHeap.poll();
                    minHeap.remove(max);
                } else {
                    int min = minHeap.poll();
                    maxHeap.remove(min);
                }
            }
        }
        int max = 0;
        int min = 0;
        if (maxHeap.size() == 0) {
            max = 0;
        } else {
            max = maxHeap.peek();
        }
        if (minHeap.size() == 0) {
            min = 0;
        } else {
            min = minHeap.peek();
        }
        answer = new int[] { max, min };
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
    }
}
