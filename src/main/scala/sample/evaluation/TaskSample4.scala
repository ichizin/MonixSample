package sample.evaluation

import java.util.concurrent.TimeUnit

import monix.eval.Task
import monix.execution.Scheduler.Implicits.global

import scala.concurrent.duration.FiniteDuration
import scala.util.Random

object TaskSample4 extends App {


  val retryTask = Task {
    val i = Random.nextInt(10)

    println(i)

    if (i < 3) { "Success!!"
    } else throw new IllegalStateException(i.toString)
  }

//  retryTask.onErrorRestart(5).runAsync.foreach(println)

  retryBackoff(retryTask, 5, new FiniteDuration(2, TimeUnit.SECONDS)).runAsync.foreach(println)

  def retryBackoff[A](source: Task[A],
                      maxRetries: Int, firstDelay: FiniteDuration): Task[A] = {
    source.onErrorHandleWith {
      case ex: Exception =>
        if (maxRetries > 0)
          retryBackoff(source, maxRetries - 1, firstDelay * 2)
            .delayExecution(firstDelay)
        else
          Task.raiseError(ex)
    }
  }
}
