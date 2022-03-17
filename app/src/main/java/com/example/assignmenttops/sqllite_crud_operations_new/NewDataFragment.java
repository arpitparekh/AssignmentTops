package com.example.assignmenttops.sqllite_crud_operations_new;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.assignmenttops.databinding.FragmentNewDataBinding;
import com.example.assignmenttops.sqllite_crud_operations_new.database_sqllite.ApplicationDatabase;
import com.example.assignmenttops.sqllite_crud_operations_new.database_sqllite.Data;
import com.example.assignmenttops.sqllite_crud_operations_new.database_sqllite.DataDao;

import org.jetbrains.annotations.NotNull;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NewDataFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NewDataFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public NewDataFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NewDataFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NewDataFragment newInstance(String param1, String param2) {
        NewDataFragment fragment = new NewDataFragment();
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

    private FragmentNewDataBinding binding;
    private Data theData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNewDataBinding.inflate(inflater, container, false);
        getActivity().setTitle("NewUserFragment");
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle bundle=getArguments();
        if(bundle!=null) {

            theData = bundle.getParcelable("data");

            if (theData != null) {
                binding.edtIdNew.setText(String.valueOf(theData.id_new));
                binding.edtFirstNameNew.setText(String.valueOf(theData.firstName_new));
                binding.edtLastNameNew.setText(theData.lastName_new);
                binding.edtEmailNew.setText(theData.email_new);
                binding.edtAgeNew.setText(String.valueOf(theData.age));
            }
        }
        binding.btnSubmitNew.setOnClickListener(v -> {


            ApplicationDatabase db= ApplicationDatabase.getInstance(getContext());

            DataDao dataDao= db.dataDao();

            if(theData!=null){
                theData.id_new= Integer.parseInt(binding.edtIdNew.getText().toString());
                theData.firstName_new=binding.edtFirstNameNew.getText().toString();
                theData.lastName_new=binding.edtLastNameNew.getText().toString();
                theData.email_new=binding.edtEmailNew.getText().toString();
                theData.age= Integer.parseInt(binding.edtAgeNew.getText().toString());
                dataDao.UpdateData(theData);
            }else{
                theData=new Data();

                theData.id_new= Integer.parseInt(binding.edtIdNew.getText().toString());
                theData.firstName_new=binding.edtFirstNameNew.getText().toString();
                theData.lastName_new=binding.edtLastNameNew.getText().toString();
                theData.email_new=binding.edtEmailNew.getText().toString();
                theData.age= Integer.parseInt(binding.edtAgeNew.getText().toString());

                dataDao.InsertData(theData);

                Toast.makeText(getContext(),"Data Enter SuccessFully",Toast.LENGTH_SHORT).show();
            }

            Navigation.findNavController(getView())
                    .popBackStack();


        });
    }
}