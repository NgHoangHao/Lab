package Lab1;

import java.util.Scanner;

public class RepeatTime {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            int[] nums = new int[n];
            for (int j = 0; j < nums.length; j++) {
                nums[j] = sc.nextInt();
            }
            sb.append(countRepeat(nums)).append("\n");
        }
        System.out.println(sb);
    }

    public static int countRepeat(int[] arr) {
        int count = 0;
        while (count < 1000) {
            boolean flag = true;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] - arr[i - 1] != 0) {
                    flag = false;
                }
            }
            if (flag == true) {
                return count;
            }
            int newnum = arr[0];
            for (int i = 0; i < arr.length; i++) {
                if (i == arr.length - 1) {
                    arr[i] = Math.abs(newnum - arr[i]);
                    break;
                }
                arr[i] = Math.abs(arr[i + 1] - arr[i]);
            }
            count++;
        }
        return -1;
    }
}
