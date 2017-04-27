package com.foodhero.volunteer.volunteer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Donor_details extends AppCompatActivity implements OnClickListener {
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.donor_details);


        b=(Button)findViewById(R.id.button1);
        b.setOnClickListener(imgButtonHandler);

        //Example of a call to a native method
        //TextView tv = (TextView) findViewById(R.id.sample_text);
        //tv.setText(stringFromJNI());
    }
    View.OnClickListener imgButtonHandler = new View.OnClickListener() {

        public void onClick(View v) {
            b.setBackgroundResource(R.drawable.buttoni);
            Intent i1=new Intent(Donor_details.this,Map.class);
            startActivity(i1);
        }
    };
    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    //public native String stringFromJNI();

    // Used to load the 'native-lib' library on application startup.


    @Override
    public void onClick(View v) {

    }
}