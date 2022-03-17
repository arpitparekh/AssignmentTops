package com.example.assignmenttops.dialog_assignment;

import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.assignmenttops.R;
import com.example.assignmenttops.databinding.DialogAssignmentBinding;
import com.example.assignmenttops.databinding.FragmentCustomDialogBinding;

import org.jetbrains.annotations.NotNull;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CustomDialogFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CustomDialogFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CustomDialogFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CustomDialogFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CustomDialogFragment newInstance(String param1, String param2) {
        CustomDialogFragment fragment = new CustomDialogFragment();
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
    private FragmentCustomDialogBinding binding;
    private DialogAssignmentBinding binding1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentCustomDialogBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.btnCustomToast.setOnClickListener(v -> {

            binding1=DialogAssignmentBinding.inflate(getLayoutInflater());

            AlertDialog.Builder builder=new AlertDialog.Builder(getContext());
            builder.setTitle("This is Custom Dialog");
            builder.setView(binding1.getRoot());

            builder.setPositiveButton("Submit",((dialog, which) -> {
                String str=binding1.edtCustomToast.getText().toString();
                Toast.makeText(getContext(),str,Toast.LENGTH_SHORT).show();
            }));
            builder.setNeutralButton("Cancel",(dialog, which) -> {
                dialog.dismiss();
            });
            Dialog dialog=builder.create();
            dialog.show();
        });

    }
}