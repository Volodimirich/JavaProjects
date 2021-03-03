import Scanner.Structures.EdgeStruct;

import java.io.IOError;
import java.io.IOException;
import java.util.*;

import Scanner.*;


public class GraphAnalytic {



    public static void main(String[] args) {
        ProgramState state = ProgramState.GraphReading;
        Scanner consoleRead = new Scanner(System.in);
        GraphScanner chosenOne;
        HashMap<Integer, GraphScanner> optionDict = new HashMap<>() {{
            put(-1, null);
            put(0, new NormalGraphScanner());
            put(1, new DiGraphScanner());
            put(2, new MultiGraphScanner());
            put(3, new MultiDiGraphScanner());
        }};

        System.out.println("Choose graph type:");
        System.out.println("Graph - 0, DiGraph - 1, MultiGraph - 2, MultiDiGraph - 3");
        System.out.println("Write -1 to exit");
        try {
            chosenOne = optionDict.get(consoleRead.nextInt());
            if (chosenOne != null) {
                GraphBased graph = new Graph(chosenOne);
                graph.GraphOut();
            }
        } catch (NoSuchElementException e) {
            System.out.println("Your choose was incorrect!");
        }
    }
}
