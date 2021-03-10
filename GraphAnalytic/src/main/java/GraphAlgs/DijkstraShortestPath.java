package GraphAlgs;

import Scanner.Structures.EdgeStruct;

import java.util.HashMap;
import java.util.HashSet;

public class DijkstraShortestPath extends PathModule{
    public DijkstraShortestPath(HashMap<Integer, HashMap<Integer, HashSet<EdgeStruct>>> graph, Integer v1, Integer v2) {
        super(graph, v1, v2);
    }
    public void CalcPath() {
        System.out.println("Something");
    }
}
