
import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] map;
    static int[][] cityMap;
    static int[][] dist;

    static int cityCount = 0;
    static final int INF = Integer.MAX_VALUE;

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static class Point {
        int r, c;
        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        cityMap = new int[N][M];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (map[r][c] == 1 && cityMap[r][c] == 0) {
                    cityCount++;
                    bfs(r, c, cityCount);
                }
            }
        }

        dist = new int[cityCount + 1][cityCount + 1];

        for (int i = 1; i <= cityCount; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        findRoads();

        System.out.println(prim());
    }

    static void bfs(int sr, int sc, int cityNum) {

        Deque<Point> dq = new ArrayDeque<>();

        dq.offerLast(new Point(sr, sc));
        cityMap[sr][sc] = cityNum;

        while (!dq.isEmpty()) {

            Point cur = dq.pollFirst();

            for (int d = 0; d < 4; d++) {

                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M)
                    continue;

                if (map[nr][nc] == 0)
                    continue;

                if (cityMap[nr][nc] != 0)
                    continue;

                cityMap[nr][nc] = cityNum;
                dq.offerLast(new Point(nr, nc));
            }
        }
    }

    // 가로, 세로 방향으로 도시 사이 도로 찾기
    static void findRoads() {

        // 가로 방향 탐색
        for (int r = 0; r < N; r++) {

            int lastIsland = 0;
            int distance = 0;

            for (int c = 0; c < M; c++) {
                int currentIsland = cityMap[r][c];
                if (currentIsland == 0) {
                    distance++;
                    continue;
                }
                if (lastIsland != 0 &&
                    lastIsland != currentIsland &&
                    distance > 0) {

                    connect(lastIsland, currentIsland, distance);
                }

                lastIsland = currentIsland;
                distance = 0;
            }
        }
        for (int c = 0; c < M; c++) {

            int lastIsland = 0;
            int distance = 0;

            for (int r = 0; r < N; r++) {

                int currentIsland = cityMap[r][c];

                if (currentIsland == 0) {
                    distance++;
                    continue;
                }

                if (lastIsland != 0 &&
                    lastIsland != currentIsland &&
                    distance > 0) {

                    connect(lastIsland, currentIsland, distance);
                }

                lastIsland = currentIsland;
                distance = 0;
            }
        }
    }

    static void connect(int from, int to, int cost) {

        dist[from][to] = Math.min(dist[from][to], cost);
        dist[to][from] = Math.min(dist[to][from], cost);
    }

    static long prim() {

        boolean[] visited = new boolean[cityCount + 1];
        int[] minCost = new int[cityCount + 1];

        Arrays.fill(minCost, INF);

        minCost[1] = 0;

        long totalCost = 0;

        for (int i = 0; i < cityCount; i++) {

            int current = -1;
            int min = INF;

            for (int j = 1; j <= cityCount; j++) {

                if (!visited[j] && minCost[j] < min) {
                    min = minCost[j];
                    current = j;
                }
            }

            if (current == -1) {
                return -1;
            }

            visited[current] = true;
            totalCost += min;

            for (int next = 1; next <= cityCount; next++) {

                if (!visited[next] &&
                    dist[current][next] < minCost[next]) {

                    minCost[next] = dist[current][next];
                }
            }
        }

        return totalCost;
    }
}
