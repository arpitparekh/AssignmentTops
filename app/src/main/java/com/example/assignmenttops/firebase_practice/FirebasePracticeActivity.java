package com.example.assignmenttops.firebase_practice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.assignmenttops.MainActivity;
import com.example.assignmenttops.R;
import com.example.assignmenttops.databinding.ActivityFirebasePracticeBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import static android.content.ContentValues.TAG;

public class FirebasePracticeActivity extends AppCompatActivity {
    private ActivityFirebasePracticeBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityFirebasePracticeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//
//        FirebaseMessaging.getInstance().getToken()
//                .addOnCompleteListener(new OnCompleteListener<String>() {
//                    @Override
//                    public void onComplete(@NonNull Task<String> task) {
//                        if (!task.isSuccessful()) {
//                            Log.i(TAG, "Fetching FCM registration token failed", task.getException());
//                            return;
//                        }
//
//                        // Get new FCM registration token
//                        String token = task.getResult();
//
//                        // Log and toast
//
//                        Log.i("token",token);
//                    }
//                });




        binding.btnFirebase.setOnClickListener(v -> {
            FirebaseDatabase database=FirebaseDatabase.getInstance();
            DatabaseReference reference=database.getReference("persons").push();

            MyData data=new MyData("arpit","parekh","arpitparekh9@gmailcom");
            reference.setValue(data);

        });

        readValue();


    }

    private void readValue() {

        FirebaseDatabase database=FirebaseDatabase.getInstance();
        DatabaseReference reference=database.getReference("persons");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                ArrayList<HashMap<String,MyData>>dataList=new ArrayList<>();
                Iterator<DataSnapshot>iterator=snapshot.getChildren().iterator();
                while(iterator.hasNext()){
                    DataSnapshot childSnapshot=iterator.next();
                    String key=childSnapshot.getKey();
                    MyData data=childSnapshot.getValue(MyData.class);
                    HashMap<String,MyData> hashMap=new HashMap<>();
                    hashMap.put(key,data);
                    dataList.add(hashMap);

                }
                    binding.tvFirebase.setText(dataList.toString());
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}