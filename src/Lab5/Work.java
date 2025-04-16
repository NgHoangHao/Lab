package Lab5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Work {
    static InputReader rd = new InputReader(System.in);

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        int n = rd.nextInt();
        int m = rd.nextInt();
        int count = 0;
        ArrayList<Integer> workTimes = new ArrayList<>();
        PriorityQueue<Person> persons = new PriorityQueue<>(new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                if (p1.loaded != p2.loaded)
                    return Integer.compare(p1.loaded, p2.loaded);
                return Integer.compare(p1.index, p2.index);

            }
        });
        for (int i = 0; i < n; i++) {
            Person person = new Person();
            person.index = count;
            count++;
            persons.add(person);
        }

        for (int i = 0; i < m; i++) {
            int timeWork = rd.nextInt();
            workTimes.add(timeWork);
        }
        workTimes.sort((s1, s2) -> compare(s1, s2));
        for (int e : workTimes) {
            Person minpersone = persons.poll();
            minpersone.loaded += e;
            persons.add(minpersone);

        }
        int[] result = new int[n];
        while (!persons.isEmpty()) {
            Person p = persons.poll();
            result[p.index] = p.loaded;
        }
        for (int e : result) {
            sb.append(e).append(" ");
        }
        System.out.println(sb);

    }

    public static int compare(int s1, int s2) {
        return Integer.compare(s2, s1);
    }

    public static class Person {
        int index;
        int loaded;

        public Person() {
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
