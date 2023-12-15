package task01;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine(); // Чтение перехода на следующую строку после ввода числа t

        for (int i = 0; i < t; i++) {
            String letters = scanner.nextLine();
            if (canFormTinkoff(letters)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    public static boolean canFormTinkoff(String letters) {
        Set<Character> letterSet = new HashSet<>();
        for (char c : letters.toCharArray()) {
            letterSet.add(c);
        }

        String tinkoff = "TINKOFF";
        for (char c : tinkoff.toCharArray()) {
            if (!letterSet.contains(c)) {
                return false;
            }
        }
        return true;
    }
}
