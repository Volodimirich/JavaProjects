import Scanner.GraphScanner;
import Scanner.NormalGraphScanner;
import Scanner.Structures.EdgeStruct;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Graph extends GraphBased {
        public Graph(GraphScanner graphScan) {
            this.scan = graphScan;
            this.scan.ReadIncidence();
            this.graph = this.scan.getGraphMap();
        }
        public void GetData() {
            System.out.println("Hello");
        }

    }
