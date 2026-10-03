
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int V;
    static int E;

    static ArrayList<Integer>[] graph;
    static int[] p_degree;
    static int[] p_weight;
    static int[] max_weight;
    static int[] weight_num;
    
    static Deque<Integer> dq = new ArrayDeque<>();
    
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        
        graph = new ArrayList[V+1];
        p_degree = new int[V+1];
        p_weight = new int[V+1];
        max_weight = new int[V+1];
        weight_num = new int[V+1];
        
        for(int i = 1; i < V+1; i ++) graph[i] = new ArrayList<Integer>();
        
        
        for(int i = 0; i < E; i ++) {
            st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            p_degree[b] ++;
            graph[a].add(b);
        }
        /*
        for (int i = 1; i <= V; i++) {
            System.out.println(i + " : " + graph[i]);
        }
        */
        for(int i = 1; i < V+1; i++) {
            if(p_degree[i]==0) {
                dq.offerLast(i);
            }
        }
        for(int i = 0; i < V+1; i ++) {
            p_weight[i] = 1;
        }
        bfs();
        int answer = 1;
        for(int w : p_weight) {
            answer = Math.max(w, answer);
        }
        /*
        for(int i = 1; i < V+1; i++) {
            System.out.printf("%d : %d \n", i, p_weight[i]);
        }
        */
        System.out.println(answer);
    }
    
    public static void bfs() {
        
        while(!dq.isEmpty()) {
            int cur = dq.pollFirst();
            
            
            for(int next : graph[cur]) {
                p_degree[next]--;
                
                // cur가 누르고 있는 next
                if(max_weight[next]==0) {
                    max_weight[next] = p_weight[cur];
                }
                else {
                    if(max_weight[next]==p_weight[cur]) {
                        weight_num[next] = 1;
                    }
                    else if(max_weight[next] < p_weight[cur]) {
                        max_weight[next] = p_weight[cur];
                        weight_num[next] = 0;
                    }
                }
                if(p_degree[next] == 0) {
                    max_weight[next] = max_weight[next] + weight_num[next];
                    p_weight[next] = max_weight[next];
                    dq.offerLast(next);
                }
                
            }
            
        }
        
    }
    

}
