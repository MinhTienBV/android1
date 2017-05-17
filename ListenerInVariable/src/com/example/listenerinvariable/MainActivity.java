package com.example.listenerinvariable;


import java.text.DecimalFormat;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
//import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {
	
	private Button btnFar,btnCel,btnClear;
	private EditText txtFar,txtCel;
	
	private OnClickListener myVarListener=new OnClickListener() {
		@Override
		public void onClick(View arg0) {
			EditText txtCel = (EditText)findViewById(R.id.edtCel);
			EditText txtFah = (EditText)findViewById(R.id.edtFah);
		
			
		if(arg0==btnFar)
		{
			double c ,f;
			f = Double.parseDouble(txtFah.getText()+"");
			c = (f- 32)* (5/9);
			DecimalFormat dcf= new DecimalFormat("#.00");
			txtCel.setText( dcf.format(c));
			
		}
		else if(arg0==btnCel)
		{
			double c ,f;
			c = Double.parseDouble(txtCel.getText()+"");
			f = c*(9/5) + 32;
			DecimalFormat dcf= new DecimalFormat("#.00");
			txtFah.setText(dcf.format(f));
		}
		else if(arg0==btnClear)
		{
		txtFar.setText("");
		MainActivity.this.txtCel.setText("");
		txtFar.requestFocus();
		}
		}
		};

		
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btnFar = (Button)findViewById(R.id.btnFah);
		btnCel = (Button)findViewById(R.id.btnCel);
		btnClear = (Button)findViewById(R.id.btnClear);
		txtFar = (EditText)findViewById(R.id.edtFah);
		txtCel = (EditText)findViewById(R.id.edtCel);
		
		btnFar.setOnClickListener(myVarListener);
		btnCel.setOnClickListener(myVarListener);
		btnClear.setOnClickListener(myVarListener);


		
		
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
