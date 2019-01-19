package hr.fer.algorithm;

import hr.fer.model.Edge;

import java.util.*;

public class KruskalAlgorithm {

    public static List<Edge> findMST(List<Edge> edges, int numberOfNodes) {
        List<Set<String>> net = new ArrayList<>();
        var result = new ArrayList<Edge>();
        edges.sort(Comparator.comparingInt(Edge::getWeight));
        for (var e : edges) {
            if (!formsCircle(result, e, net)) {
                result.add(e);
                if (result.size() == numberOfNodes - 1) {
                    return result;
                }
            }
        }
        return result;
    }

    private static boolean formsCircle(List<Edge> edges, Edge e, List<Set<String>> net) {
        int index1 = -1;
        int index2 = -1;
        for (int i = 0; i < net.size(); ++i) {
            if (net.get(i).contains(e.getNode1())) {
                index1 = i;
            }
            if (net.get(i).contains(e.getNode2())) {
                index2 = i;
            }
            if (index1 != -1 && index2 != -1) {
                break;
            }
        }

        if (index1 == -1 && index2 == -1) {
            net.add(new HashSet<>() {{
                add(e.getNode1());
                add(e.getNode2());
            }});
        } else if (index1 == index2) {
            return true;
        } else if (index1 != -1 && index2 != -1) {
            var s1 = net.get(index1);
            var s2 = net.get(index2);
            net.set(index1, new HashSet<>() {{
                addAll(s1);
                addAll(s2);
            }});
            net.remove(index2);
        } else if (index1 != -1 && index2 == -1) {
            net.get(index1).add(e.getNode2());
        } else if (index1 == -1 && index2 != -1) {
            net.get(index2).add(e.getNode1());
        }
        return false;
    }
}
