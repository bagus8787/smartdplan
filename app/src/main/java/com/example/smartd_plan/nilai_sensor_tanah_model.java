package com.example.smartd_plan;

import android.os.Parcel;
import android.os.Parcelable;

public class nilai_sensor_tanah_model {
    String kelembaban;
    String suhu;

    public nilai_sensor_tanah_model(String kelembaban, String suhu) {
        this.kelembaban = kelembaban;
        this.suhu = suhu;
    }

    public String getKelembaban() {
        return kelembaban;
    }

    public void setKelembaban(String kelembaban) {
        this.kelembaban = kelembaban;
    }


    public String getSuhu() {
        return suhu;
    }

    public void setSuhu(String suhu) {
        this.suhu = suhu;
    }
}

