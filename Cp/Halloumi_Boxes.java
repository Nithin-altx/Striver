import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            long k = sc.nextLong();

            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextLong();
            }

            // If k > 1, we can always sort via operations → YES
            if (k > 1) {
                System.out.println("YES");
                continue;
            }

            // k == 1 → array must already be sorted
            long[] cpy = Arrays.copyOf(arr, arr.length);
            Arrays.sort(cpy);

            if (Arrays.equals(cpy, arr)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        sc.close();
    }
}
