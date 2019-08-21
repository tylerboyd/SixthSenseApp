package com.example.sixthsenseapp.Setup;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.sixthsenseapp.R;

public class SetupComplete extends AppCompatActivity {

    private ImageView backgroundImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_complete);

        backgroundImage = findViewById(R.id.backgroundImage);

        int imageResource = getResources().getIdentifier("@drawable/setupcomplete", null, this.getPackageName());
        backgroundImage.setImageResource(imageResource);
    }
}
