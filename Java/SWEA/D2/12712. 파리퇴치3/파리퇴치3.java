import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            int[][] arr = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            int maxi = Integer.MIN_VALUE;

            int[] plus_r = {1, -1, 0, 0};
            int[] plus_c = {0, 0, 1, -1};

            int[] diag_r = {-1, -1, 1, 1};
            int[] diag_c = {-1, 1, -1, 1};

            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    int plus_sum = arr[row][col];
                    int diag_sum = arr[row][col];

                    for (int k = 0; k < 4; k++) {
                        for (int l = 1; l < M; l++) {
                            int y = row + l * plus_r[k];
                            int x = col + l * plus_c[k];

                            if (y >= 0 && y < N && x >= 0 && x < N) {
                                plus_sum += arr[y][x];
                            }

                            y = row + l * diag_r[k];
                            x = col + l * diag_c[k];

                            if (y >= 0 && y < N && x >= 0 && x < N) {
                                diag_sum += arr[y][x];
                            }
                        }
                    }

                    maxi = Math.max(maxi, Math.max(plus_sum, diag_sum));
                }
            }

            System.out.printf("#%d %d\n", test_case, maxi);
        }
    }
}