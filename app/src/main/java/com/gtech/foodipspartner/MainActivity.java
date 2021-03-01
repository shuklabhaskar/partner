package com.gtech.foodipspartner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(isConnect()){
            Toast.makeText(this, "Connected", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Not Connected", Toast.LENGTH_SHORT).show();
        }

    }

    public void goToNewOrder(View view) {
        Intent send = new Intent(MainActivity.this, CreateOrder.class);
        startActivity(send);
    }

    public boolean isConnect() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            assert connectivityManager != null;
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isConnected() || activeNetworkInfo.isConnectedOrConnecting();
            } else {
                return false;
            }
        } catch (Exception e){
            return false;
        }
    }


}