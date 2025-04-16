package Lab6;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Random;

public class KSmallestEle {
    static InputReader rd = new InputReader(System.in);
    static Random random = new Random();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int numofTest = rd.nextInt();
        for (int i = 0; i < numofTest; i++) {
            int n = rd.nextInt();
            long a = rd.nextLong();
            long p = rd.nextLong();
            int k = rd.nextInt();
            k-=1;
            long[] nums = new long[n];
            nums[0] = (a * a) % p;
            for (int j = 1; j < nums.length; j++) {
                nums[j] = (nums[j - 1] * a) % p;
            }
            quickSort(nums, k);
        }
        System.out.println(sb);
    }

    public static void quickSort(long[] nums, int k) {
        quickSort(nums, 0, nums.length, k);
    }

    public static void quickSort(long[] nums, int from, int to, int k) {
        if (from + 1 >= to) {
            sb.append(nums[from]).append("\n");
            return;
        }
        int middle = partition(nums, from, to);
        if (middle < k) {
            quickSort(nums, middle + 1, to, k);
        } else if (middle > k) {
            quickSort(nums, from, middle, k);
        } else {
            sb.append(nums[middle]).append("\n");
            return;
        }
    }

    public static int partition(long[] nums, int from, int to) {
        int pivotIndex = random.nextInt(to - from) + from;
        swap(nums, from, pivotIndex);
        int middle = from;
        long pivot = nums[from];
        for (int i = from + 1; i < to; i++) {
            if (pivot > nums[i]) {
                swap(nums, middle + 1, i);
                middle++;
            }
        }
        swap(nums, from, middle);
        return middle;

    }

    public static void swap(long[] nums, int i, int j) {
        long temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
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
