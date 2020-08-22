package com.example.smartd_plan;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    SimpleLineChart mSimpleLineChart;

    DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference sensor_tanah = rootRef.child("monitoring").child("sensor_tanah").child("array");

    List<sensor_tanah_model> list= new ArrayList <>();
    ArrayList keys = new ArrayList<String>();

    sensor_tanah_model sensor_tanah_model;
    nilai_sensor_tanah_model nilai_sensor_tanah_model;

    String arrayKelembaban;

    int jml_kelembaban = 0;

//    String[] xItem;
//    String[] yItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSimpleLineChart = (SimpleLineChart) findViewById(R.id.simpleLineChart);

//        getFirebase();

        sensor_tanah.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                sensor_tanah_model qsnapshot = dataSnapshot.getValue(sensor_tanah_model.class);
                assert qsnapshot != null;
                list.add(new sensor_tanah_model(qsnapshot.getKelembaban(),qsnapshot.getSuhu()));
                keys.add(dataSnapshot.getValue());
                Collections.shuffle(list);

//                Dictionary<Integer, String> dict = new Hashtable<Integer, String>();

                Log.d("aaa","aaa" + keys);

//                arrayKelembaban = sensor_tanah_model.getKelembaban();
//                updatequestion();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
                int index = keys.indexOf(dataSnapshot.getKey());
                list.remove(index);
                Collections.shuffle(list);
//                updatequestion();
                keys.remove(index);
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

//        String simpleArray = keys.get("kelembaban");

//        jml_kelembaban = keys.size();

        String[] xItem = {"8"};
        String[] yItem = {"10k","20k","30k","40k","50k"};
        if(mSimpleLineChart == null)
            Log.e("wing","null!!!!");
            Log.d("TAG", "K" + xItem);
        mSimpleLineChart.setXItem(xItem);
        mSimpleLineChart.setYItem(yItem);
        HashMap<Integer,Integer> pointMap = new HashMap();
        for(int i = 0;i<xItem.length;i++){
            pointMap.put(i, (int) (Math.random()*5));
        }
        mSimpleLineChart.setData(pointMap);

    }

//    private void getFirebase() {
//
//        sensor_tanah.addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//                sensor_tanah_model qsnapshot = dataSnapshot.getValue(sensor_tanah_model.class);
//                assert qsnapshot != null;
//                list.add(new sensor_tanah_model(qsnapshot.getKelembaban(),qsnapshot.getSuhu()));
//                keys.add(dataSnapshot.getKey());
//                Collections.shuffle(list);
//            }
//
//            @Override
//            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//            }
//
//            @Override
//            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
//                int index = keys.indexOf(dataSnapshot.getKey());
//                list.remove(index);
//                Collections.shuffle(list);
////                updatequestion();
//                keys.remove(index);
//            }
//
//            @Override
//            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });


//    }
}