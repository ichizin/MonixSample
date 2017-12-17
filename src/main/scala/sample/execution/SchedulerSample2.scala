package sample.execution

import java.util.concurrent.TimeUnit
import monix.execution.Scheduler.{global => schduler}

object SchedulerSample2 extends App {

  val cancelable = schduler.scheduleWithFixedDelay(
    0, 2, TimeUnit.SECONDS,
    new Runnable {
      def run(): Unit = {
        println("start")
        TimeUnit.SECONDS.sleep(2)
        println("end")
      }
    })


  TimeUnit.SECONDS.sleep(10)
  cancelable.cancel()
}
