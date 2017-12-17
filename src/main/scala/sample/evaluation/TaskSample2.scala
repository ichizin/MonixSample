package sample.evaluation

import java.util.concurrent.TimeUnit

import monix.eval.Task
import monix.execution.CancelableFuture
import monix.execution.Scheduler.Implicits.global

import scala.concurrent.duration._

object TaskSample2 extends App {

  val task: Task[String] = Task.eval("Hi, Monix!").delayExecution(3.seconds)
  // 3秒間待ってから処理実行
  task.runAsync.foreach(println)

  val cancelable: CancelableFuture[String] =  Task.eval("CancelTask").delayExecution(10.seconds).runAsync

  TimeUnit.SECONDS.sleep(5)
  cancelable.cancel
  println("task cancel")

}
