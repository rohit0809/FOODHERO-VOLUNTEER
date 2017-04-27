package com.foodhero.volunteer.volunteer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Map extends AppCompatActivity {
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map);
        b=(Button)findViewById(R.id.button2);
        b.setOnClickListener(imgButtonHandler);

    }
    View.OnClickListener imgButtonHandler = new View.OnClickListener() {

        public void onClick(View v) {
            b.setBackgroundResource(R.drawable.buttoni);

        }
    };
}
