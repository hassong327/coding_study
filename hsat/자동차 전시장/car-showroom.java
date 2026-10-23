import java.util.*;
import java.io.*;

public class Main {
//    static boolean[][] edgeGraph;
    static ArrayList<Integer>[] edgeGraph;
    static boolean[] visited;
    static int[][] graph;

    static class Point {
        int node;
        int cost;

        public Point(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeNum = Integer.parseInt(st.nextToken());
        int edgeNum = Integer.parseInt(st.nextToken());
        int humanNum = Integer.parseInt(st.nextToken());

        //edgeGraph = new boolean[nodeNum + 1][nodeNum + 1];
        edgeGraph = new ArrayList[nodeNum+1];
        for(int i = 1; i < nodeNum+1; i++) {
            edgeGraph[i] = new ArrayList<>();
        }
        visited = new boolean[nodeNum + 1];

        graph = new int[humanNum][nodeNum + 1];

        for (int i = 0; i < humanNum; i++) {
            Arrays.fill(graph[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < edgeNum; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            edgeGraph[start].add(end);
        }

        int[] humans = new int[humanNum];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < humanNum; i++) {
            humans[i] = Integer.parseInt(st.nextToken());
        }

        int[] answer = new int[nodeNum + 1];
        boolean[] available = new boolean[nodeNum + 1];
        Arrays.fill(available, true);

        int cnt = 0;

        for (int start : humans) {
            bfs(start, nodeNum, cnt);

            for (int i = 1; i <= nodeNum; i++) {
                if (graph[cnt][i] == Integer.MAX_VALUE) {
                    available[i] = false;
                }
                else {
                    answer[i] = Math.max(answer[i], graph[cnt][i]);
                }
            }

            cnt++;
            visited = new boolean[nodeNum + 1];
        }

        int miniCost = Integer.MAX_VALUE;
        int n = -1;

        for (int i = 1; i <= nodeNum; i++) {
            if (available[i] && miniCost > answer[i]) {
                n = i;
                miniCost = answer[i];
            }
        }
  
        miniCost = (miniCost!=Integer.MAX_VALUE)? miniCost:-1;
        System.out.println(miniCost);
    }

    public static void bfs(int start, int nodeNum, int cnt) {
        ArrayDeque<Point> dq = new ArrayDeque<>();
        dq.add(new Point(start, 0));

        while (!dq.isEmpty()) {
            Point cur = dq.poll();

            if (visited[cur.node]) {
                continue;
            }

            visited[cur.node] = true;
            graph[cnt][cur.node] = cur.cost;

            for(int i : edgeGraph[cur.node]) {
                if(!visited[i]) {
                    dq.offer(new Point(i, cur.cost+1));
                }
            }
        }
    }
}