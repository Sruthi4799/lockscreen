package com.example.tech2k8.lockscreen;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {


    EditText password;
    Button save;
    String abc;
    SharedPreferences preferences;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);

        String msg = getIntent().getStringExtra("ids");
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        preferences=getSharedPreferences("Settings", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor =preferences.edit();

        password=findViewById(R.id.user_password);
        save=findViewById(R.id.save);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp=password.getText().toString();
                editor.putString("user_pass",temp).commit();

            }
        });

    }
}
