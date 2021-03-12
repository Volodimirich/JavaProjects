package Scanner;

import Scanner.Structures.EdgeStruct;

import java.util.HashMap;
import java.util.HashSet;

public class MultiGraphScanner implements GraphScanner {
    private HashMap<Integer, HashMap<Integer, HashSet<EdgeStruct>>> graph = new  HashMap<> ();

    private void AddEdgeBetweenVertexes (Integer v1, Integer v2, EdgeStruct edgeExist, Integer weight) {
//      Проверяем, есть ли вообще в нашем графе данные вершины.
        if (graph.containsKey(v1)) {
            HashMap<Integer, HashSet<EdgeStruct>> edgeMap =  graph.get(v1);
//          Если ребро существует, игнорируем. Иначе добавляем его
            EdgeStruct edge = edgeExist == null ? new EdgeStruct(weight) : edgeExist;
            if (!edgeMap.containsKey(v2)) {
                HashSet <EdgeStruct> EdgeSet = new HashSet<>();
                EdgeSet.add(edge);
                edgeMap.put(v2, EdgeSet);
            } else {
                edgeMap.get(v2).add(edge);
            }
        } else {
            EdgeStruct edge = edgeExist == null ? new EdgeStruct(weight) : edgeExist;
            HashSet <EdgeStruct> EdgeSet = new HashSet<>();
            HashMap <Integer, HashSet<EdgeStruct>> EdgeMap = new HashMap<>();

            EdgeSet.add(edge);
            EdgeMap.put(v2, EdgeSet);
            graph.put(v1, EdgeMap);
        }
    }

    public void EdgeLogicStrategy(Integer v1, Integer v2, Integer weight) {
        AddEdgeBetweenVertexes(v1, v2, null, weight);
        AddEdgeBetweenVertexes(v2, v1, graph.get(v1).get(v2).iterator().next(), weight);
    }


    public HashMap<Integer, HashMap<Integer, HashSet<EdgeStruct>>> getGraphMap() {
        return graph;
    }


}
