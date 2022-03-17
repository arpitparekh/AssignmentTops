//package com.example.assignmenttops.realm_database;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.app.AlertDialog;
//import android.content.DialogInterface;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
//import android.widget.Toast;
//
//import com.example.assignmenttops.R;
//import com.example.assignmenttops.databinding.ActivityRealmPracticeBinding;
//
//
//import io.realm.Realm;
//import io.realm.RealmConfiguration;
//import io.realm.RealmResults;
//
//public class RealmPracticeActivity extends AppCompatActivity {
//    private ActivityRealmPracticeBinding binding;
//    private Realm realm;
//    private NewUser theUser = null;
//    private RealmResults<NewUser> userList;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        binding = ActivityRealmPracticeBinding.inflate(getLayoutInflater());
//
//        setContentView(binding.getRoot());
//
//        Realm.init(this);
//
//        RealmConfiguration configuration = new RealmConfiguration.Builder()
//                .allowWritesOnUiThread(true)
//                .name(getString(R.string.app_name))
//                .build();
//
//
//        realm = Realm.getInstance(configuration);
//
//        getAllUser();
//
//        binding.listViewRealm.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                showAlertDialog(position);
//            }
//        });
//        binding.btnSubmitRealm.setOnClickListener(v -> {
//            if (theUser == null) {
//
//                insertUser();
//
//            } else {
//
//                updateUser(theUser.id);
//            }
//
//        });
//    }
//
//    private void showAlertDialog(int position) {
//        new AlertDialog.Builder(this)
//                .setTitle("Choose One")
//                .setPositiveButton("Edit", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        theUser = userList.get(position);
//                        binding.edtIdRealm.setText(String.valueOf(theUser.id));
//                        binding.edtFirstNameRealm.setText(theUser.firstname);
//                        binding.edtLastNameRealm.setText(theUser.lastname);
//                        binding.edtEmailRealm.setText(theUser.email);
//
//                        binding.edtIdRealm.setEnabled(false);
//
//                    }
//                })
//                .setNegativeButton("Delete", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        theUser = userList.get(position);
//                        deleteUser(theUser.id);
//                    }
//                })
//                .create().show();
//    }
//
//
//    private void getAllUser() {
//        userList = realm.where(NewUser.class).findAll();
//        ArrayAdapter<NewUser> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, userList);
//        binding.listViewRealm.setAdapter(adapter);
//    }
//
//    public void reset() {
//        theUser = null;
//        binding.edtIdRealm.setText("");
//        binding.edtFirstNameRealm.setText("");
//        binding.edtLastNameRealm.setText("");
//        binding.edtEmailRealm.setText("");
//        binding.edtIdRealm.setEnabled(true);
//    }
//
//    private void updateUser(int id) {
//        realm.executeTransaction(transactionRealm -> {
//            NewUser theUser = transactionRealm.where(NewUser.class).equalTo("id", id).findFirst();
//            theUser.firstname = binding.edtFirstNameRealm.getText().toString();
//            theUser.lastname = binding.edtLastNameRealm.getText().toString();
//            theUser.email = binding.edtEmailRealm.getText().toString();
//        });
//        reset();
//        getAllUser();
//    }
//
//    private void deleteUser(int id) {
//        realm.executeTransaction(transactionRealm -> {
//            NewUser theUser = transactionRealm.where(NewUser.class).equalTo("id", id).findFirst();
//            assert theUser != null;
//            theUser.deleteFromRealm();
//        });
//        reset();
//        getAllUser();
//    }
//
//    private void insertUser() {
//        NewUser theUser = new NewUser();
//        theUser.id = Integer.parseInt(binding.edtIdRealm.getText().toString());
//        theUser.firstname = binding.edtFirstNameRealm.getText().toString();
//        theUser.lastname = binding.edtLastNameRealm.getText().toString();
//        theUser.email = binding.edtEmailRealm.getText().toString();
//
//        realm.executeTransaction(transactionRealm -> {
//            transactionRealm.insert(theUser);
//            Toast.makeText(this, "User Saved !!!", Toast.LENGTH_SHORT).show();
//        });
//        getAllUser();
//        reset();
//
//    }
//}