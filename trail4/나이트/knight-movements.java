
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;
public class Main {
    static int[] dr = {2, 1, -1, -2, -2, -1, 1, 2};
    static int[] dc = {1, 2, 2, 1, -1, -2, -2, -1};

    static int[][] visited;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int r1 = sc.nextInt();
        int c1 = sc.nextInt();
        int r2 = sc.nextInt();
        int c2 = sc.nextInt();
        // Please write your code here.

        visited = new int[n+1][n+1];
        for(int i = 0; i < n+1; i++) {
            for(int j = 0; j < n+1; j++) {
                visited[i][j] = -1;
            }
        }
        bfs(r1, c1, r2, c2);
        System.out.println(visited[r2][c2]);
    }
    
    
    static class Node{
        int r;
        int c;
        int cost;
        public Node(int r, int c, int cost) {
            // TODO Auto-generated constructor stub
            this.r = r;
            this.c = c;
            this.cost = cost;
        }
    }
    public static void bfs(int start_r, int start_c, int end_r, int end_c) {

        Deque<Node> dq = new ArrayDeque<>();

        dq.offerLast(new Node(start_r, start_c, 0));
        visited[start_r][start_c] = 0;

        while(!dq.isEmpty()) {

            Node nd = dq.pollFirst();

            int r = nd.r;
            int c = nd.c;

            if(r == end_r && c == end_c) {
                return;
            }

            for(int i = 0; i < 8; i++) {

                int nr = r + dr[i];
                int nc = c + dc[i];

                // 1 ~ n 범위
                if(nr < 1 || nr > n || nc < 1 || nc > n) {
                    continue;
                }

                // 이미 방문
                if(visited[nr][nc] != -1) {
                    continue;
                }

                visited[nr][nc] = visited[r][c] + 1;

                dq.offerLast(
                    new Node(nr, nc, visited[nr][nc])
                );
            }
        }
    }
}

