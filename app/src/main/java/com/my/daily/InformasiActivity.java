package com.my.daily;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.my.daily.Component.Utils;

public class InformasiActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informasi);
        Utils.navbarwindows(InformasiActivity.this, R.color.colorAccent);

    }
}
