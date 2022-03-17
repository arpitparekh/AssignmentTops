package com.example.assignmenttops.dialog_assignment;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.assignmenttops.R;
import com.example.assignmenttops.databinding.FragmentDatePickerAssignmentBinding;

import org.jetbrains.annotations.NotNull;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DatePickerAssignmentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DatePickerAssignmentFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DatePickerAssignmentFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DatePickerAssignmentFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DatePickerAssignmentFragment newInstance(String param1, String param2) {
        DatePickerAssignmentFragment fragment = new DatePickerAssignmentFragment();
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
    private FragmentDatePickerAssignmentBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentDatePickerAssignmentBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.btnDatePickerAssignment.setOnClickListener(v -> {
        Calendar calendar= Calendar.getInstance();
            int year=calendar.get(Calendar.YEAR);
            int month=calendar.get(Calendar.MONTH);
            int day=calendar.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog.OnDateSetListener listener=(view1, year1, month1, day1)->{
                binding.btnDatePickerAssignment.setText(day1+"/"+(month1+1)+"/"+year1);
            };
            DatePickerDialog dialog=new DatePickerDialog(getContext(),listener,year,month,day);
            //minimum date to current date
            dialog.getDatePicker().setMinDate(calendar.getTimeInMillis());
            dialog.show();
        });
    }
}