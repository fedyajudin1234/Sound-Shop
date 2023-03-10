package com.example.voice_shop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SoundOfBullfinch extends AppCompatActivity implements View.OnClickListener{
    MediaPlayer mediaPlayer;
    Button buttonPlay;
    Button buttonBackToBirdsMenu;
    Button buttonAddToPurchase;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_of_bullfinch);
        setTitle("Bullfinch");
        mediaPlayer = MediaPlayer.create(this, R.raw.bullfinch);
        buttonPlay = findViewById(R.id.buttonPlay);
        buttonPlay.setOnClickListener(this);
        buttonBackToBirdsMenu = findViewById(R.id.buttonBackToMachinesMenu);
        buttonBackToBirdsMenu.setOnClickListener(this);
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
                intent = new Intent(this, BirdsMenu.class);
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