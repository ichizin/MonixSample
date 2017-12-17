package sample.execution

import java.util.concurrent.TimeUnit

import monix.execution.Scheduler.{global => schduler}

object SchedulerSample3 extends App {
//  val cancelable = schduler.scheduleWithFixedDelay(
//    0, 2, TimeUnit.SECONDS,
//    new Runnable {
//      def run(): Unit = {
//        println("start")
//        TimeUnit.SECONDS.sleep(4)
//        println("end")
//      }
//    })

  val cancelable = schduler.scheduleAtFixedRate(
    0, 2, TimeUnit.SECONDS,
    new Runnable {
      def run(): Unit = {
        println("start")
        TimeUnit.SECONDS.sleep(4)
        println("end")
      }
    })


  TimeUnit.SECONDS.sleep(30)
  cancelable.cancel()
}
