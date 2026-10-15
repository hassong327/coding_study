import java.util.*;
import java.io.*;


public class Main {
    static int[][] arr;
    static int[] inputs;    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        inputs = new int[N];
        arr = new int[N][N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < N; i++){
            inputs[i] = Integer.parseInt(st.nextToken());
        }

        for(int r =0; r < N; r++){
            Arrays.fill(arr[r], Integer.MAX_VALUE);
        }

        // 이거 개어렵네 GG
        for(int gap = 0; gap < N; gap++){
            for(int s = 0; s < N-gap; s++){
                calCost(s, s+gap);
            }
        }

        System.out.println(arr[0][N-1]);


    }

    public static void calCost(int s, int e){
        if(s==e){
            arr[s][e] = 0;
            return;
        }
        if(Math.abs(s-e)==1){
            arr[s][e] = 0;
            arr[e][s] = 0;
            return;
        }
        for(int mid = s+1; mid < e; mid++){
            arr[s][e] = Math.min(arr[s][e], arr[s][mid] + arr[mid][e] + inputs[s]*inputs[e]*inputs[mid]);
            arr[e][s] = Math.min(arr[s][e], arr[s][mid] + arr[mid][e] + inputs[s]*inputs[e]*inputs[mid]);
        }
    }
}