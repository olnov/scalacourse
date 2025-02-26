package org.novlab.cafe

class CafeDetails (
                    val shopName: String,
                    val address: String,
                    val phone: String,
                    val prices: Map[String, Double]
                  )

class ReceiptPrinter(val cafe: CafeDetails, var order: Map[String, Int] = Map()) {

  def receipt: String = {

    cafe.shopName
  }
}

class Till(val cafe: CafeDetails) {
  private var myOrder: Map[String, Int] = Map.empty
  def showMenu():Map[String, Double] = {
    this.cafe.prices
  }

  def orderFromMenu(order: String, quantity: Int): String = {
    if (this.cafe.prices.keys.exists(key => order.contains(key))) {
      this.myOrder = myOrder + (order -> quantity)
      "Order accepted"
    }else{
      "Sorry, that's not in the menu"
    }
  }

  def checkOut(): Unit = {
    var newPrinter = ReceiptPrinter(this.cafe, this.myOrder)
  }
}