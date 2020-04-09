import java.io.*;
import java.util.*;

public class Main {

    private HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("Starting DFS");
        Main main = new Main();
        main.buildGraph();
        System.out.println(main.graph);
    }

    private void buildGraph() {
        try (Scanner scanner = new Scanner(new File("src/test_08/test_08_1.txt"))) {

            while (scanner.hasNext()) {
                String s = scanner.nextLine();
                int[] values = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
                if (graph.containsKey(values[0])) {
                    ArrayList<Integer> items = graph.get(values[0]);
                    items.add(values[1]);
                    graph.put(values[0], items);
                } else {
                    ArrayList<Integer> items = new ArrayList<>(Collections.singletonList(values[1]));
                    graph.put(values[0], items);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
