package Lab5;

import java.util.Scanner;

public class Credit {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        Student[] student = new Student[n];
        for (int i = 0; i < n; i++) {
            String id = sc.next();
            student[i] = new Student(id);
            int nOfCourse = sc.nextInt();
            for (int j = 0; j < nOfCourse; j++) {
                student[i].addGrade(sc.nextInt());
            }
        }
        for (int i = 0; i < student.length; i++) {
            sb.append(student[i]).append("\n");
        }
        System.out.println(sb);
    }

    static class Student {
        private String id;
        private int totalCredit;

        public Student(String id) {
            this.id = id;
        }

        public void addGrade(int grade) {
            if (grade >= 50) {
                totalCredit += 4;
            }

        }

        @Override
        public String toString() {
            return id + " " + totalCredit;
        }
    }
}
