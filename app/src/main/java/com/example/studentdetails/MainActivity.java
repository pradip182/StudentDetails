package com.example.studentdetails;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etname;
    RadioGroup rdogrp;
    RadioButton rdomale, rdofemale, rdoothers;
    Spinner spcountry;
    TextView tvname, tvgender, tvcountry, tvbatch;
    AutoCompleteTextView actvbatch;
    String[] batch = {"22A", "22B", "22C"};
    Button btnsave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvbatch = findViewById(R.id.tvbatch);
        tvgender = findViewById(R.id.tvgender);
        tvcountry = findViewById(R.id.tvcountry);
        tvname = findViewById(R.id.tvname);
        etname = findViewById(R.id.etname);
        rdogrp = findViewById(R.id.rdogrp);
        rdomale = findViewById(R.id.rdomale);
        rdofemale = findViewById(R.id.rdofemale);
        rdoothers = findViewById(R.id.rdoother);
        spcountry = findViewById(R.id.spcountry);
        actvbatch = findViewById(R.id.actvbatch);
        btnsave = findViewById(R.id.btnsave);


        String countries[] = {"Nepal", "India", "Bhutan", "Pakistan", "China"};

        ArrayAdapter adapter = new ArrayAdapter<>
                (this, android.R.layout.simple_list_item_1, countries
                );

        spcountry.setAdapter(adapter);

        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>
                (this, android.R.layout.simple_list_item_1, batch);

        actvbatch.setAdapter(stringArrayAdapter);
        actvbatch.setThreshold(1);


        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = rdogrp.getCheckedRadioButtonId();
                RadioButton radioButton;
                radioButton =findViewById(selectedId);
                tvgender.setText(radioButton.getText());

                tvname.setText(etname.getText());
                tvbatch.setText(actvbatch.getText());
                tvcountry.setText(spcountry.getSelectedItem().toString());
            }

        });


    }


}