import java.util.Scanner;
  
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] grid = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                grid[i][j] = sc.nextInt();
        
        // Please write your code here.
        int count = 0;
        for(int i = 0; i < N; i ++){
            int tmp = 0;
            int flag = 0;

            for(int j = 0; j < N; j ++){
                if(j==0){
                    tmp = grid[i][j];
                    flag += 1;
                }
                else{
                    if(tmp == grid[i][j]){
                        flag += 1;
                    }
                    else{
                        flag = 1;
                        tmp = grid[i][j];
                    }
                }

                if(flag >= M){
                    count += 1;
                    break;
                }
            }
        }
        for(int j = 0; j < N; j ++){
            int tmp = 0;
            int flag = 0;

            for(int i = 0; i< N; i ++){
                if(i==0){
                    tmp = grid[i][j];
                    flag += 1;
                }
                else{
                    if(tmp == grid[i][j]){
                        flag += 1;
                    }
                    else{
                        flag = 1;
                        tmp = grid[i][j];
                    }
                }

                if(flag >= M){
                    count += 1;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}