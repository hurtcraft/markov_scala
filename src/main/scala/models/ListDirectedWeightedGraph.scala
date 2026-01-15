package models

import traits.TraitDirectedWeightedGraph

import scala.collection.mutable.ListBuffer
import scala.collection.mutable

class ListDirectedWeightedGraph(_size: Int) extends TraitDirectedWeightedGraph {

  private val adjacencyList: mutable.Map[Int, List[(Int, Float)]] = mutable.Map().withDefaultValue(Nil)

  override def size: Int = _size

  override def addArc(source: Int, dest: Int, weight: Float): Unit = {
    adjacencyList(source) = adjacencyList(source) :+ (dest, weight)
  }

  override def getSuccessors(vertex: Int): Seq[(Int, Float)] = {
    adjacencyList(vertex)
  }
}
