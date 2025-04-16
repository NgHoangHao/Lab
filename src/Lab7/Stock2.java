package Lab7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Stock2 {
    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {
        int numberOfTransactions = reader.nextInt();
        TreeMap<Integer, Product> productMap = new TreeMap<>();
        while (numberOfTransactions-- > 0) {
            String action = reader.next();
            int productId = reader.nextInt();
            int quantity = reader.nextInt();
            long price = reader.nextLong();
            int timestamp = reader.nextInt();
            productMap.putIfAbsent(productId, new Product(productId));
            if (action.equals("+")) {
                productMap.get(productId).addStock(timestamp, quantity, price);
            } else {
                productMap.get(productId).exportStock(quantity);
            }
        }

        StringBuilder result = new StringBuilder();
        for (Product product : productMap.values()) {
            if (product.getTotalQuantity() > 0) {
                result.append(product).append("\n");
            }
        }
        System.out.print(result);
    }
}

class Product {
    private final int productId;
    private long totalQuantity;
    private long totalCost;
    private LinkedList<Transaction> transactions;

    public Product(int productId) {
        this.productId = productId;
        this.totalQuantity = 0;
        this.totalCost = 0;
        this.transactions = new LinkedList<>();
    }

    public void addStock(int timestamp, int quantity, long price) {
        transactions.add(new Transaction(timestamp, quantity, price));
        totalQuantity += quantity;
        totalCost += (long) quantity * price;
    }

    public void exportStock(int quantityToExport) {
        if (totalQuantity < quantityToExport) {
            return;
        }
        while (quantityToExport > 0 && !transactions.isEmpty()) {
            Transaction firstTransaction = transactions.getFirst();

            if (firstTransaction.getQuantity() > quantityToExport) {
                firstTransaction.reduceQuantity(quantityToExport);
                totalCost -= (long) quantityToExport * firstTransaction.getPrice();
                totalQuantity -= quantityToExport;
                break;
            } else {
                totalCost -= (long) firstTransaction.getQuantity() * firstTransaction.getPrice();
                totalQuantity -= firstTransaction.getQuantity();
                quantityToExport -= firstTransaction.getQuantity();
                transactions.removeFirst();
            }
        }
    }

    private long calculateAveragePrice() {
        return totalQuantity > 0 ? totalCost / totalQuantity : 0;
    }

    public long getTotalQuantity() {
        return totalQuantity;
    }

    @Override
    public String toString() {
        int firstTransactionTime = transactions.isEmpty() ? -1 : transactions.getFirst().getTimestamp();
        return productId + " " + totalQuantity + " " + calculateAveragePrice() + " " + firstTransactionTime;
    }
}

class Transaction {
    private final int timestamp;
    private int quantity;
    private final long price;

    public Transaction(int timestamp, int quantity, long price) {
        this.timestamp = timestamp;
        this.quantity = quantity;
        this.price = price;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public int getQuantity() {
        return quantity;
    }

    public long getPrice() {
        return price;
    }

    public void reduceQuantity(int amount) {
        this.quantity -= amount;
    }
}

class InputReader {
    private BufferedReader reader;
    private StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream));
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }
}