import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int n = Integer.parseInt(br.readLine());
       
        TreeMap<String, Integer> map = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            if(map.containsKey(word)){
                map.put(word, map.get(word)+1);
                continue;
            }
            map.put(word, 1);
        }

        for(Map.Entry<String, Integer> cur : map.entrySet()){
            System.out.println(cur.getKey() + " " + cur.getValue());
        }
    }
}