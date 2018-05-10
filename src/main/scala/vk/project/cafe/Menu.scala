package vk.project.cafe

import scala.math.BigDecimal

object menu {
  val availableMenu:List[MenuItem] = List(
    MenuItem("Cola", Cold, 0.5),
    MenuItem("Coffee", Hot, 1.00),
    MenuItem("Cheese Sandwich", Cold, 2.00),
    MenuItem("Steak Sandwich", Hot, 4.50)
  )
}

case class MenuItem(name: String, servedAs: ServedAs, price: BigDecimal)
sealed trait ServedAs
case object Hot extends ServedAs
case object Cold extends ServedAs

