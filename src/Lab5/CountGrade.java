package Lab5;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class CountGrade {
    static Reader rd = new Reader();

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        HashMap<Integer, Student> students = new HashMap<>();
        ArrayList<Student> studentList = new ArrayList<>();
        ArrayList<Integer>courses= new ArrayList<>();
        int n = rd.nextInt();
        int p = rd.nextInt();
        int m = rd.nextInt();
        for (int i = 0; i < n; i++) {
            int currentID = rd.nextInt();
            Student student = new Student(currentID, p);
            students.put(currentID, student);
            studentList.add(student);
           
        }
        for (int i = 0; i < p; i++) {
            int currentCourse = rd.nextInt();
            courses.add(currentCourse);

        }
        for (int i = 0; i < m; i++) {
            int id = rd.nextInt();
            int course = rd.nextInt();
            int grade=rd.nextInt();
            if(courses.contains(course)){
                students.get(id).countAvg(grade, course);

            }
           
        }
        
        studentList.sort((s1, s2) -> compare(s1, s2));
        for (Student e : studentList) {
            sb.append(e).append("\n");
        }

        System.out.println(sb);

    }

    public static class Student {
        int id;
        int p;
        double avg;
        HashMap<Integer, Integer> bestScore;
        int submit;
        int total;

        public Student(int id,int p) {
            this.id = id;
            this.bestScore = new HashMap<>();
            this.avg = 0;
            this.submit = 0;
            this.p=p;
        }

        public void countAvg(int score, int course) {
            if (!bestScore.containsKey(course)) {
                total += score;
                bestScore.put(course, score);

            } else {
                if (score > bestScore.get(course)) {
                    total += score - bestScore.get(course);
                    bestScore.put(course, score);
                }
            }
            submit++;
            this.avg = total / p;
        }

        @Override
        public String toString() {
            return id + " " + (long) avg + " " + submit;
        }

    }

    public static int compare(Student s1, Student s2) {
        if (s1.avg != s2.avg) {
            return Double.compare(s2.avg, s1.avg);
        } else {
            if (s1.submit != s2.submit) {
                return Integer.compare(s1.submit, s2.submit);
            } else {
                return Integer.compare(s1.id, s2.id);
            }
        }
    }

    static class Reader {
        private int BUFFER_SIZE = 1 << 16;
        private byte[] buffer = new byte[BUFFER_SIZE];
        private int bufferPointer = 0, bytesRead = 0;
        private InputStream rd;

        public Reader() {
            this.rd = System.in;
        }

        private int read() {
            if (bufferPointer == bytesRead) {
                bufferPointer = 0;
                try {
                    bytesRead = rd.read(buffer, bufferPointer, BUFFER_SIZE);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (bytesRead == -1) {
                    return -1;
                }
            }
            return buffer[bufferPointer++];
        }

        public int nextInt() {
            int number = 0;
            int c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean negative = (c == '-');
            if (negative) {
                c = read();
            }
            do {
                number = number * 10 + (c - '0');
                c = read();
            } while (c >= '0' && c <= '9');
            return negative ? -number : number;
        }

        public long nextLong() {
            long number = 0L;
            int c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean negative = (c == '-');
            if (negative) {
                c = read();
            }
            do {
                number = number * 10 + (c - '0');
                c = read();
            } while (c >= '0' && c <= '9');
            return negative ? -number : number;
        }

        public String next() {
            int c = read();
            while (c <= ' ') {
                c = read();
            }
            StringBuilder t = new StringBuilder();
            do {
                t.append((char) c);
                c = read();
            } while (c > ' ');
            return t.toString();
        }

        public String nextLine() {
            int c = read();
            while (c == '\n' || c == '\r') {
                c = read();
            }
            StringBuilder t = new StringBuilder();
            while (c != '\n' && c != '\r' && c != -1) {
                t.append((char) c);
                c = read();
            }
            return t.toString();
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public char nextChar() {
            int c = read();
            while (c <= ' ') {
                c = read();
            }
            return (char) c;
        }
    }

}
