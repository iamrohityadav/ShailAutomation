package com.iot.shail.automation.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.WindowManager;

import com.iot.shail.automation.R;

public class SplashActivity extends AppCompatActivity {

    Thread SplashThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //******* set action bar full screen **********
        assert getSupportActionBar() != null;
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //******* call startApp method**********
        startApp();
    }

    //******* startApp method create**********
    private void startApp() {

        SplashThread = new Thread(){
            @Override
            public void run() {
                super.run();
                int waited = 0;
                while (waited < 2500) {
                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    waited += 100;
                }

                Intent loginActivity = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(loginActivity);
                SplashActivity.this.finish();
            }
        };
        SplashThread.start();
    }
    //******* startApp method end**********
}
