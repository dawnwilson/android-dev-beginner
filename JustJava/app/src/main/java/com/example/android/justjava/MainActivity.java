package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    /**
     * The number of coffees
     */
    private int quantity = 0;
    /**
     * The price per coffee
     */
    private static final int PRICE_PER_COFFEE = 5;

    private EditText nameEditText;
    private TextView orderSummaryTextView;
    private CheckBox whippedCreamCheckbox;
    private CheckBox chocolateCheckbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //region SETUP CONTROL VARIABLES
        nameEditText = (EditText) findViewById(R.id.name_edit_text);
        orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        whippedCreamCheckbox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        chocolateCheckbox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        //endregion SETUP CONTROL VARIABLES
    }

    /**
     * Increment quantity and update displays
     * Called when the + button is clicked
     *
     * @param view the control that triggered increment
     */
    public void increment(View view) {
        this.quantity++;
        displayQuantity(quantity);
    }

    /**
     * Increment the quantity and display it and the new price
     * Called when the - button is clicked
     *
     * @param view the control that triggered decrement
     */
    public void decrement(View view) {
        if (this.quantity > 0) {
            this.quantity--;
            displayQuantity(quantity);
        }
    }

    /**
     * Called when the submit button is clicked
     *
     * @param view the control that triggered submitOrder
     */
    public void submitOrder(View view) {
        orderSummaryTextView.setText(createOrderSummary(nameEditText.getText().toString(),
                whippedCreamCheckbox.isChecked(), chocolateCheckbox.isChecked(),
                calculatePrice()));
    }

    /**
     * Creates order summary
     *
     * @param name         customers entered name
     * @param whippedCream does customer want whipped cream
     * @param chocolate    does customer want chocolate
     * @param price        total price
     * @return the order summary message
     */
    private String createOrderSummary(String name, boolean whippedCream, boolean chocolate, int price) {
        String priceMessage = "Name: " + name;
        priceMessage += "\nAdd whipped cream? " + whippedCream;
        priceMessage += "\nAdd chocolate? " + chocolate;
        priceMessage += "\nQuantity: " + quantity;
        priceMessage += "\nTotal: $" + price;
        priceMessage += "\nThank you!";
        return priceMessage;
    }

    /**
     * Calculates total price of order
     *
     * @return the total price of order
     */
    private int calculatePrice() {
        int extraCost = 0;

        if (whippedCreamCheckbox.isChecked()) {
            extraCost++;
        }

        if (chocolateCheckbox.isChecked()) {
            extraCost += 2;
        }

        return quantity * (PRICE_PER_COFFEE + extraCost);
    }

    /**
     * Display the given quantity value in the quantity_text_view
     *
     * @param numberOfCoffees the value to display
     */
    private void displayQuantity(int numberOfCoffees) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffees);
    }
}