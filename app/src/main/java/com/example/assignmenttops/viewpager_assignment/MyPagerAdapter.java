package com.example.assignmenttops.viewpager_assignment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class MyPagerAdapter extends FragmentStatePagerAdapter {
    private ArrayList<Fragment> fragments;
    private ArrayList<String> titles;

    public MyPagerAdapter(@NonNull FragmentManager fm) {
        super(fm,FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        fragments=new ArrayList<>();
        titles=new ArrayList<>();
    }

    public void addFragment(Fragment fragment,String title){
        fragments.add(fragment) ;
        titles.add(title);
    }

    @NotNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        return titles.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
