package com.example.unitcoverter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.unitcoverter.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Units units = new Units("");

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setLifecycleOwner(this);
        binding.setUnits(units);

     /*   UnitViewModel vm = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(UnitViewModel.class);
        vm.*/

        //Conversion selection creation (spinner)
        Spinner conType = findViewById(R.id.convert_pick);
        ArrayAdapter<CharSequence> types =
                ArrayAdapter.createFromResource(this, R.array.units, android.R.layout.simple_spinner_item);
        types.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        conType.setAdapter(types);


        //Functionality for button/input
        Button conButton = findViewById(R.id.convert_btn);
        conButton.setOnClickListener(v -> {
                    float data = Float.parseFloat(units.value.getValue());
                    if (units.getUserInput().toString().length() == 0) {
                        Toast.makeText(this, "Please enter a number first", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    switch (conType.getSelectedItemPosition()) {
                        case 0:
                            float cel = Converter.toCelsius(data);
                            units.setValueText();

                        case 1:
                            float kg = Converter.toKiloG(data);
                            return kg;

                        case 2:
                            float mL = Converter.toML(data);
                            return mL;

                        case 3:
                            float km = Converter.toKM(data);
                            return km;

                        default:
                            return;
                    }
                }
            );

        }
    }