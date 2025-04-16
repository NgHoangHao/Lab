import java.util.HashMap;
import java.util.Scanner;

public class Sort {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int x=sc.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int e : arr) {
            map.put(e, map.getOrDefault(e, 0) + 1);

        }
       System.out.println(map.getOrDefault(x,0));
    }
}
