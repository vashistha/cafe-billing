package vk.project.cafe
import scala.math.BigDecimal
import vk.project.cafe.menu.availableMenu

object billGenerator {
  def totalBill(purchasedItems:String*): BigDecimal  = {
    purchasedItems.flatMap(costOfItem).sum
  }

  private def costOfItem(name: String): Option[BigDecimal] = {
    availableMenu.find(menuItem => menuItem.name.equalsIgnoreCase(name)).map(item => item.price)
  }
}
