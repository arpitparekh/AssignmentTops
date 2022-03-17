package com.example.assignmenttops.UIcontrol;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.example.assignmenttops.R;
import com.example.assignmenttops.databinding.FragmentAsmdUIRadioBinding;
import com.example.assignmenttops.databinding.FragmentBetweenNumberBinding;

import org.jetbrains.annotations.NotNull;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AsmdUIRadioFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AsmdUIRadioFragment extends Fragment implements TextWatcher, RadioGroup.OnCheckedChangeListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AsmdUIRadioFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AsmdUIRadioFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AsmdUIRadioFragment newInstance(String param1, String param2) {
        AsmdUIRadioFragment fragment = new AsmdUIRadioFragment();
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

    private FragmentAsmdUIRadioBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAsmdUIRadioBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.edtNewNumber1.addTextChangedListener(this);
        binding.edtNewNumber2.addTextChangedListener(this);
        binding.rgAsmd.setOnCheckedChangeListener(this);

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        int checkedID = binding.rgAsmd.getCheckedRadioButtonId();
        calculate(checkedID);
    }

        public void calculate ( int checkedId){
            int a = 0, b = 0,sum=0;
            String str = binding.edtNewNumber1.getText().toString();
            String str2 = binding.edtNewNumber2.getText().toString();

            try {


                if (!str.equals("")) {
                    a = Integer.parseInt(str);
                }
                if (!str2.equals("")) {
                    b = Integer.parseInt(str2);
                }
                switch (checkedId) {
                    case R.id.rbadd:
                        sum = a + b;
                        break;
                    case R.id.rbsub:
                        sum = a - b;
                        break;
                    case R.id.rbdiv:
                        sum = a / b;
                        break;
                    case R.id.rbmul:
                        sum = a * b;
                        break;
                }
                        binding.tvNewResult.setText(String.valueOf(sum));


            } catch (Exception e) {
                binding.tvNewResult.setText(String.valueOf(sum));
            }

        }


    @Override
    public void afterTextChanged(Editable s) {

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        calculate(checkedId);

    }
}