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

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    Button buttonWater;
    Button buttonNature;
    Button buttonHolidays;
    Button buttonMusicInstruments;
    Button buttonMachines;
    Button buttonAnimals;
    Button buttonBirds;
    Button buttonCartMainMenu;
    Intent intent;
    Spinner spinner;
    ArrayList spinnerArrayList;
    ArrayAdapter spinnerAdapter;
    String action;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Main");
        buttonWater = findViewById(R.id.buttonWater);
        buttonWater.setOnClickListener(this);
        buttonNature = findViewById(R.id.buttonNature);
        buttonNature.setOnClickListener(this);
        buttonHolidays = findViewById(R.id.buttonHolidays);
        buttonHolidays.setOnClickListener(this);
        buttonMusicInstruments = findViewById(R.id.buttonMusicInstruments);
        buttonMusicInstruments.setOnClickListener(this);
        buttonMachines = findViewById(R.id.buttonMachines);
        buttonMachines.setOnClickListener(this);
        buttonAnimals = findViewById(R.id.buttonAnimals);
        buttonAnimals.setOnClickListener(this);
        buttonBirds = findViewById(R.id.buttonBirds);
        buttonBirds.setOnClickListener(this);
        buttonCartMainMenu = findViewById(R.id.buttonCartMainMenu);
        buttonCartMainMenu.setOnClickListener(this);
        createSpinner();
    }

    void createSpinner(){
        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        spinnerArrayList = new ArrayList();
        spinnerArrayList.add("Hello, user");
        spinnerArrayList.add("Log out");
        spinnerAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,spinnerArrayList);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.buttonNature:
                intent = new Intent(this, NatureMenu.class);
                startActivity(intent);
                break;
            case R.id.buttonWater:
                intent = new Intent(this, WaterMenu.class);
                startActivity(intent);
                break;
            case R.id.buttonHolidays:
                intent = new Intent(this, HolidaysMenu.class);
                startActivity(intent);
                break;
            case R.id.buttonMusicInstruments:
                intent = new Intent(this, MusicInstrumentsMenu.class);
                startActivity(intent);
                break;
            case R.id.buttonMachines:
                intent = new Intent(this, MachinesMenu.class);
                startActivity(intent);
                break;
            case R.id.buttonAnimals:
                intent = new Intent(this, AnimalsMenu.class);
                startActivity(intent);
                break;
            case R.id.buttonBirds:
                intent = new Intent(this, BirdsMenu.class);
                startActivity(intent);
                break;
            case R.id.buttonCartMainMenu:
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
            startActivity(new Intent(MainActivity.this,LogInMenu.class));
        }else{
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}