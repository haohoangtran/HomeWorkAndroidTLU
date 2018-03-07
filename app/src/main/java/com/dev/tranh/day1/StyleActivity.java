package com.dev.tranh.day1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class StyleActivity extends AppCompatActivity {
    @BindView(R.id.bt_small)
    Button btSmall;
    @BindView(R.id.bt_large)
    Button btLarge;
    @BindView(R.id.tv_hello)
    TextView tvHello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_style);
        ButterKnife.bind(this);
        btSmall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvHello.setTextSize(20);
            }
        });
        btLarge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvHello.setTextSize(25);
            }
        });
        tvHello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(StyleActivity.this, EditTextActivity.class);
                StyleActivity.this.startActivity(myIntent);
            }
        });
    }

}
