package hr.fer.model;

public class Edge {
    private String node1;
    private String node2;
    private int weight;

    public Edge(String node1, String node2, int weight) {
        if (node1.compareTo(node2) >= 0) {
            this.node1 = node2;
            this.node2 = node1;
        } else {
            this.node1 = node1;
            this.node2 = node2;
        }
        this.weight = weight;
    }

    public String getNode1() {
        return node1;
    }

    public String getNode2() {
        return node2;
    }

    public int getWeight() {
        return weight;
    }
}
