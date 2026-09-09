import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int T = sc.nextInt();

        int[] belt = new int[2 * N];

        for (int i = 0; i < 2 * N; i++) {
            belt[i] = sc.nextInt();
        }

        T %= (2 * N);

        for (int t = 0; t < T; t++) {
            int temp = belt[2 * N - 1];

            for (int i = 2 * N - 1; i > 0; i--) {
                belt[i] = belt[i - 1];
            }

            belt[0] = temp;
        }

        for (int i = 0; i < N; i++) {
            System.out.print(belt[i] + " ");
        }
        System.out.println();

        for (int i = N; i < 2 * N; i++) {
            System.out.print(belt[i] + " ");
        }
    }
}