package com.foodhero.volunteer.volunteer;

import android.content.Intent;
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

import java.util.HashMap;

public class Map extends AppCompatActivity {
    Button b,succ,track;
    String email=null,items=null,qty=null,volid=null,volph=null,slife=null,flg=null,exp_tim=null,addres=null,donid=null,volname=null;
    private EditText exp_time;
    String child_to_remove=null;
    HashMap<String,String> datamap=new HashMap<String, String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.track);

        exp_time = (EditText) findViewById(R.id.editText);
        b=(Button)findViewById(R.id.updat);

        succ=(Button)findViewById(R.id.succ);
        track=(Button)findViewById(R.id.track);

        track.setEnabled(false);

        track.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(Map.this,MapsActivity.class);
                //i1.putExtra("email",rw);
                startActivity(i1);
            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference mRef = database.getReference().child("Request_Database");




                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if (user != null) {
                    // Name, email address, and profile photo Url
                    String name = user.getDisplayName();
                    email = user.getEmail();


                    mRef.addListenerForSingleValueEvent(new com.google.firebase.database.ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            Iterable<DataSnapshot> children=dataSnapshot.getChildren();

                            //String email = user.getEmail();
                            boolean flag=false;
                            String tim=exp_time.getText().toString();

                            for(DataSnapshot child: children){
                                String vid=child.child("volid").getValue(String.class);
                                String ids=child.getKey();



                                if(vid.equals(email))
                                {

                                if(tim.length()==5) {
                                    char a = tim.charAt(0);
                                    char b = tim.charAt(1);
                                    char c = tim.charAt(2);
                                    char d = tim.charAt(3);
                                    char e = tim.charAt(4);

                                    //VERIFYING EXPECTED TIME IS IN PROPER FORMAT
                                    if (c == ':') {
                                        if (a == '0') {
                                            if (b == '1' || b == '2' || b == '0' || b == '3' || b == '4' || b == '5' || b == '6' || b == '7' || b == '8' || b == '9') {
                                                   if(d=='0'|| d=='1'||d=='2'||d=='3'||d=='4'||d=='5')
                                                   {
                                                       if(e == '1' || e == '2' || e == '0' || e == '3' || e == '4' || e == '5' || e == '6' || e == '7' || e == '8' || e == '9')
                                                       {
                                                           child_to_remove=ids;
                                                           items=child.child("itemname").getValue(String.class);
                                                           qty=child.child("quant").getValue(String.class);
                                                           slife=child.child("shelflife").getValue(String.class);
                                                           addres=child.child("add").getValue(String.class);
                                                           donid=child.child("donorid").getValue(String.class);
                                                           flg=child.child("flag").getValue(String.class);
                                                           volid=child.child("volid").getValue(String.class);
                                                           volph=child.child("volph").getValue(String.class);
                                                           volname=child.child("volunteername").getValue(String.class);

                                                           child.getRef().child("exp_time").setValue(tim);

                                                           datamap.put("exp_time",tim);
                                                           //Toast.makeText(Map.this,"Hey "+exp_tim,Toast.LENGTH_LONG).show();
                                                           datamap.put("itemaname",items);
                                                           datamap.put("quant",qty);
                                                           datamap.put("shelflife",slife);
                                                           datamap.put("add",addres);
                                                           datamap.put("flag",flg);
                                                           datamap.put("volid",volid);
                                                           datamap.put("volph",volph);
                                                           datamap.put("volunteername",volname);
                                                           datamap.put("donorid",donid);

                                                           Toast.makeText(Map.this,"Hurry up!Donor Waiting....",Toast.LENGTH_LONG).show();

                                                           flag=true;
                                                           break;
                                                       }
                                                       else
                                                           Toast.makeText(Map.this,"Wrong Format!! Enter again",Toast.LENGTH_LONG).show();
                                                   }
                                                   else
                                                       Toast.makeText(Map.this,"Wrong Format!! Enter again",Toast.LENGTH_LONG).show();
                                            }
                                            else
                                                Toast.makeText(Map.this,"Wrong Format!! Enter again",Toast.LENGTH_LONG).show();
                                        }
                                        else if(a=='1')
                                        {
                                            if (b == '1' || b == '2' || b == '0' || b == '3' || b == '4' || b == '5' || b == '6' || b == '7' || b == '8' || b == '9') {
                                                if(d=='0'|| d=='1'||d=='2'||d=='3'||d=='4'||d=='5')
                                                {
                                                    if(e == '1' || e == '2' || e == '0' || e == '3' || e == '4' || e == '5' || e == '6' || e == '7' || e == '8' || e == '9')
                                                    {
                                                        child_to_remove=ids;
                                                        items=child.child("itemname").getValue(String.class);
                                                        qty=child.child("quant").getValue(String.class);
                                                        slife=child.child("shelflife").getValue(String.class);
                                                        addres=child.child("add").getValue(String.class);
                                                        donid=child.child("donorid").getValue(String.class);
                                                        flg=child.child("flag").getValue(String.class);
                                                        volid=child.child("volid").getValue(String.class);
                                                        volph=child.child("volph").getValue(String.class);
                                                        volname=child.child("volunteername").getValue(String.class);

                                                        child.getRef().child("exp_time").setValue(tim);

                                                        datamap.put("exp_time",tim);
                                                        //Toast.makeText(Map.this,"Hey "+exp_tim,Toast.LENGTH_LONG).show();
                                                        datamap.put("itemaname",items);
                                                        datamap.put("quant",qty);
                                                        datamap.put("shelflife",slife);
                                                        datamap.put("add",addres);
                                                        datamap.put("flag",flg);
                                                        datamap.put("volid",volid);
                                                        datamap.put("volph",volph);
                                                        datamap.put("volunteername",volname);
                                                        datamap.put("donorid",donid);

                                                        Toast.makeText(Map.this,"Hurry up!Donor Waiting....",Toast.LENGTH_LONG).show();

                                                        flag=true;
                                                        break;
                                                    }
                                                    else
                                                        Toast.makeText(Map.this,"Wrong Format!! Enter again",Toast.LENGTH_LONG).show();
                                                }
                                                else
                                                    Toast.makeText(Map.this,"Wrong Format!! Enter again",Toast.LENGTH_LONG).show();
                                            }
                                            else
                                                Toast.makeText(Map.this,"Wrong Format!! Enter again",Toast.LENGTH_LONG).show();
                                        }
                                        else if(a=='2')
                                        {
                                            if (b == '1' || b == '2' || b == '0' || b == '3') {
                                                if(d=='0'|| d=='1'||d=='2'||d=='3'||d=='4'||d=='5')
                                                {
                                                    if(e == '1' || e == '2' || e == '0' || e == '3' || e == '4' || e == '5' || e == '6' || e == '7' || e == '8' || e == '9')
                                                    {
                                                        child_to_remove=ids;
                                                        items=child.child("itemname").getValue(String.class);
                                                        qty=child.child("quant").getValue(String.class);
                                                        slife=child.child("shelflife").getValue(String.class);
                                                        addres=child.child("add").getValue(String.class);
                                                        donid=child.child("donorid").getValue(String.class);
                                                        flg=child.child("flag").getValue(String.class);
                                                        volid=child.child("volid").getValue(String.class);
                                                        volph=child.child("volph").getValue(String.class);
                                                        volname=child.child("volunteername").getValue(String.class);

                                                        child.getRef().child("exp_time").setValue(tim);
                                                        //exp_tim=child.child("exp_time").getValue(String.class);
                                                        //Map<String, String> has=new Map<String, String>();
                                                        //has.put("flag","1");
                                                        datamap.put("exp_time",tim);
                                                        //Toast.makeText(Map.this,"Hey "+exp_tim,Toast.LENGTH_LONG).show();
                                                        datamap.put("itemaname",items);
                                                        datamap.put("quant",qty);
                                                        datamap.put("shelflife",slife);
                                                        datamap.put("add",addres);
                                                        datamap.put("flag",flg);
                                                        datamap.put("volid",volid);
                                                        datamap.put("volph",volph);
                                                        datamap.put("volunteername",volname);
                                                        datamap.put("donorid",donid);

                                                        Toast.makeText(Map.this,"Hurry up!Donor Waiting....",Toast.LENGTH_LONG).show();

                                                        flag=true;
                                                        break;
                                                    }
                                                    else
                                                        Toast.makeText(Map.this,"Wrong Format!! Enter again",Toast.LENGTH_LONG).show();
                                                }
                                                else
                                                    Toast.makeText(Map.this,"Wrong Format!! Enter again",Toast.LENGTH_LONG).show();
                                            }
                                            else
                                                Toast.makeText(Map.this,"Wrong Format!! Enter again",Toast.LENGTH_LONG).show();
                                        }
                                        else
                                            Toast.makeText(Map.this,"Wrong Format!! Enter again",Toast.LENGTH_LONG).show();
                                    }
                                    else
                                        Toast.makeText(Map.this,"Wrong Format!! Enter again",Toast.LENGTH_LONG).show();
                                }
                                else
                                    Toast.makeText(Map.this,"Wrong Format!! Enter again",Toast.LENGTH_LONG).show();



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

               // b.setBackgroundResource(R.drawable.buttoni);
                //exp_time.setText(" ");

            }

            }
        );

        succ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference mRef = database.getReference().child("Request_Database");
                DatabaseReference nRef = database.getReference().child("Record_Database");
                //fRef=new Firebase("https://foodhero-volunteer.firebaseio.com/Request_Database");




                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if (user != null) {

                    String name = user.getDisplayName();
                    email = user.getEmail();






                    nRef.push().setValue(datamap);
                    succ.setEnabled(false);
                    b.setEnabled(false);
                    track.setEnabled(true);
                    mRef.child(child_to_remove).removeValue();
                    Toast.makeText(Map.this,"I confirm Delivery of Food to NGO",Toast.LENGTH_LONG).show();


                }

            }
        });

    }


}
