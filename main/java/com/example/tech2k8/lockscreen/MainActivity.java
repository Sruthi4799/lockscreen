package com.example.tech2k8.lockscreen;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


     Button num1,num2,num3,num4,num5,num6,submit,num0,clear;
     TextView passLabel;
     String password="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num0=findViewById(R.id.num_zero);
        num1=findViewById(R.id.num_one);
        num2=findViewById(R.id.num_two);
        num3=findViewById(R.id.num_three);
        num4=findViewById(R.id.num_four);
        num5=findViewById(R.id.num_five);
        num6=findViewById(R.id.num_six);
        clear=findViewById(R.id.clear);
        submit=findViewById(R.id.validate);
        passLabel=findViewById(R.id.label);
        passLabel.setText(password);

        View.OnClickListener listener =new View.OnClickListener() {
            @Override
            public void onClick(View v) {
          //      Toast.makeText(MainActivity.this, "0", Toast.LENGTH_SHORT).show();
                switch (v.getId())
                {
                    case R.id.num_zero:
                        password=password+"0";
                        passLabel.setText(password);
                        break;

                    case R.id.num_one:password=password+"1";
                        passLabel.setText(password);
                        break;

                    case R.id.num_two:
                        password=password+"2";
                        passLabel.setText(password);
                        break;

                    case R.id.num_three:
                        password=password+"3";
                        passLabel.setText(password);
                        break;

                    case R.id.num_four:
                        password=password+"4";
                        passLabel.setText(password);
                        break;

                    case R.id.num_five:
                        password=password+"5";
                        passLabel.setText(password);
                        break;

                    case R.id.num_six:
                        password=password+"6";
                        passLabel.setText(password);
                        break;

                    case R.id.validate:
                        SharedPreferences preferences =getSharedPreferences("Settings",MODE_PRIVATE);

                        String tempPass=preferences.getString("user_pass","");
                        if (tempPass.equals(password))
                        {
                            Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
                        }else
                        {
                            Toast.makeText(MainActivity.this, "Invalid", Toast.LENGTH_SHORT).show();
                            Intent settingsAct =new Intent(MainActivity.this,SettingsActivity.class);
                            settingsAct.putExtra("ids","Welcome to settings activity");
                            startActivity(settingsAct);

                        }
                        break;
                    case R.id.clear:
                        password="";
                        passLabel.setText(password);
                        break;
                }
            }
        };
        num0.setOnClickListener(listener);

        num1.setOnClickListener(listener);

        num2.setOnClickListener(listener);

        num3.setOnClickListener(listener);

        num4.setOnClickListener(listener);

        num5.setOnClickListener(listener);

        num6.setOnClickListener(listener);

        submit.setOnClickListener(listener);

        clear.setOnClickListener(listener);
    }
}
