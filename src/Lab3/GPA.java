package Lab3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GPA {
    static InputReader rd = new InputReader(System.in);

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();
        sb1.append("");
        int numOfStudent = rd.nextInt();
        for (int i = 0; i < numOfStudent; i++) {
            String name = rd.next();
            int course = rd.nextInt();
            double average = 0;
            int count = 0;
            for (int j = 0; j < course; j++) {
                int score = rd.nextInt();
                if (score >= 50) {
                    average += score;
                    count++;
                    sb1.append(score).append(" ");
                }
            }
            if (count > 0) {
                average /= count;
                sb.append(name).append(" ").append(sb1.toString()).append((int)(average)).append("\n");
                sb1.setLength(0);
            } else {
                sb.append(name).append(" ").append(sb1.toString()).append(" ").append((int)(average)).append("\n");
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
