package Lab5;

import java.util.Scanner;

public class GPA {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        Student[] student = new Student[n];
        for (int i = 0; i < n; i++) {
            String id = sc.next();
            student[i] = new Student(id);
            int nOfCourse = sc.nextInt();
            for (int j = 0; j < nOfCourse; j++) {
                int course = sc.nextInt();
                student[i].addGrade(course);
            }
        }
        for (int i = 0; i < student.length; i++) {
            sb.append(student[i]).append("\n");
        }
        System.out.println(sb);

    }

    static class Student {
        private String id;
        private int totalGrade;
        private int totalCourse;
        private double avg;
        private StringBuilder passGrade;

        public Student(String id) {
            this.id = id;
            passGrade=new StringBuilder();
        }

        public void addGrade(int grade) {
            if (grade >= 50) {
                totalGrade += grade;
                totalCourse += 1;
                avg = totalGrade / totalCourse;
                passGrade.append(grade).append(" ");
            }
        }

        @Override
        public String toString() {
            return id + " " + passGrade.toString() + (int) avg;
        }

    }

}
