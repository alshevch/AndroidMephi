package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText text;
    private Button butt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.text=findViewById(R.id.InputText);
        this.butt=findViewById(R.id.ViewText);

        butt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                SecondActivity.start(MainActivity.this,
                        text.getText().toString());
            }
        });
    }
}
