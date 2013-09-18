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

import com.example.firstproject.fragments.ClickShowFragment;
import com.example.firstproject.fragments.SeekBarFragment;
import com.example.firstproject.fragments.SqlPageFragment;
import com.example.firstproject.fragments.WebViewerFragment;
import com.example.firstproject.variables.Degiskenler;

public class MainActivity extends Activity {
	
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
        //tab.setIcon(R.drawable.tab);
        tab.setText("SeekBar");
        actionBar.addTab(tab);
 
        // Create Second Tab
        tab = actionBar.newTab().setTabListener(new SqlPageFragment());
        // Set Tab Title
        tab.setText("Sql");
        actionBar.addTab(tab);
 
        // Create Third Tab
        tab = actionBar.newTab().setTabListener(new ClickShowFragment());
        // Set Tab Title
        tab.setText("Click");
        actionBar.addTab(tab);
        
        // Create Third Tab
        tab = actionBar.newTab().setTabListener(new WebViewerFragment());
        // Set Tab Title
        tab.setText("Web");
        actionBar.addTab(tab);
                
    }
}
