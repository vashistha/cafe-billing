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
}
