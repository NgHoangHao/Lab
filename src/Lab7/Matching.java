package Lab7;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Matching {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int X = sc.nextInt();
        int[] men = new int[N];
        int[] women = new int[M];
        for (int i = 0; i < N; i++)
            men[i] = sc.nextInt();
        for (int i = 0; i < M; i++)
            women[i] = sc.nextInt();
        Arrays.sort(men);
        Arrays.sort(women);
        int low = 0, high = Math.max(men[N - 1], women[M - 1]) - Math.min(men[0], women[0]);
        int result = high;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (canFormPairs(men, women, X, mid)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        System.out.println(result);
        sc.close();
    }

    private static boolean canFormPairs(int[] men, int[] women, int X, int H) {
        int i = 0, j = 0, count = 0;
        while (i < men.length && j < women.length) {
            if (Math.abs(men[i] - women[j]) <= H) {
                count++;
                i++;
                j++;
                if (count == X)
                    return true;
            } else if (men[i] < women[j]) {
                i++;
            } else {
                j++;
            }
        }
        return count >= X;
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
