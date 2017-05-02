package com.foodhero.volunteer.volunteer;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Map extends AppCompatActivity {
    Button b;
    String email=null;
    private EditText exp_time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map);

        exp_time = (EditText) findViewById(R.id.editText);
        b=(Button)findViewById(R.id.button2);
        b.setOnClickListener(imgButtonHandler);

    }
    View.OnClickListener imgButtonHandler = new View.OnClickListener() {

        public void onClick(View v) {
            final FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference mRef = database.getReference().child("Request_Database");
            //fRef=new Firebase("https://foodhero-volunteer.firebaseio.com/Request_Database");

        /*Intent r=getIntent();
        Bundle b=r.getExtras();
        String rw=b.getString("email");*/



            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            if (user != null) {
                // Name, email address, and profile photo Url
                String name = user.getDisplayName();
                email = user.getEmail();
                Uri photoUrl = user.getPhotoUrl();



                // The user's ID, unique to the Firebase project. Do NOT use this value to
                // authenticate with your backend server, if you have one. Use
                // FirebaseUser.getToken() instead.
                String uid = user.getUid();

                mRef.addListenerForSingleValueEvent(new com.google.firebase.database.ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        Iterable<DataSnapshot> children=dataSnapshot.getChildren();

                        //String email = user.getEmail();
                        boolean flag=false;
                        String tim=exp_time.getText().toString();

                        for(DataSnapshot child: children){
                            String vid=child.child("volid").getValue(String.class);

                            if(vid.equals(email))
                            {


                                //Map<String, String> has=new Map<String, String>();
                                //has.put("flag","1");
                                 child.getRef().child("exp_time").setValue(tim);


                                flag=true;
                                break;
                            }
                        }


                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }


                });



            }
            Toast.makeText(Map.this,"Hurry up!Donor Waiting....",Toast.LENGTH_LONG).show();
            b.setBackgroundResource(R.drawable.buttoni);
            //exp_time.setText(" ");

        }
    };
}
