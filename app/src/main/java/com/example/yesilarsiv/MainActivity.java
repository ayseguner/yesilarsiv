package com.example.yesilarsiv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
//    private ImageView imageView;
    private EditText editText;
//    private EditText editText2;
//    private Button button;
    private TextView textView;
    private Button button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent kayitSayfasinaGecis = new Intent(MainActivity.this, KayitSayfasiMain.class);
                startActivity(kayitSayfasinaGecis);
            }

        });


        button = findViewById(R.id.buttonArsiv);
        final EditText editText= findViewById(R.id.editText);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String gelenKullaniciAdi = editText.getText().toString();

                View tasarimToast = getLayoutInflater().inflate(R.layout.toast_tasarim, null);
                TextView textViewToast = tasarimToast.findViewById(R.id.textViewToast);
                textViewToast.setText("  Hoşgeldin " + gelenKullaniciAdi + "! :)  "    );

                Toast toastTasarim = new Toast(MainActivity.this);
                toastTasarim.setView(tasarimToast);
                toastTasarim.setDuration(Toast.LENGTH_LONG);
                toastTasarim.show();

                Intent anasayfayaGecis = new Intent(MainActivity.this, AnasayfaMain.class);
                finish();
                startActivity(anasayfayaGecis);
            }
        });





    }
}
