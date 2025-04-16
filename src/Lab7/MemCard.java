package Lab7;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class MemCard {
    static InputReader rd = new InputReader(System.in);

    public static void main(String[] args) {
        HashMap<String, Customer> customers = new HashMap<>();
        int n = rd.nextInt();
        for (int i = 0; i < n; i++) {
            String id = rd.next();
            long price = rd.nextLong();
            if (!customers.containsKey(id)) {
                Customer customer = new Customer(id);
                customers.put(id, customer);
            }
            customers.get(id).countDiscount(price);
        }
        double total = 0;
        for (String e : customers.keySet()) {
            total += customers.get(e).discount;
        }
        System.out.println((double) Math.round(total * 100) / 100);
    }

    public static class Customer {
        String id;
        long price;
        double discount;

        public Customer(String id) {
            this.id = id;
        }

        public void countDiscount(long price) {
            int[] level = { 200000000, 50000000, 20000000, 1000000, 0 };
            double[] discount = { 0.07, 0.05, 0.03, 0.02, 0 };
            for (int i = 0; i < level.length; i++) {
                if (this.price >= level[i]) {
                    this.discount += price * discount[i];
                    break;
                }
            }
            this.price += price;
        }
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
