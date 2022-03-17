package com.example.assignmenttops.toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

import com.example.assignmenttops.R;
import com.example.assignmenttops.databinding.ActivityToolBarBinding;

public class ToolBarActivity extends AppCompatActivity {

    private ActivityToolBarBinding binding;
    private ArrayAdapter<String>adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityToolBarBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setTitle("Toolbar");
        String []arr=getResources().getStringArray(R.array.Computer);

        adapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,arr);

        binding.listViewInToolBar.setAdapter(adapter);

        //getActionBar().hide(); // Make one Style with no Action bar add Style to activity in Manifest

        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu,menu);
        MenuItem menuItem=menu.findItem(R.id.action_search_new);
        SearchView searchView= (SearchView) menuItem.getActionView();

        searchView.setQueryHint("Type Here to Search");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                adapter.getFilter().filter(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return true;
            }
        });


        return super.onCreateOptionsMenu(menu);

    }
}