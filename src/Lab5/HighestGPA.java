package Lab5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class HighestGPA {
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
                int grade = rd.nextInt();
                student.countAvg(grade);
            }
            studentList.add(student);
        }
        studentList.sort((s1, s2) -> compare(s1, s2));
        int count = 0;

        double result = studentList.get(k - 1).avg;
        for (Student e : studentList) {
            if (e.avg > result) {
                sb.append(e).append("\n");
                count++;
            }
            if (e.avg == result) {
                count++;
            }
            if (e.avg < result) {
                break;
            }
        }
        for (Student e : studentList)
        if (count == k) {
                if (e.avg == studentList.get(k - 1).avg) {
                    sb.append(e).append("\n");
                }
        }
        System.out.println(sb);
    }

    public static class Student {
        int id;
        String name;
        int course;
        int grade;
        double avg;
        int credit;

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public void countAvg(int grade) {
            if (grade >= 50) {
                this.course++;
                this.grade += grade;
                this.credit += 4;
                this.avg = (double) this.grade / this.course;
            }
        }

        @Override
        public String toString() {
            return id + " " + name + " " + Math.round(avg) + " " + credit;
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
