package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    private TextView vtext;
    private Button butt2;
    private String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        this.vtext=findViewById(R.id.textView);
        this.butt2=findViewById(R.id.button);

        this.message = getIntent().getStringExtra("msg");

        this.vtext.setText(this.message);

        butt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto: helga-she@mail.ru"));
                intent.putExtra(Intent.EXTRA_EMAIL, "helga-she@mail.ru");
                intent.putExtra(Intent.EXTRA_SUBJECT, "App1");
                intent.putExtra(Intent.EXTRA_TEXT, message);

                if (intent.resolveActivity(getPackageManager())!=null){
                    startActivity(intent);
                }else {
                    Toast.makeText(SecondActivity.this,R.string.Error,Toast.LENGTH_LONG);
                }
            }
        });
    }

    public static void start(Activity activity, String msg){
        Intent intent = new Intent();
        intent.setClass(activity, SecondActivity.class);
        intent.putExtra("msg", msg);
        activity.startActivity(intent);

    }
}
