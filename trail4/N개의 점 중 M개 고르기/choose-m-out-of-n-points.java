import java.util.*;
import java.io.*;

public class Main {
    static int N, M;

    static int root;
    
    public static class Point{
        int x, y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static ArrayList<Point> pointList = new ArrayList<>();
    static Point[] pointArray;

    static int mini = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        pointArray = new Point[N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            pointArray[i] = new Point(x, y);
        }

        combination(0, 0);

        System.out.println(mini);

    }

    public static void combination(int start, int dist){
        if(pointList.size() == M){
            //System.out.println(dist);
            mini = dist;

            return;
        }

        for(int i = start; i < N; i++){
            int tmp = dist;
            
            //System.out.println("start: " + start + " " + pointList.size());

            for(Point p : pointList){    
                tmp = Math.max(tmp, euclid(pointArray[i], p));
            }

            if(tmp >= mini) continue;


            pointList.add(pointArray[i]);
            combination(i+1, tmp);
            pointList.remove(pointList.size()-1);
        }

    }

    public static int euclid(Point cur, Point next){
        return Math.abs(cur.x-next.x)*Math.abs(cur.x-next.x) + Math.abs(cur.y-next.y)*Math.abs(cur.y-next.y);
    }
}