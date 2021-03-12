package GraphAlgs;

import Scanner.Structures.EdgeStruct;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class DijkstraShortestPath extends PathModule{
    public DijkstraShortestPath(HashMap<Integer, HashMap<Integer, HashSet<EdgeStruct>>> graph, Integer v1, Integer v2) {
        super(graph, v1, v2);
    }
    public void CalcPath() {
        AlgPath(start, end);
    }

    public void AlgPath(Integer v1, Integer v2) {
        Integer[] weightMap = new Integer[graph.size()];
        ArrayDeque<Integer> pathEdges = new ArrayDeque<Integer>();
        Integer currentVert;
        Integer wt;

        pathEdges.push(v1);
        for (int i=0; i<graph.size(); i++)
            weightMap[i] = -1;
        weightMap[0] = 0;

        while (!pathEdges.isEmpty() && !finished) {
            currentVert = pathEdges.pop();
            visited.add(currentVert);
            for (Integer el : graph.get(currentVert).keySet()) {
                if (el.equals(v2)) {
                    finished = true;
                }

                if (!visited.contains(el)) {
                    pathEdges.push(el);
                }

                for (EdgeStruct edgeStruct : graph.get(currentVert).get(el)) {
                    wt = weightMap[currentVert] + edgeStruct.getWeight();
                    weightMap[el] = weightMap[el] > wt && weightMap[el] == -1 ? wt : weightMap[el];
                }

            }
        }

        currentVert = v2;
        boolean vertexMoved = false;
        while (!currentVert.equals(v1)) {
            for (Integer el : graph.get(currentVert).keySet()) {

                for (EdgeStruct edgeStruct : graph.get(currentVert).get(el)) {
                    if (weightMap[currentVert] - weightMap[el] == edgeStruct.getWeight()) {
                        currentVert = el;
                        vertexMoved = true;
                        path[currentVert] = el;
                        break;
                    }
                }

                if (vertexMoved) {
                    break;
                }
            }
            vertexMoved = false;
        }

    }

}
