package com.example.congtrunhanchia;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
	
	
	EditText editA, editB,editKQ;
	Button btnTH;
	RadioButton radioCong, radioTru, radioNhan, radioChia;

	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		radioCong = (RadioButton) findViewById(R.id.radioCong);
		radioTru = (RadioButton) findViewById(R.id.radioTru);
		radioNhan = (RadioButton) findViewById(R.id.radioNhan);
		radioChia = (RadioButton) findViewById(R.id.radioChia);
		
	
		
		btnTH = (Button) findViewById(R.id.btnTH);
		btnTH.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				

				editA = (EditText)findViewById(R.id.editA);
				int a = Integer.parseInt(editA.getText()+"");
				editB = (EditText)findViewById(R.id.editB);
				int b = Integer.parseInt(editB.getText()+"");
				editKQ = (EditText)findViewById(R.id.editKQ);
				
				
				if(radioCong.isChecked()== true)
					editKQ.setText(""+(a+b));
					
				if(radioTru.isChecked()== true)
					editKQ.setText(""+(a-b));
				
				if(radioNhan.isChecked()== true)
					editKQ.setText(""+(a*b));
				
				if(radioChia.isChecked()== true)
					editKQ.setText(""+ ((float)a/b));
					
				
				
				
			}
		});
		
		
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
