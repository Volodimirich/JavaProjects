package Scanner;

import Scanner.Structures.EdgeStruct;

import java.util.HashMap;
import java.util.HashSet;

public class MultiDiGraphScanner implements GraphScanner {
    private HashMap<Integer, HashMap<Integer, HashSet<EdgeStruct>>> graph = new  HashMap<> ();

    private void AddEdgeBetweenVertexes(Integer v1, Integer v2, Integer weight) {
        if (graph.containsKey(v1)) {
            HashMap<Integer, HashSet<EdgeStruct>> edgeMap =  graph.get(v1);
            EdgeStruct edge = new EdgeStruct(weight);
            if (!edgeMap.containsKey(v2)) {
                HashSet <EdgeStruct> EdgeSet = new HashSet<>();
                EdgeSet.add(edge);
                edgeMap.put(v2, EdgeSet);
            } else {
                edgeMap.get(v2).add(edge);
            }
        } else {
            EdgeStruct edge = new EdgeStruct(weight);
            HashSet <EdgeStruct> EdgeSet = new HashSet<>();
            HashMap <Integer, HashSet<EdgeStruct>> EdgeMap = new HashMap<>();

            EdgeSet.add(edge);
            EdgeMap.put(v2, EdgeSet);
            graph.put(v1, EdgeMap);
        }
    }

    public void EdgeLogicStrategy(Integer v1, Integer v2, Integer weight)
    {
        AddEdgeBetweenVertexes(v1, v2, weight);
    }


    public HashMap<Integer, HashMap<Integer, HashSet<EdgeStruct>>> getGraphMap() {
        return graph;
    }



}
