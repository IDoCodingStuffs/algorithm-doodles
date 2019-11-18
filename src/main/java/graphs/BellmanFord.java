package graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BellmanFord extends ShortestPath{

  public BellmanFord(DirectedGraph graph) {
    this.graph = graph;
  }

  public List<Vertex> getShortestPath(Vertex source, Vertex dest) {
    Map<Vertex, Integer> costs = getCostMap(source);
    List<Vertex> retList = new ArrayList<>();
    Edge minEdge = null;

    retList.add(source);

    if (source == dest) return retList;
    if (graphHasNegativeCycle(costs))
      throw new IllegalStateException("Graph cannot have negative cycles");
    if (costs.get(dest) == Integer.MAX_VALUE)
      throw new IllegalArgumentException("There are no valid paths from source to destination");

    for (Edge e : graph.adjacencyTable().get(source).get())
      if (minEdge == null || e.weight() < minEdge.weight())
        minEdge = e;

    retList.addAll(getShortestPath(minEdge.dest(),dest));
    return retList;
  }


  private boolean graphHasNegativeCycle(Map<Vertex, Integer> costMap) {
    for (Edge edge : graph.getEdges()) {
      if (costMap.get(edge.source()) + edge.weight() < costMap.get(edge.dest())) {
        return true;
      }
    }
    return false;
  }
}
