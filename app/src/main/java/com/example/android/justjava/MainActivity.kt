/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 */

package com.example.android.justjava

import android.content.Intent
import android.net.Uri
import java.text.NumberFormat;
import android.os.Bundle
import android.os.Message
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.util.Log
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

/**
 * This app displays an order form to order coffee.
 */
class MainActivity : AppCompatActivity() {

    var quantity: Int = 0
    var pricePerCoffee = 5
    var priceWhippedCream = 1
    var priceChocolate = 2
    var hasWhippedCream: Boolean = false
    var hasChocolate: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /**
     * This method is called when the order button is clicked.
     */
    fun submitOrder(view: View) {
        var nameTextView = findViewById<View>(R.id.name_id) as EditText
        var nameText: Editable = nameTextView.text
        var nameString : String = nameText.toString()
        val whippedCreamCheckBox = findViewById<CheckBox>(R.id.whippedCreamCheckboxid)
        hasWhippedCream = whippedCreamCheckBox.isChecked

        val chocolateCheckBox = findViewById<CheckBox>(R.id.chocolateCheckboxid)
        hasChocolate = chocolateCheckBox.isChecked

        var price: Int = calculatePrice(quantity)
        var priceMessage: String = createOrderSummary(price, hasWhippedCream, nameString)
        sendMail(priceMessage, nameString)
    /**    displayMessage(priceMessage) */
    }

    /**
     * This method is called to connect with Email app.
     *
     * @return total price
     */
    fun sendMail(priceMessage: String, nameString: String){

        val subject = "JustJava order for" + nameString
        val message: String = priceMessage
        val intent = Intent(Intent.ACTION_SENDTO)
        intent.setData(Uri.parse("mailto:"))
        intent.putExtra(Intent.EXTRA_SUBJECT, subject)
        intent.putExtra(Intent.EXTRA_TEXT, message)
            startActivity(Intent.createChooser(intent, "Send Email using:"))
    }
    /**
     * This method is called when the total price is calculated.
     *
     * @return total price
     */
    fun calculatePrice(numberOfCoffee: Int): Int {
        if (hasWhippedCream == true) {
            pricePerCoffee = pricePerCoffee + priceWhippedCream
        }
        if (hasChocolate == true) {
            pricePerCoffee = pricePerCoffee + priceChocolate
        }
        return numberOfCoffee * pricePerCoffee

    }

    /**
     * This method is called to create the order summary.
     *
     * @return Summary
     */
    fun createOrderSummary(totalPrice: Int, hasWhippedCream: Boolean, nameString: String): String {
        String
        var priceMessage = "Name: " + nameString +
                "\nAdd Whipped Cream " + hasWhippedCream +
                "\nAdd Chocolate " + hasChocolate +
                "\nQuantity: " + quantity +
                "\nTotal: " + "$" + totalPrice +
                "\n" + getString(R.string.Thank_You)
        return priceMessage
    }

    /**
     * This method is called when the plus button is clicked.
     */
    fun increment(view: View) {
        if (quantity < 100) {
            quantity = quantity + 1
            displayQuantity(quantity)
        }
    }

    /**
     * This method is called when the minus button is clicked.
     */
    fun decrement(view: View) {
        if (quantity > 0) {
            quantity = quantity - 1
            displayQuantity(quantity)
        } else {
            Toast.makeText(this, "Minimum number of coffees is 1", Toast.LENGTH_SHORT).show()
        }
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


