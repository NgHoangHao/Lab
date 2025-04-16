package Lab6;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.StringTokenizer;

public class Quicksort {
    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {
        int length = reader.nextInt();
        double numbers[] = new double[length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = reader.nextDouble()+i/1e10;
        }
        quicksort(numbers);
        StringBuilder sb = new StringBuilder();
        for (double i : numbers) {
            sb.append((long)i).append("\n");
        }
        System.out.println(sb);
    }

    public static void quicksort(double[] numbers) {
        quicksort(numbers, 0, numbers.length);
    }

    public static void quicksort(double[] numbers, int from, int to) {
        if (from + 1 >= to) {
            return;
        }
        int middle = lomutoPartition(numbers, from, to);
        quicksort(numbers, from, middle);
        quicksort(numbers, middle + 1, to);
    }

    public static int lomutoPartition(double numbers[], int from, int to) {
        Random random = new Random();
        int pivotIndex = random.nextInt(to - from) + from;
        swap(numbers, from, pivotIndex);
        double pivot = numbers[from];
        int middle = from;
        for (int i = from + 1; i < to; i++) {
            if (pivot < numbers[i]) {
                swap(numbers, middle + 1, i);
                middle++;
            }
        }
        swap(numbers, middle, from);
        return middle;
    }

    public static void swap(double[] numbers, int i, int j) {
        double temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
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

        public float nextFloat() {
            return Float.parseFloat(next());
        }
    }
}
