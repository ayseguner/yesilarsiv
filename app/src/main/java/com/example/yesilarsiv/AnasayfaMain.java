package com.example.yesilarsiv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class AnasayfaMain extends AppCompatActivity {

    private TextView textView3;
    private Button button3;
    private Button buttonArsiv;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anasayfa_main);

        textView3 = findViewById(R.id.textView3);
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cikisYap= new Intent(AnasayfaMain.this, MainActivity.class);

                startActivity(cikisYap);
                finish();
            }
        });

        button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gorselAramayaGec = new Intent(AnasayfaMain.this, gorselArama.class);
                startActivity(gorselAramayaGec);
            }
        });

        buttonArsiv = findViewById(R.id.buttonArsiv);
        buttonArsiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent arsivimeGec = new Intent(AnasayfaMain.this, arsivimMain.class);
                startActivity(arsivimeGec);
            }
        });

        imageView = findViewById(R.id.imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent hakkimizdayaGec = new Intent(AnasayfaMain.this, fragmentHakkimizda.class);
                startActivity(hakkimizdayaGec);
            }
        });







    }
}
