import java.util.*;
import java.io.*;
public class Main {
    final static int MOD = 1_000_000_007;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] arr = new long[N+1];
        

        arr[0] = 1;
        arr[1] = 2;
        
        if(N >= 2){
            for(int i = 2; i < N+1; i++){
                arr[i] = ((arr[i-2] *3) % MOD + (arr[i-1] * 2) % MOD) % MOD;
                for(int j = 0; j <= i-3; j++){
                    arr[i] = (arr[i] + (arr[j] * 2) % MOD) % MOD;
                }
            }
        }
        System.out.println(arr[N]);
    }
}