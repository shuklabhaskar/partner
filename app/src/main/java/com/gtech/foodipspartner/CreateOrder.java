package com.gtech.foodipspartner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.firestore.FirebaseFirestore;
import com.gtech.foodipspartner.Models.CreateNewOreder;

import java.util.Calendar;

public class CreateOrder extends AppCompatActivity {

    TextInputEditText billNumber, totalAmount, customerName, customerNumber;
    FirebaseFirestore FoodipsPartner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_order);

        billNumber = findViewById(R.id.billNumber);
        totalAmount = findViewById(R.id.totalAmount);
        customerName = findViewById(R.id.customerName);
        customerNumber = findViewById(R.id.customerNumber);

        FoodipsPartner = FirebaseFirestore.getInstance();
    }

    public void createOrder(View view) {


        if(validation(billNumber, totalAmount, customerName, customerNumber )){
            String BillNumberValue      = billNumber.getText().toString();
            String totalAmountValue     = totalAmount.getText().toString();
            String customerNameValue    = customerName.getText().toString();
            String customerNumberValue  = customerNumber.getText().toString();
            String DateTimeValue        = Calendar.getInstance().getTime().toString();

            CreateNewOreder createNewOreder = new CreateNewOreder(BillNumberValue, totalAmountValue ,customerNameValue ,customerNumberValue ,DateTimeValue);

            FoodipsPartner.collection("orders").document().set(createNewOreder)
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(CreateOrder.this, "Order placed successfully", Toast.LENGTH_SHORT).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(CreateOrder.this, e.getMessage(), Toast.LENGTH_SHORT).show();


                }
            });
        }

    }

    private boolean validation(TextInputEditText billNumber, TextInputEditText totalAmount, TextInputEditText customerName, TextInputEditText customerNumber) {

        if (billNumber.getText().toString().isEmpty()) {
            billNumber.setError("enter bill no");

        } else if (totalAmount.getText().toString().isEmpty()) {
            totalAmount.setError("enter totalAmount");

        } else if (customerName.getText().toString().isEmpty()) {
            customerName.setError("enter customerName");

        } else if (customerNumber.getText().toString().isEmpty()) {
            customerNumber.setError("enter customerNumber");
        } else {
            return true;
        }

        return false;

    }

}