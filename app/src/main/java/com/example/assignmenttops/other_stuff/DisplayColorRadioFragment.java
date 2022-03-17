package com.example.assignmenttops.other_stuff;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.example.assignmenttops.R;
import com.example.assignmenttops.databinding.FragmentDisplayColorRadioBinding;

import org.jetbrains.annotations.NotNull;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DisplayColorRadioFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DisplayColorRadioFragment extends Fragment implements RadioGroup.OnCheckedChangeListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DisplayColorRadioFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DisplayColorRadioFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DisplayColorRadioFragment newInstance(String param1, String param2) {
        DisplayColorRadioFragment fragment = new DisplayColorRadioFragment();
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

    private FragmentDisplayColorRadioBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDisplayColorRadioBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.rgcolor.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch(checkedId){
            case R.id.rbRed :
                binding.frameColor.setBackgroundColor(Color.rgb(255,0,0));
                break;
            case R.id.rbGreen:
                binding.frameColor.setBackgroundColor(Color.rgb(0,255,0));
                break;
            case R.id.rbBlue:
                binding.frameColor.setBackgroundColor(Color.rgb(0,0,255));
                break;
        }
    }

}