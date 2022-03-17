package com.example.assignmenttops.passobject;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.assignmenttops.R;
import com.example.assignmenttops.databinding.FragmentPehlaBinding;

import org.jetbrains.annotations.NotNull;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PehlaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PehlaFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PehlaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PehlaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PehlaFragment newInstance(String param1, String param2) {
        PehlaFragment fragment = new PehlaFragment();
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
    private FragmentPehlaBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentPehlaBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnSubmitKaro.setOnClickListener(v -> {

            String name=binding.edtNameBolo.getText().toString();
            String serviceNumberStr=binding.edtserviceNumberBolo.getText().toString();

            int serviceNumber=Integer.parseInt(serviceNumberStr);

            Cars cars=new Cars(name,serviceNumber);
            Bundle bundle=new Bundle();
            bundle.putParcelable("Object",cars);

            Fragment fragment=new DusraFragment();
            fragment.setArguments(bundle);

            FragmentManager manager=getFragmentManager();
            FragmentTransaction transaction=manager.beginTransaction();

            transaction.replace(R.id.frameHost,fragment);

            transaction.addToBackStack(PehlaFragment.class.getName());
            transaction.commit();





        });

    }
}