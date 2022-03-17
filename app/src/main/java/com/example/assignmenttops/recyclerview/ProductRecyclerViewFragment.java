package com.example.assignmenttops.recyclerview;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.assignmenttops.R;
import com.example.assignmenttops.databinding.FragmentProductRecyclerViewBinding;
import com.example.assignmenttops.databinding.InputProductBinding;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProductRecyclerViewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProductRecyclerViewFragment extends Fragment implements ProductAdapter.onProductClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProductRecyclerViewFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProductRecyclerViewFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProductRecyclerViewFragment newInstance(String param1, String param2) {
        ProductRecyclerViewFragment fragment = new ProductRecyclerViewFragment();
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
    private FragmentProductRecyclerViewBinding binding;
    private ArrayList<Product>productArrayList;
    private ProductAdapter adapter;
    private Product selectedProduct;
    private Product product;
    private InputProductBinding binding1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        binding=FragmentProductRecyclerViewBinding.inflate(inflater,container,false);
        return binding.getRoot();


    }



    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        binding.recyclerViewProduct.setLayoutManager(new LinearLayoutManager(getContext()));

        productArrayList=new ArrayList<Product>();
        productArrayList.add(new Product("Tv","12000","2"));
        productArrayList.add(new Product("AC","12000","2"));


        binding.tvTotalProduct.setText("Total Product is :"+productArrayList.size());

        adapter=new ProductAdapter(productArrayList,this);

        binding.recyclerViewProduct.setAdapter(adapter);

    }

    @Override
    public void onCreateOptionsMenu(@NonNull @NotNull Menu menu, @NonNull @NotNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.add_menu,menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull @NotNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.action_add:

                InputProductBinding binding1=InputProductBinding.inflate(getLayoutInflater());

                AlertDialog.Builder builder=new AlertDialog.Builder(getContext());
                //LayoutInflater inflater=this.getLayoutInflater();

                //View dialogView=inflater.inflate(R.layout.input_product,null);
                builder.setView(binding1.getRoot());
                builder.setTitle("Enter Data to insert");

                builder.setPositiveButton("Insert",((dialog, which) -> {

                    String name=binding1.edtNameProduct.getText().toString();

                    String price=binding1.edtPriceProduct.getText().toString();

                    String quantity=binding1.edtQuantityProduct.getText().toString();

                    Toast.makeText(getContext(),name,Toast.LENGTH_SHORT).show();
                    Product product=new Product(name,price,quantity);
                    productArrayList.add(product);

                    binding.tvTotalProduct.setText("Total Product is :"+productArrayList.size());


                }));
                builder.setNeutralButton("Cancel",((dialog, which) -> {
                    dialog.dismiss();
                }));
                AlertDialog dialog=builder.create();
                dialog.show();


        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onProductClick(int position) {

    }
}