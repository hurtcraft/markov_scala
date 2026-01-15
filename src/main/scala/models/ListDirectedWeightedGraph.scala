package models

import traits.TraitDirectedWeightedGraph

import scala.collection.mutable.ListBuffer
import scala.collection.mutable

class ListDirectedWeightedGraph(_size: Int) extends TraitDirectedWeightedGraph {

  // On utilise mutable.Map pour pouvoir ajouter des arcs facilement
  private val adjacencyList: mutable.Map[Int, List[(Int, Float)]] = mutable.Map().withDefaultValue(Nil)

  override def size: Int = _size

  // Ajoute un arc (source -> dest) avec un poids weight
  override def addArc(source: Int, dest: Int, weight: Float): Unit = {
    // On ajoute le tuple (dest, weight) à la liste existante du sommet source
    adjacencyList(source) = adjacencyList(source) :+ (dest, weight)
  }

  // Retourne la liste des successeurs du sommet vertex
  override def getSuccessors(vertex: Int): Seq[(Int, Float)] = {
    adjacencyList(vertex)
  }
}
