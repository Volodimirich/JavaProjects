package GraphAlgs;

import Scanner.Structures.EdgeStruct;

import java.util.*;

public class DFS extends PathModule {
    public DFS(HashMap<Integer, HashMap<Integer, HashSet<EdgeStruct>>> graph, Integer v1, Integer v2) {
        super(graph, v1, v2);
    }


    public void CalcPath() {
        AlgDFS(start, end);
    }

    public void AlgDFS(Integer v1, Integer v2) {

        for (Integer el : graph.get(v1).keySet()) {
            if (v1.equals(v2)) {
                finished = true;
                break;
            }
            if (!finished && !visited.contains(el)) {
                visited.add(el);
                path[el] = v1;
                AlgDFS(el, v2);
            }
        }
    }



}
