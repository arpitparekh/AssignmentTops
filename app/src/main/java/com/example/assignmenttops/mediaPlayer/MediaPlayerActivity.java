package com.example.assignmenttops.mediaPlayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.widget.SeekBar;

import com.example.assignmenttops.R;
import com.example.assignmenttops.databinding.ActivityMediaPlayerBinding;

public class MediaPlayerActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener,MediaPlayer.OnCompletionListener {
    private ActivityMediaPlayerBinding binding;
    private MediaPlayer mMediaPlayer;
    private Handler handler=new Handler();

    Runnable runnable=new Runnable() {
        @Override
        public void run() {
            int duration=mMediaPlayer.getDuration(); //in millisecond
            binding.tvTotalDuration.setText(getTimeFromMillis(duration));

            int currentPosition=mMediaPlayer.getCurrentPosition(); // in millisecond
            binding.tvCurrentPosition.setText(getTimeFromMillis(currentPosition));

            handler.postDelayed(this,1000);

            int progress=(currentPosition*100)/duration;
            binding.seekBarSong.setProgress(progress);

        }
    };

    private String getTimeFromMillis(int duration) {
        int hour=duration/(60*60*1000);
        int min=(duration%(60*60*1000))/(60*1000);
        int sec=((duration%(60*60*1000))%(60*1000))/1000;
        return hour+":"+min+":"+sec;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMediaPlayerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.imageViewMusic.setOnClickListener(v -> {
            if(mMediaPlayer==null){
                mMediaPlayer=MediaPlayer.create(this,R.raw.song);
                mMediaPlayer.start();
                binding.imageViewMusic.setImageResource(R.drawable.ic_pause);
            }else{

                if(mMediaPlayer.isPlaying()){
                    mMediaPlayer.pause();
                    binding.imageViewMusic.setImageResource(R.drawable.ic_play);
                }else{
                    mMediaPlayer.start();
                    binding.imageViewMusic.setImageResource(R.drawable.ic_pause);
                }
            }
        });

        binding.seekBarSong.setOnSeekBarChangeListener(this);

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if(mMediaPlayer!=null && fromUser){
            int duration=mMediaPlayer.getDuration();
            int currentPosition = (progress*duration)/100;
            mMediaPlayer.seekTo(currentPosition);

        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        mMediaPlayer.release();
        mMediaPlayer=null;
        mMediaPlayer = MediaPlayer.create(this, R.raw.song);
        mMediaPlayer.start();
        binding.imageViewMusic.setImageResource(android.R.drawable.ic_media_pause);
        handler.postDelayed(runnable,1000);
        mMediaPlayer.setOnCompletionListener(this);


    }
}