public class DoubleLL {
    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int d) {
            data = d;
            next = null;
            prev = null;
        }
    }

    public static Node head;

    public static void printDLL() {
        Node temp = head.next;
        while (temp.next != null) {
            System.out.println(temp.prev.data + " " + temp.data + " " + temp.next.data);
            // System.out.println(temp.data + " ->");
            temp = temp.next;
        }
    }

    public static Node reverseDLL() {
        Node prev = null;
        Node curr = head;
        // Node next;
        while (curr != null) {
            prev = curr.prev;
            curr.prev = curr.next;
            curr.next = prev;
            curr = curr.prev;
        }
        head = prev.prev;
        return head;

    }

    public static void isPalindrome() {
        Node right = head;
        Node left = head;
        while (right.next != null) {
            right = right.next;
        }
        while (left != right && left.prev != right) {
            if (left.data != right.data)
                System.out.println("false");

            // left = left.next;
            // right = right.prev;

            System.out.println(head.next.next.next.prev.data);
        }
        System.out.print("true");
    }

    public static void main(String[] args) {
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(2);
        head.next.next.next.next.next = new Node(1);
        head.next.prev = head;
        head.next.next.prev = head.next;
        head.next.next.next.prev = head.next.next;
        head.next.next.next.next.prev = head.next.next.next;
        head.next.next.next.next.next.prev = head.next.next.next.next.next;
        // printDLL();
        // reverseDLL();
        // printDLL();
        isPalindrome();
        // printDLL();
    }
}
