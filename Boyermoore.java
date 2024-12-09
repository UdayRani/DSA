public class Boyermoore {
    public static void main(String[] args) {
        int[] a = { 2, 2, 2, 4, 5, 2, 1 };
        int votes = 0;
        int maj = -1;
        for (int i = 0; i < a.length; i++) {
            if (votes == 0) {
                maj = a[i];
                votes++;
            } else {
                if (maj != a[i]) {
                    votes--;
                } else {
                    votes++;
                }
            }

        }
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == maj) {
                count++;
            }
        }
        if (count > a.length / 2) {
            System.out.print(maj);
        }

    }

}
