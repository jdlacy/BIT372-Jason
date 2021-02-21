package com.example.unitcoverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button fbtn = findViewById(R.id.convert_btn);
        Button kgbtn = findViewById(R.id.convert_btn1);

        EditText finput = findViewById(R.id.user_input);
        TextView ctxt = findViewById(R.id.celcius_text);
        TextView kgtext = findViewById(R.id.kg_text);

        kgbtn.setOnClickListener(v ->{
            if (lbinput.getText().length() == 0)
                return;
            float kg = Converter.toKiloG(Float.parseFloat(lbinput.getText().toString()));
            kgtext.setText(String.format("%.3f kg", kg));   
        });

        fbtn.setOnClickListener(v -> {
            if (finput.getText().length() == 0)
                return;
            double celcius = Converter.toCelcius(Float.parseFloat(finput.getText().toString()));
            ctxt.setText(String.format("%.2f ºC", celcius));
        });


    }
}