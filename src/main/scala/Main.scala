import factorys.FactoryDirectedWeightedGraph
import models.ListDirectedWeightedGraph
import traits.TraitDirectedWeightedGraph

object Main {

  def main(args: Array[String]): Unit = {
    val file=args(0);
    println("tata");
    val listG:ListDirectedWeightedGraph=FactoryDirectedWeightedGraph.createListDirectedWeightedGraphFromFile(file);
    println(listG);
  }


}