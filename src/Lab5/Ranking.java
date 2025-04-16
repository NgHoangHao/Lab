
package Lab5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Ranking {
    static InputReader rd = new InputReader(System.in);

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        ArrayList<Student> studentList = new ArrayList<>();
        int n = rd.nextInt();
        int k = rd.nextInt();
        for (int i = 0; i < n; i++) {
            int id = rd.nextInt();
            String name = rd.next();
            Student student = new Student(id, name);
            int course = rd.nextInt();
            for (int j = 0; j < course; j++) {
                int score = rd.nextInt();
                student.countAvg(score);
            }
            studentList.add(student);
        }
        int rank = 1;
        int count = 1;
        double current = 0;
        studentList.sort((s1, s2) -> compare(s1, s2));
        double result = studentList.get(k - 1).avg;
        for (Student e : studentList) {
            if (e.avg < result) {
                break;
            }
            if (e.avg != current) {
                rank = count;
            }
            current = e.avg;
            sb.append(rank).append(" ").append(e).append("\n");
            count++;

        }
        System.out.println(sb);

    }

    public static class Student {
        int id;
        String name;
        int course;
        int grade;
        double avg;

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
            this.avg = 0;
        }

        public void countAvg(int grade) {
            if (grade >= 50) {
                this.course++;
                this.grade += grade;
                this.avg = (double) this.grade / this.course;
            }
        }

        @Override
        public String toString() {
            return id + " " + name + " " + Math.round(avg);
        }

    }

    public static int compare(Student s1, Student s2) {
        if (s1.avg != s2.avg) {
            return Double.compare(s2.avg, s1.avg);
        }
        return Integer.compare(s1.id, s2.id);
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
