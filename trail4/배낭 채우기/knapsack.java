import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;

    public static class Gem{
        int weight;
        int value;
        public Gem(int weight, int value){
            this.weight = weight;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Gem[] gemArray = new Gem[N+1];

        for(int i = 1; i < N+1; i++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            gemArray[i] = new Gem(w, v);
        }

        int[][] arr = new int[N+1][M+1];
        for(int i = 1; i < N+1; i++){
            for(int j = 1; j < M+1; j++){
                arr[i][j] = arr[i-1][j];
                if(j >= gemArray[i].weight){
                    arr[i][j] = Math.max(arr[i-1][j], arr[i-1][j-gemArray[i].weight] + gemArray[i].value);
                }
            }
        }
        for(int i = 0; i < N +1; i++){
            //System.out.println(Arrays.toString(arr[i]));
        }
        System.out.println(arr[N][M]);
    }
}