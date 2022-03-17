package com.example.assignmenttops.dialog_assignment;

import android.app.TimePickerDialog;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.assignmenttops.R;
import com.example.assignmenttops.databinding.FragmentTotalTimeBinding;

import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TotalTimeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TotalTimeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TotalTimeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TotalTimeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TotalTimeFragment newInstance(String param1, String param2) {
        TotalTimeFragment fragment = new TotalTimeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    private FragmentTotalTimeBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentTotalTimeBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnStartTime.setOnClickListener(v -> {
            Calendar calendar=Calendar.getInstance();
            int hour=calendar.get(Calendar.HOUR);
            int minute=calendar.get(Calendar.MINUTE);
            TimePickerDialog.OnTimeSetListener listener=(view2,hour1,minute1)->{
                binding.btnStartTime.setText(hour1+":"+minute1);
                String startTime=hour1+":"+minute1;
            };
            TimePickerDialog dialog=new TimePickerDialog(getContext(),listener,hour,minute,true);
            dialog.show();
        });
        binding.btnEndTime.setOnClickListener(v -> {
            Calendar calendar1=Calendar.getInstance();
            int hour=calendar1.get(Calendar.HOUR);
            int minute=calendar1.get(Calendar.MINUTE);
            TimePickerDialog.OnTimeSetListener listener=(view2,hour1,minute1)->{
                binding.btnEndTime.setText(hour1+":"+minute1);
                String endTime=hour1+":"+minute1;
            };
            TimePickerDialog dialog=new TimePickerDialog(getContext(),listener,hour,minute,true);
            dialog.show();
        });

        binding.btnTotalTime.setOnClickListener(v -> {
            try {
//                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm a");

                String startTime = binding.btnStartTime.getText().toString();
                String endTime = binding.btnEndTime.getText().toString();

//                Date time1 = simpleDateFormat.parse(startTime);
//                Date time2 = simpleDateFormat.parse(endTime);
//
//                long difference = time2.getTime() - time1.getTime();
//                long days = (int) (difference / (1000 * 60 * 60 * 24));
//                long hours = (int) ((difference - (1000 * 60 * 60 * 24 * days)) / (1000 * 60 * 60));
//                //min = (int) (difference - (1000*60*60*24*days) - (1000*60*60*hours)) / (1000*60);
//                binding.tvTotalTime.setText(String.valueOf((int) hours));
//            }catch(Exception e){
//                binding.tvTotalTime.setText(e.toString());
//            }
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
                Date time1 = simpleDateFormat.parse(startTime);
                Date time2 = simpleDateFormat.parse(endTime);

                long difference = time1.getTime() - time2.getTime();
                if (difference < 0) {
                    Date dateMax = simpleDateFormat.parse("24:00");
                    Date dateMin = simpleDateFormat.parse("00:00");
                    difference = (dateMax.getTime() - time1.getTime()) + (time2.getTime() - dateMin.getTime());
                }
                int days = (int) (difference / (1000 * 60 * 60 * 24));
                int hours = (int) ((difference - (1000 * 60 * 60 * 24 * days)) / (1000 * 60 * 60));
                int min = (int) (difference - (1000 * 60 * 60 * 24 * days) - (1000 * 60 * 60 * hours)) / (1000 * 60);
                binding.tvTotalTime.setText("Hours: " + hours + ", Mins: " + min);
            }catch(Exception e){
                binding.tvTotalTime.setText(e.toString());
            }
//            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm", Locale.ENGLISH);
//
//
//
//            LocalTime start = LocalTime.parse(startTime, timeFormatter);
//            LocalTime end = LocalTime.parse(endTime, timeFormatter);
//
//            Duration diff = Duration.between(start, end);
//
//            long hours = diff.toHours();
//            long minutes = diff.minusHours(hours).toMinutes();
//            String totalTimeString = String.format("%02d:%02d", hours, minutes);
//            binding.tvTotalTime.setText(totalTimeString);
//
        });


    }
}