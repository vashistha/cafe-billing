package vk.project.cafe

import org.scalatest.FlatSpec

class MenuSpec extends FlatSpec {
  "Cafe menu" should "have 4 items" in {
    assert(menu.availableMenu.size == 4)
  }

  it must "have Cola, Coffee, Cheese Sandwich and Steak Sandwich" in {
    assert(List("Cola", "Coffee", "Cheese Sandwich", "Steak Sandwich") === menu.availableMenu.map(i => i.name))
  }
}
