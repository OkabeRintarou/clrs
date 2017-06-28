package chapter22;

import java.util.List;

public class GraphUtil {
    public static UndirectedGraph generateUndirectedGraph(List<String> vertices,List<GenericPair<String,String>> edges){
        UndirectedGraph graph = new UndirectedGraph();
        graph.addVertices(vertices);
        graph.addEdges(edges);
        return graph;
    }
}
