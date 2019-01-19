package hr.fer;

import hr.fer.algorithm.KruskalAlgorithm;
import hr.fer.model.Edge;
import hr.fer.model.Node;
import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        //Map<String, Node> graph = new HashMap<>();
        String path = "C:\\Users\\domin\\Documents\\Edi\\Fer\\DIPLOMSKI\\NASP\\labos\\nasp\\src\\hr\\fer\\Graph.txt";
        var edges = loadFromFile(path);
        var kaResult = KruskalAlgorithm.findMST(edges, 24);
        var kaWeight = 0;
        for (var r : kaResult) {
            //kaResult.sort(Comparator.comparing(Edge::getNode1));
            System.out.println(r.getNode1() + "\t" + r.getNode2() + "\t" + r.getWeight());
            kaWeight += r.getWeight();
        }
        System.out.println("Weight sum is: " + kaWeight);
    }

    private static List<Edge> loadFromFile(String path) throws IOException {
        var edges = new ArrayList<Edge>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            while (line != null) {
                String[] values = line.split(" {3}");
                edges.add(new Edge(values[0], values[1], Integer.parseInt(values[2])));
                line = br.readLine();
            }
        }
        return edges;
    }


    //
//private void addElementsToGraph(Map<String, Node> graph) {
//graph.put("a", new Node("a", new ArrayList<>() {{
//add(new Pair<> ("b", 2));
//add(new Pair<> ("c", 4));
//}}));
//graph.put("b", new Node("b", new ArrayList<>() {{
//add(new Pair<> ("a", 2));
//add(new Pair<> ("c", 5));
//add(new Pair<> ("d", 2));
//add(new Pair<> ("e", 7));
//}}));
//graph.put("c", new Node("c", new ArrayList<>() {{
//add(new Pair<> ("a", 4));
//add(new Pair<> ("b", 5));
//add(new Pair<> ("d", 1));
//add(new Pair<> ("g", 8));
//add(new Pair<> ("h", 3));
//}}));
//graph.put("d", new Node("d", new ArrayList<>() {{
//add(new Pair<> ("b", 2));
//add(new Pair<> ("c", 1));
//add(new Pair<> ("g", 7));
//add(new Pair<> ("h", 2));
//}}));
//graph.put("e", new Node("e", new ArrayList<>() {{
//add(new Pair<> ("b", 7));
//add(new Pair<> ("f", 8));
//add(new Pair<> ("h", 1));
//}}));
//graph.put("f", new Node("f", new ArrayList<>() {{
//add(new Pair<> ("e", 8));
//add(new Pair<> ("i", 4));
//add(new Pair<> ("j", 2));
//add(new Pair<> ("n", 1));
//}}));
//graph.put("g", new Node("g", new ArrayList<>() {{
//add(new Pair<> ("c", 8));
//add(new Pair<> ("d", 7));
//add(new Pair<> ("h", 4));
//add(new Pair<> ("k", 7));
//add(new Pair<> ("l", 3));
//}}));
//graph.put("h", new Node("h", new ArrayList<>() {{
//add(new Pair<> ("c", 3));
//add(new Pair<> ("d", 2));
//add(new Pair<> ("e", 1));
//add(new Pair<> ("g", 4));
//add(new Pair<> ("i", 3));
//add(new Pair<> ("l", 7));
//add(new Pair<> ("m", 2));
//}}));
//graph.put("i", new Node("i", new ArrayList<>() {{
//add(new Pair<> ("f", 4));
//add(new Pair<> ("h", 3));
//add(new Pair<> ("m", 2));
//add(new Pair<> ("n", 6));
//}}));
//graph.put("j", new Node("j", new ArrayList<>() {{
//add(new Pair<> ("f", 2));
//add(new Pair<> ("o", 5));
//}}));
//graph.put("k", new Node("k", new ArrayList<>() {{
//add(new Pair<> ("g", 7));
//add(new Pair<> ("p", 14));
//}}));
//graph.put("l", new Node("l", new ArrayList<>() {{
//add(new Pair<> ("g", 3));
//add(new Pair<> ("h", 7));
//add(new Pair<> ("p", 7));
//add(new Pair<> ("t", 8));
//}}));
//graph.put("m", new Node("m", new ArrayList<>() {{
//add(new Pair<> ("h", 2));
//add(new Pair<> ("i", 2));
//add(new Pair<> ("n", 9));
//add(new Pair<> ("r", 2));
//add(new Pair<> ("s", 4));
//}}));
//graph.put("n", new Node("n", new ArrayList<>() {{
//add(new Pair<> ("f", 1));
//add(new Pair<> ("i", 6));
//add(new Pair<> ("m", 9));
//add(new Pair<> ("r", 1));
//add(new Pair<> ("o", 9));
//add(new Pair<> ("v", 10));
//}}));
//graph.put("o", new Node("o", new ArrayList<>() {{
//add(new Pair<> ("j", 5));
//add(new Pair<> ("n", 9));
//add(new Pair<> ("v", 3));
//}}));
//graph.put("p", new Node("p", new ArrayList<>() {{
//add(new Pair<> ("k", 14));
//add(new Pair<> ("l", 7));
//}}));
//graph.put("r", new Node("r", new ArrayList<>() {{
//add(new Pair<> ("m", 2));
//add(new Pair<> ("n", 1));
//add(new Pair<> ("t", 4));
//add(new Pair<> ("u", 6));
//}}));
//graph.put("s", new Node("s", new ArrayList<>() {{
//add(new Pair<> ("m", 4));
//add(new Pair<> ("v", 2));
//}}));
//graph.put("t", new Node("t", new ArrayList<>() {{
//add(new Pair<> ("l", 8));
//add(new Pair<> ("r", 4));
//}}));
//graph.put("u", new Node("u", new ArrayList<>() {{
//add(new Pair<> ("r", 6));
//add(new Pair<> ("v", 11));
//add(new Pair<> ("x", 5));
//}}));
//graph.put("v", new Node("v", new ArrayList<>() {{
//add(new Pair<> ("n", 10));
//add(new Pair<> ("o", 3));
//add(new Pair<> ("s", 2));
//add(new Pair<> ("u", 11));
//add(new Pair<> ("x", 6));
//add(new Pair<> ("w", 4));
//add(new Pair<> ("y", 8));
//}}));
//graph.put("w", new Node("w", new ArrayList<>() {{
//add(new Pair<> ("v", 4));
//add(new Pair<> ("y", 9));
//}}));
//graph.put("x", new Node("x", new ArrayList<>() {{
//add(new Pair<> ("u", 5));
//add(new Pair<> ("v", 6));
//}}));
//graph.put("y", new Node("y", new ArrayList<>() {{
//add(new Pair<> ("v", 8));
//add(new Pair<> ("w", 9));
//}}));
//
//}
}
