package Lab1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PageNum {
    static InputReader rd = new InputReader(System.in);

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        int n = rd.nextInt();
        int[] pages = new int[n];
        int count = 1;
        for (int i = 0; i < pages.length; i++) {
            pages[i] = rd.nextInt();
        }
        Arrays.sort(pages);
        sb.append(pages[0]);
        for (int i = 1; i < pages.length; i++) {
            if (pages[i] - pages[i - 1] == 1) {
                count++;
                if (i == pages.length - 1) {
                    if (count >= 3) {
                        sb.append("-").append(pages[i]);
                    }
                    if (count == 2) {
                        sb.append(" ").append(pages[i]);
                    }
                }
            } else {
                if (count >= 3) {
                    sb.append("-").append(pages[i - 1]);
                    count = 1;
                }
                if (count == 2) {
                    sb.append(" ").append(pages[i - 1]);
                    count = 1;
                }
                sb.append(" ").append(pages[i]);
            }

        }
        System.out.println(sb);

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