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

    private int minutes = 15;
    private int hours = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab1, container, false);

        startTime = v.findViewById(R.id.starttime);
        button1 = (Button) v.findViewById(R.id.buttonMinus);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                minutes = minutes - 5;
                if(minutes <= 0)
                {
                    minutes = 0;
                    hours = hours - 1;
                }
                if(hours <= 0)
                {
                    hours = 24;
                }
                startTime.setText(hours + ":" + minutes);
                Toast toast = Toast.makeText(v.getContext(), "Timer Minus 5 min. Hours:" +hours + "Minutes" + minutes, Toast.LENGTH_LONG);
                toast.show();
            }
        });

        button2 = (Button) v.findViewById(R.id.buttonPlus);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                minutes = minutes + 5;
                if(minutes >= 60)
                {
                    minutes = 0;
                    hours = hours + 1;
                }
                if(hours >= 24)
                {
                    hours = 0;
                }
                startTime.setText(hours + ":" + minutes);
                Toast toast = Toast.makeText(v.getContext(), "Timer Plus 5 min. Hours:" +hours + "Minutes" + minutes, Toast.LENGTH_LONG);
                toast.show();
            }
        });


        Switch switch1 = (Switch) v.findViewById(R.id.switch1);
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

        Switch switch2 = (Switch) v.findViewById(R.id.switch2);
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
