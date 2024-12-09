public class SpecialIndex {
    public static void main(String[] args) {
        int[] a = { 5, 5, 2, 5, 8 };
        int[] prefix = new int[a.length];
        prefix[a.length - 1] = a[a.length - 1];
        prefix[a.length - 2] = a[a.length - 2];
        for (int i = a.length - 3; 1 >= 0; i--) {
            prefix[i] = prefix[i + 2] + a[i];
        }
        int LES = 0;
        int lOS = 0;
        int splind = 0;
        for (int i = 0; i < a.length; i++) {
            if (i % 2 == 0) {
                if (i <= a.length - 3) {
                    if (LES + prefix[i + 1] == lOS + prefix[i + 2]) {
                        splind++;
                    } else if (i == a.length - 2) {
                        if (LES + prefix[i + 1] == lOS) {
                            splind++;
                        }
                    } else {
                        if (LES == lOS) {
                            splind++;
                        }
                    }
                }
                LES += a[i];

            } else {
                if (i <= a.length - 3) {
                    if (LES + prefix[i + 2] == lOS + prefix[i + 1]) {
                        splind++;
                    } else if (i == a.length - 2) {
                        if (LES == lOS + prefix[i + 1]) {
                            splind++;
                        }
                    } else {
                        if (LES == lOS) {
                            splind++;
                        }
                    }
                }
                lOS += a[i];
            }

        }
    }

}
