package chapter22;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class GraphTest extends TestCase {
    private Graph graph;

    @Before
    public void setUp(){
        List<String> vertices = new ArrayList<String>(
                Arrays.asList("r","s","t","u","v","w","x","y")
        );
        List<GenericPair<String,String>> edges = new ArrayList<GenericPair<String, String>>(
                Arrays.asList(
                        new GenericPair<String, String>("r","s"),
                        new GenericPair<String, String>("r","v"),
                        new GenericPair<String, String>("s","w"),
                        new GenericPair<String, String>("w","t"),
                        new GenericPair<String, String>("w","x"),
                        new GenericPair<String, String>("t","u"),
                        new GenericPair<String, String>("t","x"),
                        new GenericPair<String, String>("x","u"),
                        new GenericPair<String, String>("x","y"),
                        new GenericPair<String, String>("u","y")
                )
        );
        graph = new UndirectedGraph(vertices,edges);
    }

    @Test
    public void testBFS(){
        BFS.bfs(graph,"s");
        assertEquals("s",BFS.path(graph,"s","s"));
        assertEquals("s->r",BFS.path(graph,"s","r"));
        assertEquals("s->r->v",BFS.path(graph,"s","v"));
        assertEquals("s->w",BFS.path(graph,"s","w"));
        assertEquals("s->w->t",BFS.path(graph,"s","t"));
        assertEquals("s->w->x",BFS.path(graph,"s","x"));
        assertEquals("s->w->x->y",BFS.path(graph,"s","y"));
    }

    @Test
    public void testDFS(){
        DFS.dfs(graph);
        Iterator<String> nodesName = graph.getVertices();
        List<Node> nodes = new ArrayList<Node>();
        while(nodesName.hasNext()){
            nodes.add(graph.getVertex(nodesName.next()));
        }

        for(int i = 0;i < nodes.size();i++){
            for(int j = 0;j != i && j < nodes.size();j++){
                if(nodes.get(j).getStartTime() > nodes.get(i).getStartTime() &&
                        nodes.get(j).getStartTime() < nodes.get(i).getEndTime()){
                    assertTrue(nodes.get(j).getEndTime() < nodes.get(i).getEndTime());
                }
            }
        }
    }
}
