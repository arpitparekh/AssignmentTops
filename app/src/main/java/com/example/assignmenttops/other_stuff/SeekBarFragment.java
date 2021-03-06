package com.example.assignmenttops.other_stuff;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

import com.example.assignmenttops.databinding.FragmentSeekBarBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SeekBarFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SeekBarFragment extends Fragment implements SeekBar.OnSeekBarChangeListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SeekBarFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SeekBarFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SeekBarFragment newInstance(String param1, String param2) {
        SeekBarFragment fragment = new SeekBarFragment();
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
    private FragmentSeekBarBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        binding=FragmentSeekBarBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.seekbar1.setOnSeekBarChangeListener(this);
        binding.seekbar2.setOnSeekBarChangeListener(this);
        binding.seekbar3.setOnSeekBarChangeListener(this);
    }

    @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        int red =binding.seekbar1.getProgress();
        int blue=binding.seekbar2.getProgress();
        int green=binding.seekbar3.getProgress();

        binding.linearcolor.setBackgroundColor(Color.rgb(red,green,blue));

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}