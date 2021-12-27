package com.tarek.classicalcipher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Caesar extends AppCompatActivity {

    EditText input , shift;
    Button decrypt_txt , encrypt_txt;
    TextView output , output2;
    String text = null;
    int s = 0;
    String r = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caesar);

        inticompunt();

        encrypt_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = input.getText().toString();
                s =Integer.parseInt(shift.getText().toString());
                r = encrypt(text,s).toString();
                output.setText(r);
            }
        });

        decrypt_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = decrypt(r,26-s).toString();
                output2.setText(text);
            }
        });
    }

    private void inticompunt() {
        input = findViewById(R.id.input_caesar);
        shift = findViewById(R.id.shift_caesar);
        encrypt_txt = findViewById(R.id.enc_caesar);
        decrypt_txt = findViewById(R.id.dec_caesar);
        output = findViewById(R.id.output_caesar);
        output2 = findViewById(R.id.output2_caesar);
    }

    public static StringBuffer encrypt(String text, int shift) {
        StringBuffer result = new StringBuffer();

        for (int i = 0; i < text.length(); i++) {
            if (Character.isUpperCase(text.charAt(i))) {
                char ch = (char) (((int) text.charAt(i) +
                        shift - 65) % 26 + 65);
                result.append(ch);
            } else {
                char ch = (char) (((int) text.charAt(i) +
                        shift - 97) % 26 + 97);
                result.append(ch);
            }
        }
        return result;
    }

    // Decrypts cipher using shift
    public static StringBuffer decrypt(String cipher, int shift) {
        StringBuffer result = new StringBuffer();

        for (int i = 0; i < cipher.length(); i++) {
            if (Character.isUpperCase(cipher.charAt(i))) {
                char ch = (char) (((int) cipher.charAt(i) +
                        shift - 65) % 26 + 65);
                result.append(ch);
            } else {
                char ch = (char) (((int) cipher.charAt(i) +
                        shift - 97) % 26 + 97);
                result.append(ch);
            }
        }
        return result;
    }
}