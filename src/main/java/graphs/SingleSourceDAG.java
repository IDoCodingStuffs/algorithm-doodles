package graphs;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class SingleSourceDAG extends ShortestPath{

  public SingleSourceDAG(DirectedGraph graph) {
    super.graph = graph;
  }

  @Override
  void relaxEdges(Map<Vertex, Integer> costMap) {

  }

  public Vertex[] getTopologicallySortedVertices(Vertex source) {
    Stack<Vertex> ret = new Stack<>();
    Set<Vertex> visited = new HashSet<>();

    ret.push(source);
    topologicalSortHelper(source, ret, visited);

    return ret.toArray(new Vertex[0]);
  }

  private void topologicalSortHelper(Vertex source, Stack<Vertex> ret, Set<Vertex> visited) {
    for (Edge edge: graph.adjacencyTable().get(source).get()) {
      if (!visited.contains(edge.dest())) {
        ret.push(edge.dest());
        visited.add(edge.dest());
        topologicalSortHelper(edge.dest(), ret, visited);
      }
    }
  }
}
