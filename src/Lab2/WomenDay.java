package Lab2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class WomenDay {
    static InputReader rd = new InputReader(System.in);

    public static void main(String[] args) {
        int n = rd.nextInt();
        int k = rd.nextInt();
        int maxMoney = 0;
        long minDistance = Long.MAX_VALUE / 2;
        int[] items = new int[n];
        for (int i = 0; i < items.length; i++) {
            items[i] = rd.nextInt();
        }
        int left = 0;
        int right = items.length - 1;
        Arrays.sort(items);
        while (left < right) {
            int max = items[left] + items[right];
            int min = items[right] - items[left];
            if (max > k) {
                right--;
            } else {
                if (max > maxMoney || max == maxMoney && min < minDistance) {
                    maxMoney = max;
                    minDistance = min;
                }
                left++;
            }
        }
        if (maxMoney == 0) {
            System.out.println("-1 -1");
        } else {
            System.out.println(maxMoney + " " + minDistance);
        }

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
