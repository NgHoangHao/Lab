package Lab7;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class LinkedList2 {

    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		// You code here
		int n = reader.nextInt();
		int m = reader.nextInt();
		for (int i = 0; i < n; i++) {
			linkedList.addFirst(reader.nextInt());
		}
		StringBuilder output = new StringBuilder();
		for (int i = 0; i < m; i++) {
			String command = reader.next();
			switch (command) {
				case "getAt": {
					int index = reader.nextInt();
					output.append(linkedList.getAt(index) + "\n");
					break;
				}
				case "firstIndexOf": {
					int value = reader.nextInt();
					output.append(linkedList.firstIndexOf(value) + "\n");
					break;
				}
				case "lastIndexOf": {
					int value = reader.nextInt();
					output.append(linkedList.lastIndexOf(value) + "\n");
					break;
				}
				case "sum":
					output.append(linkedList.sum() + "\n");
					break;
				case "average":
					output.append(linkedList.average() + "\n");
					break;
				case "insertAt": {
					int index = reader.nextInt();
					int value = reader.nextInt();
					linkedList.insertAt(index, value);
					break;
				}
				case "removeAt": {
					int index = reader.nextInt();
					linkedList.removeAt(index);
					break;
				}
				case "removeFirst": {
					int value = reader.nextInt();
					linkedList.removeFirst(value);
					// linkedList.printList();
					break;
				}
				default:
					break;
			}
		}
		System.out.println(output);

	}

	static class LinkedList<T extends Number> {

		static private class LinkedNode<U extends Number> {
			U number;
			LinkedNode<U> next;

			public LinkedNode(U number) {
				this.number = number;
			}
		}

		int size = 0;
		double sum = 0;
		LinkedNode<T> head = null;
		ArrayList<LinkedNode<T>> nodes = new ArrayList<>();

		public void insertAt(int index, T number) {
			// Your code here
			if (index < size && index != 0) {
				int i = 0;
				LinkedNode<T> temptNode = head;
				LinkedNode<T> nodeInserted = new LinkedNode<T>(number);
				while (temptNode.next != null) {
					i++;
					if (i == index) {
						nodeInserted.next = temptNode.next;
						temptNode.next = nodeInserted;
						break;
					}
					temptNode = temptNode.next;
				}
				sum += number.doubleValue();
				size++;
			} else if (index == 0 && size != 0) {
				LinkedNode<T> newNode = new LinkedNode<T>(number);
				newNode.next = head;
				head = newNode;
				sum += number.doubleValue();
				size++;
			} else {
				this.add(number);
			}
		}

		@SuppressWarnings({ "unchecked", "rawtypes" })
		public void add(T number) {
			// Your code here
			if (size == 0) {
				head = new LinkedNode(number);
				sum += number.doubleValue();
				size++;
			} else {
				LinkedNode<T> temptHead = head;
				LinkedNode<T> node = new LinkedNode<T>(number);
				while (temptHead.next != null) {
					temptHead = temptHead.next;
				}
				temptHead.next = node;
				sum += number.doubleValue();
				size++;
			}
		}

		@SuppressWarnings({ "unchecked", "rawtypes" })
		public void addFirst(T number) {
// Your code here
			if (size == 0) {
				head = new LinkedNode(number);
				sum += number.doubleValue();
				size++;
				nodes.add(head);
			} else {
				LinkedNode<T> temptHead = head;
				LinkedNode<T> node = new LinkedNode<T>(number);
				nodes.get(size - 1).next = node;
				nodes.add(node);
				sum += number.doubleValue();
				size++;
			}
		}

		public double sum() {
			// Your code here
			return sum;
		}

		public double average() {
			// Your code here
			if (size != 0) {
				return sum / size;
			} else {
				return 0;
			}
		}

		private int compare(T n1, T n2) {
			long l1 = n1.longValue();
			long l2 = n2.longValue();
			if (l1 != l2) {
				return (l1 < l2 ? -1 : 1);
			}
			return Double.compare(n1.doubleValue(), n2.doubleValue());
		}

		public int size() {
			return size;
		}

		/**
		 * @return -1 if number is not in list
		 */
		public int firstIndexOf(T number) {
			// Your code here
			int index = -1;
			int i = 0;
			LinkedNode<T> temptHead = head;
			while (temptHead != null) {
				if (compare(temptHead.number, number) == 0) {
					index = i;
					break;
				}
				temptHead = temptHead.next;
				i++;
			}
			return index;
		}

		/**
		 * @return -1 if number is not in list
		 */
		public int lastIndexOf(T number) {
			int index = -1;
			int i = 0;
			LinkedNode<T> temptHead = head;
			while (temptHead != null) {
				if (compare(temptHead.number, number) == 0) {
					index = i;
				}
				temptHead = temptHead.next;
				i++;
			}
			return index;
		}

		/**
		 * @return null if index is out of range
		 */
		public T getAt(int index) {
			// Your code here
			if (index < size && index >= 0) {
				int i = 0;
				LinkedNode<T> temptHead = head;
				while (temptHead != null) {
					if (i == index) {
						T num = temptHead.number;
						return num;
					}
					i++;
					temptHead = temptHead.next;
				}
			}
			return null;
		}

		public void removeFirst(T number) {
			// Your code here
			removeAt(firstIndexOf(number));
		}

		public void removeAt(int index) {
			if (index == 0) {
				sum -= head.number.doubleValue();
				head = head.next;
				size--;
			} else if (index == size - 1) {
				LinkedNode<T> nodeLast = head;
				LinkedNode<T> nodePreLast = null;
				while (nodeLast.next != null) {
					nodePreLast = nodeLast;
					nodeLast = nodeLast.next;
				}
				// if (nodePreLast == null) {
				// sum -= head.number.doubleValue();
				// head = null;
				// size--;
				// } else {
				sum -= nodeLast.number.doubleValue();
				nodePreLast.next = null;
				size--;
				// }
			} else {
				int i = 0;
				LinkedNode<T> nodeCurrent = head;
				LinkedNode<T> nodePre = null;
				while (nodeCurrent.next != null) {
					if (i == index) {
						sum -= nodeCurrent.number.doubleValue();
						nodePre.next = nodeCurrent.next;
						size--;
						break;
					}
					nodePre = nodeCurrent;
					nodeCurrent = nodeCurrent.next;
					i++;
				}
			}

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
