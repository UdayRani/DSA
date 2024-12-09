
public class recursion {
    public static void print1to5(int start, int end) {
        if (start > end)
            return;
        System.out.println(start);
        print1to5(start + 1, end);
    }

    public static void print5to1(int n) {
        if (n == 0)
            return;
        print5to1(n - 1);
        System.out.println(n);
    }

    public static void sum(int start, int end, int sum) {
        if (start > end) {
            System.out.println(sum);
            return;
        }
        sum(start + 1, end, start + sum);
    }

    public static void fact(int n, int fact) {
        if (n == 0) {
            System.out.println(fact);
            return;
        }
        fact(n - 1, fact * n);
    }

    public static int fib(int n) {
        if (n <= 1)
            return n;
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        print1to5(1, 5);
        print5to1(5);
        sum(1, 5, 0);
        fact(4, 1);
        System.out.println(fib(6));
    }

}
