package com.example.demo_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity implements LoginInterface{
    EditText edtUser,edtPassword;
    Button button,button2;
    TextView mes;
    private LoginPresenter mloginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        nhom();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickLogin();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });


    }
    private void nhom(){
        edtPassword = findViewById(R.id.Text_Password);
        edtUser = findViewById(R.id.Text_User);
        button = findViewById(R.id.LoginBTN);
        mloginPresenter = new LoginPresenter(this);
        mes = findViewById(R.id.message);
        button2 = findViewById(R.id.homeBTN);
    }
    public  void clickLogin(){
        String strUser = edtUser.getText().toString().trim();
        String strPassword = edtPassword.getText().toString().trim();
        User user = new User(strUser,strPassword);
        mloginPresenter.Login(user);
    }
    @Override
    public void loginSuccess() {
        mes.setVisibility(View.VISIBLE);
        mes.setText("login success");
        mes.setTextColor(ContextCompat.getColor(this, com.google.android.material.R.color.material_dynamic_neutral60));
    }

    @Override
    public void loginError() {
        mes.setVisibility(View.VISIBLE);
        mes.setText("login false");
        mes.setTextColor(ContextCompat.getColor(this, com.google.android.material.R.color.material_blue_grey_800));
    }
}