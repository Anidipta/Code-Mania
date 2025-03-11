import java.util.*;

public class ArrayStringDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("Array: " + Arrays.toString(arr));

        String s = sc.nextLine();
        System.out.println("String: " + s);

        sc.close();
    }
}
