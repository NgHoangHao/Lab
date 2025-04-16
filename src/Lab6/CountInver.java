package Lab6;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CountInver {
    static long[] tempArr;
    static InputReader rd = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();
    static long countInversion;

    public static void main(String[] args) {
        int numofTest = rd.nextInt();
        for (int k = 0; k < numofTest; k++) {
            int n = rd.nextInt();
            long a = rd.nextLong();
            long p = rd.nextLong();
            long[] nums = new long[n];
            nums[0] = (a * a) % p;
            for (int i = 1; i < nums.length; i++) {
                nums[i] = (nums[i - 1] * a) % p;
            }
            countInversion = 0;
            mergeSort(nums);
            sb.append(countInversion).append("\n");
        }
        System.out.println(sb);
    }

    public static void mergeSort(long[] numbers) {
        tempArr = new long[numbers.length];
        mergeSort(numbers, 0, numbers.length);
    }

    public static void mergeSort(long[] numbers, int from, int to) {
        if (from + 1 >= to) {
            return;
        }
        int middle = (from + to) / 2;
        mergeSort(numbers, from, middle);
        mergeSort(numbers, middle, to);
        merge(numbers, from, middle, to);

    }

    public static void merge(long[] numbers, int from, int middle, int to) {
        int i = from;
        int j = middle;
        int k = from;
        while (i < middle || j < to) {
            if (i < middle && j < to && numbers[i] <= numbers[j] || j == to) {
                tempArr[k++] = numbers[i++];
            } else {
                tempArr[k++] = numbers[j++];
                countInversion += middle - i;
            }
        }
        for (i = from; i < to; i++) {
            numbers[i] = tempArr[i];
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
