/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 */

package com.example.android.justjava

import java.text.NumberFormat;
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

/**
 * This app displays an order form to order coffee.
 */
class MainActivity : AppCompatActivity() {

    var quantity: Int = 0
    var pricePerCoffee = 5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /**
     * This method is called when the order button is clicked.
     */
    fun submitOrder(view: View) {
        Int
        var price = calculatePrice(quantity)
        String
        var priceMessage = createOrderSummary(price)
        displayMessage(priceMessage)
    }

    /**
     * This method is called when the total price is calculated.
     *
     * @return total price
     */
    fun calculatePrice(numberOfCoffee: Int): Int {
        return numberOfCoffee * pricePerCoffee

    }

    /**
     * This method is called to create the order summary.
     *
     * @return Summary
     */
    fun createOrderSummary(totalPrice: Int): String {
        String
        var priceMessage = "Name: Amethyst George Solomon " +
                "\nAdd Whipped Cream " + quantity +
                "\nQuantity: " + quantity +
                "\nTotal: " + "$" + totalPrice +
                "\nThank You!"
        return priceMessage
    }

    /**
     * This method is called when the plus button is clicked.
     */
    fun increment(view: View) {
        quantity = quantity + 1
        displayQuantity(quantity)
    }

    /**
     * This method is called when the minus button is clicked.
     */
    fun decrement(view: View) {
        quantity = quantity - 1
        displayQuantity(quantity)
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private fun displayQuantity(numberOfCoffee: Int) {
        val quantityTextView = findViewById<View>(R.id.quantity_text_view) as TextView
        quantityTextView.text = "" + numberOfCoffee
    }

    /**
     * This method displays the given text on the screen.
     */
    private fun displayMessage(message: String) {
        val orderSummaryTextView = findViewById<View>(R.id.order_summary_text_view) as TextView
        orderSummaryTextView.text = message
    }
}