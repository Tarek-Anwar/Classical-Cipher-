package com.tarek.classicalcipher;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    CardView caesar , playfair , transposition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initCompunt();

        caesar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Caesar.class);
                startActivity(intent);
            }
        });

        playfair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Playfair.class);
                startActivity(intent);
            }
        });

        transposition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Transposition.class);
                startActivity(intent);
            }
        });
    }

    private void initCompunt() {
        caesar = findViewById(R.id.caesar);
        playfair = findViewById(R.id.playfair);
        transposition = findViewById(R.id.transposition);
    }
}