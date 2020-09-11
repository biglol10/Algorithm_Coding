import java.util.*;

public class Solution {
    static ArrayList<String> permvalues = new ArrayList<String>();

    public static void main(String[] args) {
        int number = 9;
        int[] heap = { 7, 6, 5, 8, 3, 5, 9, 1, 6 };

        // 먼저 전체 트리 구조를 최대 힙 구조로 바꿈
        for (int i = 1; i < number; i++) {
            int c = i;
            do {
                int root = (c - 1) / 2; // 특정 원소의 부모를 가리키게 됨
                if (heap[root] < heap[c]) {
                    int temp = heap[root];
                    heap[root] = heap[c];
                    heap[c] = temp;
                }
                c = root; // 자식의 부모로 이동해서 반복적으로 사용
            } while (c != 0);
        }
        // 크기를 줄여가면서 반복적으로 힙을 구성.. 과정을 n번 반복
        for (int i = number - 1; i >= 0; i--) { // 가장 큰 값을 맨 뒤로 보내고 힙을 구성함
            int temp = heap[0]; // 0번째에 있는 값은 가장 큰 값임 이걸 맨 뒤로 보냄
            heap[0] = heap[i];
            heap[i] = temp;
            int root = 0;
            int c = 1;
            do { // 이 부분이 힙 구조를 만드는 부분
                c = 2 * root + 1;
                // 자식 중에 더 큰 값을 찾기
                if (c < i - 1 && heap[c] < heap[c + 1]) { // 범위를 벗어나지 않도록 막아줌
                    c++;
                } // 왼쪽과 오른쪽 중에서 더 큰 값을 오른쪽에 위치시켜줌
                  // 루트보다 자식이 더 크다면 교환
                if (c < i && heap[root] < heap[c]) {
                    temp = heap[root];
                    heap[root] = heap[c];
                    heap[c] = temp;
                }
                root = c;
            } while (c < i);
        }
        for (int i = 0; i < number; i++) {
            System.out.println(heap[i]);
        }
    }
}
