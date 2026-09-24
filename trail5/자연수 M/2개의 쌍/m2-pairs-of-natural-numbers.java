import java.io.*;
import java.util.*;

public class Main {

    static class Number {
        long value;
        long count;

        Number(long value, long count) {
            this.value = value;
            this.count = count;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 값 -> 개수
        TreeMap<Long, Long> map = new TreeMap<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            long count = Long.parseLong(st.nextToken());
            long value = Long.parseLong(st.nextToken());

            map.put(value, map.getOrDefault(value, 0L) + count);
        }

        ArrayList<Number> numbers = new ArrayList<>();

        for (Map.Entry<Long, Long> entry : map.entrySet()) {
            numbers.add(new Number(entry.getKey(), entry.getValue()));
        }

        int left = 0;
        int right = numbers.size() - 1;

        long answer = 0;

        while (left < right) {

            Number small = numbers.get(left);
            Number large = numbers.get(right);

            answer = Math.max(answer, small.value + large.value);

            // 두 숫자에서 동시에 처리할 수 있는 쌍의 수
            long pairCount = Math.min(small.count, large.count);

            small.count -= pairCount;
            large.count -= pairCount;

            if (small.count == 0) {
                left++;
            }

            if (large.count == 0) {
                right--;
            }
        }

        // 같은 숫자끼리 남아 있는 경우
        if (left == right && numbers.get(left).count > 0) {
            answer = Math.max(answer, numbers.get(left).value * 2);
        }

        System.out.println(answer);
    }
}