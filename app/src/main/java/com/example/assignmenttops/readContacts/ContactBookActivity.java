package com.example.assignmenttops.readContacts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.example.assignmenttops.databinding.ActivityContactBookBinding;

import java.util.ArrayList;

public class ContactBookActivity extends AppCompatActivity {
    private ActivityContactBookBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityContactBookBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<Contact> contacts = getAllContact();
        ArrayAdapter<Contact> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, contacts);
        binding.listViewContact.setAdapter(adapter);
    }

    private ArrayList<Contact> getAllContact() {

        ArrayList<Contact> contactList = new ArrayList<>();



        // getRawContactsIdList
        ContentResolver resolver = getContentResolver();
        // Row contacts content uri( access raw_contacts table. ).
        Uri rawContactUri = ContactsContract.RawContacts.CONTENT_URI;
        // Return _id column in contacts raw_contacts table.
        String queryColumnArr[] = {ContactsContract.RawContacts._ID};

        Cursor cursor = resolver.query(rawContactUri, queryColumnArr, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
            do {

                int rawContactId = cursor.getInt(cursor.getColumnIndex(ContactsContract.RawContacts._ID));
                // Data content uri (access data table.)

                Uri dataContentUri = ContactsContract.Data.CONTENT_URI;
                String selection = ContactsContract.Data.RAW_CONTACT_ID + "=" + rawContactId;
                Cursor dataCursor = resolver.query(dataContentUri, null, selection, null, null);
                if (dataCursor != null) {
                    dataCursor.moveToFirst();

                    do {
                        Contact contact=new Contact();
                        String mimeTYpe = dataCursor.getString(dataCursor.getColumnIndex(ContactsContract.Data.MIMETYPE));
                        switch (mimeTYpe) {
//                            case ContactsContract.CommonDataKinds.Email.CONTENT_ITEM_TYPE:
//                                String emailAddress = dataCursor.getString(dataCursor.getColumnIndex(ContactsContract.CommonDataKinds.Email.ADDRESS));
//                                break;
                            case ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE:
                                String displayName = dataCursor.getString(dataCursor.getColumnIndex(ContactsContract.CommonDataKinds.StructuredName.DISPLAY_NAME));
                                contact.Name=displayName;

                                break;
                            case ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE:
                                String phoneNumber = dataCursor.getString(dataCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                                contact.phoneNumber=phoneNumber;
                                contactList.add(contact);
                                break;
                        }

                    } while (dataCursor.moveToNext());
                    dataCursor.close();
                }

            } while (cursor.moveToNext());
            cursor.close();
        }

        return contactList;
    }
};
