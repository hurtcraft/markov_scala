package models

import traits.TraitDirectedWeightedGraph

class MatrixDirectedWeightedGraph(_size:Int) extends TraitDirectedWeightedGraph{

  override def size: Int = _size

  override def addArc(source: Int, dest: Int, weight: Float): Unit = ???

  override def getSuccessors(vertex: Int): Seq[(Int, Float)] = ???
}
