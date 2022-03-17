package com.example.assignmenttops.sqllite_crud_operations;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.example.assignmenttops.R;
import com.example.assignmenttops.databinding.ActivityPersonListBinding;
import com.example.assignmenttops.sqllite_crud_operations.database.AppDatabase;
import com.example.assignmenttops.sqllite_crud_operations.database.PersonDao;
import com.example.assignmenttops.sqllite_crud_operations.database.PersonDataSql;
import com.example.assignmenttops.sqllite_crud_operations.database.UtilityHelper;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class PersonListActivity extends AppCompatActivity {
    private static final int REQ_NEW_PERSON = 100;
    private static final int REQ_UPDATE_PERSON = 200;

    private ActivityPersonListBinding binding;
    private List<PersonDataSql> list;
    private PersonDao dao;
    private PersonSqlAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPersonListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        AppDatabase database = UtilityHelper.getDataBase(this);
        PersonDao dao = database.personDao();

        list = dao.getPersonData();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        binding.recyclerViewSql.setLayoutManager(layoutManager);

        binding.recyclerViewSql.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));

        adapter = new PersonSqlAdapter(list);

        binding.recyclerViewSql.setAdapter(adapter);


    }

    ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(@NonNull @NotNull RecyclerView recyclerView, @NonNull @NotNull RecyclerView.ViewHolder viewHolder, @NonNull @NotNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull @NotNull RecyclerView.ViewHolder viewHolder, int direction) {
            int position = viewHolder.getAdapterPosition();
            if (direction == ItemTouchHelper.LEFT) {
                //delete
                showConfirmDialog(position);
            } else {

                //edit
                Intent intent = new Intent(getApplicationContext(), PersonActivity.class);
                PersonDataSql personDataSql = list.get(position);
                intent.putExtra("person", personDataSql);
                startActivityForResult(intent, REQ_UPDATE_PERSON);

            }


        }

        @Override
        public void onChildDraw(@NonNull @NotNull Canvas c, @NonNull @NotNull RecyclerView recyclerView, @NonNull @NotNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
            Paint paint = new Paint();
            View itemView = viewHolder.itemView;
            Bitmap bitmap;
            int height = itemView.getHeight();
            int width = height / 3;
            if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {
                if (dX > 0) {
                    paint.setColor(Color.GREEN);
                    c.drawRect(itemView.getLeft(), itemView.getTop(), dX, itemView.getBottom(), paint);
                    bitmap = BitmapFactory.decodeResource(getResources(), android.R.drawable.ic_menu_edit);
                    c.drawBitmap(bitmap, width, itemView.getTop() + width, paint);

                } else if (dX < 0) {
                    paint.setColor(Color.RED);
                    c.drawRect(itemView.getRight() + dX, itemView.getTop(), itemView.getRight(), itemView.getBottom(), paint);
                    bitmap = BitmapFactory.decodeResource(getResources(), android.R.drawable.ic_menu_delete);
                    c.drawBitmap(bitmap, itemView.getRight() - (width * 2), itemView.getTop() + width, paint);

                }
            }


        }

    });


    private void showConfirmDialog(int position) {
        new AlertDialog.Builder(this)
                .setTitle(getString(R.string.app_name))
                .setMessage("Are you sure want to Delete?")
                .setPositiveButton("Yes", (dialog, which) -> {
                    PersonDataSql personDataSql = list.get(position);
                    dao.deletePerson(personDataSql);

                    list = dao.getPersonData();
                    adapter = new PersonSqlAdapter(list);
                    adapter.notifyDataSetChanged();

                })
                .setNegativeButton("No", (dialog, which) ->
                        adapter.notifyDataSetChanged())
                .create().show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_add) {
            Intent intent = new Intent(this, PersonActivity.class);
            startActivityForResult(intent, REQ_NEW_PERSON);
            return true;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQ_NEW_PERSON) {
            if (resultCode == RESULT_OK) {
                PersonDataSql personDataSql = data.getParcelableExtra("person");
                list = dao.getPersonData();
                adapter = new PersonSqlAdapter(list);
                adapter.notifyDataSetChanged();

            }
        }
    }
}