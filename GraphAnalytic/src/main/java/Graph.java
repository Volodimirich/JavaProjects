import Scanner.GraphScanner;
import Scanner.NormalGraphScanner;
import Scanner.Structures.EdgeStruct;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Graph extends GraphBased {
        public Graph(GraphScanner graphScan) {
            scan = graphScan;
            scan.ReadAdjancy();
            graph = scan.getGraphMap();
        }
        public void GetData() {
            System.out.println("Hello");
        }

    }
