package com.example.assignmenttops.recyclerview_crud_operation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.example.assignmenttops.R;
import com.example.assignmenttops.databinding.ActivityRecyclerViewMainBinding;
import com.example.assignmenttops.databinding.InputCountryBinding;

import java.util.ArrayList;

public class RecyclerViewMain extends AppCompatActivity implements CountryAdapter.onCountryClickListener {

    private ActivityRecyclerViewMainBinding binding;
    private ArrayList<Country> countryArrayList;
    private CountryAdapter adapter;
    private Country selectedCountry;
    private ActionMode actionMode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRecyclerViewMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyclerViewMain.setLayoutManager(layoutManager);

        countryArrayList = new ArrayList<>();
        countryArrayList.add(new Country("one", "Delhi", "3432432425"));
        countryArrayList.add(new Country("two", "gujarat", "3432432425"));
        countryArrayList.add(new Country("three", "mumbai", "3432425"));


        adapter = new CountryAdapter(countryArrayList, this);

        binding.recyclerViewMain.setAdapter(adapter);
    }

    ActionMode.Callback callback = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            getMenuInflater().inflate(R.menu.action_menu, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {

            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {

            if (item.getItemId() == R.id.action_deleteSelected) {

                ArrayList<Country> templist = new ArrayList<>();
                templist.addAll(countryArrayList);

                for (Country country : templist) {
                    if (country.isSelected()) {
                        countryArrayList.remove(country);
                    }
                }

                adapter.notifyDataSetChanged();
                actionMode.finish();

                return true;
            }
            return false;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {

            for (int i = 0; i < countryArrayList.size(); i++) {
                countryArrayList.get(i).setSelected(false);
            }
            adapter.notifyDataSetChanged();
            actionMode=null;


        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.new_menu, menu);

        MenuItem menuItem = menu.findItem(R.id.action_search);
        androidx.appcompat.widget.SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
//        searchView.setOnQueryTextListener(new SearchView().OnQueryTextListener() {
//
//
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                adapter.getFilter().filter(newText) ;
//                return true;
//            }
//        });
//        return super.onCreateOptionsMenu(menu);
//    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_New) {
            showInputDialog();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showInputDialog() {
        //View view = getLayoutInflater().inflate(R.layout.input_country,null);

        InputCountryBinding binding = InputCountryBinding.inflate(getLayoutInflater());
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("New Country");

        builder.setView(binding.getRoot());

        builder.setPositiveButton("Save", (dialog, which) -> {

            String country = binding.edtCountry.getText().toString();
            String capital = binding.edtCapital.getText().toString();
            String population = binding.edtPopulation.getText().toString();

            Country country1 = new Country(country, capital, population);
            countryArrayList.add(country1);
            adapter.notifyDataSetChanged();
        });
        AlertDialog dialog = builder.create();
        dialog.show();

    }

    @Override
    public void onCountryClick(int position) {
        if(actionMode!=null){
            toggleSelection(position);
        }else {

            selectedCountry = countryArrayList.get(position);

            InputCountryBinding binding = InputCountryBinding.inflate(getLayoutInflater());

            binding.edtCountry.setText(selectedCountry.getName());
            binding.edtCapital.setText(selectedCountry.getCapital());
            binding.edtPopulation.setText(selectedCountry.getPopulation());

            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setTitle("New Country");

            builder.setView(binding.getRoot());

            builder.setPositiveButton("Update", (dialog, which) -> {
                String country = binding.edtCountry.getText().toString();
                String capital = binding.edtCapital.getText().toString();
                String population = binding.edtPopulation.getText().toString();
                Country country1 = new Country(country, capital, population);
                countryArrayList.set(position, country1);
                adapter.notifyDataSetChanged();


            });
            builder.setNegativeButton("Delete", (dialog, which) -> {
                countryArrayList.remove(position);
                adapter.notifyDataSetChanged();
            });
            builder.setNeutralButton("Cancel", (dialog, which) -> {
                dialog.dismiss();
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        }

    }

    private void toggleSelection(int position) {
        Country the_country = countryArrayList.get(position);
        countryArrayList.get(position).setSelected(!the_country.isSelected());
        adapter.notifyDataSetChanged();

        int total=0;
        for(Country country : countryArrayList){
            if(country.isSelected()){
                total++;
            }
            actionMode.setTitle("Total : "+total);
        }
    }

    @Override
    public void onCountryLongClick(int position) {
        if (actionMode == null) {
            actionMode = startActionMode(callback);
        }
        //toggle selection
        toggleSelection(position);
    }

    @Override
    public void updateList(ArrayList<Country> list) {
        countryArrayList=list;
    }
}