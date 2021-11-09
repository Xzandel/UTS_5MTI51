package com.ubm.uts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Home extends AppCompatActivity {

    private RecyclerView recyclerView, recyclerViewNews;
    catRVAdapter recyclerViewAdapter;
    newsRVAdapter recyclerViewAdapterNews;
    Button ButtonTitle, ButtonReport, ButtonProfil;

    int[] arrfoto1 = {R.drawable.cat1, R.drawable.cat2, R.drawable.cat3};
    int[] arrfoto2 = {R.drawable.barcelona1, R.drawable.barcelona2, R.drawable.barcelona3};
    String[] arrstr = {"Liga Spanyol", "Liga Inggris", "Liga Internasional"};
    String[] arrstr2 = {"Xavi Jadi Manajer Barcelona, Dua Legenda Barcelona Ikut Turun Gunung ke Camp Nou? ",
            "Janji Xavi Sebagai Pelatih Baru Barcelona: Main Cantik dan Kerja Keras",
            "Gonta-Ganti Pelatih, Barcelona Kehilangan 33 Juta Euro untuk Kompensasi"
    };
    String[] arrstr3 = {"Barcelona", "Chelsea", "PSG"};

    //019c35fbef4040b28aff747fbde0f6c1
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerView = findViewById(R.id.rvCategories);
        recyclerViewAdapter = new catRVAdapter(arrfoto1, arrstr3);
        recyclerView.setAdapter(recyclerViewAdapter);

        recyclerViewNews = findViewById(R.id.rvNews);
        recyclerViewAdapterNews = new newsRVAdapter(arrfoto2, arrstr, arrstr2);
        recyclerViewNews.setAdapter(recyclerViewAdapterNews);
        ButtonTitle = findViewById(R.id.btnTitle);
        ButtonReport = findViewById(R.id.btnReport);
        ButtonProfil = findViewById(R.id.btnProfile);

        ButtonTitle.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), AboutUs.class);
            startActivity(intent);
        });

        ButtonReport.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), profil.class);
            startActivity(intent);
        });

        ButtonProfil.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), Report.class);
            startActivity(intent);
        });
    }


}