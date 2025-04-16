package Lab1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DistinctValue {
    static InputReader rd = new InputReader(System.in);

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        int numOfTest = rd.nextInt();
        for (int i = 0; i < numOfTest; i++) {
            int n = rd.nextInt();
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) {
                nums[j] = rd.nextInt();
            }
            Arrays.sort(nums);
            if (nums[0] < nums[1]) {
                sb.append(nums[0]).append(" ");
            }
            for (int j = 1; j < nums.length - 1; j++) {
                if (nums[j] < nums[j + 1] && nums[j] > nums[j - 1]) {
                    sb.append(nums[j]).append(" ");
                }

            }
            if (nums[nums.length - 2] < nums[nums.length - 1]) {
                sb.append(nums[nums.length - 1]);
            }
            sb.append("\n");

        }
        System.out.println(sb);

    }

    static class InputReader {
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
