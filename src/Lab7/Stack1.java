package Lab7;

import java.io.*;
import java.util.*;

class ArrayStack<T extends Number> {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        ArrayStack<Integer> stack = new ArrayStack<Integer>(n);
        // You code here
        
        for (int i = 0; i < m; i++) {
            int number = sc.nextInt();
            stack.push(number);
        }
        StringBuilder sb = new StringBuilder();
        while (k-- > 0) {
            String queue = sc.next();
            if (queue.equals("push")) {
                stack.push(sc.nextInt());
            } else {
                if (queue.equals("peek")) {
                    sb.append(stack.peek());
                } else if (queue.equals("sum")) {
                    sb.append(stack.sum());
                } else if (queue.equals("pop")) {
                    sb.append(stack.pop());
                } else if(queue.equals("average")) {
                    sb.append(stack.average());
                }else{
                    sb.append(stack.count());
                }
                sb.append("\n");
            }
 
        }
        System.out.println(sb);
    }

    // Your code here
    Object[] data;
    int lastIndex = 0;
    double total = 0;

    public ArrayStack(int capacity) {
        data = new Object[capacity];
    }

    public int count() {
        // Your code here
        return lastIndex;
    }

    public double sum() {
        // Your code here
        // T number;
        // number.doubleValue();

        return total;
    }

    public double average() {
        // Your code here
        return total / lastIndex;
    }

    /**
     * @description: add item when stack is not full
     */
    public void push(T item) {
        // Sample: data[lastIndex++] = item;
        // Your code here
        if (lastIndex < data.length) {
            data[lastIndex++] = item;
            total += (int) item;
        }
    }

    /**
     * @return: return and remove top item, or null when stack is empty
     */
    public T pop() {
        // Your code here
        if (lastIndex > 0) {
            T res = (T) data[lastIndex - 1];
            total -= (int) res;
            data[lastIndex - 1] = null;
            lastIndex--;
            return res;
        }
        return null;
    }

    /**
     * @return: return top item, or null when stack is empty
     */
    @SuppressWarnings("unchecked")
    public T peek() {
        // Sample return (T) data[lastIndex - 1];
        // Your code here
        if (lastIndex > 0) {
            return (T) data[lastIndex - 1];
        }
        return null;
    }
}
