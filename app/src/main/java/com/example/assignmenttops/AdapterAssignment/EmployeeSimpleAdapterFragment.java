package com.example.assignmenttops.AdapterAssignment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;

import com.example.assignmenttops.R;
import com.example.assignmenttops.databinding.FragmentEmployeeSimpleAdapterBinding;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EmployeeSimpleAdapterFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EmployeeSimpleAdapterFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String POSITION = "Position";
    private static final String NAME = "Name";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public EmployeeSimpleAdapterFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EmployeeSimpleAdapterFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EmployeeSimpleAdapterFragment newInstance(String param1, String param2) {
        EmployeeSimpleAdapterFragment fragment = new EmployeeSimpleAdapterFragment();
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
    private FragmentEmployeeSimpleAdapterBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentEmployeeSimpleAdapterBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayList<HashMap<String,String>> arrayList=new ArrayList<>();
        HashMap<String,String> hashmap=new HashMap<>();
        hashmap.put(NAME,"Arpit");
        hashmap.put(POSITION,"Manager");
        arrayList.add(hashmap);

        hashmap=new HashMap<>();
        hashmap.put(NAME,"Mahesh");
        hashmap.put(POSITION,"Second Manager");
        arrayList.add(hashmap);

        hashmap=new HashMap<>();
        hashmap.put(NAME,"Paresh");
        hashmap.put(POSITION,"Junior Manager");
        arrayList.add(hashmap);

        String[] from ={NAME,POSITION};
        int[] to ={R.id.tvEmployeeName,R.id.tvEmployeePosition};

        SimpleAdapter adapter=new SimpleAdapter(getContext(),arrayList,R.layout.employee,from,to);
        binding.listViewEmploee.setAdapter(adapter);

    }
}