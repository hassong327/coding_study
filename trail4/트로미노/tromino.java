import java.util.*;

public class Main {

    static int N, M;
    static int[][] map;

    static int[][][] blocks = {
        // 가로 일자
        {{0, 0}, {0, 1}, {0, 2}},

        // 세로 일자
        {{0, 0}, {1, 0}, {2, 0}},

        // L 모양 4개
        {{0, 0}, {1, 0}, {1, 1}},   // X.
                                      // XX

        {{0, 1}, {1, 0}, {1, 1}},   // .X
                                      // XX

        {{0, 0}, {0, 1}, {1, 0}},   // XX
                                      // X.

        {{0, 0}, {0, 1}, {1, 1}}    // XX
                                      // .X
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][M];

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                map[r][c] = sc.nextInt();
            }
        }

        int max = 0;

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {

                // 6가지 블록 검사
                for (int[][] block : blocks) {

                    int sum = 0;
                    boolean possible = true;

                    for (int[] p : block) {
                        int nr = r + p[0];
                        int nc = c + p[1];

                        // 격자를 벗어나면 이 모양은 불가능
                        if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
                            possible = false;
                            break;
                        }

                        sum += map[nr][nc];
                    }

                    if (possible) {
                        max = Math.max(max, sum);
                    }
                }
            }
        }

        System.out.println(max);
    }
}