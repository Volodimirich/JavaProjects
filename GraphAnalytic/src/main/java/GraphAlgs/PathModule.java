package GraphAlgs;

import Scanner.Structures.EdgeStruct;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public abstract class PathModule {
    HashMap<Integer, HashMap<Integer, HashSet<EdgeStruct>>> graph;
    boolean finished = false;
    HashSet <Integer> visited;
    ArrayDeque<Integer> pathEdges = new ArrayDeque<Integer>();
    Integer[] path;
    Integer start;
    Integer end;

    PathModule(HashMap<Integer, HashMap<Integer, HashSet<EdgeStruct>>> gr, Integer v1, Integer v2) {
        graph = gr;
        visited = new HashSet<>();
        path = new Integer[graph.size()];
        start = v1;
        end = v2;
    }

    public void Clear() {
        visited = new HashSet<>();
        path = new Integer[graph.size()];
        finished = false;

    }

    public Integer[] GetPath() {
        return path;
    }

    public void PrintPath() {
        System.out.println(Arrays.toString(path));
        if (finished) {
            Integer vert = end;
            System.out.printf("%d", vert);
            while (!start.equals(vert)) {
                System.out.print("  ---  ");
                vert = path[vert];
                System.out.printf("%d", vert);
            }
            System.out.println();
        } else {
            System.out.println("Where is no path!");
        }
    }

    abstract public void CalcPath();

}
