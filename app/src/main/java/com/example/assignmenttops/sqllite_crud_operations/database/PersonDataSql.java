package com.example.assignmenttops.sqllite_crud_operations.database;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class PersonDataSql implements Parcelable {

    @PrimaryKey
    public int id;

    @ColumnInfo(name="first_Name")
    public String firstName;

    @ColumnInfo(name="last_Name")
    public String lastName;

    @ColumnInfo(name="email")
    public String email;


    public PersonDataSql(Parcel in) {
        id = in.readInt();
        firstName = in.readString();
        lastName = in.readString();
        email = in.readString();
    }

    public static final Creator<PersonDataSql> CREATOR = new Creator<PersonDataSql>() {
        @Override
        public PersonDataSql createFromParcel(Parcel in) {
            return new PersonDataSql(in);
        }

        @Override
        public PersonDataSql[] newArray(int size) {
            return new PersonDataSql[size];
        }
    };

    public PersonDataSql() {

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(firstName);
        dest.writeString(lastName);
        dest.writeString(email);
    }
}
