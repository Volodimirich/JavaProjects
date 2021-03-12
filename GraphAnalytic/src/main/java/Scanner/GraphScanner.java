package Scanner;

import Scanner.Structures.EdgeStruct;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;



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

    private boolean InputIncidenceValidation(Integer vertex, Integer vertexAmount) {
        if (vertex >= 0 && vertex < vertexAmount) {
            return true;
        } else {
            System.out.printf("Error in data input. Trouble in vertex - %d. Ignoring this vertex\n", vertex);
            System.out.printf("Your vertex number must be in the next interval - 0 to %d\n", vertexAmount - 1);
            return false;
        }
    }

    private boolean InputAdjacencyValidation(Integer[] data, Integer vertexAmount) {
        if (data.length >= 2 && data[0] < vertexAmount && data[0] >= -1 && data[1] < vertexAmount && data[1] >= -1
                && data.length <= 3 || data[0] == -1) {
            return true;
        } else {
            if (data.length >= 2 && data.length <=3) {
                System.out.print("Error in data input. Ignoring this data  - " + Arrays.toString(data) + "\n");
            } else {
                System.out.println("Error in amount of arguments. 2 or 3 expected");
            }
            System.out.printf("Your vertex number must be in the next interval - 0 to %d.\n-1 to stop input\n",
                    vertexAmount - 1);
            return false;
        }

    }

    private int GetVertexAmount() {
        System.out.println("Please, insert amount of vertexes");
        int vertexAmount = graphConsoleRead.nextInt();
        graphConsoleRead.nextLine();
        return vertexAmount;
    }

    private Integer[] LineScan() {
        return StrConverter(graphConsoleRead.nextLine().split(" "));
    }

    public default void ReadIncidence() {
        int vertexAmount = GetVertexAmount();
        Integer[] vertexes;
        System.out.println("Был выбран обычный граф. Дубли в номерах вершин и их ориентация будут проигнорированы");
        System.out.println("Введите после номера вершины, вершины инцидентные данной через запятую: ");
        for (int v1=0; v1<vertexAmount; v1++) {
            System.out.printf("Neighbors for %d vertex:", v1);
            vertexes = LineScan();
            for (Integer vertex : vertexes)
                if (InputIncidenceValidation(v1, vertexAmount)) {
                    EdgeLogicStrategy(v1, vertex, 1);
                }
        }
    }



    public default void ReadAdjancy() {
        int vertexAmount = GetVertexAmount();
        Integer[] data;
        int weight;
        System.out.println("Input data in format: vertex vertex edge_weight(optional, default value - 1). Input -1 to stop");
        do {
            data = LineScan();
            if (InputAdjacencyValidation(data, vertexAmount)) {
                weight = data.length == 3? data[2] : 1;
                EdgeLogicStrategy(data[0], data[1], weight);
            }
        } while (!data[0].equals(-1));

    }

    public void EdgeLogicStrategy(Integer v1, Integer v2, Integer weight);
    public HashMap<Integer, HashMap<Integer, HashSet<EdgeStruct>>> getGraphMap();
}

