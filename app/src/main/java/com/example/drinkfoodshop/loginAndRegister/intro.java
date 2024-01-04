package com.example.drinkfoodshop.loginAndRegister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.drinkfoodshop.R;

public class intro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.intro);
    }

    public void dangKy(View view) {
        startActivity(new Intent(intro.this,RegisterActivity.class));
    }
    public void dangNhap(View view) {
        startActivity(new Intent(intro.this,LoginActivity.class));
    }

}