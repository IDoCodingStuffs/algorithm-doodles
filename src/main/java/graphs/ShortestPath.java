package graphs;

import java.util.HashMap;
import java.util.Map;

public class ShortestPath {

  DirectedGraph graph;

  Map<Vertex, Integer> initCostMap(Vertex source) {
    Map<Vertex, Integer> costMap = new HashMap<>();
    graph.adjacencyTable().foreach(
        kvp -> costMap.put(kvp._1, kvp._1 == source ? 0 : Integer.MAX_VALUE)
    );
    return costMap;
  }

  void relaxEdges(Map<Vertex, Integer> costMap) {
    for (Edge edge : graph.getEdges()) {
      if (costMap.get(edge.source()) + edge.weight() < costMap.get(edge.dest())) {
        costMap.put(edge.dest(), costMap.get(edge.source()) + edge.weight());
      }
    }
  }

  Map<Vertex, Integer> getCostMap(Vertex source) {
    Map<Vertex, Integer> ret = initCostMap(source);
    for (int i = 0; i < ret.size() - 1; i++) {
      relaxEdges(ret);
    }
    return ret;
  }

}
