package Lab7;

import java.io.BufferedReader;
    import java.io.FileInputStream;
    import java.io.IOException;
    import java.io.InputStream;
    import java.io.InputStreamReader;
    import java.util.StringTokenizer;

     class EIUSTACK {
        static InputReader reader = new InputReader(System.in);

        public static void main(String[] args) {
            int size = reader.nextInt();
            int noOfNumber = reader.nextInt();
            int commands = reader.nextInt();
            ArrayStack<Integer> stack = new ArrayStack<Integer>(size);
            StringBuilder output = new StringBuilder();
            for (int i = 0; i < noOfNumber; i++) {
                stack.push(reader.nextInt());
            }
            for (int i = 0; i < commands; i++) {
                String command = reader.next();
                if (command.equalsIgnoreCase("push")) {
                    stack.push(reader.nextInt());
                } else if (command.equalsIgnoreCase("pop")) {
                    output.append(stack.pop() + "\n");
                } else if (command.equalsIgnoreCase("peek")) {
                    output.append(stack.peek() + "\n");
                } else if (command.equalsIgnoreCase("sum")) {
                    output.append(stack.sum() + "\n");
                } else {
                    output.append(stack.average() + "\n");
                }
            }
            System.out.println(output);

        }

        static class ArrayStack<T extends Number> {
            // Your code here
            Object[] data;
            int lastIndex = 0;
            double sum = 0;
            int count = 0;
            int size;

            public ArrayStack(int capacity) {
                data = new Object[capacity];
                size = capacity;
            }

            public double sum() {
                return sum;
            }

            public double average() {
                double sum = sum();
                if (count != 0) {
                    return sum / (count);
                }
                return 0;

            }

            /**
             * @description: When stack is full => override the earliest added item
             */
            @SuppressWarnings("unchecked")
            public void push(T item) {
                // Sample: data[lastIndex++] = item;
                // Your code here
                if (count < size && lastIndex != size) {
                    data[lastIndex++] = item;
                    this.sum += item.doubleValue();
                    count++;
                } else if (count < size && lastIndex == size) {
                    data[0] = item;
                    lastIndex = 1;
                    this.sum += item.doubleValue();
                    count++;
                } else if (lastIndex == size && count == size) {
                    T number = (T) data[0];
                    this.sum -= number.doubleValue();
                    lastIndex = 0;
data[lastIndex++] = item;
                    this.sum += item.doubleValue();
                } else if (count == size) {
                    T number = (T) data[lastIndex];
                    this.sum -= number.doubleValue();
                    data[lastIndex++] = item;
                    this.sum += item.doubleValue();
                }
            }

            /**
             * @return: return and remove top item, or null when stack is empty
             */
            @SuppressWarnings("unchecked")
            public T pop() {
                if (count > 0 && lastIndex != 0) {
                    T tempt = (T) data[lastIndex - 1];
                    data[lastIndex - 1] = null;
                    this.lastIndex--;
                    this.sum -= tempt.doubleValue();
                    count--;
                    return tempt;
                } else if (count > 0 && lastIndex == 0) {
                    T tempt = (T) data[size - 1];
                    data[size - 1] = null;
                    this.lastIndex = size - 1;
                    this.sum -= tempt.doubleValue();
                    count--;
                    return tempt;
                } else if (count > 1 && lastIndex == 1) {
                    T tempt = (T) data[lastIndex - 1];
                    data[lastIndex - 1] = null;
                    lastIndex = size - 1;
                    this.sum -= tempt.doubleValue();
                    count--;
                    return tempt;
                } else if (count == 1 && lastIndex == 1) {
                    T tempt = (T) data[lastIndex - 1];
                    data[lastIndex - 1] = null;
                    this.sum -= tempt.doubleValue();
                    count--;
                    return tempt;
                } else if (count == 1 && lastIndex != 0) {
                    T tempt = (T) data[lastIndex - 1];
                    data[lastIndex - 1] = null;
                    lastIndex = 0;
                    this.sum -= tempt.doubleValue();
                    count--;
                    return tempt;
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
                if (count != 0) {
                    if (lastIndex != 0) {
                        return (T) data[lastIndex - 1];
                    } else if (count < size && lastIndex == 0) {
                        return (T) data[size - 1];
                    } else if (count == size) {
                        return (T) data[lastIndex];
                    }
                }
                return null;
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
