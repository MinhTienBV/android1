package com.example.bai12_tttbs;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.app.Activity; 
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
	
	
	Button btnTT,btnTiep,btnTK;
	ImageButton btnThoat;
	EditText editTen,editSl,editTongKh,editTongKhVip,ediTongTT;
	TextView txtTT;
	CheckBox chkVip;
	DanhSachKhachHang danhsach=new DanhSachKhachHang();


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		getControls();
		addEvents();
		 
	}

	private void getControls()
	 
	{
		 
		btnTT=(Button) findViewById(R.id.btnTT);
		btnTiep=(Button) findViewById(R.id.btnTiep);
		btnTK=(Button) findViewById(R.id.btnTK);
		btnThoat=(ImageButton) findViewById(R.id.btnThoat);
		editTen=(EditText) findViewById(R.id.editTen);
		editSl=(EditText) findViewById(R.id.editSl);
		editTongKh=(EditText) findViewById(R.id.editTongKh);
		editTongKhVip=(EditText) findViewById(R.id.editTongKhVip);
		ediTongTT=(EditText) findViewById(R.id.editTongTT);
		txtTT=(TextView) findViewById(R.id.txtTT);
		chkVip =(CheckBox) findViewById(R.id.chkVip);
		 
	}
	 
	private void addEvents()
	 
	{
		 
		btnTT.setOnClickListener(new ProcessMyEvent());
		btnTiep.setOnClickListener(new ProcessMyEvent());
		btnTK.setOnClickListener(new ProcessMyEvent());
		btnThoat.setOnClickListener(new ProcessMyEvent());
		 
	}
	
	private void doTinhTien()
	 
	{
	 
	KhachHang kh=new KhachHang(); 
	kh.setTenKh(editTen.getText()+""); 
	kh.setSlmua(Integer.parseInt(editSl.getText()+"")); 
	kh.setVip(chkVip.isChecked());
	txtTT.setText(kh.tinhThanhTien()+"");
	danhsach.addKhachHang(kh);
	}
	 
	private void doTiep() 
	{
	editTen.setText("");
	editSl.setText(""); 
	txtTT.setText("");
	editTen.requestFocus(); 
	}
	 
	private void doThongKe()
	 
	{ 
	editTongKh.setText(danhsach.tongKhachHang()+"");
	editTongKhVip.setText(danhsach.tongKhachHangVip()+"");
	ediTongTT.setText(danhsach.tongDoanhThu()+""); 
	}
	 
	private void doThoat()
	 
	{
	 AlertDialog.Builder builder=new AlertDialog.Builder(this);
	 builder.setTitle("hỏi thoát chương trình");
	 builder.setMessage("Muốn thoát chương trình này hả?" ) ;
	 builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
		 
		@Override
		 
		public void onClick(DialogInterface dialog, int which) {
		 dialog.cancel();
		 
		}
		 
		});

	builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
		 
		@Override
		 
		public void onClick(DialogInterface dialog, int which) {
		 
		finish();
		 
		}
		 
		});
		 
		builder.create().show();
		}
	
	private class ProcessMyEvent implements OnClickListener
	 
	{
	 
	@Override
	 
	public void onClick(View arg0) {
	switch(arg0.getId()) 
	{
		case R.id.btnTT:
		doTinhTien();
		break;
		case R.id.btnTiep:
		doTiep();
		break;
		case R.id.btnTK:
		doThongKe();
		break;
		case R.id.btnThoat:
		doThoat();
		break;
	 
	}
	}


	 

	
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

/*	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		 return super.onOptionsItemSelected(item);
	}*/
	}
}

