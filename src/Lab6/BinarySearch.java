package Lab6;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

class BinarySearch {
    static int[] tempArr;
    static InputReader rd = new InputReader(System.in);

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        int n = rd.nextInt();
        int m = rd.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = rd.nextInt();
        }
        Arrays.sort(nums);
        for (int i = 0; i < m; i++) {
            int x = rd.nextInt();
            sb.append(binarySearch(nums, x)).append(" ");
        }
        System.out.println(sb);
    }

    public static int binarySearch(int[] nums, int x) {
        int left = 0;
        int right = nums.length - 1;
        int index = -1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] > x) {
                right = middle - 1;
            } else if (nums[middle] < x) {
                left = middle + 1;
            } else {
                index = middle;
                right = middle - 1;
            }
        }
        return index;

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