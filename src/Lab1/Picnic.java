package Lab1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Picnic {
    static InputReader rd = new InputReader(System.in);

    public static void main(String[] args) {
        int n = rd.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i < 5; i++) {
            map.put(i, 0);
        }
        for (int i = 0; i < n; i++) {
            int num = rd.nextInt();
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int count = 0;
        count += map.get(4);
        count += map.get(3);
        if (map.get(3) > map.get(1)) {
            map.put(1, 0);
        } else {
            map.put(1, map.get(1) - map.get(3));
        }
        int nextCount = map.get(2) * 2 / 4;
        count += nextCount;
        int finalCount = (map.get(2) * 2 % 4 + map.get(1));
        count += finalCount / 4;
        if (finalCount % 4 > 0) {
            count++;
        }
        System.out.println(count);

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
