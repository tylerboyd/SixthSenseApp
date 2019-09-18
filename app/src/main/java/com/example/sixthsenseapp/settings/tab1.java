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
import android.widget.TextView;
import android.widget.Toast;

import com.example.sixthsenseapp.R;

public class tab1 extends Fragment {

    private Button button1;
    private Button button2;
    private TextView startTime;

    private Switch switch1;
    private Switch switch2;

    Boolean stateAutoActivate;
    Boolean stateNightLight;

    private int minutes = 0;
    private int hours = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab1, container, false);

        startTime = v.findViewById(R.id.starttime);
        button1 = v.findViewById(R.id.buttonMinus);
        switch1 = v.findViewById(R.id.switch1);
        switch2 = v.findViewById(R.id.switch2);

        startTime.setText(hours + ":" + minutes);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(hours != 0 && minutes == 0)
                {
                    hours--;
                }
                else if(hours == 0 && minutes == 0)
                {
                    hours = 23;
                }

                minutes = minutes - 5;

                if(minutes < 0)
                {
                    minutes = 55;
                }
                startTime.setText(hours + ":" + minutes);
                Toast toast = Toast.makeText(v.getContext(), "Timer Minus 5 min. Hours: " +hours + " Minutes" + minutes, Toast.LENGTH_LONG);
                toast.show();
            }
        });

        button2 = v.findViewById(R.id.buttonPlus);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(hours != 23 && minutes == 55)
                {
                    hours++;
                }
                else if(hours == 23 && minutes == 55)
                {
                    hours = 0;
                }

                minutes = minutes + 5;

                if(minutes == 60)
                {
                    minutes = 0;
                }
                startTime.setText(hours + ":" + minutes);
                Toast toast = Toast.makeText(v.getContext(), "Timer Plus 5 min. Hours:" +hours + "Minutes" + minutes, Toast.LENGTH_LONG);
                toast.show();
            }
        });

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast toast = Toast.makeText(buttonView.getContext(), "ON", Toast.LENGTH_LONG);
                    toast.show();
                    stateAutoActivate = true;
                } else {
                    Toast toast = Toast.makeText(buttonView.getContext(), "OFF", Toast.LENGTH_LONG);
                    toast.show();
                    stateAutoActivate = false;
                }
            }
        });

        switch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast toast = Toast.makeText(buttonView.getContext(), "ON", Toast.LENGTH_LONG);
                    toast.show();
                    stateNightLight = true;

                } else {
                    Toast toast = Toast.makeText(buttonView.getContext(), "OFF", Toast.LENGTH_LONG);
                    toast.show();
                    stateNightLight = false;
                }
            }
        });

        return v;
    }
}
