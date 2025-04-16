package Lab1;

import java.util.Scanner;

public class MostCommonNum {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] nums = new int[100000];
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            nums[num]++;
        }
        int max = 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        System.out.println(index + " " + max);
    }

}
