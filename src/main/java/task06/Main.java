package task06;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int minVal = Integer.MAX_VALUE;
        long maxSum = 0;

        for (int i = 0; i < q; i++) {
            String queryType = scanner.next();
            if (queryType.equals("++")) {
                int l = scanner.nextInt();
                int r = scanner.nextInt();
                int x = scanner.nextInt();
                for (int j = l-1; j <= r-1; j++) {
                    a[j] += x;
                }
            } else {
                int l = scanner.nextInt();
                int r = scanner.nextInt();
                int k = scanner.nextInt();
                int b = scanner.nextInt();
                for (int j = l-1; j <= r-1; j++) {
                    int minValue = Math.min(a[j], k*j + b);
                    minVal = Math.min(minVal, minValue);
                    maxSum += minValue;
                }
            }
        }

        System.out.println(maxSum);
    }
}
