package sample.evaluation

import monix.eval.{Callback, Task}
import monix.execution.Scheduler.Implicits.global

object TaskSample3 extends App {

  val task = Task( 1 + 1 )

  val callback = new Callback[Int] {
    override def onSuccess(value: Int): Unit = println(value)

    override def onError(ex: Throwable): Unit = ex.printStackTrace()
  }

  task.map(i => i * 4).runAsync(callback)

}
