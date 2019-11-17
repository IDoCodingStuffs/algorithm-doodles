package graphs

import scala.collection.mutable;

case class Vertex(id: String)

case class Edge(source: Vertex, dest: Vertex, weight: Int)


class DirectedGraph {
  val adjacencyTable: mutable.Map[Vertex, Array[Edge]] = new mutable.HashMap[Vertex, Array[Edge]]()

  def addVertex(vertex: Vertex): Unit = adjacencyTable.put(vertex, new Array[Edge](0))

  def addEdge(source: Vertex, dest: Vertex, weight: Int): Unit =
    adjacencyTable.put(source, adjacencyTable(source) :+ Edge(source, dest, weight))

  def getEdges: Array[Edge] = adjacencyTable.keys.flatMap(i => adjacencyTable(i)).toArray
}
