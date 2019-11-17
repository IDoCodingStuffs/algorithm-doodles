package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BellmanFord {

  private DirectedGraph graph;

  public BellmanFord(DirectedGraph graph) {
    this.graph = graph;
  }

  public List<Vertex> getShortestPath(Vertex source, Vertex dest) {
    Map<Vertex, Integer> costs = getCostMap(source);

    if (costs.get(dest) == Integer.MAX_VALUE) return null;

    List<Vertex> retList = new ArrayList<>();
    retList.add(source);

    if (source == dest) return retList;

    Edge minEdge = null;
    for (Edge e : graph.adjacencyTable().get(source).get())
      if (minEdge == null || e.weight() < minEdge.weight())
        minEdge = e;

    retList.addAll(getShortestPath(minEdge.dest(),dest));
    return retList;
  }

  private Map<Vertex, Integer> getCostMap(Vertex source) {
    Map<Vertex, Integer> ret = initCostMap(source);
    for (int i = 0; i < ret.size() - 1; i++) {
      relaxEdges(ret);
    }
    return ret;
  }

  private void relaxEdges(Map<Vertex, Integer> costMap) {
    for (Edge edge : graph.getEdges()) {
      if (costMap.get(edge.source()) + edge.weight() < costMap.get(edge.dest())) {
        costMap.put(edge.dest(), costMap.get(edge.source()) + edge.weight());
      }
    }
  }

  private Map<Vertex, Integer> initCostMap(Vertex source) {
    Map<Vertex, Integer> costMap = new HashMap<>();
    graph.adjacencyTable().foreach(
        kvp -> costMap.put(kvp._1, kvp._1 == source ? 0 : Integer.MAX_VALUE)
    );
    return costMap;
  }
}
