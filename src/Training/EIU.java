package Training;

import java.util.Scanner;

public class EIU {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        sb.append(" ").append("_").append("\n");
        for (int i = 1; i < n; i++) {
            if (i == n / 2) {
                sb.append("|").append("_").append("  ").append("|").append("  ").append("|").append(" ")
                        .append("|").append("\n");
                continue;

            }
            sb.append("|").append("   ").append("|").append("  ").append("|").append(" ").append("|").append("\n");

        }
        sb.append("|").append("_").append("  ").append("|").append("  ").append("|").append("_")
                .append("|").append("\n");
        System.out.println(sb);
    }

}
