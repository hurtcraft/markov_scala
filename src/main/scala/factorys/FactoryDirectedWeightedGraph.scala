package factorys

import models.{ListDirectedWeightedGraph, MatrixDirectedWeightedGraph}
import traits.TraitDirectedWeightedGraph

import scala.io.Source

object FactoryDirectedWeightedGraph {
  def createListDirectedWeightedGraphFromFile(file:String): ListDirectedWeightedGraph = {
    createDirectedWeightedGraphFromFile(file = file, typeGraph = "listAdj").asInstanceOf[ListDirectedWeightedGraph];
  }

  def createMatrixDirectedWeightedGraphFromFile(file: String): MatrixDirectedWeightedGraph = {
    createDirectedWeightedGraphFromFile(file = file, typeGraph = "matrixAdj").asInstanceOf[MatrixDirectedWeightedGraph];

  }

  private def createDirectedWeightedGraphFromFile(file: String,typeGraph: String): TraitDirectedWeightedGraph = {

    val sourceFile = Source.fromFile(file)

    try {
      val lines = sourceFile.getLines()

      val nbSommet = lines.next().toInt

      val graph: TraitDirectedWeightedGraph = typeGraph match {
        case "listAdj"   => ListDirectedWeightedGraph(nbSommet)
        case "matrixAdj" => MatrixDirectedWeightedGraph(nbSommet)
        case _ => throw new IllegalArgumentException("Type de graphe inconnu")
      }

      for (line <- lines if line.nonEmpty) {
        if(line.nonEmpty){
          println(line)
          val splittedLine:Array[String] = line.split(" ")
          val from = splittedLine(0).toInt
          val to = splittedLine(1).toInt
          val weight = splittedLine(2).toFloat

          graph.addArc(from, to, weight)
        }

      }

      graph
    } finally {
      sourceFile.close()
    }
  }
}
