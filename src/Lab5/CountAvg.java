package Lab5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class CountAvg {
    static InputReader rd = new InputReader(System.in);
    static HashMap<Integer, Integer> map1 = new HashMap<>();
    static HashMap<Integer, Double> map2 = new HashMap<>();

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        int n = rd.nextInt();
        ArrayList<Integer> student = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int id = rd.nextInt();
            int course = rd.nextInt();
            double grade = rd.nextDouble();
            map1.put(id, map1.getOrDefault(id, 0) + 1);
            map2.put(id, map2.getOrDefault(id, (double) 0) + grade);
            if (map1.get(id) == 1) {
                student.add(id);
            }
        }
        student.sort((s1, s2) -> compare(s1, s2));
        for (int e : student) {
            sb.append(e).append(" ").append((double) Math.round(countAvg(e) * 1000) / 1000).append("\n");
        }
        System.out.println(sb);
    }

    public static int compare(int s1, int s2) {
        double avg1 = countAvg(s1);
        double avg2 = countAvg(s2);
        if (avg1 != avg2) {
            return Double.compare(avg2, avg1);
        } else {
            return Integer.compare(s1, s2);
        }
    }

    public static double countAvg(int id) {
        if (map1.containsKey(id))
            return map2.get(id) / map1.get(id);
        return 0;
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
