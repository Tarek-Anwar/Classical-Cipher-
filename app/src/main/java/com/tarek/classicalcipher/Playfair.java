package com.tarek.classicalcipher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;

public class Playfair extends AppCompatActivity {

    EditText input , key_txt;
    Button decrypt_txt , encrypt_txt;
    TextView output , output2;

    String decrypted="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playfair);


        inticompunt();



        encrypt_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PFEncryption pfEncryption=new PFEncryption();
                String key = key_txt.getText().toString();
                String msg = input.getText().toString();
                pfEncryption.makeArray(key);
                msg=pfEncryption.manageMessage(msg);
                pfEncryption.doPlayFair(msg, "Encrypt");
                String en=pfEncryption.getEncrypted();
                output.setText(en);
                pfEncryption.doPlayFair(en, "Decrypt");
                decrypted =  pfEncryption.getDecrypted();
            }
        });

        decrypt_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                output2.setText(decrypted);
            }
        });

    }

    private void inticompunt() {
        input = findViewById(R.id.input_playfair);
        key_txt = findViewById(R.id.key_playfair);
        encrypt_txt = findViewById(R.id.enc_playfair);
        decrypt_txt = findViewById(R.id.dec_playfair);
        output = findViewById(R.id.output1_playfair);
        output2 = findViewById(R.id.output2_playfair);
    }

}