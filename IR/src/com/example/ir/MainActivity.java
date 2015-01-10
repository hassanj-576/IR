package com.example.ir;

import java.io.Console;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;



public class MainActivity extends Activity{
	
	private static final String TAG = "ConsumerIrTest";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button irButton = (Button) findViewById(R.id.IrButton);
        final ConsumerIrManager manager = ConsumerIrManager.getSupportConsumerIrManager(this);
        final IrCommand prontoCommand = IrCommand.Pronto.buildPronto("0000 006d 0022 0003 00a9 00a8 0015 003f 0015 003f 0015 003f 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 003f 0015 003f 0015 003f 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 003f 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 0040 0015 0015 0015 003f 0015 003f 0015 003f 0015 003f 0015 003f 0015 003f 0015 0702 00a9 00a8 0015 0015 0015 0e6e");
       
        irButton.setOnClickListener(new OnClickListener() {
        	
       
			public void onClick(View v) {
				 if (!manager.hasIrEmitter()) {
					 Toast.makeText(getApplicationContext(), "Cannot Find Transmitter", Toast.LENGTH_LONG).show();
					 Log.e(TAG, "No IR Emitter found\n");
	        		 return;
	        		 }
				
						// transmit the pattern at 38.4KHz
				 		manager.transmit(prontoCommand);
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
