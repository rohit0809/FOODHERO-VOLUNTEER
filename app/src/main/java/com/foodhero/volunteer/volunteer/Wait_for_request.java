package com.foodhero.volunteer.volunteer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;

public class Wait_for_request extends AppCompatActivity {
Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wait_for_request);
    b=(Button)findViewById(R.id.button);
        b.setOnClickListener(imgButtonHandler);
        //sdmkndj
//jknkncjksdjknckndsk
}
    View.OnClickListener imgButtonHandler = new View.OnClickListener() {

        public void onClick(View v) {
            b.setBackgroundResource(R.drawable.buttoni);
            Intent i1=new Intent(Wait_for_request.this,Donor_details.class);
            startActivity(i1);
        }
    };
}