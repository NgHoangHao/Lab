package Lab6;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class InsertSort {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        InputReader rd = new InputReader(System.in);
        int n = rd.nextInt();
        String dataType = rd.next();
        if (dataType.equals("double")) {
            Double[] array = new Double[n];
            for (int i = 0; i < array.length; i++) {
                array[i] = rd.nextDouble();
            }

            bubbleSort(array);
            for (int i = 0; i < array.length; i++) {
                sb.append(array[i]).append(" ");
            }
        }
        if (dataType.equals("int")) {
            Integer[] array = new Integer[n];
            for (int i = 0; i < array.length; i++) {
                array[i] = rd.nextInt();
            }
            bubbleSort(array);
            for (int i = 0; i < array.length; i++) {
                sb.append(array[i]).append(" ");
            }

        }
        if (dataType.equals("long")) {
            Long[] array = new Long[n];
            for (int i = 0; i < array.length; i++) {
                array[i] = rd.nextLong();
            }
            bubbleSort(array);
            for (int i = 0; i < array.length; i++) {
                sb.append(array[i]).append(" ");
            }
        }
        if (dataType.equals("float")) {
            Float[] array = new Float[n];
            for (int i = 0; i < array.length; i++) {
                array[i] = rd.nextFloat();
            }
            bubbleSort(array);
            for (int i = 0; i < array.length; i++) {
                sb.append(array[i]).append(" ");
            }
        }
        System.out.println(sb);
    }

    static <T extends Number & Comparable<T>> void bubbleSort(T[] array) {
        for (int i = 0; i < array.length; i++) {
            T temp = array[i];
            var j = i - 1;
            while (j >= 0 && array[j].compareTo(temp) > 0) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;

        }

    }

    // Your code here

    // Compare t[i] and T[j]: t[i].compareTo(T[j])

    public static <T extends Number & Comparable<T>> void swap(T[] array, int i, int j) {
        T temp;
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;

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
