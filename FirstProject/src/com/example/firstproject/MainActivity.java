package com.example.firstproject;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.firstproject.fragments.SeekBarFragment;
import com.example.firstproject.fragments.SqlPageFragment;
import com.example.firstproject.variables.Degiskenler;

public class MainActivity extends Activity {

	ImageView imv1 = null;
	ImageView imv2 = null;
	Button btn1 = null;
	Button btn2 = null;
	Button btn3 = null;
	TextView txturl = null;
	
	Tab tab;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        ActionBar actionBar = getActionBar();
        // Hide Actionbar Icon
        actionBar.setDisplayShowHomeEnabled(false);
        // Hide Actionbar Title
        actionBar.setDisplayShowTitleEnabled(false);
        // Create Actionbar Tabs
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
 
        // Create first Tab
        tab = actionBar.newTab().setTabListener(new SeekBarFragment());
        // Create your own custom icon
        tab.setIcon(R.drawable.tab);
        actionBar.addTab(tab);
 
        // Create Second Tab
        tab = actionBar.newTab().setTabListener(new SqlPageFragment());
        // Set Tab Title
        tab.setText("Tab2");
        actionBar.addTab(tab);
 
        /*
        // Create Third Tab
        tab = actionBar.newTab().setTabListener(new FragmentTab3());
        // Set Tab Title
        tab.setText("Tab3");
        actionBar.addTab(tab);
        */
        
        imv1 = (ImageView)findViewById(R.id.imageView1);
        imv2 = (ImageView)findViewById(R.id.imageView2);
        btn1 = (Button)findViewById(R.id.button1);
        btn2 = (Button)findViewById(R.id.button2);
        btn3 = (Button)findViewById(R.id.button3);
        imv1.setVisibility(View.INVISIBLE);
        imv2.setVisibility(View.INVISIBLE);
        txturl = (TextView)findViewById(R.id.txtUrl);
        
       
        btn3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String url = txturl.getText().toString();
				Intent i = new Intent();
				i.putExtra(Degiskenler.URL, url);
				i.setClass(getApplicationContext(), WebDisplay.class);
				startActivity(i);
			}
		});
        
        imv1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				imv2.setVisibility(View.VISIBLE);
			}
		});
		
        btn1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent();
				i.putExtra(Degiskenler.Ad, "Yigit");
				i.putExtra(Degiskenler.Soyad, "Ersun");
				i.setClass(getApplicationContext(), InfoPage.class);
				startActivity(i);
				
			}
		});
		
        btn2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				imv1.setImageResource(R.drawable.sinyal);
				imv1.setVisibility(View.VISIBLE);
			}
		});
        
		
       
        
        // little dummy note
    }

}
