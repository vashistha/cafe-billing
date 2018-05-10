package vk.project.cafe

import org.scalatest.FlatSpec

class BillGeneratorSpec extends FlatSpec {

  "BillGenerator" should " produce standard bill for items" in {
    assert(billGenerator.totalBill("Cola", "Coffee", "Cheese Sandwich") === 3.50)
  }

  it should "produce 0.00 bill for non existent items" in {
    assert(billGenerator.totalBill("asd") == 0.0)
  }

  it should "calculate bill correctly when same item ordered multiple times" in {
    assert(billGenerator.totalBill("Cola", "Cola", "Coffee", "Cola", "asd", "asd") == 2.50)
  }

  it should "produce bill with no service charge for drink only order" in {
    val totalBill = billGenerator.totalBillWithServiceCharge("Cola", "Coffee")
    val expectedBill = 1.50
    assert(expectedBill == totalBill)
  }

  it should "produce bill with 10% service charge for order with any food item" in {
    val totalBill = billGenerator.totalBillWithServiceCharge("Cola", "Coffee", "Cheese Sandwich")
    val expectedBill = 3.85 // (1.0 +0.5 + 2.0)*1.10 = 3.85
    assert(expectedBill == totalBill)
  }

  it should "produce bill with 20% service charge for order with any hot food item" in {
    val totalBill = billGenerator.totalBillWithServiceCharge("Cola", "Coffee", "Cheese Sandwich", "Steak Sandwich", "dfg")
    val expectedBill = 9.6 // (1.0 + 0.5 + 2.0 + 4.5)*1.20 = 9.6
    assert(expectedBill == totalBill)
  }

  it should "produce bill with service charge but max service charge must not exceed £20.00" in {
    val totalBill = billGenerator.totalBillWithServiceCharge(
      "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich",
      "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich",
      "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich",
      "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich",
      "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich",
      "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich",
      "Cola", "Coffee", "Cheese Sandwich")
    val expectedBill = 158.50 // 30*4.5 +0.5+1+2 + 20 = 158.5
    assert(expectedBill == totalBill)
  }
}
