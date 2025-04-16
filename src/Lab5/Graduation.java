package Lab5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Graduation {
    static InputReader rd = new InputReader(System.in);

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        ArrayList<Student> students = new ArrayList<>();
        int n = rd.nextInt();
        int minCredit = rd.nextInt();
        for (int i = 0; i < n; i++) {
            long id = rd.nextLong();
            String name = rd.next();
            Student student = new Student(id, name);
            int course = rd.nextInt();
            for (int j = 0; j < course; j++) {
                int grade = rd.nextInt();
                student.countAvg(grade);
            }
            students.add(student);
        }
        students.sort((s1, s2) -> compare(s1, s2));
        for (Student e : students) {
            if (e.credit >= minCredit) {
                sb.append(e).append("\n");
            }
        }
        System.out.println(sb);

    }

    public static class Student {
        long id;
        String name;
        int course;
        double grade;
        double avg;
        int credit;

        public Student(long id, String name) {
            this.id = id;
            this.name = name;
            this.credit = 0;
        }

        public void countAvg(int grade) {
            if (grade >= 50) {
                this.course++;
                this.grade += grade;
                this.avg = this.grade / this.course;
                this.credit += 4;
            }
        }

        @Override
        public String toString() {
            return id + " " + name + " " + (int) avg;

        }

    }

    public static int compare(Student s1, Student s2) {
        if ((int)s1.avg != (int)s2.avg) {
            return Double.compare(s2.avg, s1.avg);
        }
        return Long.compare(s1.id, s2.id);

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
