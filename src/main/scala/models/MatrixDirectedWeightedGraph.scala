package models

import traits.TraitDirectedWeightedGraph

class MatrixDirectedWeightedGraph(_size: Int) extends TraitDirectedWeightedGraph {

  private val matrix: Array[Array[Float]] =
    Array.fill(_size, _size)(0.0f)

  override def size: Int = _size

  override def addArc(source: Int, dest: Int, weight: Float): Unit = {
    matrix(source - 1)(dest - 1) = weight
  }

  override def getSuccessors(vertex: Int): Seq[(Int, Float)] = {
    matrix(vertex - 1).zipWithIndex.collect {
      case (weight, idx) if weight != 0.0f =>
        (idx + 1, weight)
    }
  }
}