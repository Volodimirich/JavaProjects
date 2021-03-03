package Scanner;

import Scanner.Structures.EdgeStruct;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

enum ReadModule{Incidence, Adjacency}


public interface GraphScanner {
    Scanner graphConsoleRead = new Scanner(System.in);
    private Integer[] StrConverter(String[] splitedStr) {
        Integer[] result = new Integer[splitedStr.length];
        try {
            for (int i = 0; i < splitedStr.length; i++) {
                result[i] = Integer.parseInt(splitedStr[i]);
            }
            return result;
        } catch (NumberFormatException e) {
            return new Integer[0];
        }
    }

    public default int GetVertexAmount() {
        System.out.println("Please, insert amount of vertexes");
        int vertexAmount = graphConsoleRead.nextInt();
        graphConsoleRead.nextLine();
        return vertexAmount;
    }

    public default Integer[] LineScan(int vertexNum) {
        System.out.printf("Neighbors for %d vertex:", vertexNum);
        System.out.println();
        return StrConverter(graphConsoleRead.nextLine().split(" "));
    }

    public default void ReadIncidence() {
        int vertexAmount = GetVertexAmount();
        Integer[] vertexes;
        System.out.println("Был выбран обычный граф. Дубли в номерах вершин и их ориентация будут проигнорированы");
        System.out.println("Введите после номера вершины, вершины инцидентные данной через запятую: ");
        for (int v1=0; v1<vertexAmount; v1++) {
            vertexes = LineScan(v1);
            for (Integer vertex : vertexes)
                EdgeLogicStrategy(v1, vertex);
        }
    }


    public void EdgeLogicStrategy(Integer v1, Integer v2);
    public HashMap<Integer, HashMap<Integer, HashSet<EdgeStruct>>> getGraphMap();
    public void ReadAdjancy();
}

