package edu.iastate.coms3110.hw4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        // Create a new directed graph
        DirectedGraph<String> graph = new DirectedGraph<>();

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");

        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "D");
        graph.addEdge("C", "D");
        graph.addEdge("C", "E");
        graph.addEdge("D", "E");
        graph.addEdge("D", "C");
        graph.addEdge("C", "B");
        graph.addEdge("E", "B");

        Map<Tuple<String, String>, Double> weights = new HashMap<>();
        weights.put(Tuple.create("A", "B"), 5.0);
        weights.put(Tuple.create("A", "C"), 200.0);
        weights.put(Tuple.create("B", "D"), 1.0);
        weights.put(Tuple.create("C", "D"), 10.0);
        weights.put(Tuple.create("C", "B"), 2000.0);
        weights.put(Tuple.create("C", "E"), 1000.0);
        weights.put(Tuple.create("D", "E"), 3000.0);
        weights.put(Tuple.create("D", "C"), 1.0);
        weights.put(Tuple.create("E", "B"), 1.0);


        Tuple<Map<String, Double>, Map<String, String>> result = graph.dijkstras("A", weights);

        Map<String, Double> dist = result.getFirst();
        Map<String, String> pred = result.getSecond();

        System.out.println("Shortest distances from source A:");
        for (Map.Entry<String, Double> entry : dist.entrySet()) {
            System.out.println("To " + entry.getKey() + " - Distance: " + entry.getValue());
        }

        System.out.println("\nShortest paths from source A:");
        for (Map.Entry<String, String> entry : pred.entrySet()) {
            String destination = entry.getKey();
            String path = destination;
            String predecessor = pred.get(destination);

            while (predecessor != null) {
                path = predecessor + " -> " + path;
                predecessor = pred.get(predecessor);
            }

            System.out.println("Path to " + destination + ": " + path);
        }
    }

    private static boolean isMinHeap(ArrayList<Integer> heap) {
        int n = heap.size();

        // Check all internal nodes (nodes that have children)
        for (int i = 0; i < n / 2; i++) {
            int leftChildIndex = 2 * i + 1;
            int rightChildIndex = 2 * i + 2;

            // Check if left child exists and is greater than the current node
            if (leftChildIndex < n && heap.get(i) > heap.get(leftChildIndex)) {
                return false;
            }

            // Check if right child exists and is greater than the current node
            if (rightChildIndex < n && heap.get(i) > heap.get(rightChildIndex)) {
                return false;
            }
        }

        // All checks passed, so it's a valid min-heap
        return true;
    }

}
