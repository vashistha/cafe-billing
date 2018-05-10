package vk.project.cafe
import vk.project.cafe.menu.availableMenu

import scala.math.BigDecimal
import scala.math.BigDecimal.RoundingMode.HALF_UP

object billGenerator {

  def totalBillWithServiceCharge(purchasedItems:String*): BigDecimal = {
    val bill = totalBill(purchasedItems: _*)
    val serviceCharge = calculateServiceCharge(bill:BigDecimal, purchasedItems: _*)
    bill + serviceCharge
  }

  def totalBill(purchasedItems: String*): BigDecimal  = {
    purchasedItems.flatMap(costOfItem).sum
  }

  private def calculateServiceCharge(bill: BigDecimal, purchasedItems: String*): BigDecimal = {
    var serviceCharge = BigDecimal(0.0)
    var hasFoodItem = false
    var hasHotFood = false

    purchasedItems.flatMap(getItem).foreach( order => {
      hasFoodItem |= order.itemType == food
      hasHotFood |= order.servedAs == Hot && order.itemType == food
    })

    if(hasHotFood) {
      serviceCharge = bill * 0.20 // 20% of total bill
    }
    else if(hasFoodItem) {
      serviceCharge = bill * 0.10 // 10% of total bill
    }
    serviceCharge.setScale(2, HALF_UP) min 20
  }

  private def getItem(name: String): Option[MenuItem] = {
    availableMenu.find(menuItem => menuItem.name.equalsIgnoreCase(name))
  }

  private def costOfItem(name: String): Option[BigDecimal] = {
    availableMenu.find(menuItem => menuItem.name.equalsIgnoreCase(name)).map(item => item.price)
  }
}
