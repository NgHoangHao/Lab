package Lab1;

import java.util.Scanner;

public class Letter {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String firstString = sc.next();
        String secondString = sc.next();
        int result = 0;
        for (int i = 0; i < firstString.length(); i++) {
            String splitString = firstString.substring(i);
            if (secondString.startsWith(splitString)) {
                result = i + secondString.length();
                break;
            }
        }
        if (result == 0) {
            result = firstString.length() + secondString.length();
        }
        System.out.println(result);
    }

}
