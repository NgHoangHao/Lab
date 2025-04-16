package Lab5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Scholarship {
    static InputReader rd = new InputReader(System.in);

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        ArrayList<Student> students = new ArrayList<>();
        int n = rd.nextInt();
        for (int i = 0; i < n; i++) {
            String name = rd.next();
            int course = rd.nextInt();
            Student student = new Student(name);
            for (int j = 0; j < course; j++) {
                int grade = rd.nextInt();
                student.countAvg(grade);
            }
            students.add(student);
        }
        students.sort((s1, s2) -> compare(s1, s2));
        int k = 2;
        for (Student e : students) {
            sb.append(e).append("\n");
            k--;
            if (k == 0) {
                break;
            }
        }
        System.out.println(sb);
    }
 
    public static class Student {
        String name;
        double grade;
        double avg;
        int course;

        public Student(String name) {
            this.name = name;
            this.grade = 0;
            this.avg = 0;
            this.course = 0;
        }

        public void countAvg(double grade) {
            this.grade += grade;
            this.course++;
            this.avg = this.grade / this.course;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public static int compare(Student s1, Student s2) {
        return Double.compare(s2.avg, s1.avg);
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
