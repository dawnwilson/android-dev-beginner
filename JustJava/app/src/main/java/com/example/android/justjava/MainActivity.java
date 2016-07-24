package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends ActionBarActivity {

    /**
     * The number of coffees
     */
    private int quantity = 0;
    /**
     * The price per coffee
     */
    private static final int PRICE_PER_COFFEE = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Increment quantity and update displays
     * Called when the + button is clicked
     *
     * @param view
     */
    public void increment(View view) {
        this.quantity++;
        updateDisplay();
    }

    /**
     * Increment the quantity and display it and the new price
     * Called when the - button is clicked
     *
     * @param view
     */
    public void decrement(View view) {
        if (this.quantity > 0) {
            this.quantity--;
            updateDisplay();
        }
    }

    /**
     * Displays value in the thanks_text_view
     * Called when the submit button is clicked
     *
     * @param view
     */
    public void submitOrder(View view) {
        TextView thanksTextView = (TextView) findViewById(R.id.thanks_text_view);
        thanksTextView.setText("Thank You!");
    }

    /**
     * Updates quantity and price to be displayed
     */
    private void updateDisplay() {
        displayQuantity(this.quantity);
        displayPrice(this.quantity * PRICE_PER_COFFEE);
        removeThanks();
    }

    private void removeThanks() {
        TextView thanksTextView = (TextView) findViewById(R.id.thanks_text_view);
        thanksTextView.setText("");
    }


    /**
     * Display the given total price in the price_text_view
     *
     * @param number The value to display
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    /**
     * Display the given quantity value in the quantity_text_view
     *
     * @param number The value to display
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
}