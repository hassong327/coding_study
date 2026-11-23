import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;

    static int count = 0;
    static int maxBlockSize = 0;

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static class Point{
        int r, c;
        public Point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for(int r = 0; r < N; r ++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int c = 0; c < N; c++){
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        for(int r = 0; r < N; r++){
            for(int c = 0; c < N; c++){
                int tmp = dfs(new Point(r, c), 1);
                maxBlockSize = Math.max(maxBlockSize, tmp);
                if(tmp>=4){
                    count++;
                }
            }
        }
        System.out.println(count + " " + maxBlockSize);
        

    }
    public static int dfs(Point p, int blockSize){
        int curR = p.r;
        int curC = p.c;
        int curValue = map[curR][curC];

        if(visited[curR][curC]==true){
            return blockSize;
        }

        visited[curR][curC] = true;

        for(int i = 0; i < 4; i++){
            int nextR = curR + dr[i];
            int nextC = curC + dc[i];

            if(nextR >= 0 && nextR < N && nextC >= 0 && nextC < N){
                if(visited[nextR][nextC]==false && map[nextR][nextC]==curValue){
                    blockSize = dfs(new Point(nextR, nextC), blockSize+1);
                }
            }
        }
        return blockSize;
    }
}