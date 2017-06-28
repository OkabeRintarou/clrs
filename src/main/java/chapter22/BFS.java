package chapter22;

import java.util.*;

public class BFS {
    public static void bfs(Graph graph,String start){
        Iterator<String> iter = graph.getVertices();
        while(iter.hasNext()){
            String vertex = iter.next();
            if(!vertex.equals(start)){
                Node node = graph.getVertex(vertex);
                node.setColor(Color.WHITE);
                node.setDistance(-1);
                node.setParent(null);
            }
        }

        Node s = graph.getVertex(start);
        s.setColor(Color.GRAY);
        s.setDistance(0);
        s.setParent(null);
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(s);
        while(!queue.isEmpty()){
            Node u = queue.poll();
            List<Node> neighbors = u.getNeighbors();
            for(Node v : neighbors){
		        if(v.getColor() == Color.WHITE){
                	v.setColor(Color.GRAY);
                	v.setDistance(u.getDistance() + 1);
                	v.setParent(u);
                	queue.offer(v);
		        }
            }
            u.setColor(Color.BLACK);
        }
    }

    public static String path(Graph graph,String from,String to){
        List<Node> paths = new ArrayList<Node>();
        Node nodeFrom = graph.getVertex(from);
        Node nodeTo = graph.getVertex(to);

        if(!path(graph,nodeFrom,nodeTo,paths)){
            return null;
        }

        StringBuilder builder = new StringBuilder();
        for(int i = paths.size() - 1;i > 0;i--){
            builder.append(paths.get(i).getId() + "->");
        }
        builder.append(paths.get(0).getId());
        return builder.toString();
    }

    public static boolean path(Graph graph,Node from,Node to,List<Node> paths){
        if(from.getId().equals(to.getId())){
            paths.add(from);
            return true;
        }

        if(to.getParent() == null){
            return false;
        }

        paths.add(to);
        return path(graph,from,to.getParent(),paths);
    }
}
