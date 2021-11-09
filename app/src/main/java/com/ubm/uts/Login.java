package com.ubm.uts;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    EditText identification, password;
    Button ButtonSignUp, ButtonLogin;
    SqliteHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        identification = findViewById(R.id.editID);
        password = findViewById(R.id.editPwd);
        ButtonSignUp =  findViewById(R.id.btnSignup);
        ButtonLogin = findViewById(R.id.btnLogin);
        DB = new SqliteHelper(this);

        ButtonLogin.setOnClickListener(view -> {
            String id = identification.getText().toString();
            String pass = password.getText().toString();
    

            if(id.equals("")||pass.equals(""))
                Toast.makeText(Login.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
            else{
                Boolean checkidpass = DB.checkidpassword(id,pass);
                if(checkidpass) {
                    Toast.makeText(Login.this, "Log in successful!!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), Home.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(Login.this, "Invalid login credentials", Toast.LENGTH_SHORT).show();
                }

            }
        });
        ButtonSignUp.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), SignUp.class);
            startActivity(intent);
        });
    }

}