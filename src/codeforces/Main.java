package codeforces;

import java.io.*;
import java.util.*;

public class Main {

    private Map<Integer, ArrayList<Integer>> graph = new HashMap<>();
    private Map<Integer, ArrayList<Integer>> t_graph = new HashMap<>();
    private Map<Integer, Boolean> visited = new HashMap<>();
    private Stack<Integer> stack = new Stack<>();

    private boolean yes =false;
    private int t;
    private TreeMap<Integer, Integer> f = new TreeMap<>(Collections.reverseOrder());
//    private Map<Integer, Integer> f = new HashMap<>();
    private List<Integer> components = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Starting DFS");
        Main main = new Main();
        main.buildGraph();
        main.strongConnectedComponent();
//        System.out.println(main.getComponents());
        List<Integer> com = main.getComponents();
        System.out.println(com.get(0));
        System.out.println(com.get(1));
        System.out.println(com.get(2));
        System.out.println(com.get(3));
        System.out.println(com.get(4));


//        System.out.println(main.getF());
//        System.out.println(main.getGraph());
//        System.out.println(main.getT_graph());
    }

    public List<Integer> getComponents() {
        components.sort(Collections.reverseOrder());
        return components;
    }

    public Map<Integer, ArrayList<Integer>> getGraph() {
        return graph;
    }

    public Map<Integer, ArrayList<Integer>> getT_graph() {
        return t_graph;
    }

    public Map<Integer, Integer> getF() {
        return f;
    }

    private void strongConnectedComponent() {
//        System.out.println(graph);
        DFSLoop();
        stack.clear();
        DFSLoopT();
    }

    private void DFSLoop() {
        graph.forEach((integer, integers) -> {
            if (!visited.containsKey(integer)) {
//                System.out.println("Loop: " + integer);
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

    private void DFSR(Map<Integer, ArrayList<Integer>> graph, int start) {
//        stack.push(start);
//        visited.put(start, true);
//        while (!stack.isEmpty()) {
//            int V = stack.peek();
//            yes = true;
//            List<Integer> items = graph.get(V);
//            for (int i = items.size()-1; i >=0; i--) {
//                if (!visited.containsKey(items.get(i))) {
//                    yes = false;
//                    visited.put(items.get(i), true);
//                    stack.push(items.get(i));
//                }
//            }
//
//            if (yes) {
//                t += 1;
//                int g = stack.pop();
//                f.put(t, g);
//            }
//        }

        visited.put(start, true);
        graph.get(start).forEach(integer -> {
            if (!visited.containsKey(integer)) {
                DFSR(graph, integer);
            }
        });
        t++;
        f.put(t,start);
    }

    private void DFSRT(Map<Integer, ArrayList<Integer>> graph, int start) {
//        stack.push(start);
//        visited.put(start, true);
//        while (!stack.isEmpty()) {
//            yes = true;
//            List<Integer> items = graph.get(stack.peek());
//            for (int i = items.size()-1; i >=0; i--) {
//                if (!visited.containsKey(items.get(i))) {
//                    yes = false;
//                    visited.put(items.get(i), true);
//                    stack.push(items.get(i));
//                }
//            }
//
//            if (yes) {
//                t += 1;
//                stack.pop();
//            }
//        }

        visited.put(start, true);
        graph.get(start).forEach(integer -> {
            if (!visited.containsKey(integer)) {
                DFSRT(graph, integer);
            }
        });
        t++;

    }

    private void buildGraph() {
        try (Scanner scanner = new Scanner(new File("src/test_08/test_08_2.txt"))) {
//        try (Scanner scanner = new Scanner(new File("src/test_08/input_08.txt"))) {

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
