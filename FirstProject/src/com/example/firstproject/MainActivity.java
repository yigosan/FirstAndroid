package com.example.firstproject;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;

import com.example.firstproject.fragments.ClickShowFragment;
import com.example.firstproject.fragments.SeekBarFragment;
import com.example.firstproject.fragments.SqlPageFragment;
import com.example.firstproject.fragments.WebViewerFragment;

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
 
        /*
        // Create first Tab
        tab = actionBar.newTab().setTabListener(new SeekBarFragment()));
        // Create your own custom icon
        //tab.setIcon(R.drawable.tab);
        tab.setText("SeekBar");
        tab.setTag("SeekBar");
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
      
      */
        
        tab = actionBar.newTab();
        tab.setText("SeekBar");
        tab.setTabListener(new TabListener<SeekBarFragment>(this, "tab1",SeekBarFragment.class));
        actionBar.addTab(tab);
        
        // Create Second Tab
        tab = actionBar.newTab();
        tab.setText("Sql");
        tab.setTabListener(new TabListener<SqlPageFragment>(this, "tab2",SqlPageFragment.class));
        actionBar.addTab(tab);
 
        // Create Third Tab
        tab = actionBar.newTab();
        tab.setText("Click");
        tab.setTabListener(new TabListener<ClickShowFragment>(this, "tab3",ClickShowFragment.class));
        actionBar.addTab(tab);
        
        // Create Third Tab
        tab = actionBar.newTab();
        tab.setText("Web");
        tab.setTabListener(new TabListener<WebViewerFragment>(this, "tab4",WebViewerFragment.class));
        actionBar.addTab(tab);
      
        
        // check if there is a saved state to select active tab  
        if (savedInstanceState != null) {  
             getActionBar().setSelectedNavigationItem(savedInstanceState.getInt("ACTIVE_TAB"));  
        }
    }
    
    @Override
    public void onSaveInstanceState(Bundle outState) {
    	super.onSaveInstanceState(outState);
    	outState.putInt("ACTIVE_TAB", getActionBar().getSelectedNavigationIndex());  
    }
}
