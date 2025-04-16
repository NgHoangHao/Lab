package Lab1;

import java.util.Scanner;

public class Dormitory {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int count = 0;
        for (int i = 0; i < n; i++) {
            int p = sc.nextInt();
            int q = sc.nextInt();
            if (q - p >= 2) {
                count++;
            }

        }
        System.out.println(count);
    }

}
