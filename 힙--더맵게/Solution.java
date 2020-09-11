import java.util.*;

public class Solution {
    static ArrayList<String> permvalues = new ArrayList<String>();

    public static void main(String[] args) {
        int[] scoville = { 1, 2, 3, 9, 10, 12 };
        int K = 7;
        int answer = 0;
        PriorityQueue<Integer> heapmin = new PriorityQueue<Integer>();
        for (int i = 0; i < scoville.length; i++) {
            heapmin.offer(scoville[i]);
        }
        // try catch를 사용하여 만약 Overflow가 생길 경우 answer = -1로 설정한다.
        // 또는 힙 사이즈가 1이 됬는데 스코빌이 K보다 작으면 더 이상 만들 수 없으므로 answer = -1을 한다.
        while (heapmin.peek() < K) {
            try {
                int new_food = heapmin.poll() + heapmin.poll() * 2;
                heapmin.offer(new_food);
                answer++;

                if (heapmin.peek() >= K)
                    break;
                if (heapmin.size() == 1 && heapmin.peek() < K) {
                    answer = -1;
                    break;
                }
            } catch (Exception e) {
                answer = -1;
            }
        }
        System.out.println(answer);
    }
}