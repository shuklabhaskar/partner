package com.gtech.foodipspartner;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class login extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void authenticateUser(View view) {



    }

    public void goToRegister(View view) {
        Intent send = new Intent(login.this, Register.class);
        startActivity(send);
    }
}