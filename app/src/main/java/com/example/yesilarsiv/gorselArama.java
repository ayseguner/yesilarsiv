package com.example.yesilarsiv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Switch;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class gorselArama extends AppCompatActivity {

    private CheckBox checkBox, checkBox2;
    private RadioButton radioButton, radioButton2, radioButton3, radioButton5, radioButton6, radioButton7;
    private Switch switch1;
    private Button button4;
    private ProgressBar progressBar;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gorsel_arama);

        checkBox = findViewById(R.id.checkBox);
        checkBox2 = findViewById(R.id.checkBox2);
        radioButton = findViewById(R.id.radioButton);
        radioButton2 = findViewById(R.id.radioButton2);
        radioButton3 = findViewById(R.id.radioButton3);
        radioButton5 = findViewById(R.id.radioButton5);
        radioButton6 = findViewById(R.id.radioButton6);
        radioButton7 = findViewById(R.id.radioButton7);
        switch1 = findViewById(R.id.switch1);
        button4 = findViewById(R.id.button4);
        progressBar = findViewById(R.id.progressBar3);
        fab = findViewById(R.id.fab2);

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressBar.setVisibility(View.VISIBLE);

                Boolean pembe = checkBox.isChecked();
                Boolean beyaz = checkBox2.isChecked();
                Boolean konik = radioButton3.isChecked();
                Boolean sutun = radioButton2.isChecked();
                Boolean piramit = radioButton.isChecked();
                Boolean pul = radioButton7.isChecked();
                Boolean igne = radioButton6.isChecked();
                Boolean genis = radioButton5.isChecked();
                Boolean dagilan = switch1.isChecked();

                Log.e("Pembe Durum", String.valueOf(pembe));
                Log.e("Beyaz Durum", String.valueOf(beyaz));
                Log.e("Konik Durum", String.valueOf(konik));
                Log.e("Sütun Durum", String.valueOf(sutun));
                Log.e("Piramit Durum", String.valueOf(piramit));
                Log.e("Pul Durum", String.valueOf(pul));
                Log.e("İğne Durum", String.valueOf(igne));
                Log.e("Geniş Durum", String.valueOf(genis));
                Log.e("Dağılan Durum", String.valueOf(dagilan));


            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent arsivimeGit = new Intent(gorselArama.this, arsivimMain.class);
                startActivity(arsivimeGit);
            }
        });
        
    }
}
