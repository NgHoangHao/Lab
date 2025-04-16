package Lab7;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Scholarship2 {
    static InputReader rd = new InputReader(System.in);

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        ArrayList<Student> studentList = new ArrayList<>();
        int n = rd.nextInt();
        for (int i = 0; i < n; i++) {
            String name = rd.next();
            Student student = new Student(name);
            studentList.add(student);
            int course = rd.nextInt();
            for (int j = 0; j < course; j++) {
                int grade = rd.nextInt();
                student.countAvg(grade);
            }
        }
        studentList.sort((s1, s2) -> compare(s1, s2));
        int a = n / 12;
        double indexValue = studentList.get(a).avg;
        double currentValueA = 0;
        for (Student e : studentList) {
            if (e.avg > indexValue) {
                sb.append(e).append(" ").append("A").append("\n");
                currentValueA = e.avg;
            }
        }
        int b = n / 3;
        double currentValueB = 0;
        indexValue = studentList.get(b).avg;
        for (Student e : studentList) {
            if (e.avg > indexValue && e.avg < currentValueA) {
                sb.append(e).append(" ").append("B").append("\n");
                currentValueB = e.avg;
            }
        }
        int c = n / 2;
        indexValue = studentList.get(c).avg;
        for (Student e : studentList) {
            if (e.avg > indexValue && e.avg < currentValueB) {
                sb.append(e).append(" ").append("C").append("\n");
            }
        }
        System.out.println(sb);

    }

    public static class Student {
        String name;
        int course;
        int grade;
        double avg;

        public Student(String name) {
            this.name = name;
        }

        public void countAvg(int grade) {
            if (grade >= 50) {
                this.grade += grade;
                this.course++;
                this.avg = (double) this.grade / this.course;
            }
        }

        public String toString() {
            return name + " " + (double) Math.round(avg * 100) / 100;
        }
    }

    public static int compare(Student s1, Student s2) {
        if (s1.avg != s2.avg) {
            return Double.compare(s2.avg, s1.avg);
        }
        return s1.name.compareTo(s2.name);
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
