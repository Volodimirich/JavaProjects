import Scanner.GraphScanner;
import Scanner.NormalGraphScanner;
import Scanner.Structures.EdgeStruct;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


public class Graph extends GraphBased {
        public Graph() {
            Scan.ReadIncidence();
            HashMap<Integer, HashMap<Integer, HashSet<EdgeStruct>>> gr = Scan.getGraphMap();
            System.out.println('!');
        }
        public void GetData() {
            System.out.println("Hello");
        }

    }


//public class DiGraph extends GraphBased {
//        public DiGraph() {
//
//        }
//        public void GetData() {
//            System.out.println("Hello");
//        }
//
//    }
//
//    public class MultiGraph extends GraphBased {
//        public MultiGraph() {
//
//        }
//        public void GetData() {
//            System.out.println("Hello");
//        }
//
//    }
//
//    public class DiMultiGraph extends GraphBased {
//        public DiMultiGraph() {
//
//        }
//        public void GetData() {
//            System.out.println("Hello");
//        }
//
//    }