package com.example.yesilarsiv;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class arsivimAdapter extends RecyclerView.Adapter<arsivimAdapter.kartTasarimTutucu>{

    private Context cont;
    private List<arsivim> notlarListesi;
    private veritabani vt;

    public arsivimAdapter() {
    }

    @NonNull
    @Override
    public kartTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //tasarimi bağlıyoruz

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_arsivim, parent, false);
        return new kartTasarimTutucu(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final kartTasarimTutucu holder, int position) {
        //kac tane veri varsa o kadar calısır
        //sırayla tıklanılma özelliklerini burada tanımlayacağız

        final arsivim arsiv = notlarListesi.get(position);

        holder.textViewNot.setText(String.valueOf(arsiv.getTextViewNot()));
   //***     holder.textViewNot.setText(arsiv.getTextViewNot()+ " -- " );

        holder.bubble.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PopupMenu popupMenu = new PopupMenu(cont , holder.bubble);
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()){
                            case R.id.sil_item:
                                Snackbar.make(holder.bubble, "Not silinsin mi?", Snackbar.LENGTH_LONG)
                                        .setAction("Evet", new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                new arsivDao().notSil(vt, arsiv.getNotId());

                                                notlarListesi = new arsivDao().tumArsivim(vt);
                                                notifyDataSetChanged();
                                            }
                                        })


                                        .show();
                                return true;
                            case R.id.duzenle_item:
                                alertGosterItem(arsiv);
                                return true;
                            default:
                                return false;



                        }
                    }
                });


                popupMenu.show();

            }
        });


    }

    @Override
    public int getItemCount() {
        //kac tane gostereceğini soruyor
        return notlarListesi.size();
    }

    public arsivimAdapter(Context cont, List<arsivim> notlarListesi, veritabani vt) {
        this.cont = cont;
        this.notlarListesi = notlarListesi;
        this.vt = vt;
    }

    public class kartTasarimTutucu extends RecyclerView.ViewHolder{
        private TextView textViewNot;
        //private CardView cv;
        private ImageView bubble;

        public kartTasarimTutucu(@NonNull View itemView) {
            super(itemView);

            textViewNot = itemView.findViewById(R.id.textViewNot);
           // cv = itemView.findViewById(R.id.cv);
            bubble = itemView.findViewById(R.id.bubble);
        }
    }

    public void alertGosterItem(final arsivim arsiv){

        LayoutInflater layout = LayoutInflater.from(cont);
        View view = layout.inflate(R.layout.alert_tasarim,null);

        final EditText editTextNotYaz = view.findViewById(R.id.textViewNot);
        editTextNotYaz.setText(arsiv.getTextViewNot());
//        new arsivDao().notGuncelle(vt,arsiv.getNotId(), arsiv.getTextViewNot());
//
//        notlarListesi = new arsivDao().tumArsivim(vt);
//        notifyDataSetChanged();
//

        AlertDialog.Builder alert = new AlertDialog.Builder(cont);
        alert.setTitle("Notu Düzenle : ");
        alert.setView(view);

        alert.setPositiveButton("Kaydet", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String textViewNot = editTextNotYaz.getText().toString().trim();

                new arsivDao().notGuncelle(vt, arsiv.getNotId(), textViewNot);

                notlarListesi = new arsivDao().tumArsivim(vt);
                notifyDataSetChanged();

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
