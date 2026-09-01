import java.util.Scanner;
import java.util.*;

public class Main {
    static int n = 0;
    /*
    private static class Point{
        int row;
        int col;
        Point(int row, int col){
            this.row = row;
            this.col = col;
        }

    }

    static ArrayList<Point> visit = new ArrayList<>();
    */
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
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
                    dfs(cnt, row, col, i, visited);
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
                            if(visited[r][c]!=-1 && grid[r][c]==1){
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