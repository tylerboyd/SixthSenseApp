package com.example.sixthsenseapp.settings;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.example.sixthsenseapp.R;

public class tab1 extends Fragment {

    private Button button1;
    private Button button2;
    private Button button3;

    private Switch switch1;
    private Switch switch2;

    private int timer = 15;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab1, container, false);

        button1 = (Button) v.findViewById(R.id.buttonMinus);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer = timer - 5;
                Toast toast = Toast.makeText(v.getContext(), "Timer Minus 5 min: " + timer, Toast.LENGTH_LONG);
                toast.show();
            }
        });

        button2 = (Button) v.findViewById(R.id.buttonPlus);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer = timer + 5;
                Toast toast = Toast.makeText(v.getContext(), "Timer Plus 5 min: " + timer, Toast.LENGTH_LONG);
                toast.show();
            }
        });

        button3 = (Button) v.findViewById(R.id.buttonInfo);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(v.getContext(), "Further Information Available In The Future", Toast.LENGTH_LONG);
                toast.show();
            }
        });

        Switch switch1 = (Switch) v.findViewById(R.id.switch1);
        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast toast = Toast.makeText(buttonView.getContext(), "ON", Toast.LENGTH_LONG);
                } else {
                    Toast toast = Toast.makeText(buttonView.getContext(), "OFF", Toast.LENGTH_LONG);
                }
            }
        });

        Switch switch2 = (Switch) v.findViewById(R.id.switch2);
        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast toast = Toast.makeText(buttonView.getContext(), "ON", Toast.LENGTH_LONG);
                } else {
                    Toast toast = Toast.makeText(buttonView.getContext(), "OFF", Toast.LENGTH_LONG);
                }
            }
        });

        return v;
    }

}
