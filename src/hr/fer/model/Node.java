package hr.fer.model;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public final String name;
    private List<Pair<String, Integer>> neighbours;

    public Node(String name) {
        this.name = name;
        this.neighbours = new ArrayList<>();
    }

    public Node(String name, List<Pair<String, Integer>> neighbours) {
        this.name = name;
        this.neighbours = neighbours;
    }

    public void addNeighbour(Pair<String, Integer> neighbour) {
        this.neighbours.add(neighbour);
    }

    public List<Pair<String, Integer>> getNeighbours() {
        return this.neighbours;
    }
}
