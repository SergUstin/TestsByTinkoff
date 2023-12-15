package task04;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static Map<Integer, Integer> cheapestPackage; // Мап, которая хранит для каждой компании номер вершины с самым дешевым пакетом акций

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();  // размер дерева
        int k = scanner.nextInt();  // количество интересующих компаний
        cheapestPackage = new HashMap<>();

        for (int i = 0; i < k; i++) {
            String company = scanner.next();  // название компании
            cheapestPackage.put(i, Integer.MAX_VALUE);  // Инициализация номера вершины с самым дешевым пакетом акций большим значением
        }

        // Заполнение информации о вершинах дерева
        Node[] nodes = new Node[n + 1];
        for (int i = 1; i <= n; i++) {
            int parent = scanner.nextInt();
            int cost = scanner.nextInt();
            String company = scanner.next();
            nodes[i] = new Node(parent, cost, company);
        }

        // Обход дерева для поиска самых дешевых пакетов акций для каждой компании
        dfs(1, nodes);

        // Проверка, есть ли одновременно пакеты акций для всех интересующих компаний в поддереве
        int minCost = Integer.MAX_VALUE;
        for (int cost : cheapestPackage.values()) {
            if (cost == Integer.MAX_VALUE) {
                System.out.println(-1);
                return;
            }
            minCost = Math.min(minCost, cost);
        }
        System.out.println(minCost);
    }

    // DFS для поиска самых дешевых пакетов акций для каждой компании
    private static void dfs(int current, Node[] nodes) {
        if (cheapestPackage.containsValue(Integer.MAX_VALUE)) {
            for (Map.Entry<Integer, Integer> entry : cheapestPackage.entrySet()) {
                entry.setValue(0);
            }
        }

        if (nodes[current].cost < cheapestPackage.get(getCompanyId(nodes[current].company))) {
            cheapestPackage.put(getCompanyId(nodes[current].company), nodes[current].cost);
        }

        for (int i = 1; i < nodes.length; i++) {
            if (nodes[i].parent == current) {
                dfs(i, nodes);
            }
        }
    }

    // Получение id компании
    private static int getCompanyId(String company) {
        return company.hashCode();
    }

    // Класс, представляющий вершину дерева
    static class Node {
        int parent;
        int cost;
        String company;

        Node(int parent, int cost, String company) {
            this.parent = parent;
            this.cost = cost;
            this.company = company;
        }
    }
}