package com.example.sixthsenseapp.settings;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.example.sixthsenseapp.R;

public class tab3 extends Fragment {

    private Switch careCircle;
    private Switch bloodSugar;
    private Switch insuCalc;
    private Switch library;
    private Switch preScript;
    private Switch achievements;

    Boolean careCircleOn;
    Boolean bloodSugarOn;
    Boolean insuCalcOn;
    Boolean libraryOn;
    Boolean preScriptOn;
    Boolean achievementsOn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab3, container, false);

        Switch careCircle = (Switch) v.findViewById(R.id.carecircle);
        careCircle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast toast = Toast.makeText(buttonView.getContext(), "ON", Toast.LENGTH_LONG);
                    toast.show();
                    careCircleOn = true;
                } else {
                    Toast toast = Toast.makeText(buttonView.getContext(), "OFF", Toast.LENGTH_LONG);
                    toast.show();
                    careCircleOn = false;
                }
            }
        });

        Switch bloodSugar = (Switch) v.findViewById(R.id.bloodsugar);
        bloodSugar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast toast = Toast.makeText(buttonView.getContext(), "ON", Toast.LENGTH_LONG);
                    toast.show();
                    bloodSugarOn = true;
                } else {
                    Toast toast = Toast.makeText(buttonView.getContext(), "OFF", Toast.LENGTH_LONG);
                    toast.show();
                    bloodSugarOn = false;
                }
            }
        });

        Switch insuCalc = (Switch) v.findViewById(R.id.insucalc);
        insuCalc.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast toast = Toast.makeText(buttonView.getContext(), "ON", Toast.LENGTH_LONG);
                    toast.show();
                    insuCalcOn = true;
                } else {
                    Toast toast = Toast.makeText(buttonView.getContext(), "OFF", Toast.LENGTH_LONG);
                    toast.show();
                    insuCalcOn = false;
                }
            }
        });

        Switch library = (Switch) v.findViewById(R.id.library);
        library.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast toast = Toast.makeText(buttonView.getContext(), "ON", Toast.LENGTH_LONG);
                    toast.show();
                    libraryOn = true;
                } else {
                    Toast toast = Toast.makeText(buttonView.getContext(), "OFF", Toast.LENGTH_LONG);
                    toast.show();
                    libraryOn = false;
                }
            }
        });

        Switch preScript = (Switch) v.findViewById(R.id.prescript);
        preScript.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast toast = Toast.makeText(buttonView.getContext(), "ON", Toast.LENGTH_LONG);
                    toast.show();
                    preScriptOn = true;
                } else {
                    Toast toast = Toast.makeText(buttonView.getContext(), "OFF", Toast.LENGTH_LONG);
                    toast.show();
                    preScriptOn = false;
                }
            }
        });

        Switch achievements = (Switch) v.findViewById(R.id.achievements);
        achievements.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast toast = Toast.makeText(buttonView.getContext(), "ON", Toast.LENGTH_LONG);
                    toast.show();
                    achievementsOn = true;
                } else {
                    Toast toast = Toast.makeText(buttonView.getContext(), "OFF", Toast.LENGTH_LONG);
                    toast.show();
                    achievementsOn = false;
                }
            }
        });

        return v;
    }
}
