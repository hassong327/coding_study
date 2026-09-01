import java.util.Scanner;
import java.util.*;

public class Main {
    static int n = 0;

    private static class Point{
        int row;
        int col;
        Point(int row, int col){
            this.row = row;
            this.col = col;
        }

    }

    static ArrayList<Point> visit = new ArrayList<>();
    
    // 있으니까 쓰는데, 원래였으면 boolean으로 처리하는게 나음. boolean의 2차원 배열
    static int[][] bfs(int[][] visited, int r, int c, int k){
        Deque<Point> dq = new ArrayDeque<>();
        int[][] dist = new int[n][n];
        for(int i = 0 ; i < n ; i ++ ){
            for(int j = 0 ; j < n ; j ++){
                dist[i][j]= -1;
            }
        }

        dq.offer(new Point(r, c));
        visited[r][c] = 0;
        dist[r][c] = 0;

        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        
        while(!dq.isEmpty()){
            Point tmp = dq.poll();
            int inner_r = tmp.row;
            int inner_c = tmp.col;

            if(dist[inner_r][inner_c] == k){
                continue;
            }
            
            for(int i = 0; i < 4; i++){
                if(inner_r+dr[i]<0 || inner_r+dr[i]>=n || inner_c+dc[i]<0 || inner_c+dc[i]>=n){
                    continue;
                }
                
                int next_r = inner_r + dr[i];
                int next_c = inner_c + dc[i];

                if(visited[next_r][next_c]==-1){
                    visited[next_r][next_c] = 1;
                    dist[next_r][next_c] = dist[inner_r][inner_c]+1;
                    dq.offer(new Point(next_r, next_c));
                }
            }
            
        }
        return dist;
    }



    static void dfs(int cnt, int r, int c, int k, int[][] visited) {
        if (cnt > k) {
            return;
        }

        if(visited[r][c]!=-1){
            if(visited[r][c]>cnt){
                visited[r][c]=cnt;
            }
            else{
                return;
            }
        }
        else{
            //visit.add(new Point(r, c));
            visited[r][c] = cnt;
        }
        
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr < 0 || nr >= n || nc < 0 || nc >= n) {
                continue;
            }
            //System.out.printf("%d, %d ||", nr, nc);
            dfs(cnt + 1, nr, nc, k, visited);
        }
    }

    public static void main(String[] args) {
         

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        // Please write your code here.
        int result = 0;
        for(int i = 0; i < n + 1; i++){
            //i=3;
            int cost = i*i+(i+1)*(i+1);
            // row, col은 마름모의 중심 좌표
            for(int row = 0; row < n; row++){
                for(int col = 0; col < n; col++){
                    int[][] visited = new int[n][n];
                    for(int r = 0; r < n; r++){
                        for(int c = 0; c<n; c++){
                            visited[r][c] = -1;
                        }
                    }
                    //visit.clear();
                    int gold = 0;
                    int cnt = 0;
                    //dfs(cnt, row, col, i, visited);
                    int[][] result_arr = bfs(visited, row, col, i);
                    //System.out.printf("row = %d, col = %d", row, col);
                    //System.out.println("");
                    
                    /*
                    for(Point p : visit){
                        if(grid[p.row][p.col]==1){
                            gold += 1;
                            //System.out.printf("%d %d , ", p.row, p.col);
                        }
                    }
                    */
                    for(int r = 0; r < n; r ++){
                        for(int c = 0; c < n; c++){
                            if(result_arr[r][c]>=0 && grid[r][c]==1){
                                gold += 1;
                                //System.out.println(gold);
                            }
                        }
                    }
                    if(gold*m - cost>=0){
                        result = Math.max(result, gold);
                    }

                }
            }
        }
        System.out.print(result);
    }

}