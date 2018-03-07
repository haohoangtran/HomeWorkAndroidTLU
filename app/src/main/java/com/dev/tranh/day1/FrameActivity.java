package com.dev.tranh.day1;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FrameActivity extends AppCompatActivity {
    @BindView(R.id.tvName)
    TextView tvName;
    @BindView(R.id.ivClick)
    ImageView ivClick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);
        ButterKnife.bind(this);
        ivClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ivClick.setVisibility(View.GONE);
                tvName.setTextColor(Color.RED);
                tvName.setTextSize(32);
            }
        });
        tvName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(FrameActivity.this, StyleActivity.class);
                FrameActivity.this.startActivity(myIntent);
            }
        });
    }
}
