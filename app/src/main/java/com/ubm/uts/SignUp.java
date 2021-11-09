package com.ubm.uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {


    EditText username,email, password, repass, identification;
    RadioGroup rgjenisk;
    RadioButton rbjenisk;
    Button ButtonCreate, ButtonLogin;
    SqliteHelper DB;
    String jeniskelamin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        username = findViewById(R.id.editUsername);
        identification = findViewById(R.id.editID);
        email = findViewById(R.id.editEmail);
        password = findViewById(R.id.editPwd);
        repass = findViewById(R.id.editRePwd);
        rgjenisk = findViewById(R.id.rgJenisKelamin);
        DB = new SqliteHelper(this);

        ButtonCreate = findViewById(R.id.btnCreate);
        ButtonCreate.setOnClickListener(view -> {

            //Take Edit Texts Values
            String usern = username.getText().toString();
            String e_mail = email.getText().toString();
            String pass = password.getText().toString();
            String id = identification.getText().toString();
            String repasswd = repass.getText().toString();

            //Take Radio Button
            int radioId = rgjenisk.getCheckedRadioButtonId();
            rbjenisk = findViewById(radioId);
            jeniskelamin = rbjenisk.getText().toString();


            if(usern.equals("")||pass.equals("")||e_mail.equals("")||repasswd.equals("")||id.equals(""))
                Toast.makeText(SignUp.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
            else{
                if(pass.equals(repasswd)){
                    Boolean checkuser = DB.checkusername(usern);
                    if(checkuser == false){
                        Boolean insert = DB.insertData(usern,pass,id,jeniskelamin,e_mail);
                        if (insert){
                            Intent intent = new Intent(getApplicationContext(), Login.class);
                            startActivity(intent);
                        }

                    }
                    else{
                        Toast.makeText(SignUp.this, "User already exists!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        ButtonLogin = findViewById(R.id.btnLogin);
        ButtonLogin.setOnClickListener(view -> {
            Intent Login = new Intent(SignUp.this, Login.class);
            startActivity(Login);
        });
    }

    public void checkButton(View v){
        int radioId = rgjenisk.getCheckedRadioButtonId();
        rbjenisk = findViewById(radioId);
    }
}