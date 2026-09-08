import java.util.*;

public class Main {

    static int n;
    static int answer = 0;

    static ArrayList<Point> bombs = new ArrayList<>();

    // 현재 몇 번 폭탄에 의해 초토화되어 있는지 저장
    static int[][] destroyed;

    static class Point {
        int r;
        int c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    // 폭탄 1번: 세로
    static int[][][] dr = {
        {{-2, 0}, {-1, 0}, {0, 0}, {1, 0}, {2, 0}},
        {{-1, 0}, {1, 0}, {0, 0}, {0, -1}, {0, 1}},
        {{-1, -1}, {-1, 1}, {0, 0}, {1, -1}, {1, 1}}
    };

    static void dfs(int idx) {

        // 모든 폭탄의 종류를 결정한 경우
        if (idx == bombs.size()) {

            int count = 0;

            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    if (destroyed[r][c] > 0) {
                        count++;
                    }
                }
            }

            answer = Math.max(answer, count);
            return;
        }

        Point bomb = bombs.get(idx);

        // 현재 폭탄을 3가지 종류 중 하나로 선택
        for (int type = 0; type < 3; type++) {

            // 폭탄 터뜨리기
            for (int i = 0; i < 5; i++) {

                int nr = bomb.r + dr[type][i][0];
                int nc = bomb.c + dr[type][i][1];

                if (nr < 0 || nr >= n || nc < 0 || nc >= n) {
                    continue;
                }

                destroyed[nr][nc]++;
            }

            dfs(idx + 1);

            // 원상복구
            for (int i = 0; i < 5; i++) {

                int nr = bomb.r + dr[type][i][0];
                int nc = bomb.c + dr[type][i][1];

                if (nr < 0 || nr >= n || nc < 0 || nc >= n) {
                    continue;
                }

                destroyed[nr][nc]--;
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {

                int value = sc.nextInt();

                if (value == 1) {
                    bombs.add(new Point(r, c));
                }
            }
        }

        destroyed = new int[n][n];

        dfs(0);

        System.out.println(answer);
    }
}