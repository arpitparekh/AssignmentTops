package com.example.assignmenttops.dialog_assignment;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.assignmenttops.R;
import com.example.assignmenttops.databinding.DialogInContextualBinding;
import com.example.assignmenttops.databinding.FragmentContextualMenuFragementBinding;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ContextualMenuFragement#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ContextualMenuFragement extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ContextualMenuFragement() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ContextualMenuFragement.
     */
    // TODO: Rename and change types and number of parameters
    public static ContextualMenuFragement newInstance(String param1, String param2) {
        ContextualMenuFragement fragment = new ContextualMenuFragement();
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
    private FragmentContextualMenuFragementBinding binding;
    private ArrayAdapter<String>adapter;
    private int indexval;

    private ArrayList<String>list;;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentContextualMenuFragementBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        list = new ArrayList<>();
        list.add("Hi");
        list.add("bye");
        list.add("hello");

        adapter=new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1,list);
        binding.listViewContextual.setAdapter(adapter);
        registerForContextMenu(binding.listViewContextual);

        binding.listViewContextual.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                indexval=position;   // bas atluj karvanu hatu
            }
        });
    }


    @Override
    public void onCreateContextMenu(@NonNull @NotNull ContextMenu menu, @NonNull @NotNull View v, @Nullable @org.jetbrains.annotations.Nullable ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater= getActivity().getMenuInflater();
        inflater.inflate(R.menu.view_edit,menu);
        menu.setHeaderTitle("Choose one");
    }

    @Override
    public boolean onContextItemSelected(@NonNull @NotNull MenuItem item) {

        switch(item.getItemId()){
            case R.id.action_edit:

                //Toast.makeText(getContext(),"This is Taost",Toast.LENGTH_SHORT).show();
                DialogInContextualBinding binding1=DialogInContextualBinding.inflate(getLayoutInflater());
                AlertDialog.Builder builder =new AlertDialog.Builder(getContext());
                builder.setTitle("Enter Data For Edit");
                builder.setView(binding1.getRoot());

                binding1.edtInContextual.setText(list.get(indexval));

                builder.setPositiveButton("Ok",((dialog, which) -> {


                    String str=binding1.edtInContextual.getText().toString();
                    list.set(indexval,str);
                    adapter.notifyDataSetChanged();
                }));
                Dialog dialog=builder.create();
                dialog.show();
                break;
            case R.id.action_delete_contextual:

                AlertDialog.Builder builder1 =new AlertDialog.Builder(getContext());
                builder1.setTitle("Do u Really Want to? Think again !?");
                builder1.setPositiveButton("Yes",(dialog1, which) -> {
                    list.remove(indexval);
                    adapter.notifyDataSetChanged();
                });
                builder1.setNegativeButton("No",((dialog1, which) -> {
                    dialog1.dismiss();
                }));
                Dialog dialog1=builder1.create();
                dialog1.show();
                break;
        }
        return super.onContextItemSelected(item);
    }
}