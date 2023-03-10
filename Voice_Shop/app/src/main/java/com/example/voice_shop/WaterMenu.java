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

public class WaterMenu extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener{
    Button buttonSoundOfOceanWaves;
    Button buttonSoundOfAtlanticOcean;
    Button buttonSoundOfSurfAtDawn;
    Button buttonSoundOfRagingWaves;
    Button buttonSoundOfOceanDepth;
    Button buttonSoundOfEmptyBeach;
    Button buttonSoundOfSeagullsAndSurf;
    Button buttonBackToMainMenu;
    Button buttonCart;
    Intent intent;
    Spinner spinner;
    ArrayList spinnerArrayList;
    ArrayAdapter spinnerAdapter;
    String action;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_menu);
        setTitle("Water");
        buttonSoundOfOceanWaves = findViewById(R.id.buttonSoundOfOwl);
        buttonSoundOfOceanWaves.setOnClickListener(this);
        buttonSoundOfAtlanticOcean = findViewById(R.id.buttonSoundOfTitmouse);
        buttonSoundOfAtlanticOcean.setOnClickListener(this);
        buttonSoundOfSurfAtDawn = findViewById(R.id.buttonSoundOfBullfinch);
        buttonSoundOfSurfAtDawn.setOnClickListener(this);
        buttonSoundOfRagingWaves = findViewById(R.id.buttonSoundOfСock);
        buttonSoundOfRagingWaves.setOnClickListener(this);
        buttonSoundOfOceanDepth = findViewById(R.id.buttonSoundOfFox);
        buttonSoundOfOceanDepth.setOnClickListener(this);
        buttonSoundOfEmptyBeach = findViewById(R.id.buttonSoundOfRain);
        buttonSoundOfEmptyBeach.setOnClickListener(this);
        buttonSoundOfSeagullsAndSurf = findViewById(R.id.buttonSoundOfSeagullsAndSurf);
        buttonSoundOfSeagullsAndSurf.setOnClickListener(this);
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
                intent = new Intent(this, SoundOfOceanWaves.class);
                startActivity(intent);
                break;
            case R.id.buttonSoundOfTitmouse:
                intent = new Intent(this, SoundOfAtlanticOcean.class);
                startActivity(intent);
                break;
            case R.id.buttonSoundOfBullfinch:
                intent = new Intent(this, SoundOfSurfAtDawn.class);
                startActivity(intent);
                break;
            case R.id.buttonSoundOfСock:
                intent = new Intent(this, SoundOfRagingWaves.class);
                startActivity(intent);
                break;
            case R.id.buttonSoundOfFox:
                intent = new Intent(this, SoundOfOceanDepth.class);
                startActivity(intent);
                break;
            case R.id.buttonSoundOfRain:
                intent = new Intent(this, SoundOfEmptyBeach.class);
                startActivity(intent);
                break;
            case R.id.buttonSoundOfSeagullsAndSurf:
                intent = new Intent(this, SoundOfSeagullsAndSurf.class);
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
            startActivity(new Intent(WaterMenu.this,LogInMenu.class));
        }else{
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}