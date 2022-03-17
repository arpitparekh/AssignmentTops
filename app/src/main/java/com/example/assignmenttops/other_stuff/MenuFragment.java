package com.example.assignmenttops.other_stuff;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.assignmenttops.R;
import com.example.assignmenttops.databinding.FragmentMenuBinding;

import org.jetbrains.annotations.NotNull;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MenuFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MenuFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MenuFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MenuFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MenuFragment newInstance(String param1, String param2) {
        MenuFragment fragment = new MenuFragment();
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

    private FragmentMenuBinding binding;
    private static final String TAG = "MenuFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        setHasOptionsMenu(true);
        binding = FragmentMenuBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onCreateContextMenu(@NonNull @NotNull ContextMenu menu, @NonNull @NotNull View v, @Nullable @org.jetbrains.annotations.Nullable ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater=getActivity().getMenuInflater();
        inflater.inflate(R.menu.example_menu,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull @NotNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.action_file:
                Log.i(TAG,"File menu click");
                Toast.makeText(getActivity(),"File menu click",Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_cut:
                Log.i(TAG,"Cut menu Click ");
                break;
            case R.id.action_copy:
                Log.i(TAG,"Copy menu click");
                break;
            case R.id.action_paste:
                Log.i(TAG,"Paste menu click");
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull @NotNull Menu menu, @NonNull @NotNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.example_menu,menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull @NotNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.action_file:
                Log.i(TAG,"File menu click");
                break;
            case R.id.action_cut:
                Log.i(TAG,"Cut menu Click ");
                break;
            case R.id.action_copy:
                Log.i(TAG,"Copy menu click");
                break;
            case R.id.action_paste:
                Log.i(TAG,"Paste menu click");
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        registerForContextMenu(binding.btncontextmenu);

        binding.btnpopupmenu.setOnClickListener(v -> {
            PopupMenu pmenu=new PopupMenu(getContext(),v);
            pmenu.getMenuInflater().inflate(R.menu.example_menu,pmenu.getMenu());
            pmenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                switch(item.getItemId()){
                    case R.id.action_file:
                        Log.i(TAG,"File menu click");
                        break;
                    case R.id.action_cut:
                        Log.i(TAG,"Cut menu Click ");
                        break;
                    case R.id.action_copy:
                        Log.i(TAG,"Copy menu click");
                        break;
                    case R.id.action_paste:
                        Log.i(TAG,"Paste menu click");
                        break;
                }
                    return false;
                }
            });
            pmenu.show();
        });


    }
}