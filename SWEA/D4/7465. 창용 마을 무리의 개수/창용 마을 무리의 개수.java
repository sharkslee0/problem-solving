import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    static int n, m;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int tcs = Integer.parseInt(br.readLine());
        for (int tc = 1; tc < tcs + 1; tc++) {
            sb.append("#").append(tc).append(" ");
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            parents = new int[n + 1];
            for (int i = 1; i < n + 1; i++) {
                parents[i] = i;
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a, b);
            }

            int answer = 0;

            for (int i = 1; i < n + 1; i++) {
                if (parents[i] == i) {
                    answer++;
                }
            }

            sb.append(answer).append("\n");

        }

        System.out.println(sb);

    }

    private static void union(int a, int b) {
        int pA = find(a);
        int pB = find(b);

        if (pA < pB) {
            parents[pB] = pA;
        } else if (pB < pA) {
            parents[pA] = pB;
        }
    }

    private static int find(int num) {
        if (parents[num] != num) {
            parents[num] = find(parents[num]);
        }

        return parents[num];
    }


}