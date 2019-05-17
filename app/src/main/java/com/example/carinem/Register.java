package com.example.carinem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends AppCompatActivity {
    EditText user,password;
    Button registerhere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        user=(EditText)findViewById(R.id.username);
        password=(EditText) findViewById(R.id.password);
        registerhere=(Button)findViewById(R.id.registerhere);
        registerhere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent me=new Intent(Register.this,MainActivity.class);
                startActivity(me);
            }
        });
    }
}
