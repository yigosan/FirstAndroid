package com.example.firstproject;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class TabHostPage extends TabActivity{

	public TabHostPage(){
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tabbedpage);
		
		TabHost th = (TabHost) findViewById(android.R.id.tabhost);
		
		TabSpec tab1 = th.newTabSpec("tab1");
		TabSpec tab2 = th.newTabSpec("tab2");
		
		tab1.setIndicator("Ana Sayfa", getResources().getDrawable(android.R.color.black)).setContent(new Intent(this,MainActivity.class));
		// tab2.setIndicator("SQL", getResources().getDrawable(android.R.color.black)).setContent(new Intent(this,SqlPage.class));
		
		th.addTab(tab1);
		// th.addTab(tab2);
		
	}

}
