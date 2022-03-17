package com.example.assignmenttops.dialog_assignment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.assignmenttops.R;
import com.example.assignmenttops.databinding.FragmentSingleChoiceDialogBinding;

import org.jetbrains.annotations.NotNull;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SingleChoiceDialogFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SingleChoiceDialogFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SingleChoiceDialogFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SingleChoiceDialogFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SingleChoiceDialogFragment newInstance(String param1, String param2) {
        SingleChoiceDialogFragment fragment = new SingleChoiceDialogFragment();
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
    private FragmentSingleChoiceDialogBinding binding;
    private final String[] gender={"Male","Female","TransGender","OutOfThisWorld"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=FragmentSingleChoiceDialogBinding.inflate(inflater,container,false);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnDialogSingleChoice.setOnClickListener(v -> {
            AlertDialog.Builder builder=new AlertDialog.Builder(getContext());
            builder.setTitle("Please Select Your Choice");
            builder.setItems(gender, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int i) {
                    binding.tvDialogSingleChoice.setText(gender[i]);
                }
            });

            AlertDialog dialog = builder.create();
            dialog.show();

        });

    }
}