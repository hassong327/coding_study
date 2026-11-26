import java.util.*;
import java.io.*;

public class Main {
    static boolean[][] visited = new boolean[5][1_000_003];

    public static class Point {
        int num, flag;
        int count;

        public Point(int num, int flag, int count) {
            this.num = num;
            this.flag = flag;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int answer = bfs(N);
        System.out.println(answer);
    }
    // 1, 2, 3, 4 flag에 따라서 연산 수행하도록, 
    // dq에 연산 넣어줄거. 
    // Number랑 연산자flag 를 하나의 step으로 dq에 넣어주기
    public static int bfs(int n) {
        ArrayDeque<Point> dq = new ArrayDeque<>();

        for (int i = 1; i <= 4; i++) {
            dq.offerLast(new Point(n, i, 0));
        }

        int answer = 0;

        while (!dq.isEmpty()) {
            Point curStep = dq.pollFirst();

            int curNum = curStep.num;
            int curFlag = curStep.flag;
            int curCount = curStep.count;
            int tmp = curNum;

            if (curNum == 1) {
                answer = curCount;
                break;
            }

            if (curNum <= 0 || curNum >= 1_000_003 || visited[curFlag][curNum]) continue;

            if (curFlag == 1) {
                curNum--;
                dq.offerLast(new Point(curNum, 1, curCount + 1));
                dq.offerLast(new Point(curNum, 3, curCount + 1));
                dq.offerLast(new Point(curNum, 4, curCount + 1));
            }

            if (curFlag == 2) {
                curNum++;
                dq.offerLast(new Point(curNum, 2, curCount + 1));
                dq.offerLast(new Point(curNum, 3, curCount + 1));
                dq.offerLast(new Point(curNum, 4, curCount + 1));
            }

            if (curFlag == 3) {
                if (curNum % 2 == 0) {
                    curNum = curNum / 2;
                    dq.offerLast(new Point(curNum, 1, curCount + 1));
                    dq.offerLast(new Point(curNum, 2, curCount + 1));
                    dq.offerLast(new Point(curNum, 3, curCount + 1));
                    dq.offerLast(new Point(curNum, 4, curCount + 1));
                }
            }

            if (curFlag == 4) {
                if (curNum % 3 == 0) {
                    curNum = curNum / 3;
                    dq.offerLast(new Point(curNum, 1, curCount + 1));
                    dq.offerLast(new Point(curNum, 2, curCount + 1));
                    dq.offerLast(new Point(curNum, 3, curCount + 1));
                    dq.offerLast(new Point(curNum, 4, curCount + 1));
                }
            }

            visited[curFlag][tmp] = true;
        }

        return answer;
    }
}