import GraphAlgs.BFS;
import GraphAlgs.DFS;
import GraphAlgs.PathModule;
import Scanner.GraphScanner;
import Scanner.NormalGraphScanner;
import Scanner.Structures.EdgeStruct;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

abstract public class GraphBased {
    GraphScanner scan;
    HashMap<Integer, HashMap<Integer, HashSet<EdgeStruct>>> graph = null;


    public void GraphOut() {
        System.out.println(Arrays.toString(graph.keySet().toArray()));
        for (Integer v1: graph.keySet()) {
            System.out.printf("Vertex %d connected with:", v1);
            System.out.println();
            for (Integer v2: graph.get(v1).keySet()) {
                for (int counter = 0; counter < graph.get(v1).get(v2).size(); counter++) {
                    System.out.printf("%d ", v2);
                }
            }
            System.out.println();
        }
    }

    public void FindPath(PathFind type) {
        PathModule finder = switch (type) {
            case BFS -> new BFS(graph, 0, 1);
            case DFS -> new DFS(graph, 0, 1);
        };
        finder.CalcPath();
        finder.PrintPath();
    }

    abstract public void GetData();
}
