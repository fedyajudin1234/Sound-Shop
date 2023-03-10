package com.example.voice_shop;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OrderCart extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    Button buttonBackToMainMenuFromOrderCart;
    Button buttonBuy;
    Intent intent;
    ListView orders_list;
    Spinner spinnerOceanWaves;
    ArrayList spinnerArrayList;
    ArrayAdapter spinnerAdapter;
    String action;
    private EditText editTextEmail;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_cart);
        setTitle("Cart");
        orders_list = findViewById(R.id.orders_list);
        orders_list.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Order.items_name.toArray()));
        buttonBackToMainMenuFromOrderCart = findViewById(R.id.buttonBackToMainMenuFromOrderCart);
        buttonBackToMainMenuFromOrderCart.setOnClickListener(this);
        buttonBuy = findViewById(R.id.buttonBuy);
        buttonBuy.setOnClickListener(this);
        createSpinner();
    }

    void createSpinner(){
        spinnerOceanWaves = findViewById(R.id.spinnerOceanWaves);
        spinnerOceanWaves.setOnItemSelectedListener(this);
        spinnerArrayList = new ArrayList();
        spinnerArrayList.add("");
        spinnerArrayList.add("Log out");
        spinnerAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,spinnerArrayList);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerOceanWaves.setAdapter(spinnerAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonBackToMainMenuFromOrderCart:
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.buttonBuy:
                submitOrder(v);
                break;
            default:
                break;
        }
    }
    public void submitOrder(View view){
        editTextEmail = findViewById(R.id.editTextEmail);
        String email = editTextEmail.getText().toString().trim();
        if(email.length() != 0){
            //String email = editTextEmail.getText().toString().trim();
            String orderTitle = "Order from Voice Shop";
            Intent intentEmail = new Intent(Intent.ACTION_SEND);
            intentEmail.putExtra(Intent.EXTRA_EMAIL, new String[]{email});
            intentEmail.putExtra(Intent.EXTRA_SUBJECT, orderTitle);
            intentEmail.putExtra(Intent.EXTRA_TEXT, Order.items_name.toString());
            intentEmail.setType("message/rfc822");
            startActivity(Intent.createChooser(intentEmail, "Выберите email клиент :"));
        }else{
            Toast.makeText(this,"Enter your email address",Toast.LENGTH_LONG).show();
        }
        //if(intent.resolveActivity(getPackageManager()) != null) {
        //    startActivity(intent);
        //}
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        action = spinnerOceanWaves.getSelectedItem().toString();
        if(action.equals("Log out")){
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(OrderCart.this,LogInMenu.class));
        }else{

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}