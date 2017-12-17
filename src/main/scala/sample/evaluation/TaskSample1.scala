package sample.evaluation

import monix.eval.Task

import scala.concurrent.Future

import monix.execution.Scheduler.Implicits.global

/**
  * FutureとTaskの違い
  *
  */
object TaskSample1 extends App {

  val future: Future[Int] = Future { println("Future");  1 + 1 }

  // Future
  // 2
  // 2
  future.foreach(println)
  future.foreach(println)

  val task: Task[Int] = Task { println("Task"); 1 + 1 }

  // Task
  // 2
  // Task
  // 2
  task.runAsync.foreach(println)
  task.runAsync.foreach(println)

  val taskValOnce = Task.evalOnce{ println("taskValOnce"); 1 + 1  }

  // taskValOnce
  // 2
  // 2
  taskValOnce.runAsync.foreach(println)
  taskValOnce.runAsync.foreach(println)
}
