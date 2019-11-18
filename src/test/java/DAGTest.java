import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import graphs.DirectedGraph;
import graphs.SingleSourceDAG;
import graphs.Vertex;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class DAGTest {
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

    graph.addEdge(vertices[1], vertices[2], 1);
    graph.addEdge(vertices[2], vertices[3], 1);
    graph.addEdge(vertices[2], vertices[5], -4);
    graph.addEdge(vertices[3], vertices[4], -1);
    graph.addEdge(vertices[4], vertices[5], 2);
    graph.addEdge(vertices[0], vertices[1], 8);
    graph.addEdge(vertices[0], vertices[2], 10);
  }

  @Test
  public void testTopologicalSort() {
    SingleSourceDAG singleSourceDAG = new SingleSourceDAG(graph);
    assertArrayEquals(vertices,
        singleSourceDAG.getTopologicallySortedVertices(vertices[0]));
  }
}
