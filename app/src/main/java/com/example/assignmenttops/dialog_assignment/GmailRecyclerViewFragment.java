package com.example.assignmenttops.dialog_assignment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.view.ActionMode;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.assignmenttops.R;
import com.example.assignmenttops.databinding.DialogInContextualBinding;
import com.example.assignmenttops.databinding.DialogInRecyclerviewBinding;
import com.example.assignmenttops.databinding.FragmentGmailRecyclerViewBinding;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GmailRecyclerViewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GmailRecyclerViewFragment extends Fragment implements GmailAdapter.onGmailClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public GmailRecyclerViewFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GmailRecyclerViewFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GmailRecyclerViewFragment newInstance(String param1, String param2) {
        GmailRecyclerViewFragment fragment = new GmailRecyclerViewFragment();
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

    private FragmentGmailRecyclerViewBinding binding;
    private ArrayList<GmailData> gmailDataArrayList;
    private GmailAdapter adapter;

    int indexValue;

    //    private GmailData selectedlist;
//    private GmailRecyclerViewFragment fragment;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentGmailRecyclerViewBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        registerForContextMenu(binding.getRoot());

        binding.recyclerViewGmail.setLayoutManager(new LinearLayoutManager(getContext()));

        gmailDataArrayList = new ArrayList<>();
        gmailDataArrayList.add(new GmailData("Arpit", "Send Me the File", "12,9,19", "12:30"));
        gmailDataArrayList.add(new GmailData("Praik", "Call me ASAP", "24,9,20", "2:30"));
        gmailDataArrayList.add(new GmailData("Vimal", "How r u?", "12,10,21", "1:30"));
        gmailDataArrayList.add(new GmailData("Shraddha", "Send me Link", "13,6,21", "12:00"));
        gmailDataArrayList.add(new GmailData("urvi", "Thank u", "18,7,21", "2:00"));

        adapter = new GmailAdapter(gmailDataArrayList, this);

        binding.recyclerViewGmail.setAdapter(adapter);

    }

    @Override
    public void onCreateContextMenu(@NonNull @NotNull ContextMenu menu, @NonNull @NotNull View v, @Nullable @org.jetbrains.annotations.Nullable ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater= getActivity().getMenuInflater();
        inflater.inflate(R.menu.view_edit,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull @NotNull MenuItem item) {

        switch(item.getItemId()){

            case R.id.action_edit:

                //Toast.makeText(getContext(),"This is Taost",Toast.LENGTH_SHORT).show();
                DialogInRecyclerviewBinding binding1=DialogInRecyclerviewBinding.inflate(getLayoutInflater());
                AlertDialog.Builder builder =new AlertDialog.Builder(getContext());
                builder.setTitle("Enter Data For Edit");
                builder.setView(binding1.getRoot());

                builder.setPositiveButton("Ok",((dialog, which) -> {
                    String name=binding1.nameDialogInRecyclerView.getText().toString();
                    String message=binding1.messageDialogInRecyclerView.getText().toString();
                    String date=binding1.dateDialogInRecyclerView.getText().toString();
                    String time=binding1.timeDialogInRecyclerView.getText().toString();

                    GmailData gmailData1=new GmailData(name,message,date,time);
                    gmailDataArrayList.set(item.getGroupId(),gmailData1);
                    adapter.notifyDataSetChanged();

                }));
                builder.setNegativeButton("Cancel",((dialog, which) -> {
                    dialog.dismiss();
                }));

                Dialog dialog=builder.create();
                dialog.show();
                break;
            case R.id.action_delete_contextual:

                AlertDialog.Builder builder1 =new AlertDialog.Builder(getContext());
                builder1.setTitle("Do u Really Want to? Think again !?");
                builder1.setPositiveButton("Yes",(dialog1, which) -> {
                    gmailDataArrayList.remove(item.getGroupId());
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
    //    @Override
//    public void onCreateContextMenu(@NonNull @NotNull ContextMenu menu, @NonNull @NotNull View v, @Nullable @org.jetbrains.annotations.Nullable ContextMenu.ContextMenuInfo menuInfo) {
//        super.onCreateContextMenu(menu, v, menuInfo);
//
////        MenuInflater inflater= getActivity().getMenuInflater();
////        inflater.inflate(R.menu.view_edit,menu);
//
//
//    }


    @Override
    public void onGmailClick(int position) {

    }

    @Override
    public void onGmailLongClick(int position) {

    }


//    @Override
//    public void onGmailLongClick(int position) {
////        selectedData=gmailDataArrayList.get(position);
////
////        DialogInContextualBinding binding1=DialogInContextualBinding.inflate(getLayoutInflater());
////        AlertDialog.Builder builder =new AlertDialog.Builder(getContext());
////        builder.setTitle("Enter Data For Edit");
////        builder.setView(binding1.getRoot());
////
////
////
////        builder.setPositiveButton("Ok",((dialog, which) -> {
////
////
////            String str=binding1.edtInContextual.getText().toString();
////            gmailDataArrayList.set(position,selectedData);
////            adapter.notifyDataSetChanged();
////        }));
////        Dialog dialog=builder.create();
////        dialog.show();
//
//    }

//    @Override
//    public void onGmailClick(int position) {
//
//    }

//    @Override
//    public void onGmailLongClick(int position) {
//
//        MenuInflater inflater= getActivity().getMenuInflater();
//
//
//    }
}