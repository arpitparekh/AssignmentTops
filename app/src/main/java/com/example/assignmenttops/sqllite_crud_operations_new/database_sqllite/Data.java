package com.example.assignmenttops.sqllite_crud_operations_new.database_sqllite;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Data implements Parcelable {

    @PrimaryKey
    public int id_new;

    @ColumnInfo(name = "First Name")
    public String firstName_new;

    @ColumnInfo(name = "Last Name")
    public String lastName_new;

    @ColumnInfo(name = "Email")
    public String email_new;

    public int age;

    protected Data(Parcel in) {
        id_new = in.readInt();
        firstName_new = in.readString();
        lastName_new = in.readString();
        email_new = in.readString();
        age = in.readInt();
    }

    public static final Creator<Data> CREATOR = new Creator<Data>() {
        @Override
        public Data createFromParcel(Parcel in) {
            return new Data(in);
        }

        @Override
        public Data[] newArray(int size) {
            return new Data[size];
        }
    };

    public Data() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id_new);
        dest.writeString(firstName_new);
        dest.writeString(lastName_new);
        dest.writeString(email_new);
        dest.writeInt(age);
    }
}
