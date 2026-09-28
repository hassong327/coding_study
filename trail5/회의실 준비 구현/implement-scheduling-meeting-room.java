import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {
    
    public static class Node{
        int start;
        int end;
        public Node(int start, int end) {
            // TODO Auto-generated constructor stub
            this.start = start;
            this.end = end;
        }
    }
    static Node[] meetings;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        
        meetings = new Node[N];
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            
            meetings[i] = new Node(s, e);
        }
        
        Arrays.sort(meetings, (a, b) -> {
            if(a.end == b.end) {
                return a.start - b.start;
            }
            return a.end - b.end;
        });
        
        
        System.out.println(greedy_meetings());
        
    }
    
    public static int greedy_meetings() {
        int count = 0;
        int end = 0;
        for(Node m : meetings) {
            if(m.start >= end) {
                count += 1;
                end = m.end;
            }
        }
        
        
        return count;
    }
}
