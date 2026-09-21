import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] map;
    static int[][] visited;
    
    static int n;
    static int m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        visited = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
                visited[i][j] = -1;
            }
        // Please write your code here.
        bfs(0, 0);
        System.out.println(visited[n-1][m-1]);

    }

    private static class Point{
        int x;
        int y;
        int cost;
        public Point(int x, int y, int cost) {
            // TODO Auto-generated constructor stub
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
    
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    
    public static void bfs(int row, int col){
        Point p = new Point(row, col, 0);
        Deque<Point> dq = new ArrayDeque<>();
        dq.offerLast(p);
        int cost = 0;
        while(!dq.isEmpty()) {
           
            Point tmp = dq.pollFirst();
            
            int x = tmp.x;
            int y = tmp.y;

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if((!(nx < 0 || nx >= n || ny < 0 || ny >= m)) && (visited[nx][ny]==-1 && map[nx][ny]==1)) {
                    dq.offerLast(new Point(nx, ny, tmp.cost+1));
                    visited[nx][ny] = tmp.cost+1;
                }
            }
        }
    }
}