package com.example.smartd_plan;

import android.os.Parcel;
import android.os.Parcelable;

public class sensor_tanah_model implements Parcelable {
    public String kelembaban;
    public String suhu;

    public sensor_tanah_model(String kelembaban, String suhu) {
        this.kelembaban = kelembaban;
        this.suhu = suhu;
    }

    public sensor_tanah_model() {

    }

    //
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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int i) {
        dest.writeString(this.kelembaban);
        dest.writeString(this.suhu);
    }

    protected sensor_tanah_model(Parcel in) {
        this.kelembaban = in.readString();
        this.suhu = in.readString();
    }

    public static final Parcelable.Creator<sensor_tanah_model> CREATOR = new Parcelable.Creator<sensor_tanah_model>() {
        @Override
        public sensor_tanah_model createFromParcel(Parcel source) {
            return new sensor_tanah_model(source);
        }

        @Override
        public sensor_tanah_model[] newArray(int size) {
            return new sensor_tanah_model[size];
        }
    };
}