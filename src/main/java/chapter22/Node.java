package chapter22;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private String id;
    private Color color;
    private Node parent;
    private int d;
    private List<Node> neighbors;
    private int startTime,endTime;

    public Node(String id){
        this.id = id;
        color = Color.WHITE;
        parent = null;
        d = -1;
        neighbors = new ArrayList<Node>();
        startTime = endTime = 0;
    }

    public String getId(){
        return id;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color c){
        color = c;
    }

    public Node getParent(){
        return parent;
    }

    public void setParent(Node p){
        parent = p;
    }

    public int getDistance(){
        return d;
    }

    public void setDistance(int d){
        this.d = d;
    }

    public List<Node> getNeighbors(){
        return neighbors;
    }

    public void addNeighbor(Node n){
        neighbors.add(n);
    }

    public void addNeighbors(List<Node> neighbors){
        for(Node n : neighbors){
            neighbors.add(n);
        }
    }

    public int getStartTime(){
        return startTime;
    }

    public void setStartTime(int time){
        startTime = time;
    }

    public int getEndTime(){
        return endTime;
    }

    public void setEndTime(int time){
        endTime = time;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append(id + " : ");
        List<Node> neighbors = getNeighbors();
        int sz = neighbors.size();
        for(int i = 0;i < sz;i++){
            if(i != sz - 1){
                builder.append(neighbors.get(i).id + " -> ");
            }else{
                builder.append(neighbors.get(i).id);
            }
        }
        return builder.toString();
    }
}
