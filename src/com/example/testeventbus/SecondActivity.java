package com.example.testeventbus;

import com.example.testeventbus.event.FirstEvent;

import de.greenrobot.event.EventBus;
import android.app.Activity;
import android.os.Bundle;


public class SecondActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    
        // TODO 自动生成的方法存根
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activty);
        EventBus.getDefault().post(new FirstEvent("hahahhhhh,aha!"));   
    }

}
