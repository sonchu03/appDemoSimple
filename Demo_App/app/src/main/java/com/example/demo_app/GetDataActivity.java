package com.example.demo_app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GetDataActivity extends AppCompatActivity {
    private static final String tag = "Acivity";
    TextView textView;
    Button button;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_get_data);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        button = findViewById(R.id.homemainBTN);
        textView = findViewById(R.id.receiver_data);
        Intent intent = getIntent();
        String str = intent.getStringExtra("Mes_data");
        textView.setText(str);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent1);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(tag,"onStart được gọi");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(tag,"onResume được gọi");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(tag,"onPause được gọi");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(tag,"onStop được gọi");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(tag,"onDestroy được gọi");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(tag,"onRestart được gọi");
    }
}