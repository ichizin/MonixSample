package sample.execution

import java.util.concurrent.TimeUnit

import monix.execution.Cancelable
import monix.execution.Scheduler.{global => scheduler}

import scala.concurrent.duration._

object SchedulerSample1 extends App{

  val cancelable: Cancelable = scheduler.scheduleOnce(2.seconds) { println("Monix Scheduler") }

  // cancelable.cancel()

  TimeUnit.SECONDS.sleep(5)
}
