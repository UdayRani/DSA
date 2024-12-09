public class Link1 {
    public static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static Node head;

    public static void printLL() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public class LinkedList3 {
        public static class Node {
            int data;
            Node next;

            Node(int d) {
                data = d;
                next = null;
            }
        }
    }

    public static Node sortColours() {
        Node zeroHead = new Node(-1);
        Node oneHead = new Node(-1);
        Node twoHead = new Node(-1);
        Node zero = zeroHead;
        Node one = oneHead;
        Node two = twoHead;
        Node temp = head;
        while (temp != null) {
            if (temp.data == 0) {
                zero.next = temp;
                zero = zero.next;
            } else if (temp.data == 1) {
                one.next = temp;
                one = one.next;
            } else {
                two.next = temp;
                two = two.next;
            }
            temp = temp.next;
        }
        two.next = null;
        if (oneHead.next == null) {
            zero.next = twoHead.next;
        } else {
            zero.next = oneHead.next;
        }
        one.next = twoHead.next;
        return zeroHead.next;
    }

    public static Node rotateRight(int k) {
        if (head == null || k == 0) {
            return head;
        }
        Node temp = head;
        int count = 0;
        while (temp.next != null) {
            count++;
            temp = temp.next;
        }
        count++;
        if (k % count == 0) {
            return head;
        }
        k = k % count;
        temp.next = head;
        Node prev = null;
        for (int i = 0; i < count - k + 1; i++) {
            prev = temp;
            temp = temp.next;
        }
        prev.next = null;
        head = temp;
        return head;

    }

    public static void main(String[] args) {
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        printLL();
        // sortColours();
        // printLL();
        rotateRight(4);
        printLL();
    }

}
