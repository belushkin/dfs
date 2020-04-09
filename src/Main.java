import java.io.*;
import java.util.*;
import java.util.function.BiConsumer;

public class Main {

    private HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
    private HashMap<Integer, Boolean> visited = new HashMap<>();

    private int t;
    private ArrayList<Integer> f;

    public static void main(String[] args) {
        System.out.println("Starting DFS");
        Main main = new Main();
        main.buildGraph();
        System.out.println(main.graph);
    }

    private void strongConnectedComponent(HashMap<Integer, ArrayList<Integer>> graph) {
        DFSLoop(graph);
    }

    private void DFSLoop(HashMap<Integer, ArrayList<Integer>> graph) {
        graph.forEach((integer, integers) -> {
            if (!visited.containsKey(integer)) {
                DFSR(graph, integer);
            }
        });
    }

    private void DFSR(HashMap<Integer, ArrayList<Integer>> graph, int start) {

    }

    private void buildGraph() {
        try (Scanner scanner = new Scanner(new File("src/test_08/test_08_1.txt"))) {

            while (scanner.hasNext()) {
                String s = scanner.nextLine();
                int[] values = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
                addVertex(values[0], values[1]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void addVertex(int key, int value) {
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
