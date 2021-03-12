package GraphAlgs;

import Scanner.Structures.EdgeStruct;

import java.util.*;

public class BFS extends PathModule {
    ArrayDeque<Integer> pathEdges;
    public BFS(HashMap<Integer, HashMap<Integer, HashSet<EdgeStruct>>> graph, Integer v1, Integer v2) {
        super(graph, v1, v2);
        pathEdges = new ArrayDeque<Integer>();

    }

    @Override
    public void CalcPath() {

        Integer vertex;
        pathEdges.push(start);

        while (!pathEdges.isEmpty() && !finished) {
            vertex = pathEdges.pop();
                for (Integer el : graph.get(vertex).keySet()) {
                    if (!visited.contains(el)) {
                        path[el] = vertex;
                        pathEdges.push(el);

                        if (el.equals(end)) {
                            finished = true;
                            break;
                        }
                    }
                }
                visited.add(vertex);
        }
    }



}