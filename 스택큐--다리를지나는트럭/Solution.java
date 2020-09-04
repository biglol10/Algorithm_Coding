import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = { 7, 4, 5, 6 };
        int answer = 0;
        Queue<Integer> goingCars = new LinkedList<Integer>();
        int[] carTime = new int[truck_weights.length];
        int carIdx = 0;
        int sum_weight = 0;

        while (true) {
            answer++;
            if (carIdx < truck_weights.length && sum_weight + truck_weights[carIdx] <= weight) {
                goingCars.add(truck_weights[carIdx]);
                sum_weight += truck_weights[carIdx];
                carIdx++;
            }
            for (int i = 0; i < carIdx; i++) {
                if (carTime[i] != -1) {
                    carTime[i] += 1;
                }
            }
            for (int j = 0; j < carTime.length; j++) {
                if (carTime[j] == bridge_length) {
                    sum_weight -= goingCars.poll();
                    carTime[j] = -1;
                }
            }
            boolean isBreak = false;
            if (carTime[truck_weights.length - 1] == -1) {
                isBreak = true;
            }
            if (isBreak) {
                answer++;
                break;
            }
        }
        System.out.print(answer);
    }
}