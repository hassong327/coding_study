import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int K;
    static int uLimit;
    static int dLimit;

    static int[][] map;
    static boolean[][] visited;

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static public class Point{
        int r, c;
        public Point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        uLimit = Integer.parseInt(st.nextToken());
        dLimit = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        visited = new boolean[N][N];


        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int r = 0; r < N; r++){
            for(int c = 0; c < N; c++){
                if(visited[r][c]==false){
                    int tmp = bfs(r, c);
                    pq.offer(tmp);
                    // System.out.println();
                }
            }
        }

        int answer = 0;
        int iterNum = Math.min(K, pq.size());
        
        for(int i = 0; i < iterNum; i++){
            answer += pq.poll();
        }

        System.out.println(answer);
        

    }
    
    public static int bfs(int r, int c){
        ArrayDeque<Point> dq = new ArrayDeque<>();
        dq.offerLast(new Point(r, c));
        visited[r][c] = true;

        int count = 1;

        while(!dq.isEmpty()){
            Point p = dq.pollFirst();
            
            int curR = p.r;
            int curC = p.c;
            // System.out.println(curR + ", "+curC);

            for(int i = 0; i < 4; i++){
                int nextR = curR + dr[i];
                int nextC = curC + dc[i];

                if(nextR >= 0 && nextR < N && nextC >= 0 && nextC < N){
                    if(visited[nextR][nextC]==false){
                        int tmp = Math.abs(map[curR][curC]-map[nextR][nextC]);

                        if(tmp >= uLimit && tmp <= dLimit){
                                visited[nextR][nextC] = true;
                                count++;
                                dq.offerLast(new Point(nextR, nextC));
                        }
                    }
                }
            }
        }
        return count;

    }


}
