package com.mobileappselin.cityguide.Common.LoginSignUp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.mobileappselin.cityguide.R;
import com.mobileappselin.cityguide.User.UserDashboard;

public class Login extends AppCompatActivity {

    ImageView backBtn;
    Button hesapBtn;
    Button girisYapBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        hesapBtn = findViewById(R.id.hesap_olustur_btn);
        girisYapBtn = findViewById(R.id.girisyap_btn);

        backBtn = findViewById(R.id.login_back_button);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Login.super.onBackPressed();
            }
        });

        hesapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent kaydol = new Intent(getApplicationContext(),SignUp.class);
                startActivity(kaydol);
            }
        });

        girisYapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent giris = new Intent(getApplicationContext(), UserDashboard.class);
                startActivity(giris);
            }
        });


    }
    public void tanimlama7(){
        hesapBtn = findViewById(R.id.hesap_olustur_btn);
    }
    public void tanimlama8(){
        girisYapBtn = findViewById(R.id.girisyap_btn);
    }
}