package Lab5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Profit {
    static InputReader rd = new InputReader(System.in);

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        ArrayList<Item> itemList = new ArrayList<>();
        int n = rd.nextInt();
        int k = rd.nextInt();
        for (int i = 0; i < n; i++) {
            int identity = rd.nextInt();
            String name = rd.next();
            Item item = new Item(identity, name);
            int price = rd.nextInt();
            int cost = rd.nextInt();
            long number = rd.nextLong();
            item.countProfit(price, cost, number);
            itemList.add(item);
        }
        itemList.sort((s1, s2) -> compare(s1, s2));
        long count = itemList.get(k - 1).profit;
        for (Item e : itemList) {
            if (e.profit < count) {
                break;
            }
            sb.append(e).append("\n");
        }
        System.out.println(sb);
    }

    public static class Item {
        int identity;
        String name;
        long profit;

        public Item(int identity, String name) {
            this.identity = identity;
            this.name = name;
        }

        public void countProfit(int price, int cost, long number) {
            this.profit = (price - cost) * number;
        }

        @Override
        public String toString() {
            return identity + " " + name + " " + profit;

        }
    }

    public static int compare(Item s1, Item s2) {
        if (s1.profit != s2.profit) {
            return Long.compare(s2.profit, s1.profit);
        }
        return Integer.compare(s1.identity, s2.identity);
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
