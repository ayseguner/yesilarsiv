package com.example.yesilarsiv;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class arsivimMain extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private Toolbar toolbar;
    private FloatingActionButton fab2;
    private RecyclerView rv;
    private ArrayList<arsivim> arsivimListesi;
    private arsivimAdapter adapter;
    private veritabani vt;
    private String textViewNot;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arsivim_main);

        toolbar = findViewById(R.id.toolbar);
        rv = findViewById(R.id.rv);

        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));

  //      arsivimListesi = new ArrayList<>();


        vt = new veritabani(this);

        arsivimListesi = new arsivDao().tumArsivim(vt);

        adapter = new arsivimAdapter(this,arsivimListesi,vt);
        rv.setAdapter(adapter);

        toolbar.setTitle("  ARŞİVİM");
   //     toolbar.setSubtitle(" Görsel Arama ");
        toolbar.setLogo(R.drawable.kapalidosya);
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorPrimaryDark));

        setSupportActionBar(toolbar);

        fab2 = findViewById(R.id.fab2);

        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertGoster();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.arsivimtoolbar_menu, menu);

        MenuItem menuItem = menu.findItem(R.id.action_arama);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(this);


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            case R.id.action_anasayfa:
                Intent anasayfayaGit = new Intent(arsivimMain.this, AnasayfaMain.class);
                startActivity(anasayfayaGit);
                return true;
            case R.id.action_arama:
                SearchView searchView = (SearchView) item.getActionView();
                searchView.setOnQueryTextListener(this);
                return true;
            case R.id.action_ayarlar:
                //Ayarlara git
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        Log.e("onQueryTextSubmit",query);



        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        Log.e("onQueryTextChange",newText);

        arsivimListesi = new arsivDao().araArsivim(vt, newText);

        adapter = new arsivimAdapter(this,arsivimListesi,vt);
        rv.setAdapter(adapter);



        return false;
    }

    public void alertGoster(){

        LayoutInflater layout = LayoutInflater.from(this);
        View view = layout.inflate(R.layout.alert_tasarim,null);

        final EditText editTextNotYaz = view.findViewById(R.id.editTextNotYaz);

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Not Ekleyiniz :");
        alert.setView(view);

        alert.setPositiveButton("Kaydet", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String textViewNot = editTextNotYaz.getText().toString().trim();
                new arsivDao().notEkle(vt,textViewNot);


            }
        });

        alert.setNegativeButton("Vazgeç", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        alert.create().show();


    }

}
