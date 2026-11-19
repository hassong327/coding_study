import java.util.*;
import java.io.*;

public class Main {
    static int N;

    static Point[][] map;
    static int[][] memoryMap;

    // idx: 0은 제외, 1~9까지 사용
    static int[] dr = {0, -1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 0, 1, 1, 1, 0, -1, -1, -1};

    public static class Point{
        int value;
        int dir;
        public Point(int value, int dir){
            this.value = value;
            this.dir = dir;
        }
    }

    public static class rc{
        int r, c;
        public rc(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
        
    static ArrayDeque<rc> dq = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        map = new Point[N][N];
        memoryMap = new int[N][N];

        for(int i = 0; i < N; i ++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j ++){
                int value = Integer.parseInt(st.nextToken());
                map[i][j] = new Point(value, 0);
            }
        }
        for(int i = 0; i < N; i ++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j ++){
                int dir = Integer.parseInt(st.nextToken());
                map[i][j].dir = dir;
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int startR = Integer.parseInt(st.nextToken())-1;
        int startC = Integer.parseInt(st.nextToken())-1;

        // 출발지를 제외한 원소에서의 최대거리를 구하기...?
        // union-find?
        for(int i = 0; i < N; i++){
            Arrays.fill(memoryMap[i], 0);
        }
        
        dq.offerLast(new rc(startR, startC));

        dfs();
        int highest = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                highest = Math.max(highest, memoryMap[i][j]);
            }
        }
        System.out.println(highest);
        

    }

    public static void dfs(){
        while(!dq.isEmpty()){
            rc cur = dq.pollFirst();

            int nextR = cur.r + dr[map[cur.r][cur.c].dir];
            int nextC = cur.c + dc[map[cur.r][cur.c].dir];

            while(nextR>=0 && nextR<N && nextC>=0 && nextC<N){
                if(map[nextR][nextC].value > map[cur.r][cur.c].value){

                    int tmp = memoryMap[cur.r][cur.c] + 1;
                    
                    if(tmp > memoryMap[nextR][nextC]){
                        memoryMap[nextR][nextC] = tmp;

                        dq.offerLast(new rc(nextR, nextC));
                    }

                }
                nextR += dr[map[cur.r][cur.c].dir];
                nextC += dc[map[cur.r][cur.c].dir];
            }
        }
        
        
    }
}