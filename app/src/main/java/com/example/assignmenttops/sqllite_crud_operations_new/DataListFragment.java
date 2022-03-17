package com.example.assignmenttops.sqllite_crud_operations_new;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.assignmenttops.R;
import com.example.assignmenttops.databinding.FragmentDataListBinding;
import com.example.assignmenttops.sqllite_crud_operations_new.database_sqllite.ApplicationDatabase;
import com.example.assignmenttops.sqllite_crud_operations_new.database_sqllite.Data;
import com.example.assignmenttops.sqllite_crud_operations_new.database_sqllite.DataDao;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DataListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DataListFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DataListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DataListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DataListFragment newInstance(String param1, String param2) {
        DataListFragment fragment = new DataListFragment();
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

    private FragmentDataListBinding binding;
    private DataAdapter adapter;
    private List<Data> dataList;
    private DataDao dao;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true);
        binding = FragmentDataListBinding.inflate(inflater, container, false);
        getActivity().setTitle("UserList Fragment");


        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.recyclerViewSqlLite.setLayoutManager(new LinearLayoutManager(getContext()));

        ApplicationDatabase db = ApplicationDatabase.getInstance(getContext());

        dao = db.dataDao();

        dataList = dao.getAllData();

        adapter=new DataAdapter();
        adapter.setDataList(dataList);

        binding.recyclerViewSqlLite.setAdapter(adapter);

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NotNull RecyclerView recyclerView, @NonNull @NotNull RecyclerView.ViewHolder viewHolder, @NonNull @NotNull RecyclerView.ViewHolder target) {

                return false;
            }

            @Override
            public void onSwiped(@NotNull RecyclerView.ViewHolder viewHolder, int direction) {

                int position = viewHolder.getAdapterPosition();

                if (direction == ItemTouchHelper.LEFT) {
                    //delete
                    showConfirmDialog(position);    // dialog

                } else {
                    //update
                    Data theData=dataList.get(position);
                    Bundle bundle=new Bundle();
                    bundle.putParcelable("data",theData);
                    Navigation.findNavController(getView())
                            .navigate(R.id.action_dataListFragment_to_newDataFragment,bundle);

                    // go to new Data and get the bundle




                }
            }

            public void showConfirmDialog(int position) {
                new AlertDialog.Builder(getContext())
                        .setTitle(R.string.app_name)
                        .setMessage("Do u want to delete ? ")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Data theData=dataList.get(position);

                                dao.deleteData(theData);

                                dataList = dao.getAllData();


                                adapter.setDataList(dataList);

                                adapter.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                adapter.notifyDataSetChanged();
                            }
                        })
                        .create().show();
            }

            @Override
            public void onChildDraw(@NotNull Canvas c, @NotNull RecyclerView recyclerView, @NonNull @NotNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {

                Paint paint = new Paint();

                Bitmap icon;

                View itemView = viewHolder.itemView;

                int height = itemView.getHeight();

                int padding = height / 3;


                if (dX > 0) {
                    paint.setColor(Color.GREEN);
                    c.drawRect(itemView.getLeft(), itemView.getTop(), dX, itemView.getBottom(), paint);
                    icon = BitmapFactory.decodeResource(getResources(), android.R.drawable.ic_menu_edit);
                    c.drawBitmap(icon, (padding), itemView.getTop() + padding, paint);
                } else {
                    paint.setColor(Color.RED);
                    c.drawRect(itemView.getRight() + dX, itemView.getTop(), itemView.getRight(), itemView.getBottom(), paint);
                    icon = BitmapFactory.decodeResource(getResources(), android.R.drawable.ic_menu_delete);
                    c.drawBitmap(icon, itemView.getRight() - (padding*2), itemView.getTop() + padding, paint);
                }
                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
            }
        });
        itemTouchHelper.attachToRecyclerView(binding.recyclerViewSqlLite);
    }

    @Override
    public void onCreateOptionsMenu(@NotNull Menu menu, @NonNull @NotNull MenuInflater inflater) {
        inflater.inflate(R.menu.add_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull @NotNull MenuItem item) {

        if (item.getItemId() == R.id.action_add) {

            Navigation.findNavController(getView())
                    .navigate(R.id.action_dataListFragment_to_newDataFragment);
        }

        return super.onOptionsItemSelected(item);
    }
}