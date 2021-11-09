package com.ubm.uts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class profil extends AppCompatActivity {

    SqliteHelper DB;
    TextView username,email, password,  identification, jeniskelamin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

    }
}