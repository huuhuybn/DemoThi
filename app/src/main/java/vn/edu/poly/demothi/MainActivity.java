package vn.edu.poly.demothi;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private RecyclerView lvList;
    private PhoneAdapter phoneAdapter;
    private List<Phone> phones;
    private LinearLayoutManager linearLayoutManager;

    private SqliteHelper sqliteHelper;
    private DAOPhone daoPhone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvList = findViewById(R.id.lvList);

        sqliteHelper = new SqliteHelper(this);
        daoPhone = new DAOPhone(sqliteHelper);

        initData();

        phones = daoPhone.getAllPhones();


        Log.e("SIZE", phones.size() + "");

        phoneAdapter = new PhoneAdapter(this, phones);

        linearLayoutManager = new LinearLayoutManager(this);

        lvList.setAdapter(phoneAdapter);
        lvList.setLayoutManager(linearLayoutManager);

        findViewById(R.id.btnAdd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivityForResult(intent, 999);

            }
        });


    }

    public void initData() {
        daoPhone.insertPhone(new Phone("1", "Samsung", "1000"));
        daoPhone.insertPhone(new Phone("2", "Sony", "1000"));
        daoPhone.insertPhone(new Phone("3", "Huewi", "1000"));
        daoPhone.insertPhone(new Phone("4", "HTC", "1000"));
        daoPhone.insertPhone(new Phone("5", "Apple", "1000"));
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        phones = new ArrayList<>();
        phones = daoPhone.getAllPhones();


        Log.e("SIZE", phones.size() + "");

        phoneAdapter = new PhoneAdapter(this, phones);

        linearLayoutManager = new LinearLayoutManager(this);

        lvList.setAdapter(phoneAdapter);
        lvList.setLayoutManager(linearLayoutManager);

    }
}
