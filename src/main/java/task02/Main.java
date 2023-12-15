package task02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int maxConnections = 0;
            for (int j = 0; j < n; j++) {
                int a = scanner.nextInt();
                maxConnections = Math.max(maxConnections, a);
            }

            if (maxConnections >= n - 1) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}

