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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /**
     * This method is called when the order button is clicked.
     */
    fun submitOrder(view: View) {
        Int
        val price = calculatePrice(quantity)

        String
        var priceMessage = "Name: Amethyst George Solomon " +
                "\nAdd Whipped Cream " + quantity +
                "\nQuantity: " + quantity +
                "\nTotal: " + "$" + price
        priceMessage = priceMessage + "\nThank You!"
        displayMessage(priceMessage)
    }
    /**
     * This method is called when the total price is calculated.
     */
    fun calculatePrice(number: Int): Int {
        Int
        val totalPrice = quantity * 5
        return totalPrice
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
    private fun displayQuantity(number: Int) {
        val quantityTextView = findViewById<View>(R.id.quantity_text_view) as TextView
        quantityTextView.text = "" + number
    }

    /**
     * This method displays the given price on the screen.
     */
    private fun displayPrice(number: Int) {
        val priceTextView = findViewById<View>(R.id.price_text_view) as TextView
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number))
    }

    /**
     * This method displays the given text on the screen.
     */
    private fun displayMessage(message: String) {
        val priceTextView = findViewById<View>(R.id.price_text_view) as TextView
        priceTextView.text = message
    }
}