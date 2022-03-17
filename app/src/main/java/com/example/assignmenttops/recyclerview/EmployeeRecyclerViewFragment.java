package com.example.assignmenttops.recyclerview;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.assignmenttops.R;
import com.example.assignmenttops.databinding.FragmentEmployeeRecyclerViewBinding;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EmployeeRecyclerViewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EmployeeRecyclerViewFragment extends Fragment implements EmployeeAdapter.onEmployeeClickListner {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public EmployeeRecyclerViewFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EmployeeRecyclerViewFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EmployeeRecyclerViewFragment newInstance(String param1, String param2) {
        EmployeeRecyclerViewFragment fragment = new EmployeeRecyclerViewFragment();
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
    private FragmentEmployeeRecyclerViewBinding binding;
    private ArrayList<Employee>employeeArrayList;
    private EmployeeAdapter adapter;
    private Employee selectedEmployee;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentEmployeeRecyclerViewBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
        binding.recyclerViewEmployee.setLayoutManager(layoutManager);

        employeeArrayList=new ArrayList<>();
        employeeArrayList.add(new Employee("Arpit","Staff","arpit@gmail.com"));
        employeeArrayList.add(new Employee("Pratik","Staff","pratik@gmail.com"));
        employeeArrayList.add(new Employee("Urvi","Staff","urvi@gmail.com"));
        employeeArrayList.add(new Employee("Vimal","Senior Manager","vimal@gmail.com"));
        employeeArrayList.add(new Employee("Shraddha","Manager","shraddha@gmail.com"));

        adapter=new EmployeeAdapter(employeeArrayList,this);

        binding.recyclerViewEmployee.setAdapter(adapter);

    }

    @Override       // not in Fragment // already done is recyclerview CRUD
    public void onCreateOptionsMenu(@NonNull @NotNull Menu menu, @NonNull @NotNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

    }

    @Override
    public void onEmployeeClick(int position) {
         Employee selectedEmployee=employeeArrayList.get(position);

        Toast.makeText(getContext(),"This is "+selectedEmployee.getName(),Toast.LENGTH_SHORT).show();
    }
}