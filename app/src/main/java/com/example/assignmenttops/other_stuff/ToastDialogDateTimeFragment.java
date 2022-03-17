package com.example.assignmenttops.other_stuff;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.assignmenttops.R;
import com.example.assignmenttops.databinding.FragmentToastDialogDateTimeBinding;

import org.jetbrains.annotations.NotNull;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ToastDialogDateTimeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ToastDialogDateTimeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ToastDialogDateTimeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ToastDialogDateTimeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ToastDialogDateTimeFragment newInstance(String param1, String param2) {
        ToastDialogDateTimeFragment fragment = new ToastDialogDateTimeFragment();
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


    private FragmentToastDialogDateTimeBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentToastDialogDateTimeBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btntoast.setOnClickListener(v -> {
            CustomToast("This is message");
        });
        binding.btndialog.setOnClickListener(v -> {
            AlertDialog.Builder builder=new AlertDialog.Builder(getContext());
            builder.setTitle("This is Demo");
            builder.setMessage("This is demo message");
            builder.setIcon(R.mipmap.ic_launcher);
            builder.setCancelable(false);



            builder.setPositiveButton("Yes",((dialog, which) -> {
                CustomToast("Yes is Clicked");
            }));

            builder.setNegativeButton("No",((dialog, which) -> {
                CustomToast("No is Clicked");
            }));
            builder.setNeutralButton("Cancel",((dialog, which) -> {
                CustomToast("Cancel is Clicked");
            }));

            AlertDialog dialog=builder.create();
            dialog.show();


        });
        binding.btndatepicker.setOnClickListener(v -> {
            Calendar calendar=Calendar.getInstance();
            int year=calendar.get(Calendar.YEAR);
            int month=calendar.get(Calendar.MONTH);
            int day=calendar.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog.OnDateSetListener listener=(view1,year1,month1,day1)->{
                binding.btndatepicker.setText(day1+"/"+(month1+1)+"/"+year1);
            };
            DatePickerDialog dialog=new DatePickerDialog(getContext(),listener,year,month,day);

            dialog.getDatePicker().setMinDate(calendar.getTimeInMillis());
            dialog.show();
        });
        binding.btntimepicker.setOnClickListener(v -> {
            Calendar calendar=Calendar.getInstance();
            int hour=calendar.get(Calendar.HOUR);
            int min=calendar.get(Calendar.MINUTE);
            TimePickerDialog.OnTimeSetListener listener=(view2,hour1,min1)->{
                binding.btntimepicker.setText(hour1+"/"+min1);
            };
            TimePickerDialog dialog=new TimePickerDialog(getContext(),listener,hour,min,false);
            dialog.show();
        });
    }

    private void CustomToast(String msg) {
        Toast toast =new Toast(getContext());
        toast.setGravity(Gravity.CENTER,0,0);
        View customView=getLayoutInflater().inflate(R.layout.toast,null);
        TextView tvtoast=customView.findViewById(R.id.tvtoast);
        tvtoast.setText(msg);

        toast.setView(customView);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.show();

    }
}