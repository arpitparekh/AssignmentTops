package com.example.assignmenttops.ViewPager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.assignmenttops.other_stuff.CheckBoxFragment;
import com.example.assignmenttops.other_stuff.EditTextFragment;
import com.example.assignmenttops.other_stuff.MenuFragment;
import com.example.assignmenttops.other_stuff.RadioButtonFragment;
import com.example.assignmenttops.other_stuff.RegistrationFragment;
import com.example.assignmenttops.other_stuff.SeekBarFragment;
import com.example.assignmenttops.other_stuff.SpinnerFragment;
import com.example.assignmenttops.other_stuff.ToastDialogDateTimeFragment;
import com.example.assignmenttops.databinding.ActivityViewPagerBinding;

import java.util.ArrayList;

public class ViewPagerActivity extends AppCompatActivity {
    private ActivityViewPagerBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityViewPagerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<Fragment>fragments=new ArrayList<>();
        fragments.add(new CheckBoxFragment());
        fragments.add(new EditTextFragment());
        fragments.add(new MenuFragment());
        fragments.add(new RadioButtonFragment());
        fragments.add(new RegistrationFragment());
        fragments.add(new SeekBarFragment());
        fragments.add(new SpinnerFragment());
        fragments.add(new ToastDialogDateTimeFragment());

        ArrayList<String> titles=new ArrayList<>();
        titles.add("CheckBox");
        titles.add("EditText");
        titles.add("Menu");
        titles.add("RadioButton");
        titles.add("Registration");
        titles.add("SeekBar");
        titles.add("Spinner");
        titles.add("ToastDialogDateTime");

        ViewPagerAdapter adapter=new ViewPagerAdapter(getSupportFragmentManager(),fragments,titles);
        binding.viewPager.setAdapter(adapter);

        binding.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                setTitle(titles.get(position));

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
}