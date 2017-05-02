package com.foodhero.volunteer.volunteer;

import android.content.Intent;
import android.net.Uri;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import java.util.*;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Donor_details extends AppCompatActivity implements View.OnClickListener {
    Button b;
    //private Firebase fRef;
    private String email=null;
    private ValueEventListener mSearchedLocationReferenceListener;
    private DatabaseReference mSearchedLocationReference;
    private TextView item;
    private TextView quantity;
    private TextView shelf;
    private TextView address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.donor_details);
       /* if(!FirebaseApp.getApps(this).isEmpty()){
            FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        }*/

        b=(Button)findViewById(R.id.button1);
        b.setOnClickListener(imgButtonHandler);
        item = (TextView) findViewById(R.id.tv1);
        quantity = (TextView) findViewById(R.id.tv2);

        shelf = (TextView) findViewById(R.id.tv3);
        address = (TextView) findViewById(R.id.tv4);



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

                    for(DataSnapshot child: children){
                        String vid=child.child("volid").getValue(String.class);

                        if(vid.equals(email))
                        {
                            String items=child.child("itemname").getValue(String.class);
                            String qty=child.child("quant").getValue(String.class);
                            String slife=child.child("shelflife").getValue(String.class);
                            String addres=child.child("add").getValue(String.class);
                            //Toast.makeText(Donor_details.this,"Hey "+did,Toast.LENGTH_LONG).show();
                            item.setText("Item: "+items);
                            quantity.setText("Number of persons it can feed: "+qty);
                            shelf.setText("Shelflife: "+slife);
                            address.setText("Address: "+addres);

                            //Map<String, String> has=new Map<String, String>();
                            //has.put("flag","1");
                           // child.getRef().child("flag").setValue("1");


                            flag=true;
                            break;
                        }
                    }

                    if(!flag)
                    {
                       // Toast.makeText(Donor_details.this,"No Donor ",Toast.LENGTH_LONG).show();
                        item.setText("No Details Available. ");
                        quantity.setText("No Details Available. ");
                        shelf.setText("No Details Available.  ");
                        address.setText("No Details Available.  ");
                        b.setEnabled(false);
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }


            });



        }
        //Toast.makeText(Donor_details.this,"Hi",Toast.LENGTH_LONG).show();

        //Example of a call to a native method
        //TextView tv = (TextView) findViewById(R.id.sample_text);
        //tv.setText(stringFromJNI());
    }
    View.OnClickListener imgButtonHandler = new View.OnClickListener() {

        public void onClick(View v) {
            b.setBackgroundResource(R.drawable.buttoni);
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

                        for(DataSnapshot child: children){
                            String vid=child.child("volid").getValue(String.class);

                            if(vid.equals(email))
                            {
                               /* String items=child.child("itemname").getValue(String.class);
                                String qty=child.child("quant").getValue(String.class);
                                String slife=child.child("shelflife").getValue(String.class);
                                String addres=child.child("add").getValue(String.class);
                                //Toast.makeText(Donor_details.this,"Hey "+did,Toast.LENGTH_LONG).show();
                                item.setText("Item: "+items);
                                quantity.setText("Number of persons it can feed: "+qty);
                                shelf.setText("Shelflife: "+slife);
                                address.setText("Address: "+addres);*/

                                //Map<String, String> has=new Map<String, String>();
                                //has.put("flag","1");
                                child.getRef().child("flag").setValue("1");


                                flag=true;
                                break;
                            }
                        }

                       /* if(!flag)
                        {
                            // Toast.makeText(Donor_details.this,"No Donor ",Toast.LENGTH_LONG).show();
                            item.setText("No Details Available. ");
                            quantity.setText("No Details Available. ");
                            shelf.setText("No Details Available.  ");
                            address.setText("No Details Available.  ");
                            b.setEnabled(false);
                        }*/
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }


                });



            }
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