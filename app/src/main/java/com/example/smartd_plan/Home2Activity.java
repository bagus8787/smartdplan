package com.example.smartd_plan;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.DecelerateInterpolator;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Home2Activity extends AppCompatActivity {
    ProgressBar mprogressBar, mprogressBar_suhu, getMprogressBar_kelembaban_tanah;
    TextView txt_kelembabann, txt_suhu, txt_kelembaban_tanah;

    String value, string_nilai_kelembaban, string_nilai_suhu;
//    int nilai_kelembaban = 0;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference().child("monitoring");

    final DatabaseReference kelembaban = myRef.child("sensor_tanah").child("kelembaban");
    final DatabaseReference suhu = myRef.child("sensor_tanah").child("suhu");

    final DatabaseReference kelembaban_tanah = myRef.child("sensor_tanah").child("kelembaban");
    final DatabaseReference statusTemp = myRef.child("Temperature");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);

        mprogressBar = (ProgressBar) findViewById(R.id.circularProgressbar_kelembaban);
        mprogressBar_suhu = (ProgressBar) findViewById(R.id.circularProgressbar_suhu);

        getMprogressBar_kelembaban_tanah = findViewById(R.id.circularProgressbar_kelembaban_tanah);


        txt_kelembabann = findViewById(R.id.text_kelembaban);
        txt_suhu = findViewById(R.id.text_suhu);
        txt_kelembaban_tanah = findViewById(R.id.text_kelembaban_tanah);

        kelembaban.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                value = dataSnapshot.getValue(String.class);
                Log.d("file", "Value is: " + value);
                txt_kelembabann.setText(value+"%");
//
                string_nilai_kelembaban = value;
                Log.d("file", "ooooooooooo is: " + string_nilai_kelembaban);

                int nilai_kelembaban = Integer.parseInt(value);
                Log.d("file", "k is: " + nilai_kelembaban);

                ObjectAnimator anim = ObjectAnimator.ofInt(mprogressBar, "SecondaryProgress", 0, nilai_kelembaban);
                anim.setDuration(10000);
                anim.setInterpolator(new DecelerateInterpolator());
                anim.start();

            }

            @Override
            public void onCancelled(DatabaseError error) {

                Log.w("File", "Failed to read value.", error.toException());

            }
        });

        suhu.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                value = dataSnapshot.getValue(String.class);
                Log.d("file", "Value is: " + value);
                txt_suhu.setText(value+"%");
//                text_kelembaban.setText(value+"%");

//                progressBar.setSecondaryProgress(Integer.parseInt(value));
//                progressBar_kelembaban.setSecondaryProgress(Integer.parseInt(value));
                string_nilai_suhu = value;
                Log.d("file", "ooooooooooo is: " + string_nilai_suhu);

                int nilai_suhu = Integer.parseInt(value);
                Log.d("file", "k is: " + nilai_suhu);

//                mprogressBar_suhu.setSecondaryProgress(100);

//                mprogressBar_suhu.setProgress(Integer.parseInt(value));

                ObjectAnimator anim = ObjectAnimator.ofInt(mprogressBar_suhu, "SecondaryProgress", 0, nilai_suhu);
                anim.setDuration(10000);
                anim.setInterpolator(new DecelerateInterpolator());
                anim.start();

            }

            @Override
            public void onCancelled(DatabaseError error) {

                Log.w("File", "Failed to read value.", error.toException());

            }
        });

        kelembaban_tanah.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                value = dataSnapshot.getValue(String.class);
                Log.d("file", "Value is: " + value);
                txt_kelembaban_tanah.setText(value+"%");
//
                string_nilai_kelembaban = value;
                Log.d("file", "ooooooooooo is: " + string_nilai_kelembaban);

                int nilai_kelembaban = Integer.parseInt(value);
                Log.d("file", "k is: " + nilai_kelembaban);

                ObjectAnimator anim = ObjectAnimator.ofInt(getMprogressBar_kelembaban_tanah, "SecondaryProgress", 0, nilai_kelembaban);
                anim.setDuration(10000);
                anim.setInterpolator(new DecelerateInterpolator());
                anim.start();
            }

            @Override
            public void onCancelled(DatabaseError error) {

                Log.w("File", "Failed to read value.", error.toException());

            }
        });
    }
}