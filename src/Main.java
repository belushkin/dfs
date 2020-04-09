import java.io.*;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Main {

    private HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
    private HashMap<Integer, ArrayList<Integer>> t_graph = new HashMap<>();
    private HashMap<Integer, Boolean> visited = new HashMap<>();

    private int t;
    private HashMap<Integer, Integer> f = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("Starting DFS");
        Main main = new Main();
        main.buildGraph();
//        main.strongConnectedComponent(main.getGraph());
//        System.out.println(main.getF());
        System.out.println(main.getGraph());
        System.out.println(main.getT_graph());
    }

    public HashMap<Integer, ArrayList<Integer>> getGraph() {
        return graph;
    }

    public HashMap<Integer, ArrayList<Integer>> getT_graph() {
        return t_graph;
    }

    public HashMap<Integer, Integer> getF() {
        return f;
    }

    private void strongConnectedComponent(HashMap<Integer, ArrayList<Integer>> graph) {
        DFSLoop(graph);
    }

    private void DFSLoop(HashMap<Integer, ArrayList<Integer>> graph) {
        graph.forEach((integer, integers) -> {
            if (!visited.containsKey(integer)) {
                System.out.println("DFSLoop " + integer);
                DFSR(graph, integer);
            }
        });
    }

    private void DFSR(HashMap<Integer, ArrayList<Integer>> graph, int start) {
        visited.put(start, true);
        graph.get(start).forEach(integer -> {
            if (!visited.containsKey(integer)) {
                DFSR(graph, integer);
            }
        });
        t++;
        f.put(start, t);
    }

    private void buildGraph() {
        try (Scanner scanner = new Scanner(new File("src/test_08/test_08_1.txt"))) {

            while (scanner.hasNext()) {
                String s = scanner.nextLine();
                int[] values = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
                addVertex(graph, values[0], values[1]);
                addVertex(t_graph, values[1], values[0]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void addVertex(HashMap<Integer, ArrayList<Integer>> graph, int key, int value) {
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
