import java.util.*;
import java.io.*;

public class Main {
    static class Point{
        int r, c;
        int step;
        public Point(int r, int c, int step){
            this.r = r;
            this.c = c;
            this.step = step;
        }
    }

    static int n;
    static int m;

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static ArrayDeque<Point> dq = new ArrayDeque<>();
    static boolean[][] visited;
    static int[][]  grid;

    static int[][] stepGrid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new int[n][m];

        visited = new boolean[n][m];
        stepGrid = new int[n][m];
        for(int i = 0; i < n; i++){
            Arrays.fill(stepGrid[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int targetStep = bfs();
        int answer = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1 && stepGrid[i][j] == targetStep){
                    ++answer;
                }
            }
        }
        System.out.println(targetStep + " " + answer);

    }


    public static int bfs() {
        dq.offer(new Point(0, 0, 0));
        visited[0][0] = true;

        int lastStep = 0;

        while (!dq.isEmpty()) {
            ArrayDeque<Point> nextIce = new ArrayDeque<>();

            while (!dq.isEmpty()) {
                Point cur = dq.pollFirst();

                int curR = cur.r;
                int curC = cur.c;

                for (int i = 0; i < 4; i++) {
                    int nextR = curR + dr[i];
                    int nextC = curC + dc[i];

                    if (nextR < 0 || nextR >= n ||
                        nextC < 0 || nextC >= m ||
                        visited[nextR][nextC]) {
                        continue;
                    }

                    visited[nextR][nextC] = true;

                    if (grid[nextR][nextC] == 0) {
                        dq.offer(new Point(
                            nextR, nextC, lastStep
                        ));
                    } else {
                        nextIce.offer(new Point(
                            nextR, nextC, lastStep + 1
                        ));
                    }
                }
            }

            if (nextIce.isEmpty()) {
                break;
            }

            lastStep++;

            while (!nextIce.isEmpty()) {
                Point ice = nextIce.pollFirst();

                stepGrid[ice.r][ice.c] = lastStep;
                dq.offer(ice);
            }
        }
        return lastStep;
    }

}