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
import com.example.assignmenttops.databinding.FragmentTotalDaysBinding;

import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TotalDaysFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TotalDaysFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TotalDaysFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TotalDaysFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TotalDaysFragment newInstance(String param1, String param2) {
        TotalDaysFragment fragment = new TotalDaysFragment();
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

    private FragmentTotalDaysBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTotalDaysBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.edtDateOne.setOnClickListener(v -> {

            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog.OnDateSetListener listener = (view2, year1, month1, day1) -> {
                String dateOne = day1+"/"+month1+"/"+year1;
                binding.edtDateOne.setText(dateOne);
            };
            DatePickerDialog dialog = new DatePickerDialog(getContext(), listener, year, month, day);
            dialog.show();

        });

        binding.edtDateTwo.setOnClickListener(v -> {

            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog.OnDateSetListener listener = (view2, year1, month1, day1) -> {
                String dateTwo = day1+"/"+month1+"/"+year1;
                binding.edtDateTwo.setText(dateTwo);
            };
            DatePickerDialog dialog = new DatePickerDialog(getContext(), listener, year, month, day);
            dialog.show();

        });

        binding.btnTotalDays.setOnClickListener(v -> {
            try {
                String date1 = binding.edtDateOne.getText().toString();
                String date2 = binding.edtDateTwo.getText().toString();

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

                Date dateOne = simpleDateFormat.parse(date1);
                Date dateTwo = simpleDateFormat.parse(date2);

                if(dateOne.before(dateTwo)){
                    long diff=Math.abs(dateTwo.getTime()-dateOne.getTime());
                    long diffdays=diff/(24*60*60*1000);
                    binding.tvTotalDays.setText(Long.toString(diffdays));

                }else {
                    if (dateTwo.before(dateOne)) {
                        long diff = Math.abs(dateOne.getTime() - dateTwo.getTime());
                        long diffdays = diff / (24 * 60 * 60 * 1000);
                        binding.tvTotalDays.setText(Long.toString(diffdays));
                    }
                }
            }catch(Exception e){
                binding.tvTotalDays.setText(e.toString());
            }

        });
    }
}