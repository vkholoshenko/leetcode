package lc133_CloneGraph;

import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    private HashMap<Node, Node> relations;

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        if (relations == null) {
            relations = new HashMap<>();
        }
        if (!relations.containsKey(node)) {
            Node cloned = new Node(node.val);
            relations.put(node, cloned);
            if (node.neighbors != null) {
                cloned.neighbors = new ArrayList<Node>();
                for (Node neighbor : node.neighbors) {
                    cloned.neighbors.add(cloneGraph(neighbor));
                }
            }
        }

        return relations.get(node);
    }
}