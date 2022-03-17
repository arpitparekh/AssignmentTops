package com.example.assignmenttops.other_stuff;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.assignmenttops.databinding.FragmentEditTextBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EditTextFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EditTextFragment extends Fragment implements TextWatcher {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public EditTextFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EditTextFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EditTextFragment newInstance(String param1, String param2) {
        EditTextFragment fragment = new EditTextFragment();
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
    private FragmentEditTextBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=FragmentEditTextBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.edittext1.addTextChangedListener(this);
        binding.edittext2.addTextChangedListener(this);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void  onTextChanged(CharSequence s, int start, int before, int count) {
    int sum=0;
    int a=0,b=0;
    try {
        String str1 = binding.edittext1.getText().toString();
        if(!str1.equals("")) {
            a = Integer.parseInt(str1);
        }
        String str2 = binding.edittext2.getText().toString();
        if(!str2.equals("")){
            b = Integer.parseInt(str2);
        }
        sum = a + b;
        // in set text first parameter is resource id
        binding.tvsum.setText("hello"+sum);
    }catch(Exception e){

        binding.tvsum.setText("hello"+sum);
    }


    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}