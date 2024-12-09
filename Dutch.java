public class Dutch {
    public static void main(String[] uday_) {
        int[] a = { 0, 1, 0, 2, 0, 1, 2 };
        int left = 0;
        int mid = 0;
        int right = a.length - 1;
        while (mid <= right) {
            if (a[mid] == 0) {
                int temp = a[mid];
                a[mid] = a[left];
                a[left] = temp;
                left++;
                mid++;

            } else if (a[mid] == 1) {
                mid++;
            } else {
                int temp = a[right];
                a[right] = a[mid];
                a[mid] = temp;
                right--;
            }
        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }

    }
}
