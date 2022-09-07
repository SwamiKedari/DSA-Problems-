import java.util.*;
public class kadaneAlgorithm {
    // doubt
    public static void main(String[] swami) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }
        System.out.println(kadane(a));
    }

    private static int kadane(int[] a) {
        int k = a.length;
        int u = 0;
        int max = a[0];
        for (int i = 0; i < k; i++) {
            u += a[i];
            if (u > max) {
                max = u;
            }
            if (u < 0) {
                u = 0;

            }
        }
        return max;
    }

    long maxSubarraySum(int a[], int n) {

        // Your code here
        long m = a[0];
        long cur = 0;
        for (int i = 0; i < n; i++) {
            cur += a[i];
            if (cur > m) {
                m = cur;
            }
            if (cur < 0) {
                cur = 0;
            }
        }
        return m;


    }
}

