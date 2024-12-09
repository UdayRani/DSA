public class LinkedList3 {
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

    public static Node evenOdd() {
        Node evenHead = new Node(-1);
        Node oddHead = new Node(-1);
        Node even = evenHead;
        Node odd = oddHead;
        Node temp = head;
        int index = 0;
        while (temp != null) {
            if (index % 2 == 0) {
                even.next = temp;
                even = even.next;
            } else {
                odd.next = temp;
                odd = odd.next;
            }
            index++;
            temp = temp.next;
        }
        even.next = oddHead.next;
        odd.next = null;

        return evenHead.next;

    }

    public static boolean isPalindrome() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node prev = null;
        Node curr = slow;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node temp = head;
        while (temp != null && prev != null) {
            if (temp.data != prev.data)
                return false;
            temp = temp.next;
            prev = prev.next;
        }
        return true;
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
        return zero.next;
    }

    public static void main(String[] args) {
        head = new Node(0);
        head.next = new Node(0);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        head.next.next.next.next = new Node(0);
        head.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next = new Node(0);
        // printLL();
        // evenOdd();
        printLL();
        sortColours();
        printLL();
        // System.out.println(isPalindrome());
        // printLL();
    }

}
