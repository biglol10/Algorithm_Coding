import java.util.*;

public class Solution{
    public static void main(String[] args){
        int size = 3;
        int[] start = {0,0};
        int[] end = {0,0};
        int numMoves = 2;
        System.out.println("answer is : " + howMany(size,start,end,numMoves));
    }
    public static long howMany(int size, int[] start, int[] end, int numMoves){
        // 각 체크판 좌표에 numMoves마다 기능 경로 수를 저장할 것임, numMoves가 1부터라서 +1할당
        long[][][] metric = new long[size][size][numMoves+1];

        // 시작점과 끝점
        int sx = start[0], sy = start[1];
        int ex = end[0], ey = end[1];

        // 킹나이트가 가능한 움직임
        int [] w = {1, -1, 0, 0, 1, 1, -1, -1, 1, 2, -1, -2, 1, 2, -1, -2}; 
        int [] h = {0, 0, 1, -1 ,1, -1, 1, -1, 2, 1, -2, -1, -2, -1, 2, 1};

        // 시작 지점에서 움직이는 경우만 + 값을 줄 수 있도록
        metric[sx][sy][0] = 1;

        for (int i = 1; i <= numMoves; i++) {
            //출발의 기준점을 정해줌
            for (int x = 0; x < size; x++) {
                for (int y = 0; y < size; y++) {
                    for (int j = 0; j < w.length; j++) {
                        // 해당 x,y를 시작점으로 생각했을 때 시작점에서 이동 가능한 모든 칸
                        int nx = x + w[j];
                        int ny = y + h[j];
                        if(nx>=0 && nx<size && ny>=0 && ny<size){
                            System.out.println("X : " + x + " Y : " + y);
                            System.out.println("nextX : " + nx + " nextY : " + ny);
                            System.out.println("value : " + metric[x][y][i-1]);
                            metric[nx][ny][i] += metric[x][y][i-1];
                            System.out.println("target value : " + metric[nx][ny][i]);
                        }
                    }
                }
            }
            System.out.println("numMoves = "+i);
            for (int xi = 0; xi < size; xi++) {
                for (int yi = 0; yi < size; yi++) {
                    System.out.print(metric[xi][yi][i] + " ");
                }
                System.out.println();
            }
        }
        return metric[ex][ey][numMoves];
    }
}