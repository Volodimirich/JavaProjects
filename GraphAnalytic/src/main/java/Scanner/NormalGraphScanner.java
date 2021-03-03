package Scanner;

import Scanner.Structures.EdgeStruct;

import java.util.HashMap;
import java.util.HashSet;

public class NormalGraphScanner implements GraphScanner {
    private HashMap<Integer, HashMap<Integer, HashSet<EdgeStruct>>> graph = new  HashMap<> ();

    private void AddEdgeBetweenVertexes (Integer v1, Integer v2, EdgeStruct edgeExist) {
//      Проверяем, есть ли вообще в нашем графе данные вершины.
        if (graph.containsKey(v1)) {
            HashMap<Integer, HashSet<EdgeStruct>> edgeMap =  graph.get(v1);
//          Если ребро существует, игнорируем. Иначе добавляем его
            if (!edgeMap.containsKey(v2)) {
                EdgeStruct edge = edgeExist == null ? new EdgeStruct() : edgeExist;
                HashSet <EdgeStruct> EdgeSet = new HashSet<>();
                EdgeSet.add(edge);
                edgeMap.put(v2, EdgeSet);
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

    public HashMap<Integer, HashMap<Integer, HashSet<EdgeStruct>>> getGraphMap() {
        return graph;
    }

    @Override
    public void ReadIncidence() {
        int vertexAmount = GetVertexAmount();
        Integer[] vertexes;
        System.out.println("Был выбран обычный граф. Дубли в номерах вершин и их ориентация будут проигнорированы");
        System.out.println("Введите после номера вершины, вершины инцидентные данной через запятую: ");
        for (int v1=0; v1<vertexAmount; v1++) {
            vertexes = LineScan(v1);
            for (Integer v2: vertexes) {
                AddEdgeBetweenVertexes(v1, v2, null);
//              Добавим копию данного ребра, сделав его обратным
                AddEdgeBetweenVertexes(v2, v1, graph.get(v1).get(v2).iterator().next());
            }
        }

    }

    @Override
    public void ReadAdjancy() {
        int vertexAmount = GetVertexAmount();

    }
}


