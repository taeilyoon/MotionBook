package com.example.yuntaeil.motionbooks.Views.Splash;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.yuntaeil.motionbooks.R;
import com.example.yuntaeil.motionbooks.Views.MainTabControllerActivity;

public class SplashActivity extends AppCompatActivity {


    static final String TAG = "SplashScreenActivity";
    final int delayMilliSeconds = 1700;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }
    void StartWaiting() {
        handler.postDelayed(r , delayMilliSeconds);
    }

    @Override
    protected void onResume() {
        super.onResume();
        StartWaiting();
    }
    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacks(r);
    }

    Handler handler = new Handler();
    Runnable r= new Runnable()
    {
        @Override
        public void run() {
            MoveToNextActivity();
        }
    };

    public void MoveToNextActivity(){
        //TODO:: CHECK Update
        Intent intent = new Intent(this, MainTabControllerActivity.class);
        startActivity(intent);
        finish();
    }
}
