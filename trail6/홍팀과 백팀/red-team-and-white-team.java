import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;

    static ArrayList<Integer>[] graph;
    static int[] visited;

    static boolean answer = true;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        visited = new int[N + 1];
        
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 대결 관계 입력
        for (int i = 0; i < M; i++) {

            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        // 연결되지 않은 그래프가 여러 개일 수도 있음
        for (int i = 1; i <= N; i++) {
            if (visited[i] == 0) {

                visited[i] = 1;
                dfs(i);

                if (!answer) {
                    break;
                }
            }
        }
        
        if (answer) System.out.println(1);
        else System.out.println(0);
    }

    static void dfs(int cur) {

        for (int next : graph[cur]) {
            if (visited[next] == 0) {
                visited[next] = -visited[cur];

                dfs(next);

                if (!answer) {
                    return;
                }
            }

            else if (visited[next] == visited[cur]) {
                answer = false;
                return;
            }
        }
    }
}