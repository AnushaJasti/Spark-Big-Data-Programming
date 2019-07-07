import org.apache.spark.{SparkConf, SparkContext}
object BFS {
  def main(args: Array[String]) {
    System.setProperty("hadoop.home.dir", "c:\\winutils")
    val conf = new SparkConf().setAppName("Breadthfirst").setMaster("local[*]")
    val sc = new SparkContext(conf)
    type V = Int
    type Graph = Map[V, List[V]]
    val g: Graph = Map(1 -> List(2,3,5), 2 -> List(1,3,6), 3 -> List(3,4), 4 -> List(1,3),5 -> List(1,6),6 -> List(1,2))
    //I want this to return results in the different layers that it finds them (hence the list of list of vertex)
     def DFS(start: Vertex): List[Vertex] = {

        def DFS0(v: Vertex, visited: List[Vertex]): List[Vertex] = {
          if (visited.contains(v))
            visited
          else {
            val neighbours:List[Vertex] = g(v) filterNot visited.contains
            neighbours.foldLeft(v :: visited)((b,a) => DFS0(a,b))
          }
        }
        DFS0(start,List()).reverse
      }
    val bfsresult=BFS(1,g )
    println(bfsresult.mkString(","))

  }
}