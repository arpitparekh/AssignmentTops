package com.example.assignmenttops.broadcast_receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.EditText;

import com.example.assignmenttops.databinding.ActivityBroadcastBinding;

public class MyReceiver extends BroadcastReceiver {
    private EditText edtOtp;
    private static final String TAG = "MyReceiver";

    public MyReceiver(EditText etOtp) {
        this.edtOtp=etOtp;
    }

    public MyReceiver(){

    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        if(intent.getAction().equals(Intent.ACTION_AIRPLANE_MODE_CHANGED)) {
            Log.i(TAG, "Airplane mode onReceive");
        }else if(intent.getAction().equals(Intent.ACTION_BATTERY_LOW)){
            Log.i(TAG, "Batter Low onReceive");
        }else if(intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")){
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
                SmsMessage messages[]=Telephony.Sms.Intents.getMessagesFromIntent(intent);
                for(SmsMessage sms : messages)
                {
                    String from = sms.getOriginatingAddress();
                    String msg = sms.getMessageBody();
                    // here we are spliting the sms using " : " symbol
                    String otp = msg.split(": ")[1];
                    //editText.setText(otp);
                    Log.i(TAG, from);
                    Log.i(TAG, msg);
                    edtOtp.setText(otp);
                }
            }
        }
    }
}
