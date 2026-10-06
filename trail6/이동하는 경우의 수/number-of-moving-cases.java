import java.io.*;
import java.util.*;

public class Main {

    static int V;
    static int E;

    static class Edge {
        int to;
        int cost;
        int num;

        Edge(int to, int cost, int num) {
            this.to = to;
            this.cost = cost;
            this.num = num;
        }
    }

    static ArrayList<Edge>[] graph;

    // dp[i] = i에서 V까지 갈 때 최대 비용
    static int[] dp;

    // dp 계산 여부
    static boolean[] calculated;

    // 최장 경로에 포함되는 간선 번호
    static HashSet<Integer> pathEdges = new HashSet<>();

    // 최장 경로 간선을 찾는 DFS에서 사용
    static boolean[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[V + 1];

        // 초기화
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= E; i++) {

            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            // edge 넣어주기
            graph[from].add(new Edge(to, cost, i));
        }

        dp = new int[V + 1];
        visited = new boolean[V + 1];
        // 우선 최대 비용 계산
        int maxCost = dfs(1);

        visited = new boolean[V + 1];

        // 최장 경로에 들어가는 간선 찾기
        findEdges(1);

        System.out.printf("%d %d", maxCost, pathEdges.size());
    }


    // cur에서 V까지 갈 수 있는 최대 비용
    static int dfs(int cur) {

        // 도착점
        if (cur == V) {
            return 0;
        }

        // 이미 계산했으면 다시 DFS하지 않음
        if (visited[cur]) {
            return dp[cur];
        }

        visited[cur] = true;

        int max = 0;

        for (Edge e : graph[cur]) {

            int nextCost = e.cost + dfs(e.to);

            max = Math.max(max, nextCost);
        }

        dp[cur] = max;

        return dp[cur];
    }


    // 최장 경로에 속하는 간선 찾기
    static void findEdges(int cur) {
        // 같은 정점을 여러 번 조사할 필요 없음
        if (visited[cur]) {
            return;
        }

        visited[cur] = true;

        for (Edge e : graph[cur]) {
            if (dp[cur] == e.cost + dp[e.to]) {

                pathEdges.add(e.num);

                findEdges(e.to);
            }
        }
    }
}