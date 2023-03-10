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

public class MusicInstrumentsMenu extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener{
    Button buttonSoundOfGuitar;
    Button buttonSoundOfDrums;
    Button buttonSoundOfViolin;
    Button buttonSoundOfPiano;
    Button buttonSoundOfBassGuitar;
    Button buttonSoundOfSpecial;
    Button buttonCart;
    Button buttonBackToMainMenu;
    Intent intent;
    Spinner spinner;
    ArrayList spinnerArrayList;
    ArrayAdapter spinnerAdapter;
    String action;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_instruments_menu);
        setTitle("Music Instruments");
        buttonSoundOfGuitar = findViewById(R.id.buttonSoundOfOwl);
        buttonSoundOfGuitar.setOnClickListener(this);
        buttonSoundOfDrums = findViewById(R.id.buttonSoundOfTitmouse);
        buttonSoundOfDrums.setOnClickListener(this);
        buttonSoundOfViolin = findViewById(R.id.buttonSoundOfBullfinch);
        buttonSoundOfViolin.setOnClickListener(this);
        buttonSoundOfPiano = findViewById(R.id.buttonSoundOfСock);
        buttonSoundOfPiano.setOnClickListener(this);
        buttonSoundOfBassGuitar = findViewById(R.id.buttonSoundOfFox);
        buttonSoundOfBassGuitar.setOnClickListener(this);
        buttonSoundOfSpecial = findViewById(R.id.buttonSoundOfSpecial);
        buttonSoundOfSpecial.setOnClickListener(this);
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
                intent = new Intent(this, SoundOfGuitar.class);
                startActivity(intent);
                break;
            case R.id.buttonSoundOfTitmouse:
                intent = new Intent(this, SoundOfDrums.class);
                startActivity(intent);
                break;
            case R.id.buttonSoundOfBullfinch:
                intent = new Intent(this, SoundOfViolin.class);
                startActivity(intent);
                break;
            case R.id.buttonSoundOfСock:
                intent = new Intent(this, SoundOfPiano.class);
                startActivity(intent);
                break;
            case R.id.buttonSoundOfFox:
                intent = new Intent(this, SoundOfBassGuitar.class);
                startActivity(intent);
                break;
            case R.id.buttonSoundOfSpecial:
                intent = new Intent(this, SoundOfSpecial.class);
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
            startActivity(new Intent(MusicInstrumentsMenu.this,LogInMenu.class));
        }else{
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}