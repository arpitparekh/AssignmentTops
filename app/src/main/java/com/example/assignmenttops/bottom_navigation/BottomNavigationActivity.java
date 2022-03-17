package com.example.assignmenttops.bottom_navigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.assignmenttops.R;
import com.example.assignmenttops.databinding.ActivityBottomNavigationBinding;
import com.example.assignmenttops.dialog_assignment.ContextualMenuFragement;
import com.example.assignmenttops.dialog_assignment.CustomDialogFragment;
import com.example.assignmenttops.dialog_assignment.GmailRecyclerViewFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;

public class BottomNavigationActivity extends AppCompatActivity {
    private ActivityBottomNavigationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBottomNavigationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Fragment fragment = new GmailRecyclerViewFragment();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameInBototmNavigation, fragment);
        transaction.commit();

        binding.bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
                Fragment fragment1;
                switch (item.getItemId()) {
                    case R.id.dash:
                        fragment1 = new ContextualMenuFragement();
                        loadFragment(fragment1);
                        break;
                    case R.id.profile:
                        fragment1 = new CustomDialogFragment();
                        loadFragment(fragment1);
                        break;
                    default:
                        fragment1 = new GmailRecyclerViewFragment();
                        loadFragment(fragment1);
                        break;
                }
                return false;
            }


        });


    }

        public void loadFragment(Fragment fragment) {
            FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frameInBototmNavigation,fragment);
            transaction.addToBackStack(null);
            transaction.commit();
    }
}