package com.example.unitcoverter;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.unitcoverter.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    UnitViewModel vm;

    @RequiresApi(api = Build.VERSION_CODES.R)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText user_entry_box = findViewById(R.id.user_input)

        vm = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(UnitViewModel.class);
        final Observer<String> userObserver = new Observer<String>() {
            @Override
            public void onChanged(String s) {
                if (!(s.length() == 0))
                    user_entry_box.setText(s);
            }
        };

        vm.getUserText().observe(this, userObserver);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setLifecycleOwner(this);
        binding.setUnits(units);a

        //Conversion selection creation (spinner)
        Spinner conType = findViewById(R.id.convert_pick);
        ArrayAdapter<CharSequence> types =
                ArrayAdapter.createFromResource(this, R.array.units, android.R.layout.simple_spinner_item);
        types.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        conType.setAdapter(types);


        //Functionality for button/input
        Button conButton = findViewById(R.id.convert_btn);
        conButton.setOnClickListener(v -> {
                    float data = Float.parseFloat(units.getValue());
                    if (TextUtils.isEmpty(data)) {
                        Toast.makeText(this, "Please enter a number first", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    switch (conType.getSelectedItemPosition()) {
                        case 0:
                            data = Converter.toCelsius(data);
                            Toast.makeText(this, String.format("New Number: %s", data), Toast.LENGTH_SHORT).show();
                            return;

                        case 1:
                            float kg = Converter.toKiloG(data);

                        case 2:
                            float mL = Converter.toML(data);

                        case 3:
                            float km = Converter.toKM(data);

                        default:
                            return;
                    }
                }
            );

        }
    }