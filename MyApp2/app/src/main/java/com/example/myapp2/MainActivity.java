package com.example.myapp2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Olga Shevchuk");

        final EditText message = findViewById(R.id.editText);
        Button toSend = findViewById(R.id.enterButton);
        ImageButton vkSend = findViewById(R.id.address1);
        ImageButton instSend = findViewById(R.id.address2);
        ImageButton gitSend = findViewById(R.id.address3);
        LinearLayout textLayout = findViewById(R.id.textLayout);

        TextView text = new TextView(this);
        LinearLayout.LayoutParams textParams= new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, //width
                ViewGroup.LayoutParams.MATCH_PARENT //height
        );
        textParams.gravity = Gravity.CENTER_HORIZONTAL;

        text.setLayoutParams(textParams);
        text.setText("© 2018 Olga Shevchuk");

        textLayout.addView(text);

        toSend.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ShowToast")
            @Override
            public void onClick(View v) {
                String mess = message.getText().toString();
                Intent intent =new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto: helga-she@mail.ru"));
                intent.putExtra(Intent.EXTRA_SUBJECT, "App2");
                intent.putExtra(Intent.EXTRA_TEXT,mess) ;

                if (intent.resolveActivity(getPackageManager())!=null){
                    startActivity(intent);
                }else {
                    Toast.makeText(MainActivity.this,R.string.error,Toast.LENGTH_LONG);
                }
            }
        });

        vkSend.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ShowToast")
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://vk.com/id151704407"));
                if (intent.resolveActivity(getPackageManager())!=null){
                    startActivity(intent);
                }else {
                    Toast.makeText(MainActivity.this, getString(R.string.error), Toast.LENGTH_LONG);
                }
            }
        });

        instSend.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ShowToast")
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.instagram.com/alena_shchk/"));
                if (intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this,getString(R.string.error), Toast.LENGTH_LONG);
                }
            }
        });

        gitSend.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ShowToast")
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://github.com/alshevch"));
                if (intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this,getString(R.string.error), Toast.LENGTH_LONG);
                }
            }
        });

    }
}
