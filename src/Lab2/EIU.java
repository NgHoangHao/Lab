package Lab2;

import java.util.Scanner;

public class EIU {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        sb.append(begin(n)).append("\n");
        for (int i = 0; i < n / 2 - 1; i++) {
            sb.append(middleSpace(n)).append("\n");
        }
        sb.append(middle(n)).append("\n");
        for (int i = 0; i < n / 2 - 1; i++) {
            sb.append(middleSpace(n)).append("\n");
        }
        sb.append(end(n));
        System.out.println(sb);

    }

    public static String begin(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append(" ");
        for (int i = 0; i < n / 2; i++) {
            sb.append("_");
        }
        sb.append(" ").append(" ");
        sb.append(" ");
        for (int i = 0; i < n / 2; i++) {
            sb.append(" ");
        }
        sb.append(" ");
        return sb.toString();
    }

    public static String middleSpace(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append("|");
        for (int i = 0; i < n / 2; i++) {
            sb.append(" ");
        }
        sb.append(" ").append("|").append(" ").append("|");
        for (int i = 0; i < n / 2; i++) {
            sb.append(" ");
        }
        sb.append("|");
        return sb.toString();

    }

    public static String middle(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append("|");
        for (int i = 0; i < n / 2; i++) {
            sb.append("_");
        }
        sb.append(" ").append("|").append(" ").append("|");
        for (int i = 0; i < n / 2; i++) {
            sb.append(" ");
        }
        sb.append("|");
        return sb.toString();

    }

    public static String end(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append("|");
        for (int i = 0; i < n / 2; i++) {
            sb.append("_");
        }
        sb.append(" ").append("|").append(" ").append("|");
        for (int i = 0; i < n / 2; i++) {
            sb.append("_");
        }
        sb.append("|");
        return sb.toString();

    }

}
