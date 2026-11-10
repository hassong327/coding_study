import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if (map.containsKey(tmp)){
                continue;
            }
            map.put(tmp, i+1);
        }
        for(Map.Entry<Integer, Integer> cur : map.entrySet()){
            System.out.println(cur.getKey() + " " + cur.getValue());
        }

        

    }
}
