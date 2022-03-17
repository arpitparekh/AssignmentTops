package com.example.assignmenttops.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.Dialog;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.assignmenttops.R;
import com.example.assignmenttops.databinding.ActivityLastProgramRecyclerViewBinding;
import com.example.assignmenttops.databinding.DisplayDataBinding;
import com.example.assignmenttops.databinding.InputDataBinding;
import com.example.assignmenttops.databinding.LastProgramRowItemBinding;
import com.example.assignmenttops.databinding.ProductRowItemBinding;

import java.util.ArrayList;

public class LastProgramRecyclerView extends AppCompatActivity implements LastProgramAdapter.onDataClickListener {
    private ActivityLastProgramRecyclerViewBinding binding;
    private ArrayList<LastProgramData >lastProgramDataArrayList;
    private LastProgramAdapter adapter;
    private LastProgramData selectedData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityLastProgramRecyclerViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.recyclerViewLastProgram.setLayoutManager(new LinearLayoutManager(this));

        lastProgramDataArrayList=new ArrayList<>();
        lastProgramDataArrayList.add(new LastProgramData("Arpit"));
        lastProgramDataArrayList.add(new LastProgramData("Pratik"));

        adapter=new LastProgramAdapter(lastProgramDataArrayList,this);

        binding.recyclerViewLastProgram.setAdapter(adapter);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.add_menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.action_add:

                InputDataBinding binding2=InputDataBinding.inflate(getLayoutInflater());



                AlertDialog.Builder builder=new AlertDialog.Builder(this);

                builder.setTitle("InsertData on MenuClick");

                builder.setView(binding2.getRoot());


                builder.setPositiveButton("Insert",((dialog,which)->{

                    String nameString=binding2.edtInputData.getText().toString();

                    LastProgramData lastProgramData=new LastProgramData(nameString);

                    lastProgramDataArrayList.add(lastProgramData);
                    adapter.notifyDataSetChanged();

                }));
                builder.setNeutralButton("Cancel",((dialog, which) -> {
                    dialog.dismiss();
                }));
                AlertDialog dialog = builder.create();
                dialog.show();
                break;

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDataClick(int position) {
        selectedData=lastProgramDataArrayList.get(position);
        DisplayDataBinding binding1=DisplayDataBinding.inflate(getLayoutInflater());

        AlertDialog.Builder builder=new AlertDialog.Builder(this);

        builder.setTitle("Display on SingleClick");

        binding1.tvData.setText("Name is : "+selectedData.getName());

        builder.setView(binding1.getRoot());

        builder.setPositiveButton("Ok",(dialog,which)->{
           dialog.dismiss();
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public void onDataLongClick(int position) {
        selectedData=lastProgramDataArrayList.get(position);

        InputDataBinding binding2=InputDataBinding.inflate(getLayoutInflater());

        binding2.edtInputData.setText(selectedData.getName());

        AlertDialog.Builder builder=new AlertDialog.Builder(this);

        builder.setTitle("UpdateData on LongClick");



        builder.setView(binding2.getRoot());

        builder.setPositiveButton("Update",((dialog,which)->{
            String nameString=binding2.edtInputData.getText().toString();

            LastProgramData lastProgramData=new LastProgramData(nameString);
            lastProgramDataArrayList.set(position,lastProgramData);
            adapter.notifyDataSetChanged();
        }));
        builder.setNeutralButton("Cancel",((dialog, which) -> {
            dialog.dismiss();
        }));
        builder.setNegativeButton("Delete",((dialog, which) -> {
            lastProgramDataArrayList.remove(position);
            adapter.notifyDataSetChanged();
        }));

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    }
