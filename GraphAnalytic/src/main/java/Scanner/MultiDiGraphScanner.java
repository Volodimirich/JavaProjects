package Scanner;

import Scanner.Structures.EdgeStruct;

import java.util.HashMap;
import java.util.HashSet;

public class MultiDiGraphScanner implements GraphScanner {
    private HashMap<Integer, HashMap<Integer, HashSet<EdgeStruct>>> graph = new  HashMap<> ();

    private void AddEdgeBetweenVertexes (Integer v1, Integer v2, EdgeStruct edgeExist) {
        if (graph.containsKey(v1)) {
            HashMap<Integer, HashSet<EdgeStruct>> edgeMap =  graph.get(v1);
            EdgeStruct edge = edgeExist == null ? new EdgeStruct() : edgeExist;
            if (!edgeMap.containsKey(v2)) {
                HashSet <EdgeStruct> EdgeSet = new HashSet<>();
                EdgeSet.add(edge);
                edgeMap.put(v2, EdgeSet);
            } else {
                edgeMap.get(v2).add(edge);
            }
        } else {
            EdgeStruct edge = edgeExist == null ? new EdgeStruct() : edgeExist;
            HashSet <EdgeStruct> EdgeSet = new HashSet<>();
            HashMap <Integer, HashSet<EdgeStruct>> EdgeMap = new HashMap<>();

            EdgeSet.add(edge);
            EdgeMap.put(v2, EdgeSet);
            graph.put(v1, EdgeMap);
        }
    }

    public void EdgeLogicStrategy(Integer v1, Integer v2) {
        AddEdgeBetweenVertexes(v1, v2, null);
    }


    public HashMap<Integer, HashMap<Integer, HashSet<EdgeStruct>>> getGraphMap() {
        return graph;
    }

    @Override
    public void ReadAdjancy() {
        int vertexAmount = GetVertexAmount();

    }

}
