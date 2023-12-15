package task03;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // длина списка подарков
        long m = scanner.nextLong(); // размер предодобренного кредита
        long[] prices = new long[n]; // цены подарков

        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextLong();
        }

        Arrays.sort(prices);

        long maxRemaining = 0;
        for (int i = 0; i < n; i++) {
            long remainder = Math.max(0, prices[i] - m * (n - i - 1)); // тут может быть ошибка
            maxRemaining = Math.max(maxRemaining, remainder);
        }

        System.out.println(maxRemaining);
    }
}

