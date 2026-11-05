
import java.util.*;
import java.io.*;

public class Main {
    public static class Point {
        int idx, x;
        Point prev, next;
        boolean alive = true;

        public Point(int idx, int x) {
            this.idx = idx;
            this.x = x;
        }
    }

    public static class Dist {
        Point right, left;

        public Dist(Point right, Point left) {
            this.right = right;
            this.left = left;
        }
    }

    static boolean isValid(Dist d) {
        return d.right.alive && d.left.alive
            && d.right.next == d.left;
    }

    static void clean(PriorityQueue<Dist> pq) {
        while(!pq.isEmpty() && !isValid(pq.peek())) {
            pq.poll();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int orderNum = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int orderCode = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Point[] byId = new Point[M + orderNum + 5];

        PriorityQueue<Dist> pq = new PriorityQueue<>(Comparator.comparingInt((Dist d) -> d.left.x - d.right.x).reversed()
            .thenComparingInt(d -> d.right.x));

        Point head = null;
        Point tail = null;

        for(int idx = 1; idx <= M; idx++) {
            int x = Integer.parseInt(st.nextToken());
            Point p = new Point(idx, x);
            byId[idx] = p;

            if(tail == null) {
                head = p;
            } 
            else {
                tail.next = p;
                p.prev = tail;
                pq.offer(new Dist(tail, p));
            }

            tail = p;
        }

        int curIdx = M;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < orderNum - 1; i++) {
            st = new StringTokenizer(br.readLine());
            orderCode = Integer.parseInt(st.nextToken());

            // 가로등 추가
            if(orderCode == 200) {
                while(!pq.isEmpty() && !isValid(pq.peek())) {
                    pq.poll();
                }

                Dist d = pq.poll();
                Point a = d.right;
                Point b = d.left;

                int mid = a.x + (b.x - a.x + 1) / 2;

                Point p = new Point(++curIdx, mid);
                byId[curIdx] = p;

                p.prev = a;
                p.next = b;
                a.next = p;
                b.prev = p;

                pq.offer(new Dist(a, p));
                pq.offer(new Dist(p, b));
                continue;
            }

            // 가로등 제거
            if(orderCode == 300) {
                int target = Integer.parseInt(st.nextToken());
                Point p = byId[target];

                Point a = p.prev;
                Point b = p.next;

                if(a != null) a.next = b;
                else head = b;

                if(b != null) b.prev = a;
                else tail = a;

                p.alive = false;

                if(a != null && b != null) {
                    pq.offer(new Dist(a, b));
                }
                continue;
            }

            // 최소 전력 계산
            if(orderCode == 400) {
                while(!pq.isEmpty() && !isValid(pq.peek())) {
                    pq.poll();
                }

                int maxDist = 0;

                if(!pq.isEmpty()){
                    maxDist = pq.peek().left.x - pq.peek().right.x;
                }
                
                maxDist = Math.max(maxDist, 2 * (head.x - 1));
                maxDist = Math.max(maxDist, 2 * (N - tail.x));

                sb.append(maxDist).append('\n');
            }
        }

        System.out.print(sb);
    }
}
