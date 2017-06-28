package chapter22;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DFS {
    private static int time = 0;

    public static void dfs(Graph graph){
        List<Node> nodes = new ArrayList<Node>();
        Iterator<String> iter = graph.getVertices();
        while(iter.hasNext()){
            Node n = graph.getVertex(iter.next());
            n.setColor(Color.WHITE);
            n.setParent(null);
            nodes.add(n);
        }

        time = 0;
        for(Node n : nodes){
            if(n.getColor() == Color.WHITE){
                dfsVisit(graph,n);
            }
        }

    }

    private static void dfsVisit(Graph graph,Node n){
        time++;
        n.setStartTime(time);
        n.setColor(Color.GRAY);
        List<Node> neighbors = n.getNeighbors();
        for(Node v : neighbors){
            if(v.getColor() == Color.WHITE){
                v.setParent(n);
                dfsVisit(graph,v);
            }
        }
        n.setColor(Color.BLACK);
        time++;
        n.setEndTime(time);
    }
}
