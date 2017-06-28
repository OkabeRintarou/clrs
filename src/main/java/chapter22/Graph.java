package chapter22;

import java.util.Iterator;
import java.util.List;

public interface Graph {
    Node getVertex(String id);
    Iterator<String> getVertices();
    List<Node> getNeighbors(String from);
    int getWeight(String from,String to);
    boolean isConnected(String from,String to);
}
