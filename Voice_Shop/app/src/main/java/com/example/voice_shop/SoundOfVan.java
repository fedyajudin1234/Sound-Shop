package com.example.voice_shop;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SoundOfVan extends AppCompatActivity implements View.OnClickListener{
    MediaPlayer mediaPlayer;
    Button buttonPlay;
    Button buttonBackToMachinesMenu;
    Button buttonAddToPurchase;
    Intent intent;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_of_van);
        setTitle("Van");
        mediaPlayer = MediaPlayer.create(this, R.raw.van);
        buttonPlay = findViewById(R.id.buttonPlay);
        buttonPlay.setOnClickListener(this);
        buttonBackToMachinesMenu = findViewById(R.id.buttonBackToMachinesMenu);
        buttonBackToMachinesMenu.setOnClickListener(this);
        buttonAddToPurchase = findViewById(R.id.buttonAddToPurchase);
        buttonAddToPurchase.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonPlay:
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                    buttonPlay.setText("Play");

                }else{
                    mediaPlayer.start();
                    buttonPlay.setText("Pause");
                }
                break;
            case R.id.buttonBackToMachinesMenu:
                intent = new Intent(this, MachinesMenu.class);
                startActivity(intent);
                break;
            case R.id.buttonAddToPurchase:
                TextView textView = findViewById(R.id.textViewSound);
                String string = textView.getText().toString();
                Order.items_name.add(string);
                Toast.makeText(this,"Sound was added to cart",Toast.LENGTH_LONG).show();
                break;
            default:
                break;
        }
    }
}