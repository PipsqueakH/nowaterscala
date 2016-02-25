package move

/**
 * Created by hp on 2016/2/25.
 */

import org.scalatest._
import move.movement.transform

class TestMove extends FlatSpec {
  "A transform" should "move the grid correctly" in {
    assert(transform(4, Seq(Seq(4, 0, 2, 0), Seq(0, 0, 0, 8), Seq(4, 0, 2, 4), Seq(2, 4, 2, 2)), "RIGHT") == Seq(Seq(0, 0, 4, 2), Seq(0, 0, 0, 8), Seq(0, 4, 2, 4), Seq(0, 2, 4, 4)))
    assert(transform(4, Seq(Seq(2, 0, 2, 0), Seq(0, 2, 0, 4), Seq(2, 8, 0, 8), Seq(0, 8, 0, 16)), "UP") == Seq(Seq(4, 2, 2, 4), Seq(0, 16, 0, 8), Seq(0, 0, 0, 16), Seq(0, 0, 0, 0)))
  }
}
