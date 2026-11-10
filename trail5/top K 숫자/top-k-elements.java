import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        TreeSet<Integer> ts = new TreeSet<>(Collections.reverseOrder());
        st = new StringTokenizer(br.readLine());
        for (int i = 0;  i < n; i++) {
            ts.add(Integer.parseInt(st.nextToken()));
        }

        int count = 0;
        for(int i : ts){
            System.out.print(i + " ");
            if(++count == k) break;
        }
        
    }
}