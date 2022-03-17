package com.example.assignmenttops.dialog_assignment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.assignmenttops.R;
import com.example.assignmenttops.databinding.FragmentMultiChoiceDialogBinding;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MultiChoiceDialogFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MultiChoiceDialogFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MultiChoiceDialogFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MultiChoiceDialogFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MultiChoiceDialogFragment newInstance(String param1, String param2) {
        MultiChoiceDialogFragment fragment = new MultiChoiceDialogFragment();
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

    private FragmentMultiChoiceDialogBinding binding;
    //final String[] order = {"Pizza", "Burger", "French Fries", "Small Coke", "Large Coke", "Extra Cheese", "Ice Cream"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMultiChoiceDialogBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayList<String> order = new ArrayList<>();
        order.add("Pizza");
        order.add("Sandwich");
        order.add("Burger");
        order.add("French Fries");
        order.add("Ice Cream");
        order.add("Coke");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.select_dialog_multichoice, order);

        binding.listViewDialogMultipleChoice.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        binding.listViewDialogMultipleChoice.setAdapter(adapter);

        binding.btnDialogMultiChoice.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

            builder.setTitle("Select Orders");

            //from krupal // SparseBooleanArrays map integers to booleans
            SparseBooleanArray checked = binding.listViewDialogMultipleChoice.getCheckedItemPositions();

            ArrayList<String> selectedOrders = new ArrayList<>();

            for (int i = 0; i < checked.size(); i++) {
                int position = checked.keyAt(i);
                if (checked.valueAt(i)) {
                    selectedOrders.add(adapter.getItem(position).toString());
                }
            }
            String[] output = new String[selectedOrders.size()];

            for (int i = 0; i < selectedOrders.size(); i++) {
                output[i] = selectedOrders.get(i);
            }
            builder.setItems(output, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();

        });
    }
}