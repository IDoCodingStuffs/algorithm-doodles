import static org.junit.jupiter.api.Assertions.assertEquals;

import graphs.BellmanFord;
import graphs.DirectedGraph;
import graphs.Vertex;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class BellmanFordTest {

  static DirectedGraph graph;
  static Vertex[] vertices;

  @BeforeAll
  public static void init() {
    graph = new DirectedGraph();
    vertices = new Vertex[]{
        new Vertex("S"),
        new Vertex("A"),
        new Vertex("B"),
        new Vertex("C"),
        new Vertex("D"),
        new Vertex("E")
    };

    for(Vertex v:vertices) graph.addVertex(v);

    graph.addEdge(vertices[0], vertices[5], 8);
    graph.addEdge(vertices[0], vertices[1], 10);
    graph.addEdge(vertices[2], vertices[1], 1);
    graph.addEdge(vertices[5], vertices[4], 1);
    graph.addEdge(vertices[4], vertices[1], -4);
    graph.addEdge(vertices[4], vertices[3], -1);
    graph.addEdge(vertices[1], vertices[3], 2);
    graph.addEdge(vertices[3], vertices[2], -2);
  }

  @Test
  public void testMinPathsReturned() {
    BellmanFord bellmanFord = new BellmanFord(graph);
    assertEquals(Arrays.asList(vertices[0], vertices[5], vertices[4]),
        bellmanFord.getShortestPath(vertices[0], vertices[4]));
  }
}
