package com.example.yesilarsiv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class KayitSayfasiMain extends AppCompatActivity {

    private EditText editText,editText6, editText5, editText2, editText3, editText4;
    private TextView textView2, textViewToast;
    private Spinner spinner;
    private Button button;
    private ArrayList<String> meslekler = new ArrayList<>();
    private ArrayAdapter<String> mesleklerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_kayit_sayfasi2);

        spinner = findViewById(R.id.spinner);
        button = findViewById(R.id.buttonArsiv);
        editText = findViewById(R.id.editText);
        editText6 = findViewById(R.id.editText6);
        editText5 = findViewById(R.id.editText5);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        editText4 = findViewById(R.id.editText4);

        meslekler.add("");
        meslekler.add("Avcılık ve Yaban Hayatı");
        meslekler.add("Çiçek Düzenleme");
        meslekler.add("Orman Mühendisliği");
        meslekler.add("Orman Endüstri Mühendisliği");
        meslekler.add("Peyzaj Mimarlığı");
        meslekler.add("Sulama Teknolojisi");
        meslekler.add("Süs Bitkileri Yetiştiriciliği");
        meslekler.add("Yaban Hayatı Ekolojisi ve Yönetimi");
        meslekler.add("Diğer");

        mesleklerAdapter = new ArrayAdapter<String>(KayitSayfasiMain.this, android.R.layout.simple_list_item_2, android.R.id.text1, meslekler);
        spinner.setAdapter(mesleklerAdapter);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                activityArasiVeriTasima nesne = new activityArasiVeriTasima();

                View tasarimToast = getLayoutInflater().inflate(R.layout.toast_tasarim, null);
                TextView textViewToast = tasarimToast.findViewById(R.id.textViewToast);
                textViewToast.setText("  Kayıt işlemin gerçekleşti. Lütfen Giriş yap! :)  ");

                Toast toastTasarim = new Toast(KayitSayfasiMain.this);
                toastTasarim.setView(tasarimToast);
                toastTasarim.setDuration(Toast.LENGTH_LONG);
                toastTasarim.show();

                Intent girisSayfasinaGecis = new Intent(KayitSayfasiMain.this, MainActivity.class);
                finish();
                startActivity(girisSayfasinaGecis);
            }
        });









    }
}
