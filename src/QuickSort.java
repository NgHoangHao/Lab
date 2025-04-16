import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.StringTokenizer;

public class QuickSort {
    static InputReader sc = new InputReader(System.in);

    public static void main(String[] args) {
        var n = sc.nextInt();
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }

        quickSort(numbers, 0, numbers.length);
        var sb = new StringBuilder();
        for (var a : numbers) {
            sb.append(a).append(" ");
        }
        System.out.println(sb);
    }

    static void quickSort(int[] numbers, int from, int to) {
        if (from < to) {
            int middle = partition(numbers, from, to);
            quickSort(numbers, from, middle);
            quickSort(numbers, middle + 1, to);
        }
    }

    static int partition(int[] numbers, int from, int to) {
        var pivot = numbers[from];
        int i = from;
        int count = 0;

        for (var j = i + 1; j < to; j++) {
            if (numbers[j] < pivot) {
                i++;
                swap(numbers, i, j);
            }
            if (numbers[j] == pivot) {
                count++;
                if (count == to) {
                    break;
                } else {
                    continue;
                }
            }
        }
        swap(numbers, from, i);
        return i;
    }

    static void swap(int[] numbers, int i, int j) {
        var temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    static void shuffleArray(int[] numbers) {
        Random rd = new Random();
        for (int i = numbers.length - 1; i > 0; i--) {
            int j = rd.nextInt(i + 1);
            int temp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = temp;
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