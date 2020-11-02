package com.example.dbhandlingtut;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.example.dbhandlingtut.Database.DBHelper;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    EditText e1;
    EditText e2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = findViewById(R.id.editUser);
        e2 = findViewById(R.id.editPass);

        /*ListView lvContact = findViewById(R.id.lvContact);
        SimpleCursorAdapter simpleCursorAdapter = DBHelper.populateListViewFromDB();
        lvContact.setAdapter(simpleCursorAdapter);*/
    }

    public void add(View view){
        DBHelper dbHelper = new DBHelper(this);

        long val = dbHelper.addInfo(e1.getText().toString(),e2.getText().toString());

        if(val > 0){
            Toast.makeText(this,"Sucessfull",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this,"UnSucessfull",Toast.LENGTH_SHORT).show();
        }

    }

    public void viewAll(View view){
        DBHelper dbHelper = new DBHelper(this);

        List unarmed = dbHelper.readAllInfo("user");

        Toast.makeText(this,unarmed.toString(),Toast.LENGTH_SHORT).show();

    }

    public void deleteData(View view){
        DBHelper dbHelper = new DBHelper(this);

        dbHelper.deleteInfo(e1.getText().toString());

        Toast.makeText(this,e1.getText().toString() + "Deleted Sucessfully", Toast.LENGTH_SHORT).show();

    }

    public void updateData(View view){
        DBHelper dbHelper = new DBHelper(this);

        int val = dbHelper.updateInfo(e1.getText().toString(),e2.getText().toString());

        if(val > 0){
            Toast.makeText(this,"updated Sucessfull",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this,"Not updated",Toast.LENGTH_SHORT).show();
        }

    }



}
