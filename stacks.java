import java.util.*;
import java.util.Arrays;

public class stacks {
    static class StackUsingAL {
        ArrayList<Integer> al = new ArrayList<>();

        public boolean isEmpty() {
            if (al.size() == 0)
                return true;
            return false;
        }

        public void push(int d) {
            al.add(d);
        }

        public int pop() {
            if (isEmpty()) {
                return -1;
            }
            return al.remove(al.size() - 1);
        }

        public int peek() {
            if (isEmpty()) {
                return -1;
            }
            return al.get(al.size() - 1);
        }

        public int size() {
            return al.size();
        }

    }

    public static void nextGreater(int[] a) {
        Stack<Integer> st = new Stack<>();
        int[] nextGreater = new int[a.length];
        for (int i = a.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && a[i] >= a[st.peek()]) {
                st.pop();
            }
            if (st.isEmpty())
                nextGreater[i] = -1;
            else
                nextGreater[i] = a[st.peek()];
            st.push(i);
        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(nextGreater[i] + " ");
        }

    }

    public static void nextSmaller(int[] a) {
        Stack<Integer> st = new Stack<>();
        int[] nextSmaller = new int[a.length];
        for (int i = a.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && a[i] <= a[st.peek()]) {
                st.pop();
            }
            if (st.isEmpty())
                nextSmaller[i] = -1;
            else
                nextSmaller[i] = a[st.peek()];
            st.push(i);
        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(nextSmaller[i] + " ");
        }

    }

    public static void nextGreaterLeft(int[] a) {
        Stack<Integer> st = new Stack<>();
        int[] nextGreaterLeft = new int[a.length];
        for (int i = 0; i <= a.length - 1; i++) {
            while (!st.isEmpty() && a[i] >= a[st.peek()]) {
                st.pop();
            }
            if (st.isEmpty())
                nextGreaterLeft[i] = -1;
            else
                nextGreaterLeft[i] = a[st.peek()];
            st.push(i);
        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(nextGreaterLeft[i] + " ");
        }

    }

    public static void nextSmallerLeft(int[] a) {
        Stack<Integer> st = new Stack<>();
        int[] nextSmallerLeft = new int[a.length];
        for (int i = 0; i <= a.length - 1; i++) {
            while (!st.isEmpty() && a[i] <= a[st.peek()]) {
                st.pop();
            }
            if (st.isEmpty())
                nextSmallerLeft[i] = -1;
            else
                nextSmallerLeft[i] = a[st.peek()];
            st.push(i);
        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(nextSmallerLeft[i] + " ");
        }

    }

    public static void main(String[] args) {
        /*
         * StackUsingAL stack = new StackUsingAL();
         * stack.push(1);
         * stack.push(2);
         * stack.push(3);
         * stack.push(4);
         * stack.push(5);
         * System.out.println(stack.size());
         * System.out.println(stack.peek());
         * System.out.println(stack.pop());
         * System.out.println(stack.isEmpty());
         */
        int[] a = { 6, 9, 2, 0, 8, 1, 3 };
        System.out.println(" 6,9,2,0,8,1,3");
        // nextGreater(a);
        // nextSmaller(a);
        // nextGreaterLeft(a);
        nextSmallerLeft(a);

    }

}
