package com.example.drinkfoodshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class adminApp extends AppCompatActivity {
    TextView tvGet;
    Button btnPushData, btnGetData;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_app);

        editText = findViewById(R.id.editData);
        btnPushData = findViewById(R.id.btnPush);
        btnGetData = findViewById(R.id.btnGet);
        tvGet = findViewById(R.id.tvGetData);
        btnPushData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickPushData();
            }
        });
        btnGetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readDatabase();
            }
        });
    }

    private void onClickPushData() {
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://drink-food-shop-default-rtdb.asia-southeast1.firebasedatabase.app/");
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue(editText.getText().toString().trim());
    }
    private void readDatabase(){
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://drink-food-shop-default-rtdb.asia-southeast1.firebasedatabase.app/");
        DatabaseReference myRef = database.getReference("message");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange( DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);
                tvGet.setText(value);
            }

            @Override
            public void onCancelled( DatabaseError error) {

            }
        });
    }

}