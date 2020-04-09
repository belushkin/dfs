import java.io.*;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Main {

    private HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
    private HashMap<Integer, ArrayList<Integer>> t_graph = new HashMap<>();
    private HashMap<Integer, Boolean> visited = new HashMap<>();
    private Stack<Integer> stack = new Stack<>();

    private int t;
    private int k = 1;
    private TreeMap<Integer, Integer> f = new TreeMap<>(Collections.reverseOrder());
    private List<Integer> components = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Starting DFS");
        Main main = new Main();
        main.buildGraph();
        main.strongConnectedComponent();
        System.out.println(main.getComponents());

        System.out.println(main.getF());
//        System.out.println(main.getGraph());
//        System.out.println(main.getT_graph());
    }

    public List<Integer> getComponents() {
        return components;
    }

    public HashMap<Integer, ArrayList<Integer>> getGraph() {
        return graph;
    }

    public HashMap<Integer, ArrayList<Integer>> getT_graph() {
        return t_graph;
    }

    public TreeMap<Integer, Integer> getF() {
        return f;
    }

    private void strongConnectedComponent() {
        DFSLoop(graph);
//        DFSLoopT();
    }

    private void DFSLoop(HashMap<Integer, ArrayList<Integer>> graph) {
        graph.forEach((integer, integers) -> {
            if (!visited.containsKey(integer)) {
                System.out.println("Loop: " + integer);
                DFSR(graph, integer);
            }
        });
    }

    private void DFSLoopT() {
        visited = new HashMap<>();
        f.forEach(((integer, integer2) -> {
            if (!visited.containsKey(integer2)) {
                t = 0;
                DFSRT(t_graph, integer2);
                components.add(t);
            }
        }));
    }

    private void DFSR(HashMap<Integer, ArrayList<Integer>> graph, int start) {
        visited.put(start, true);
        f.put(k, start);
        stack.push(start);
        while (!stack.isEmpty()) {
            int v = stack.pop();
            graph.get(v).forEach(integer -> {
                if (!visited.containsKey(integer)) {
                    k += 1;
                    visited.put(integer, true);
                    f.put(k, integer);
                    stack.push(integer);
                }
            });
        }


//        visited.put(start, true);
//        graph.get(start).forEach(integer -> {
//            if (!visited.containsKey(integer)) {
//                DFSR(graph, integer);
//            }
//        });
//        t++;
//        f.put(t,start);
    }

    private void DFSRT(HashMap<Integer, ArrayList<Integer>> graph, int start) {
        visited.put(start, true);
        graph.get(start).forEach(integer -> {
            if (!visited.containsKey(integer)) {
                DFSRT(graph, integer);
            }
        });
        t++;
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
