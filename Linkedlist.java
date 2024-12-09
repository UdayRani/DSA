public class Linkedlist {
    static class Node {
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

    public static void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;

    }

    public static void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public static void countNodes() {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        System.out.print(count);

    }

    public static void deleteFirst() {
        head = head.next;
    }

    public static void deleteLast() {
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
    }

    // public static Node head;

    public static Node evenOdd() {
        Node evenHead = new Node(-1);
        Node oddHead = new Node(-1);
        Node even = evenHead;
        Node odd = oddHead;
        int index = 0;
        Node temp = head;
        while (temp != null) {
            if (index % 2 == 0) {
                even.next = temp;
                even = even.next;
            } else {
                odd.next = temp;
                odd = odd.next;
            }
            temp = temp.next;
            index++;
        }
        even.next = oddHead.next;
        odd.next = null;
        return evenHead.next;

    }

    public static void deleteKFromLast(int k) {
        Node fast = head;
        while (k != 0 && fast != null) {
            fast = fast.next;
            k--;

        }
        if (k != 0) {
            System.out.println("This can't happen");
            return;
        }
        if (fast == null) {
            head = head.next;
            return;
        }
        Node slow = head;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        printLL();
    }

    public static Node reverseLL() {
        Node prev = null;
        Node curr = head;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return prev;

    }

    public static int lenOfLL1(Node head) {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public static int lenOfLL2(Node head2) {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public static int intersectionOfLL() {
        int len1 = lenOfLL1(head);
        int len2 = lenOfLL2(head2);
        if (len1 > len2) {
            int steps = len1 - len2;
            Node temp = head;
            while (steps - 1 != -1) {
                temp = temp.next;
                steps--;
            }
            Node temp2 = head2;
            while (temp != temp2) {
                temp2 = temp2.next;
                temp = temp.next;
            }
            if (temp2 == null)
                return -1;
            return temp.data;
        } else {
            int steps = len2 - len1;
            Node temp = head2;
            while (steps - 1 != 1) {
                temp = temp.next;
                steps--;
            }
            Node temp2 = head;
            while (temp != temp2) {
                temp2 = temp2.next;
                temp = temp.next;
            }
            if (temp2 == null)
                return -1;
            return temp.data;
        }
    }

    public static Node head2;

    public static int intersectionOfLL2() {
        Node temp1 = head;
        Node temp2 = head2;
        int count1 = 0;
        int count2 = 0;
        while (temp1 != temp2) {
            temp1 = temp1.next;
            temp2 = temp2.next;
            if (temp1 == null) {
                if (count1 == 1) {
                    return -1;
                }
                temp1 = head2;
                count1++;
            }
            if (temp2 == null) {
                if (count2 == 1)
                    return -1;
                temp2 = head;
                count2++;
            }
        }
        if (temp1 != null || temp2 != null) {
            return -1;
        }
        return 1;
    }

    public static void main(String[] uday) {
        head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);
        head.next.next.next.next.next = new Node(60);
        head.next.next.next.next.next.next = new Node(70);
        head2 = new Node(8);
        head2.next = new Node(9);
        head2.next.next = new Node(10);
        head2.next.next.next = head.next.next.next.next;
        // head.next.next.next.next.next.next.next = head.next.next;

        // printLL();
        // printLL();
        // addLast(100);
        // printLL();
        // addFirst(200);
        // deleteFirst();
        // deleteLast();
        // evenOdd();
        printLL();
        // deleteKFromLast(3);
        printLL();
        reverseLL();
        printLL();
        // countNodes();
        // intersectionOfLL();
        // intersectionOfLL2();
        printLL();

    }
}
