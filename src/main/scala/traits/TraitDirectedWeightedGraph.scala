package traits

trait TraitDirectedWeightedGraph {
  def size : Int;
  def addArc(source:Int, dest:Int,weight:Float):Unit;
  def getSuccessors(vertex:Int):Seq[(Int,Float)];

  override def toString: String = {
    val builder = new StringBuilder
    builder.append(s"Graphe dirigé pondéré (_size = $size):\n")
    for (vertex <- 0 until size) {
      val edges = getSuccessors(vertex).map { case (dest, w) => s"$dest($w)" }.mkString(", ")
      builder.append(s"$vertex -> [$edges]\n")
    }
    builder.toString()
  }
}
