import java.util.*;
import java.io.*;

// 1. 그냥 문제대로 1~N 다 트리셋에 넣고
// 애들 빼보기

// 2. 빼는 애들만 트리셋에 넣고
// 그 사이 간격만 계산하기

// 이 두 방법 하면서 둘 다 계산량 많음 10만 * 10만 -> 100억 펑
// 그러면 굳이 다 계산하지말고, 내가 넣고자 하는 간격? 암튼 그 녀석의 왼쪽 오른쪽만 구하고
// 걔네들 이용해서 걔네만 계산해보자.


public class Main {
    static int N;
    static int M;

    static TreeSet<Integer> ts = new TreeSet<>();
    static TreeMap<Integer, Integer> partition = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ts.add(-1);
        ts.add(N+1);
        partition.put(N+1, 1);

        st = new StringTokenizer(br.readLine());

        for(int i = 0 ; i < M; i++){
            int x = Integer.parseInt(st.nextToken());

            int left = ts.lower(x);
            int right = ts.higher(x);

            // 이전 단계에서의 이번 단계 숫자가 들어가는 구간의 간격
            int prevLen = right - left - 1;
            // 그 길이의 개수
            int count = partition.get(prevLen);

            // 어차피 1이라면 -> 그냥 빼고
            // 동일 길이의 최장 구간이 2개 이상일 수도 있으니까
            if(count == 1){
                partition.remove(prevLen);
            }
            // 아니라면 업데이트
            else{
                partition.put(prevLen, count-1);
            }

            // x 기준 왼쪽 
            int leftLen = right - x - 1;
            if(leftLen>0){
                partition.put(leftLen, partition.getOrDefault(leftLen, 0) + 1);
            }

            // x 기준 오른쪽
            int rightLen = x - left - 1;
            if(rightLen>0){
                partition.put(rightLen, partition.getOrDefault(rightLen, 0) + 1);
            }

            ts.add(x);

            System.out.println(partition.lastKey());

        }
    }
}