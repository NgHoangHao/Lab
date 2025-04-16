package Lab5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Grade {
    static InputReader rd = new InputReader(System.in);

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        ArrayList<Student> studentList = new ArrayList<>();
        HashMap<Integer, Student> students = new HashMap<>();
        int n = rd.nextInt();
        for (int i = 0; i < n; i++) {
            int id = rd.nextInt();
            int course = rd.nextInt();
            double grade = rd.nextDouble();
            if (!students.containsKey(id)) {
                Student student = new Student(id);
                students.put(id, student);
            }
            students.get(id).countAvg(grade);
        }
        for (int e : students.keySet()) {
            studentList.add(students.get(e));
        }
        studentList.sort((s1, s2) -> compare(s1, s2));
        for (Student e : studentList) {
            sb.append(e).append("\n");

        }
        System.out.println(sb);

    }

    public static class Student {
        int id;
        double avg;
        long totalCourse;
        double totalGrade;

        public Student(int id) {
            this.id = id;
            this.avg = 0;
            this.totalCourse = 0;
            this.totalGrade = 0;
        }

        public void countAvg(double score) {
            this.totalCourse++;
            this.totalGrade += score;
            this.avg = this.totalGrade / this.totalCourse;

        }

        @Override
        public String toString() {
            return id + " " + (double) Math.round(avg * 1000) / 1000;
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
