package com.example.yesilarsiv;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class fragmentHakkimizda extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_hakkimizda);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        MyViewPagerAdapter adapter = new MyViewPagerAdapter(getSupportFragmentManager());
        adapter.fragmentEkle(new fragmentNedir(), "YEŞİL ARŞİV NEDİR");
        adapter.fragmentEkle(new fragmentDanismanlarimiz(), "DANIŞMANLARIMIZ");
        adapter.fragmentEkle(new fragmentIletisim(), "İNSAN KAYNAKLARI");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }

    class MyViewPagerAdapter extends FragmentPagerAdapter{
        private final List<Fragment> fragmentListesi = new ArrayList<>();
        private final List<String> fragmentBaslikListesi = new ArrayList<>();

        public MyViewPagerAdapter(FragmentManager manager){
            super(manager);

        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragmentListesi.get(position);
        }

        @Override
        public int getCount() {
            return fragmentListesi.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return fragmentBaslikListesi.get(position);
        }

        public void fragmentEkle(Fragment fragment, String baslik){
            fragmentListesi.add(fragment);
            fragmentBaslikListesi.add(baslik);

        }
    }
}
