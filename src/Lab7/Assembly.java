package Lab7;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Assembly {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            long M = scanner.nextLong();
            long[] Pi = new long[N];
            long[] Mi = new long[N];
            for (int i = 0; i < N; i++) {
                Pi[i] = scanner.nextLong();
                Mi[i] = scanner.nextLong();
            }
            long left = 0;
            long right = M + Arrays.stream(Pi).sum();
            long result = 0;
            while (left <= right) {
                long mid = left + (right - left) / 2;
                if (canAchieve(mid, Pi, Mi, M, N)) {
                    result = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            System.out.println(result);
        }
        scanner.close();
    }

    private static boolean canAchieve(long X, long[] Pi, long[] Mi, long M, int N) {
        long totalCost = 0;
        for (int i = 0; i < N; i++) {
            if (X > Pi[i]) {
                long needed = X - Pi[i];
                totalCost += needed * Mi[i];

                if (totalCost > M) {
                    return false;
                }
            }
        }
        return true;
    }

    public static class InputReader {
        StringTokenizer tokenizer;
        BufferedReader reader;
        String token;
        String temp;

        public InputReader(InputStream stream) {
            tokenizer = null;
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public InputReader(FileInputStream stream) {
            tokenizer = null;
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public String nextLine() throws IOException {
            return reader.readLine();
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    if (temp != null) {
                        tokenizer = new StringTokenizer(temp);
                        temp = null;
                    } else {
                        tokenizer = new StringTokenizer(reader.readLine());
                    }
                } catch (IOException e) {
                }
            }
            return tokenizer.nextToken();
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}
