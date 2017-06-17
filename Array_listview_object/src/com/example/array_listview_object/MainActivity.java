package com.example.array_listview_object;

import java.util.ArrayList;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;


public class MainActivity extends ActionBarActivity {

	

EditText editId,editName;
 Button btnNhap;
 RadioGroup radgroup;
 ListView lvNhanvien;
 ArrayList<Employee>arrEmployee=new ArrayList<Employee>();
 ArrayAdapter<Employee>adapter=null;
 //Khai báo 1 employee object
 Employee employee=null;

	
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        editId=(EditText) findViewById(R.id.editTextMNV);
        editName=(EditText) findViewById(R.id.editTextTenNV);
        btnNhap=(Button) findViewById(R.id.buttonNhap);
        radgroup=(RadioGroup) findViewById(R.id.radioGroup);
        lvNhanvien=(ListView) findViewById(R.id.listViewNV);
        //đưa Data Source là các employee vào Adapter
        adapter=new ArrayAdapter<Employee>(this,
        android.R.layout.simple_list_item_1,
        arrEmployee);
        //đưa adapter vào ListView
        lvNhanvien.setAdapter(adapter);
        
        btnNhap.setOnClickListener(new OnClickListener() {
        
        @Override
        public void onClick(View arg0) {
        // TODO Auto-generated method stub
        	processNhap();
        }
        });
        }
        //Xử lý sự kiện nhập
        public void processNhap()
        {
        //Lấy ra đúng id của Radio Button được checked
        int radId=radgroup.getCheckedRadioButtonId();
        String id=editId.getText()+"";
        String name=editName.getText()+"";
        if(radId==R.id.radioChinhThuc)
        {
        //tạo instance là FullTime
        employee=new EmployeeFullTime();
        }
        else
        {
        //Tạo instance là Partime
        employee=new EmployeePartTime();
        }
        //FullTime hay Partime thì cũng là Employee
        //nên có các hàm này là hiển nhiên
        employee.setId(id);
        employee.setTen(name);
        //Đưa employee vào ArrayList
        arrEmployee.add(employee);
        //Cập nhập giao diện
        adapter.notifyDataSetChanged();
        }

       


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
