package com.example.assignmenttops.intent_action;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.widget.Toast;

import com.example.assignmenttops.databinding.ActivityDifferentActionsBinding;

public class DifferentActionsActivity extends AppCompatActivity {
    private static final int REQUEST_PHONE_CALL = 100;
    private static final int REQUEST_SMS = 101;
    private ActivityDifferentActionsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDifferentActionsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnPhoneIntent.setOnClickListener(v -> {
            String number=binding.edtPhoneIntent.getText().toString();
            Intent callIntent=new Intent(Intent.ACTION_DIAL);
            callIntent.setData(Uri.parse("tel:"+number));

            if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE},REQUEST_PHONE_CALL);
            }
            else
            {
                startActivity(callIntent);
            }
        });
        binding.btnMessage.setOnClickListener(v -> {
            String number=binding.edtPhoneMessageIntent.getText().toString();
            String message=binding.edtMessageIntent.getText().toString();
//             Intent msgIntent=new Intent(Intent.ACTION_VIEW);
//             msgIntent.setData(Uri.parse("to :"+number));
//             msgIntent.putExtra("sms",message);
//
//
//             if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
//                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS},REQUEST_SMS);
//            }
//            else
//            {
//                startActivity(msgIntent);
//            }
            try {
                //send message using intent
                SmsManager manager = SmsManager.getDefault();
                manager.sendTextMessage(number, null, message, null, null);
                Toast.makeText(this, "Send SuccessFully", Toast.LENGTH_SHORT).show();
            }catch (Exception e){
                Toast.makeText(getApplicationContext(),"Send Fail",Toast.LENGTH_SHORT).show();
            }

        });
        binding.btnMailIntent.setOnClickListener(v -> {
            String email=binding.edtEmailIntent.getText().toString();
            String message=binding.edtMessageInMail.getText().toString();
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:")); // only email apps should handle this
            intent.putExtra(Intent.EXTRA_EMAIL, email);
            intent.putExtra(Intent.EXTRA_SUBJECT, message);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        });
    }
}