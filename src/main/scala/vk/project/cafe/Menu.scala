package vk.project.cafe

import scala.math.BigDecimal

object menu {
  val availableMenu:List[MenuItem] = List(
    MenuItem("Cola", Cold, 0.5, drink),
    MenuItem("Coffee", Hot, 1.00, drink),
    MenuItem("Cheese Sandwich", Cold, 2.00, food),
    MenuItem("Steak Sandwich", Hot, 4.50, food)
  )
}

case class MenuItem(name: String, servedAs: ServedAs, price: BigDecimal, itemType: ItemType)
sealed trait ServedAs
case object Hot extends ServedAs
case object Cold extends ServedAs

sealed trait ItemType
case object drink extends ItemType
case object food extends ItemType
