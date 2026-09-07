import java.util.Scanner;
import java.util.*;
public class Main {
    static int N = 0;
    static int answer = 0;
    static private void dfs(int cnt){
        if(cnt == N){
            answer += 1;
            return;
        }
        else if(cnt > N){
            return;
        }
        for(int i = 1; i <= 4; i ++){
            dfs(cnt + i);
        }
        

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        // Please write your code here.
        dfs(0);
        System.out.println(answer);

    }
}