package com.example.assignmenttops.passobject;

import android.os.Parcel;
import android.os.Parcelable;

public class Cars implements Parcelable {

    private String name;

    private int serviceNumber;

    public  Cars(){

    }

    public Cars(String name, int serviceNumber) {
        this.name = name;
        this.serviceNumber = serviceNumber;
    }

    protected Cars(Parcel in) {
        name = in.readString();
        serviceNumber = in.readInt();
    }

    public static final Creator<Cars> CREATOR = new Creator<Cars>() {
        @Override
        public Cars createFromParcel(Parcel in) {
            return new Cars(in);
        }

        @Override
        public Cars[] newArray(int size) {
            return new Cars[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getServiceNumber() {
        return serviceNumber;
    }

    public void setServiceNumber(int serviceNumber) {
        this.serviceNumber = serviceNumber;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(serviceNumber);
    }
}
