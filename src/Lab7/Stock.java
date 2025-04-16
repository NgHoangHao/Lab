package Lab7;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Stock {
    static InputReader rd = new InputReader(System.in);

    public static void main(String[] args) {
        ArrayList<Product> productList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        HashMap<Integer, Product> products = new HashMap<>();
        int n = rd.nextInt();
        for (int i = 0; i < n; i++) {
            String equal = rd.next();
            int id = rd.nextInt();
            int nums = rd.nextInt();
            int price = rd.nextInt();
            if (!products.containsKey(id)) {
                Product product = new Product(id);
                products.put(id, product);
                productList.add(product);
            }
            if (equal.equals("+")) {
                products.get(id).countImPrice(nums, price);
            }
            if (equal.equals("-")) {
                products.get(id).countExPrice(nums, price);
            }
        }
        productList.sort((s1, s2) -> compare(s1, s2));
        for (Product e : productList) {
            if (e.imPrice > 0) {
                sb.append(e).append("\n");
            }
        }
        System.out.println(sb);
    }

    public static class Product {
        int id;
        int imNum;
        long imPrice;
        long exPrice;

        public Product(int id) {
            this.id = id;
            this.imNum = 0;
        }

        public void countImPrice(int nums, int price) {
            this.imNum += nums;
            this.imPrice += (long) price * nums;
        }

        public void countExPrice(int nums, int price) {
            if (this.imNum >= nums) {
                this.imNum -= nums;
                this.exPrice += (long) nums * price;
            }
        }

        public String toString() {
            return id + " " + imPrice + " " + exPrice;
        }

    }

    public static int compare(Product s1, Product s2) {
        return Integer.compare(s1.id, s2.id);
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
