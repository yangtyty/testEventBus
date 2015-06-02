
package com.example.testeventbus;

import com.example.testeventbus.event.FirstEvent;

import de.greenrobot.event.EventBus;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    TextView tx;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
	
	super.onCreate(savedInstanceState);
	requestWindowFeature(Window.FEATURE_NO_TITLE);
	setContentView(R.layout.activity_main);
	init();
	
    }
    private void init() {

	// TODO 自动生成的方法存根
	EventBus.getDefault().register(this);  
	tx=(TextView) findViewById(R.id.tx);
	btn=(Button) findViewById(R.id.btn);
	btn.setOnClickListener(new OnClickListener() {
	    
	    @Override
	    public void onClick(View v) {
	    
		// TODO 自动生成的方法存根
		Intent intent=new Intent();
		intent.setClass(MainActivity.this, SecondActivity.class);
		startActivity(intent);	
	    }
	});
    }
    
    
    public void onEventMainThread(FirstEvent fet) {

	// TODO 自动生成的方法存根
	String info=fet.getMsg();
	Log.e("onEventMainThread", info);
	tx.setText(info);
    }
    
    @Override
    protected void onDestroy() {
    
        // TODO 自动生成的方法存根
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
