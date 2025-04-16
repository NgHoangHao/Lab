package Lab2;

import java.util.Scanner;

public class WLetter {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int h = sc.nextInt();
        int a = 2 * h - 2;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < h; i++) {
            sb.append(w(h, i, a)).append(w(h, i, a)).append("\n");
            a -= 2;
        }
        System.out.println(sb);
    }

    public static String w(int n, int i, int a) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < i; j++) {
            sb.append(" ");
        }
        sb.append("\\");

        for (int j = 0; j < a; j++) {
            sb.append(" ");
        }
        sb.append("/");
        for (int j = 0; j < i; j++) {
            sb.append(" ");
        }
        return sb.toString();
    }
}
