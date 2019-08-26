package com.example.sixthsenseapp.Settings;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.sixthsenseapp.R;

public class tab2 extends Fragment {

    private Button minusButton1;
    private Button plusButton1;
    private Button minusButton2;
    private Button plusButton2;
    private Button minusButton3;
    private Button plusButton3;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab2, container, false);

        minusButton1 = (Button) v.findViewById(R.id.minusbutton1);
        minusButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(v.getContext(), "Reduce Minimum", Toast.LENGTH_LONG);
                toast.show();
            }
        });


        plusButton1 = (Button) v.findViewById(R.id.plusbutton1);
        plusButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(v.getContext(), "Increase Minimum", Toast.LENGTH_LONG);
                toast.show();
            }
        });

        minusButton2 = (Button) v.findViewById(R.id.minusbutton2);
        minusButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(v.getContext(), "Reduce Maximum", Toast.LENGTH_LONG);
                toast.show();
            }
        });

        plusButton2 = (Button) v.findViewById(R.id.plusbutton2);
        plusButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(v.getContext(), "Increase Maximum", Toast.LENGTH_LONG);
                toast.show();
            }
        });

        minusButton3 = (Button) v.findViewById(R.id.minusbutton3);
        minusButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(v.getContext(), "Decrease Timer", Toast.LENGTH_LONG);
                toast.show();
            }
        });

        plusButton3 = (Button) v.findViewById(R.id.plusbutton3);
        plusButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(v.getContext(), "Increase Timer", Toast.LENGTH_LONG);
                toast.show();
            }
        });



        return v;
    }
}
