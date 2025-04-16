package Lab5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Exercise {
    static InputReader rd = new InputReader(System.in);

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        ArrayList<Student> studentList = new ArrayList<>();
        ArrayList<Integer> studentID = new ArrayList<>();
        HashMap<Integer, Student> students = new HashMap<>();
        int n = rd.nextInt();
        int p = rd.nextInt();
        int m = rd.nextInt();
        for (int i = 0; i < n; i++) {
            int currentid = rd.nextInt();
            Student student = new Student(currentid);
            students.put(currentid, student);
            studentList.add(student);

        }
        for (int i = 0; i < p; i++) {
            int currentCourse = rd.nextInt();
        }
        for (int i = 0; i < m; i++) {
            int id = rd.nextInt();
            int course = rd.nextInt();
            int grade = rd.nextInt();
            students.get(id).countAvg(grade, p, course);

        }
        studentList.sort((s1, s2) -> compare(s1, s2));
        for (Student e : studentList) {
            sb.append(e).append("\n");
        }
        System.out.println(sb);
    }

    public static class Student {
        int id;
        HashMap<Integer, Integer> bestScore;
        int total;
        double avg;

        public Student(int id) {
            this.id = id;
            this.bestScore = new HashMap<>();
        }

        public void countAvg(int grade, int p, int course) {
            if (bestScore.get(course) == null) {
                total += grade;
                bestScore.put(course, grade);
            } else {
                if (bestScore.get(course) < grade) {
                    total += (grade - bestScore.get(course));
                    bestScore.put(course, grade);
                }
            }
            this.avg = total / p;
        }

        @Override
        public String toString() {
            return id + " " + (int) avg;
        }

    }

    public static int compare(Student s1, Student s2) {
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
