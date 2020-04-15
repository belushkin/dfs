

import java.util.*;

public class Solvator {

    private Map<Integer, ArrayList<Integer>> graph = new HashMap<>();
    private Map<Integer, Boolean> visited = new HashMap<>();
    private Map<Integer, Integer> f = new HashMap<>();
    private int n;
    private int k;

    public static void main(String[] args) {
        Solvator main = new Solvator();
        main.buildGraph();
        main.dfs();
        List<Integer> values = new ArrayList<>(main.f.values());
        values.sort(Collections.reverseOrder());
//        System.out.println(values);
        int sum = 0;
        for (int i = 0; i < main.n; i++) {
            if (i < main.k) {
                sum += values.get(i);
            }
        }
        System.out.println(sum);
    }

    private void dfs() {
        graph.forEach((integer, integers) -> {
            if (!visited.containsKey(integer)) {
//                System.out.println(integer);
                dfsr(graph, integer, 0);
            }
        });
        System.out.println(f);
        System.out.println(graph);
    }

    private void dfsr(Map<Integer, ArrayList<Integer>> graph, int start, int deep) {
        visited.put(start, true);
        graph.get(start).forEach(integer -> {
            if (!visited.containsKey(integer)) {
                dfsr(graph, integer, deep + 1);
            }
        });
        f.put(start, deep);
    }
    private void buildGraph() {
        Scanner sc = new Scanner(System.in);

        String p = sc.nextLine();
        String[] result = p.split(" ");
        n = Integer.parseInt(result[0]);
        k = Integer.parseInt(result[1]);

        for (int i = 0; i < n-1; i++) {
            String s    = sc.nextLine();
            String[] res = s.split(" ");
            addVertex(graph, Integer.parseInt(res[0]), Integer.parseInt(res[1]));
        }
    }

    private void addVertex(Map<Integer, ArrayList<Integer>> graph, int key, int value) {
        ArrayList<Integer> items = new ArrayList<>();
        if (graph.containsKey(key)) {
            items = graph.get(key);
        }

        items.add(value);
        graph.put(key, items);

        if (!graph.containsKey(value)) {
            graph.put(value, new ArrayList<>());
        }
    }

}
