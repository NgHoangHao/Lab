package Lab7;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AsemblyLine {
    static InputReader rd = new InputReader(System.in);

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        int numOfTest = rd.nextInt();
        for (int i = 0; i < numOfTest; i++) {
            int numOfProduct = rd.nextInt();
            int totalBudget = rd.nextInt();
            int[] products = new int[numOfProduct];
            int[] budgets = new int[numOfProduct];

            for (int j = 0; j < numOfProduct; j++) {
                products[j] = rd.nextInt();
                budgets[j] = rd.nextInt();
            }

            sb.append(maxValue(products, budgets, totalBudget)).append("\n");
        }
        System.out.println(sb);
    }

    public static int maxValue(int[] products, int[] budgets, int budget) {
        int minProduct = Integer.MAX_VALUE;
        int minBudget = Integer.MAX_VALUE;
        int maxProduct = Integer.MIN_VALUE;
        for (int i = 0; i < products.length; i++) {
            minProduct = Math.min(minProduct, products[i]);
            minBudget = Math.min(minBudget, budgets[i]);
            maxProduct = Math.max(maxProduct, products[i]);
        }
        if (budget == 0)
            return minProduct;
        if (budget < minBudget)
            return minProduct;

        int left = minProduct;
        int right = maxProduct + (budget / minBudget);
        int result = minProduct;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (isEnough(products, budgets, middle, budget)) {
                result = middle;
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return result;
    }

    public static boolean isEnough(int[] product, int[] budget, int middle, int totalBudget) {
        long totalCost = 0;
        for (int i = 0; i < product.length; i++) {
            if (product[i] < middle) {
                totalCost += (long) (middle - product[i]) * budget[i];
            }
            if (totalCost > totalBudget)
                return false;
        }
        return totalCost <= totalBudget;
    }

    public static class InputReader {
        StringTokenizer tokenizer;
        BufferedReader reader;
        String token;
        String temp;

        public InputReader(InputStream stream) {
            tokenizer = null;
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public InputReader(FileInputStream stream) {
            tokenizer = null;
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public String nextLine() throws IOException {
            return reader.readLine();
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    if (temp != null) {
                        tokenizer = new StringTokenizer(temp);
                        temp = null;
                    } else {
                        tokenizer = new StringTokenizer(reader.readLine());
                    }
                } catch (IOException e) {
                }
            }
            return tokenizer.nextToken();
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}