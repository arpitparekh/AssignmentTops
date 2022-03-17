package com.example.assignmenttops.Layouts;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.assignmenttops.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CustomLayoutFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CustomLayoutFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CustomLayoutFragment() {
        // Required empty public constructor
    }
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CustomLayoutFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CustomLayoutFragment newInstance(String param1, String param2) {
        CustomLayoutFragment fragment = new CustomLayoutFragment();
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
    int count=0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getActivity().setTitle("CustomLayoutFragment");

        LinearLayout linear=new LinearLayout(getContext());
        linear.setOrientation(LinearLayout.VERTICAL);


        Button btnhello=new Button(getContext());
        btnhello.setText("Add Button");
        linear.addView(btnhello);

        btnhello.setOnClickListener(v ->{

            Button btntest=new Button(getContext());
            btntest.setText("Button"+count);
            count++;
            linear.addView(btntest);

                });


            Button btnremove=new Button(getContext());
            btnremove.setText("Remove Button");
            linear.addView(btnremove);

        btnremove.setOnClickListener(v -> {
            if(linear.getChildCount()>2){
                linear.removeViewAt(linear.getChildCount()-1);
            }
        });

        return linear;
    }
}