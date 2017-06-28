package chapter22;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class UndirectedGraph implements Graph {
    private Map<String,Node> matrix;

    public UndirectedGraph(){
        matrix = new HashMap<String,Node>();
    }

    public UndirectedGraph(List<String> vertices,List<GenericPair<String,String>> edges){
        matrix = new HashMap<String, Node>();
        addVertices(vertices);
        addEdges(edges);
    }

    public UndirectedGraph(Map<String,Node> matrix){
        this.matrix = matrix;
    }

    public List<Node> getNeighbors(String from){
        if(!matrix.containsKey(from)){
            return null;
        }
        return matrix.get(from).getNeighbors();
    }

    public int getWeight(String from,String to){
        if(isConnected(from,to)){
            return 1;
        }
        return 0;
    }

    public boolean isConnected(String from,String to){
        List<Node> neighbors = getNeighbors(from);
        if(neighbors == null){
            return false;
        }
        for(Node node : neighbors){
            if(node.getId().equals(to)){
                return true;
            }
        }
        return false;
    }

    public Iterator<String> getVertices(){
        return matrix.keySet().iterator();
    }

    public Node getVertex(String id){
        return matrix.get(id);
    }

    public void addVertex(String vertex){
        if(!matrix.containsKey(vertex)){
            matrix.put(vertex,new Node(vertex));
        }
    }

    public void addVertices(List<String> vertices){
        for(String vertex : vertices){
            addVertex(vertex);
        }
    }

    public void addEdge(String from,String to){
        if(!matrix.containsKey(from)){
            matrix.put(from,new Node(from));
        }
        if(!matrix.containsKey(to)){
            matrix.put(to,new Node(to));
        }
        Node n1 = matrix.get(from);
        Node n2 = matrix.get(to);
        n2.addNeighbor(n1);
        n1.addNeighbor(n2);
    }

    public void addEdge(GenericPair<String,String> pair){
        addEdge(pair.getFirst(),pair.getSecond());
    }

    public void addEdges(List<GenericPair<String,String>> pairs){
        for(GenericPair<String,String> pair : pairs){
            addEdge(pair.getFirst(),pair.getSecond());
        }
    }
}
