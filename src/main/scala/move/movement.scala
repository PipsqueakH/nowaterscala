package move

/**
 * Created by hp on 2016/2/25.
 */
object movement {
  def transform(n: Int, grid: Seq[Seq[Int]], direction: String): Seq[Seq[Int]] = {

    def gridReverse(grid: Seq[Seq[Int]]) = grid.foldRight(List(List[Int]())){(line, matrix) =>
      matrix.zipAll(line, Nil, Nil).map{case(body: List[Int], elem: Int ) => elem :: body} }

    val transGrid = direction match {
      case "LEFT" => grid.foldRight(Seq[Seq[Int]]()){(line, matrix) => line.reverse +: matrix}
      case "UP" => gridReverse(grid).foldRight(Seq[Seq[Int]]()){(line, matrix) => line.reverse +: matrix}
      case "DOWN" => gridReverse(for(line <- grid) yield line)
      case _ => grid
    }

    def combine(n: Int, line: Seq[Int]) = {
      val z = line.foldRight(List[Int]()){(x, part) =>
        (x, part) match {
          case (0, part) => part
          case (x, Nil) => x :: Nil
          case (x, y :: tail) if x == y => 1 :: 2*y :: tail
          case (x, 1 :: tail) => x :: tail
          case _ => x :: part
        }
      }.filter(_ > 1)

      (1 to n - z.length).foldRight(z)((_ , z) => 0 :: z)

    }

    val combinedGrid = transGrid.foldRight(Seq[Seq[Int]]()){(line, matrix) => combine(n, line) +: matrix}

    direction match {
      case "LEFT" => combinedGrid.foldRight(Seq[Seq[Int]]()){(line, matrix) => line.reverse +: matrix}
      case "UP" => gridReverse(combinedGrid.foldRight(Seq[Seq[Int]]()){(line, matrix) => line.reverse +: matrix})
      case "DOWN" => gridReverse(for(line <- combinedGrid) yield line)
      case _ => combinedGrid
    }


  }

  def main (args: Array[String]) {
    println("hello world")
  }


}
