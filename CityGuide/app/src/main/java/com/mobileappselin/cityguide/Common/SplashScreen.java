package com.mobileappselin.cityguide.Common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.mobileappselin.cityguide.Common.LoginSignUp.Startup_Screen;
import com.mobileappselin.cityguide.R;
import com.mobileappselin.cityguide.User.UserDashboard;

public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_TIMER = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(getApplicationContext(), Startup_Screen.class);
                startActivity(intent);
                finish();

            }
        },SPLASH_TIMER);


    }
}