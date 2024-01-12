package com.example.drinkfoodshop.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.drinkfoodshop.R;
import com.example.drinkfoodshop.loginAndRegister.intro;
import com.google.firebase.auth.FirebaseAuth;

public class homeActivity extends AppCompatActivity {
    private Button btnSignout;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSignout = findViewById(R.id.btnLogOut);
        mAuth = FirebaseAuth.getInstance();
        btnSignout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(homeActivity.this, intro.class);
                startActivity(intent);
                finish();
            }
        });
    }
}