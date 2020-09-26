import java.util.*;

public class Solution {
	public static void main(String[] args) {
		int A = 4;
		int B= 1;
		int K = 3;
		minimalMoves(A, B, K);
	}
	public static int minimalMoves(int A, int B, int K) {
		if(A==0) return 0;
		if(A+B<K) return -1;
		int[] array = new int[A+B+1];
		for (int i = 0; i < array.length; i++) {
			array[i] = -1;
		}
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(A);
		array[A] = 0;
		while(!q.isEmpty()) {
			int i = q.poll(); // i는 0의 수
			for (int j = Math.max(0, K-(A+B-i)); j <= Math.min(i, K); j++) { // j는 0을 뒤집는 수
				int nextzero = i + (K -2 *j); // 다음 상태의 0의 수
				if(array[nextzero] == -1) { // 처음 도착하는 곳이라면 다음 탐색에 추가
					if(nextzero == 0) return array[i]+1;//답을 찾으면 이걸 리턴
					array[nextzero] = array[i]+1;
					q.add(nextzero);
				}
			}
			
		}
		return -1;
	}
}