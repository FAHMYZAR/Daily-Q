package com.my.daily;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.my.daily.Component.Utils;

public class SplashActivity extends AppCompatActivity {
    public static boolean splashloaded;
    static boolean crackerdetect = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.pikapi);
        mediaPlayer.start();
        mediaPlayer.setVolume(5.5f,5.5f);
        final Animation animation = AnimationUtils.loadAnimation(this, R.anim.bounce);
        final ImageView logo = findViewById(R.id.imgrotation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            int repeatCount = 0;
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if (repeatCount < 1) {
                    logo.startAnimation(animation);
                    repeatCount++;
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        logo.startAnimation(animation);
        Utils.navbarwindows(SplashActivity.this, R.color.colorAccent);
        final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mediaPlayer.stop();
                    splashloaded = true;
                    crackerdetect = true;
                    startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                    finish();
                }
            }, 3000);
    }
}



