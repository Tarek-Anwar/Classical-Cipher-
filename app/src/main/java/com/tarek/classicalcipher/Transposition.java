package com.tarek.classicalcipher;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Transposition extends AppCompatActivity {

    EditText input , key_txt;
    Button decrypt_txt , encrypt_txt;
    TextView output , output2;

    String r="";
    String key ="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transposition);

        inticompunt();

        encrypt_txt.setOnClickListener(v -> {
            key = key_txt.getText().toString();
            String msg = input.getText().toString();
            r = ColTransCipher.encryption(msg, key);
            output.setText(r);
        });


        decrypt_txt.setOnClickListener(v -> output2.setText(ColTransCipher.decryption(r, key)));


    }
    private void inticompunt() {
        input = findViewById(R.id.input_transposition);
        key_txt = findViewById(R.id.key_transposition);
        encrypt_txt = findViewById(R.id.enc_transposition);
        decrypt_txt = findViewById(R.id.dec_transposition);
        output = findViewById(R.id.output1_transposition);
        output2 = findViewById(R.id.output2_transposition);
    }

}