package Lab1;

import java.util.HashSet;
import java.util.Scanner;

public class FirstOcurrence {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        HashSet<Integer> uniqueNum = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            uniqueNum.add(num);
        }
        for (int e : uniqueNum) {
            System.out.print(e + " ");
        }

    }
}