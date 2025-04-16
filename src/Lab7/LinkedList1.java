package Lab7;
import java.util.Scanner;

class LinkedList<T extends Number> {

    static private class LinkedNode<U extends Number> {
        U number;
        LinkedNode<U> next;

        public LinkedNode(U number) {
            this.number = number;
        }
    }

    LinkedNode<T> head = null;
    int count = 0;

    public void insertAt(int index, T number) {
        // Your code here

        LinkedNode<T> newNode = new LinkedNode(number);
        // first index
        if (index == 0) {
            if (head == null) {
                head = newNode;
            } else {
                newNode.next = head;
                head = newNode;
            }
            count++;
        }

        // last index
        else if (index == count) {
            LinkedNode<T> tempNode = head;
            for (int i = 0; i < count; i++) {
                tempNode.next = newNode;

            }
            tempNode.next = newNode;
            count++;
        }

        // mid index
        else if (index > 0 && index < count) {
            LinkedNode<T> tempNode = head;
            for (int i = 0; i < index; i++) {
                tempNode = tempNode.next;
            }
            tempNode.next = newNode;
            count++;
        }

    }

    /**
     * @return null if index is out of range
     */
    public T getAt(int index) {
        // Your code here
        if (index < count) {
            LinkedNode<T> tempNode = head;
            for (int i = 0; i < index; i++) {
                tempNode = tempNode.next;
            }
            return tempNode.number;
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        // You code here
        StringBuilder sb = new StringBuilder();
        int con = sc.nextInt();
        int m = sc.nextInt();
        while (m-- > 0) {
            String command = sc.next();
          
            switch (command) {
                case "insertAt": {
                    int index = sc.nextInt();
                    int number = sc.nextInt();
                    linkedList.insertAt(index, number);
                    break;
                }
                case "getAt": {
                    int index = sc.nextInt();
                    sb.append(linkedList.getAt(index)).append("\n");
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}