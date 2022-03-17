package com.example.assignmenttops.other_stuff;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.assignmenttops.databinding.FragmentRegistrationBinding;

import org.jetbrains.annotations.NotNull;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RegistrationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegistrationFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RegistrationFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RegistrationFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RegistrationFragment newInstance(String param1, String param2) {
        RegistrationFragment fragment = new RegistrationFragment();
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

    private FragmentRegistrationBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentRegistrationBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Registration Fragment");
        binding.btnSubmit.setOnClickListener(v -> {
            String username = binding.edtUserName.getText().toString();
            if (TextUtils.isEmpty(username)) {
                binding.edtUserName.setError("Enter the UserName");
            }
            String regex = "^(.+)@(.+)$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(username);
            String password = binding.edtPassword.getText().toString();

             if (!matcher.matches()) {
                binding.edtUserName.setError("Enter valid Email");
                return;
            }

            else if (TextUtils.isEmpty(password)) {
                binding.edtPassword.setError("Enter the Password");
            }
            else if (password.length()>=6){
                binding.edtPassword.setError("Password must be only 6 digit");
            }
            else if (binding.rgGenderNew.getCheckedRadioButtonId() == -1) {
                Toast.makeText(getContext(), "Please Select Gender", Toast.LENGTH_SHORT).show();
            }
            else if(!binding.checkboxTerms.isChecked()){
                Toast.makeText(getContext(),"Please select is the Term and Condition",Toast.LENGTH_SHORT).show();
            }
            else{
                binding.btnSubmit.setText("Submitted SuccessFully");
            }

        });
    }
}