package vn.edu.poly.demothi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {

    private EditText edtID;
    private EditText edtName;
    private EditText edtPrice;
    private Button btnAdd;

    private SqliteHelper sqliteHelper;
    private DAOPhone daoPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        sqliteHelper = new SqliteHelper(this);
        daoPhone = new DAOPhone(sqliteHelper);


        edtID = findViewById(R.id.edtID);
        edtName = findViewById(R.id.edtName);
        edtPrice = findViewById(R.id.edtPrice);
        btnAdd = findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = edtID.getText().toString().trim();
                String name = edtName.getText().toString().trim();
                String price = edtPrice.getText().toString().trim();

                if (id.matches("")) {
                    edtID.setError("Empty");
                    return;
                }

                if (name.matches("")) {
                    edtName.setError("Empty");
                    return;
                }

                if (price.matches("")) {
                    edtPrice.setError("Empty");
                    return;
                }

                Phone phone = new Phone(id, name, price);
                long result = daoPhone.insertPhone(phone);

                Toast.makeText(AddActivity.this, result + "", Toast.LENGTH_SHORT).show();
                setResult(999);
                finish();
            }
        });


    }
}
