package Scanner;

import Scanner.Structures.EdgeStruct;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

enum ReadModule{Incidence, Adjacency}


public interface GraphScanner {
    Scanner graphConsoleRead = new Scanner(System.in);
    private Integer[] StrConverter(String[] splitedStr) {
        Integer[] result = new Integer[splitedStr.length];
        try {
            for (int i = 0; i <= splitedStr.length; i++) {
                result[i] = Integer.parseInt(splitedStr[i]);
            }
            return result;
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public default int GetVertexAmount() {
        System.out.println("Please, insert amount of vertexes");
        return graphConsoleRead.nextInt();
    }

    public default Integer[] LineScan(int vertexNum) {
        System.out.printf("%d - ", vertexNum);
        return StrConverter(graphConsoleRead.nextLine().replace(" ","").split(","));
    }

    public HashMap<Integer, HashMap<Integer, HashSet<EdgeStruct>>> getGraphMap();
    public void ReadIncidence();
    public void ReadAdjancy();
}

