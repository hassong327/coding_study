import java.util.Scanner;
import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        // Please write your code here.

        int answer = 0;
        for(int row = 0; row < n-1; row++){
            
                     
            for(int col = 1; col<n; col++){
                ArrayList<int[]> arr3 = new ArrayList<>();
                // arr3에 좌표 넣어주기. 가능한 좌하향 대각선 좌표들
                int total = row + col;
                for(int i = row+1; i < n-1; i++) {
                    int bcol = total -i;
                    
                    //밖으로 벗어날 경우
                    if(bcol < 0) {
                        break;
                    }
                    
                    // 시작 지점 기준 좌하향 점 B
                    arr3.add(new int[] {i, bcol});
                    for(int j = i + 1; j < n; j++) {
                        
                        //B 부터 C 까지의 거리 -> 나중에 시작 지점에서 D 지점을 알 수 있음
                        int dist = j - i;
                        
                        // B 기준 우하향 점 C
                        int ccol = bcol + dist;
                        
                        //밖으로 벗어날 경우
                        if(ccol >= n) {
                            break;
                        }
                        
                        // C 기준 우상향 점 D
                        int drow = row + dist;
                        int dcol = col + dist;
                        
                        // 밖으로 벗어날 경우
                        if(drow >= n || dcol >= n) {
                            break;
                        }
                        
                        ArrayList<int[]> arr4 = new ArrayList<>(arr3);
                        arr4.add(new int[] {row, col});
                        
                        // B to C
                        for(int step = 1; step <= dist; step ++) {
                            arr4.add(new int[] {i + step, bcol + step});
                        }
                        
                        // A to D
                        for(int step = 1; step <= dist; step++) {
                            arr4.add(new int[] {row + step, col + step});
                        }
                        
                        // D to B
                        int arr3_len = i - row;
                        
                        for(int step = 1; step < arr3_len; step++) {
                            arr4.add(new int[] {drow + step, dcol - step});
                        }
                        
                        // A to B 는 어딨지?
                        // 앞에서의 arr3.add(new int[] {i, bcol}); 에서 넣어줌
                        
                        
                        
                        int tmp_sum = 0;
                        for(int[] target : arr4) {
                            tmp_sum += grid[target[0]][target[1]];
                        }
                        answer = Math.max(answer, tmp_sum);
                    }
                    
                }
            }
        }
        System.out.println(answer);
    }
}