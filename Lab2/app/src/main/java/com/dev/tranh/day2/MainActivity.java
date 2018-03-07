package com.dev.tranh.day2;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.cbCream)
    CheckBox cbCream;
    @BindView(R.id.cbSugar)
    CheckBox cbSugar;
    @BindView(R.id.bt_Summit)
    Button btSummit;
    @BindView(R.id.cbShowtoast)
    CheckBox cbShowToast;
    @BindView(R.id.llCb)
    LinearLayout llCb;
    @BindView(R.id.llRb)
    LinearLayout llRb;
    @BindView(R.id.cb_Bai2)
    CheckBox cbBai2;
    @BindView(R.id.bt_SummitRb)
    Button btSummitRb;
    @BindView(R.id.rgCoffee)
    RadioGroup rgCoffee;
    @BindView(R.id.spMain)
    Spinner spMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        btSummit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cbShowToast.isChecked()) {
                    String str = cbCream.isChecked() ? "Cream " : "";
                    str += cbSugar.isChecked() ? str.isEmpty() ? "Sugar" : "& Sugar" : "";
                    Toast.makeText(MainActivity.this, str, Toast.LENGTH_LONG).show();
                } else {
                    final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Information!!!")
                            .setMessage("Are you sure to exit?")
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .setPositiveButton("Yes", new
                                    DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int
                                                which) {
                                            MainActivity.this.finish();
                                        }
                                    })
                            .setNegativeButton("No", new
                                    DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int
                                                which) {
                                        }
                                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
            }
        });
        btSummitRb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = "";
                if (rgCoffee.getCheckedRadioButtonId() == R.id.rbCream) {
                    str = "Cream ";
                }
                if (rgCoffee.getCheckedRadioButtonId() == R.id.rbSugar) {
                    str ="Sugar";
                }
                Toast.makeText(MainActivity.this, str, Toast.LENGTH_LONG).show();
            }
        });
        cbBai2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    llRb.setVisibility(View.VISIBLE);
                    llCb.setVisibility(View.GONE);
                } else {
                    llCb.setVisibility(View.VISIBLE);
                    llRb.setVisibility(View.GONE);
                }
            }
        });
        final ArrayList<String> arrayList=new ArrayList<>();
        arrayList.add("hi");
        arrayList.add("ha");
        spMain.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arrayList));
        spMain.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, arrayList.get(i),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(MainActivity.this, "Nothing",Toast.LENGTH_LONG).show();
            }
        });
    }
}
