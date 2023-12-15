package task05;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int q = scanner.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        Map<Integer, List<Integer>> friends = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int v = scanner.nextInt();
            int u = scanner.nextInt();
            friends.putIfAbsent(v, new ArrayList<>());
            friends.putIfAbsent(u, new ArrayList<>());
            friends.get(v).add(u);
            friends.get(u).add(v);
        }

        for (int i = 0; i < q; i++) {
            String event = scanner.next();
            int v = scanner.nextInt();
            int x = scanner.nextInt();
            if (event.equals("++")) {
                if (friends.containsKey(v)) {
                    for (int u : friends.get(v)) {
                        a[u-1] += x;
                    }
                }
            } else if (event.equals("?")) {
                System.out.println(a[v-1]);
            }
        }

        scanner.close();
    }
}
