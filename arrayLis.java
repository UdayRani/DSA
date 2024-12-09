
import java.util.*;

public class arrayLis {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(0);
        al.add(1);
        al.add(3);
        al.add(4);
        System.out.println(al);
        al.set(3, 24);
        System.out.println(al);
        al.remove(2);
        System.out.println(al);
        System.out.println(al.size());
        for (int i : al) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < al.size(); i++) {
            System.out.print(al.get(i) + " ");
        }
    }

}
