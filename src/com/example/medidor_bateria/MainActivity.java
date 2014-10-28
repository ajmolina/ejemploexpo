package com.example.medidor_bateria;

import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class MainActivity extends ActionBarActivity {

	private Button btn;
	private TextView txt;

	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		
	
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		
		IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
		Intent batteryStatus = this.registerReceiver(null, ifilter);

		int level = batteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
		int scale = batteryStatus.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
		final float batteryPct = (level / (float)scale)*100;

		
		txt=(TextView)findViewById(R.id.bt);
		btn=(Button) findViewById(R.id.btnbaterry);
	
		btn.setOnClickListener(new OnClickListener() 
		{
			
			@Override
			public void onClick(View v){
				
				txt.setText(Float.toString(batteryPct) + " %");
				
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
