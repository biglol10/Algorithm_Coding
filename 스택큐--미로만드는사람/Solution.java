import java.util.*;

public class Solution {

	public static void main(String[] args) {
		String[] maze = {".......", "X.X.X..", "XXX...X","....X..","X....X.","......."};
        Integer startRow = 5;
        Integer startCol = 0;
        Integer[] moveRow = {1,0,-1,0,-2,1};
        Integer[] moveCol = {0,-1,0,1,3,0};
        System.out.print(longestPath(maze,startRow, startCol, moveRow, moveCol));
	}
	public static int longestPath(String[] maze, Integer startRow, Integer startCol, Integer[] moveRow, Integer[] moveCol){
        Integer max = 0;
        Integer width = maze[0].length();
        Integer height = maze.length;
        Integer[][] board = new Integer[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                board[i][j] = -1;
            }
        }
        board[startRow][startCol] = 0;
        Queue<Integer> queueX = new LinkedList<Integer>();
        Queue<Integer> queueY = new LinkedList<Integer>();
        queueX.add(startCol);
        queueY.add(startRow);
        while(queueX.size()>0){
            Integer x = queueX.poll();
            Integer y = queueY.poll();
            for (int i = 0; i < moveRow.length; i++) {
                int nextX = x+moveCol[i];
                int nextY = y+moveRow[i];
                if(0<=nextX && nextX< width && 0<=nextY && nextY< height && board[nextY][nextX] == -1 && maze[nextY].substring(nextX,nextX+1).equals(".")){
                    board[nextY][nextX] = board[y][x] + 1;
                    queueX.add(nextX);
                    queueY.add(nextY);
                }
            }
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if(maze[i].substring(j,j+1).equals(".") && board[i][j] == -1)
                    return -1;
                max = Math.max(max, board[i][j]);
            }
        }
        return max;
    }
}
