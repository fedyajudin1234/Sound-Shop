package com.example.voice_shop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class AnimalsMenu extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener{
    Button buttonSoundOfDog;
    Button buttonSoundOfCat;
    Button buttonSoundOfCow;
    Button buttonSoundOfWolf;
    Button buttonSoundOfFox;
    Button buttonCart;
    Button buttonBackToMainMenu;
    Intent intent;
    Spinner spinner;
    ArrayList spinnerArrayList;
    ArrayAdapter spinnerAdapter;
    String action;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals_menu);
        setTitle("Animals");
        buttonSoundOfDog = findViewById(R.id.buttonSoundOfOwl);
        buttonSoundOfDog.setOnClickListener(this);
        buttonSoundOfCat = findViewById(R.id.buttonSoundOfTitmouse);
        buttonSoundOfCat.setOnClickListener(this);
        buttonSoundOfCow = findViewById(R.id.buttonSoundOfBullfinch);
        buttonSoundOfCow.setOnClickListener(this);
        buttonSoundOfWolf = findViewById(R.id.buttonSoundOfСock);
        buttonSoundOfWolf.setOnClickListener(this);
        buttonSoundOfFox = findViewById(R.id.buttonSoundOfFox);
        buttonSoundOfFox.setOnClickListener(this);
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
                intent = new Intent(this, SoundOfDog.class);
                startActivity(intent);
                break;
            case R.id.buttonSoundOfTitmouse:
                intent = new Intent(this, SoundOfCat.class);
                startActivity(intent);
                break;
            case R.id.buttonSoundOfBullfinch:
                intent = new Intent(this, SoundOfCow.class);
                startActivity(intent);
                break;
            case R.id.buttonSoundOfСock:
                intent = new Intent(this, SoundOfWolf.class);
                startActivity(intent);
                break;
            case R.id.buttonSoundOfFox:
                intent = new Intent(this, SoundOfFox.class);
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
            startActivity(new Intent(AnimalsMenu.this,LogInMenu.class));
        }else{
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}