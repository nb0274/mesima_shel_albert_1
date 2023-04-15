package com.example.mesima103;

import static java.lang.Integer.parseInt;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mesimashelalberto1.R;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText a_parameter;
    EditText b_parameter;
    EditText c_parameter;
    TextView selution_text;
    Button randomize;
    Button to_selution;
    int descrim;
    double x1;
    double x2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        a_parameter = (EditText) findViewById(R.id.a_parameter);
        b_parameter = (EditText) findViewById(R.id.b_parameter);
        c_parameter = (EditText) findViewById(R.id.c_parameter);
        selution_text = (TextView) findViewById(R.id.selution_text);
        randomize = (Button) findViewById(R.id.randomize);
        to_selution = (Button) findViewById(R.id.to_selution);
    }

    public void onClickRandomize(View view) {
        Random rand = new Random();
        int a = rand.nextInt(100);
        int b = rand.nextInt(100);
        int c = rand.nextInt(100);

        a_parameter.setText(String.valueOf(a));
        b_parameter.setText(String.valueOf(b));
        c_parameter.setText(String.valueOf(c));
    }

    public void onClickSelution(View view) {
        if(a_parameter.getText().toString() != null && b_parameter.getText().toString() != null && c_parameter.getText().toString() != null)
        {
            Intent si = new Intent(this, MainActivity2.class);

            si.putExtra("a", parseInt(a_parameter.getText().toString()));
            si.putExtra("b", parseInt(b_parameter.getText().toString()));
            si.putExtra("c", parseInt(c_parameter.getText().toString()));
            startActivityForResult(si, 1);
        }

    }

    protected void onActivityResult(int source, int good, @Nullable Intent data_back) {
        super.onActivityResult(source, good, data_back);
        if (data_back != null) {
            descrim = data_back.getIntExtra("descrim", -1);
            x1 = data_back.getDoubleExtra("x1", -1);
            x2 = data_back.getDoubleExtra("x2", -1);

            if(descrim == 0){
                selution_text.setText("no selutions");
            }
            if(descrim == 1){
                selution_text.setText("x1: " + x1);
            }
            if(descrim == 2){
                selution_text.setText("x1: " + x1 + "," + "x2: " + x2);
            }
        }
    }
}