import Scanner.GraphScanner;
import Scanner.NormalGraphScanner;
import Scanner.Structures.EdgeStruct;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

abstract public class GraphBased {
    GraphScanner Scan = new NormalGraphScanner();

    HashMap<Integer, HashMap<Integer, HashSet<EdgeStruct>>> graph = null;

    public HashMap<Integer, HashSet<EdgeStruct>> Edges(Integer key) {
        assert (graph != null) : "Graph is empty";
        return graph.getOrDefault(key, null);
    }

    public HashSet<EdgeStruct> Edges(Integer key1, Integer key2) {
        assert (graph != null) : "Graph is empty";
        if (graph.containsKey(key1)) {
            return graph.get(key1).getOrDefault(key2, null);
        } else {
            return null;
        }
    }

    public Set<Integer> AdjacentVertexes(Integer key) {
        assert (graph != null) : "Graph is empty";
        if (graph.containsKey(key)) {
            return graph.get(key).keySet();
        } else {
            return null;
        }
    }

    abstract public void GetData();
}
