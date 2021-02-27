package com.example.unitcoverter;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    UnitViewModel vm;

    @RequiresApi(api = Build.VERSION_CODES.R)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText userEntryBox = findViewById(R.id.user_input);

        vm = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(UnitViewModel.class);
        final Observer<String> userObserver = new Observer<String>() {
            @Override
            public void onChanged(String s) {
                if (!(s.length() == 0))
                    userEntryBox.setText(s);
            }
        };

        vm.getUserText().observe(this, userObserver);

        //Conversion selection creation (spinner)
        Spinner conType = findViewById(R.id.convert_pick);
        ArrayAdapter<CharSequence> types =
                ArrayAdapter.createFromResource(this, R.array.units, android.R.layout.simple_spinner_item);
        types.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        conType.setAdapter(types);


        //Functionality & logic for button &input
        Button conButton = findViewById(R.id.convert_btn);
        conButton.setOnClickListener(v -> {
                    if (TextUtils.isEmpty(userEntryBox.getText())) {
                        Toast.makeText(this, "Please enter a number first", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    double entry = Double.parseDouble(userEntryBox.getText().toString());
                    switch (conType.getSelectedItemPosition()) {
                        case 0:
                            vm.getUserText().setValue(Double.toString(Converter.toCelsius(entry)));
                            return;

                        case 1:
                            vm.getUserText().setValue(Double.toString(Converter.toKiloG(entry)));
                            return;

                        case 2:
                            vm.getUserText().setValue(Double.toString(Converter.toML(entry)));
                            return;

                        case 3:
                            vm.getUserText().setValue(Double.toString(Converter.toKM(entry)));
                            return;

                        default:
                            return;
                    }
                }
            );

        }
    }