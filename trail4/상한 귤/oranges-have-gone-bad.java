import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int K;

    static int[][] map;

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static int[][] rotted;

    public static class Point{
        int r, c;
        public Point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        rotted = new int[N][N];
        
        for(int i = 0; i < N; i++){
            Arrays.fill(rotted[i], -1);
        }


        ArrayDeque<Point> dq = new ArrayDeque<>();

        int emptySize = 0;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j]==2){
                    rotted[i][j] = 0;
                    dq.offerLast(new Point(i, j));
                }

                else if(map[i][j]==0){
                    emptySize++;
                }
                
            }
        }
        rottenMandarin(dq, emptySize);

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                System.out.printf("%d ", rotted[i][j]);
            }
            System.out.println();
        }


    }

    public static void rottenMandarin(ArrayDeque<Point> dq, int emptySize){
        
        while(!dq.isEmpty()){
            Point p = dq.pollFirst();
            int curR = p.r;
            int curC = p.c;
            int curTime = rotted[curR][curC];

            for(int i = 0; i < 4; i++){
                int nextR = curR + dr[i];
                int nextC = curC + dc[i];

                if(nextR >= 0 && nextR < N && nextC >= 0 && nextC < N){
                    if(map[nextR][nextC]!=0 && rotted[nextR][nextC]==-1){
                        dq.offerLast(new Point(nextR, nextC));
                        rotted[nextR][nextC] = curTime + 1;
                    }
                }
            }
        }
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(rotted[i][j]==-1 && map[i][j]==1){
                    rotted[i][j] = -2;
                }
            }
        }

    }
}