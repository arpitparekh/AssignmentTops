package com.example.assignmenttops.sqllite_crud_operations;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.Toast;

import com.example.assignmenttops.databinding.ActivityPersonBinding;
import com.example.assignmenttops.sqllite_crud_operations.database.AppDatabase;
import com.example.assignmenttops.sqllite_crud_operations.database.PersonDao;
import com.example.assignmenttops.sqllite_crud_operations.database.PersonDataSql;
import com.example.assignmenttops.sqllite_crud_operations.database.UtilityHelper;

public class PersonActivity extends AppCompatActivity {
    private ActivityPersonBinding binding;
    private PersonDataSql thePersonDataSql;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPersonBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnSubmitSql.setOnClickListener(v -> {

            AppDatabase database = UtilityHelper.getDataBase(this);

            PersonDao dao = database.personDao();

            if (thePersonDataSql == null) {


                thePersonDataSql = new PersonDataSql();

                thePersonDataSql.id = Integer.parseInt(binding.edtId.getText().toString());
                thePersonDataSql.firstName = binding.edtFistName.getText().toString();
                thePersonDataSql.lastName = binding.edtLastName.getText().toString();
                thePersonDataSql.email = binding.edtEmail.getText().toString();
                dao.savePerson(thePersonDataSql);

                Toast.makeText(this, "Data Added SuccessFully", Toast.LENGTH_SHORT).show();
            } else {

                thePersonDataSql.firstName = binding.edtFistName.getText().toString();
                thePersonDataSql.lastName = binding.edtLastName.getText().toString();
                thePersonDataSql.email = binding.edtEmail.getText().toString();
                dao.updatePerson(thePersonDataSql);
                Toast.makeText(this, "User Updated", Toast.LENGTH_SHORT).show();

            }

            Intent intent=new Intent(this,PersonListActivity.class);
            intent.putExtra("person",thePersonDataSql);
            setResult(RESULT_OK,intent);
            startActivity(intent);
            finish();

        });
    }
}