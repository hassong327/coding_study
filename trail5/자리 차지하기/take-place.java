import java.util.*;
import java.io.*;

public class Main {
    static TreeSet<Integer> ts = new TreeSet<Integer>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        // 자리 입력 받기
        st = new StringTokenizer(br.readLine());
        boolean disable;
        int answer = 0;

        for(int i = 1; i < M+1; i++){
            ts.add(i);
        }

        for(int i = 0; i < N; i++){
            int available = Integer.parseInt(st.nextToken());

            disable = seating(available);
            if(disable) {
                break;
            }
            answer++;
        }
        System.out.println(answer);
    }


    public static boolean seating(int available){
        Integer s = ts.floor(available);
        if(s==null){
            return true;
        }
        ts.remove(s);
        return false;
    }
    
}