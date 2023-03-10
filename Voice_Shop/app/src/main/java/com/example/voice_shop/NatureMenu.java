package com.example.voice_shop;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class NatureMenu extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener{
    Button buttonSoundOfRustleOfLeaves;
    Button buttonSoundOfColdStorm;
    Button buttonSoundOfSummerField;
    Button buttonSoundOfRainforest;
    Button buttonSoundOfHail;
    Button buttonSoundOfRain;
    Button buttonCart;
    Button buttonBackToMainMenu;
    Intent intent;
    Spinner spinner;
    ArrayList spinnerArrayList;
    ArrayAdapter spinnerAdapter;
    String action;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nature_menu);
        setTitle("Nature");
        buttonSoundOfRustleOfLeaves = findViewById(R.id.buttonSoundOfOwl);
        buttonSoundOfRustleOfLeaves.setOnClickListener(this);
        buttonSoundOfColdStorm = findViewById(R.id.buttonSoundOfTitmouse);
        buttonSoundOfColdStorm.setOnClickListener(this);
        buttonSoundOfSummerField = findViewById(R.id.buttonSoundOfBullfinch);
        buttonSoundOfSummerField.setOnClickListener(this);
        buttonSoundOfRainforest = findViewById(R.id.buttonSoundOfСock);
        buttonSoundOfRainforest.setOnClickListener(this);
        buttonSoundOfHail = findViewById(R.id.buttonSoundOfFox);
        buttonSoundOfHail.setOnClickListener(this);
        buttonSoundOfRain = findViewById(R.id.buttonSoundOfRain);
        buttonSoundOfRain.setOnClickListener(this);
        buttonBackToMainMenu = findViewById(R.id.buttonBackToMainMenu);
        buttonBackToMainMenu.setOnClickListener(this);
        buttonCart = findViewById(R.id.buttonCart);
        buttonCart.setOnClickListener(this);
        createSpinner();
    }

    void createSpinner(){
        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        spinnerArrayList = new ArrayList();
        spinnerArrayList.add("");
        spinnerArrayList.add("Log out");
        spinnerAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,spinnerArrayList);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.buttonSoundOfOwl:
                intent = new Intent(this, SoundOfRustleOfLeaves.class);
                startActivity(intent);
                break;
            case R.id.buttonSoundOfTitmouse:
                intent = new Intent(this, SoundOfColdStorm.class);
                startActivity(intent);
                break;
            case R.id.buttonSoundOfBullfinch:
                intent = new Intent(this, SoundOfSummerField.class);
                startActivity(intent);
                break;
            case R.id.buttonSoundOfСock:
                intent = new Intent(this, SoundOfRainforest.class);
                startActivity(intent);
                break;
            case R.id.buttonSoundOfFox:
                intent = new Intent(this, SoundOfHail.class);
                startActivity(intent);
                break;
            case R.id.buttonSoundOfRain:
                intent = new Intent(this, SoundOfRain.class);
                startActivity(intent);
                break;
            case R.id.buttonBackToMainMenu:
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.buttonCart:
                intent = new Intent(this, OrderCart.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        action = spinner.getSelectedItem().toString();
        if(action.equals("Log out")){
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(NatureMenu.this,LogInMenu.class));
        }else{
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}