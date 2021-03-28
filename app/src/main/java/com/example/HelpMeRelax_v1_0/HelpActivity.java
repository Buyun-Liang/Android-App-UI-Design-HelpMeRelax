package com.example.HelpMeRelax_v1_0;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

public class HelpActivity extends AppCompatActivity {

//    // references to button and other controls on the layout
//    Button btn_add, btn_viewAll;
//    EditText et_name, et_age;
//    Switch sw_activeCustomer;
//    ListView lv_customerList;
//
//    ArrayAdapter customerArrayAdapter;
//    PostDBHelper postDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);


//        btn_add = findViewById(R.id.btn_add);
//        btn_viewAll = findViewById(R.id.btn_viewAll);
//        et_age = findViewById(R.id.et_age);
//        et_name = findViewById(R.id.et_name);
//        sw_activeCustomer = findViewById(R.id.sw_active);
//        lv_customerList = findViewById(R.id.lv_customerList);
//
//        dataBaseHelper = new DataBaseHelper(HelpActivity.this);
//
//        ShowCustomersOnListView(dataBaseHelper);
//
//        // button listeners for the add and view all buttons
//        btn_add.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
////                CustomerModel customerModel;
////                try{
////                    customerModel = new CustomerModel(-1, et_name.getText().toString(), title, content, Integer.parseInt(et_age.getText().toString()), sw_activeCustomer.isChecked());
////
////                    Toast.makeText(HelpActivity.this,customerModel.toString(), Toast.LENGTH_SHORT).show();
////                }
////                catch (Exception e) {
////                    Toast.makeText(HelpActivity.this,"Error Creating Customer", Toast.LENGTH_SHORT).show();
////                    customerModel = new CustomerModel(-1,"error", title, content, 0,false);
////                }
////
////                DataBaseHelper dataBaseHelper = new DataBaseHelper(HelpActivity.this);
////
////                boolean success = dataBaseHelper.addOne(customerModel);
////
////                Toast.makeText(HelpActivity.this, "Success= " + success, Toast.LENGTH_SHORT).show();
////                ShowCustomersOnListView(dataBaseHelper);
//            }
//        });
//
//        btn_viewAll.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                DataBaseHelper dataBaseHelper = new DataBaseHelper(HelpActivity.this);
//
//                ShowCustomersOnListView(dataBaseHelper);
////                Toast.makeText(HelpActivity.this,everyone.toString(), Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        lv_customerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                CustomerModel clickCustomer = (CustomerModel) parent.getItemAtPosition(position);
//                dataBaseHelper.deleteOne(clickCustomer);
//                ShowCustomersOnListView(dataBaseHelper);
//                Toast.makeText(HelpActivity.this, " Deleted " + clickCustomer.toString(), Toast.LENGTH_SHORT).show();
//            }
//        });
    }
//
//    private void ShowCustomersOnListView(DataBaseHelper dataBaseHelper2) {
//        customerArrayAdapter = new ArrayAdapter<CustomerModel>(HelpActivity.this, android.R.layout.simple_list_item_1, dataBaseHelper2.getEveryone());
//        lv_customerList.setAdapter(customerArrayAdapter);
//    }


}
