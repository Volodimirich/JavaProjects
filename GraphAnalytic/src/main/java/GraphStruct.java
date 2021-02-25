import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class GraphStruct {
    public interface GraphBased {
        HashMap<Integer, HashMap<Integer, HashSet<EdgeStruct>>> graph = null;

        public default HashMap<Integer, HashSet<EdgeStruct>> Edges(Integer key) {
            assert (graph != null) : "Graph is empty";
            return graph.getOrDefault(key, null);
        }

        public default HashSet<EdgeStruct> Edges(Integer key1, Integer key2) {
            assert (graph != null) : "Graph is empty";
            if (graph.containsKey(key1)) {
                return graph.get(key1).getOrDefault(key2, null);
            } else {
                return null;
            }
        }

        public default Set<Integer> AdjacentVertexes(Integer key) {
            assert (graph != null) : "Graph is empty";
            if (graph.containsKey(key)) {
                return graph.get(key).keySet();
            } else {
                return null;
            }
        }

        public void GetData();
    }

    public class Graph implements GraphBased {
        public void GetData {
            System.out.println("Hello");
        }

    }
}