package com.example.assignmenttops.text_to_speech;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;

import com.example.assignmenttops.databinding.ActivityMyTextToSpeechBinding;

import java.util.Locale;

public class MyTextToSpeech extends AppCompatActivity {
    private ActivityMyTextToSpeechBinding binding;
    private TextToSpeech tts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMyTextToSpeechBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        tts=new TextToSpeech(this, status -> {
            if(status==TextToSpeech.SUCCESS){
                tts.setLanguage(Locale.US);
                tts.setSpeechRate(0.5f);
                tts.setPitch(0.5f);
            }
        });
        binding.btnSubmit.setOnClickListener(v->{
            String text=binding.edtEditText.getText().toString();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                tts.speak(text,TextToSpeech.QUEUE_FLUSH,null,null);
            }else{
                tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

    }
}