package Lab6;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MergeSort {
    static int[] tempArray;
    static InputReader rd = new InputReader(System.in);

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        int n = rd.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rd.nextInt();
        }
        mergeSort(numbers);
        for (int i = 0; i < numbers.length; i++) {
            sb.append(numbers[i]).append("\n");
        }
        System.out.println(sb);

    }

    public static void mergeSort(int[] numbers) {
        tempArray = new int[numbers.length];
        mergeSort(numbers, 0, numbers.length);

    }

    public static void mergeSort(int[] numbers, int from, int to) {
        if (from + 1 >= to) {
            return;
        }
        int middle = (from + to) / 2;
        mergeSort(numbers, from, middle);
        mergeSort(numbers, middle, to);
        merge(numbers, from, middle, to);

    }

    public static void merge(int[] numbers, int from, int middle, int to) {
        int i = from;
        int j = middle;
        int k = from;
        while (i < middle || j < to) {
            if (i < middle && j < to && numbers[i] <= numbers[j] || j == to) {
                tempArray[k++] = numbers[i++];
            } else {
                tempArray[k++] = numbers[j++];
            }
        }
        for (i = from; i < to; i++) {
            numbers[i] = tempArray[i];
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
