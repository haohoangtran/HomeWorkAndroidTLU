package com.dev.tranh.day1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EditTextActivity extends AppCompatActivity {
    @BindView(R.id.tv_Name)
    TextView tvName;
    @BindView(R.id.et_Name)
    EditText etName;
    @BindView(R.id.bt_summit)
    Button btSummit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);
        ButterKnife.bind(this);
        btSummit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvName.setText(etName.getText()+" dang hoc android");
            }
        });
    }
}
