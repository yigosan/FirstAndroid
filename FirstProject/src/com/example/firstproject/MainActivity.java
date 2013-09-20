package com.example.firstproject;

import java.lang.reflect.Type;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.os.Bundle;

import com.example.firstproject.fragments.ClickShowFragment;
import com.example.firstproject.fragments.PictureGaleryFragment;
import com.example.firstproject.fragments.SeekBarFragment;
import com.example.firstproject.fragments.SqlPageFragment;
import com.example.firstproject.fragments.WebServiceFragment;
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
        System.out.println("**********************" + SeekBarFragment.class.getName());

        tab = actionBar.newTab();
        tab.setText("SeekBar");
        tab.setTabListener(new TabListener<SeekBarFragment>(this, "tab1","com.example.firstproject.fragments.SeekBarFragment"));
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
      
        // Create Fourth Tab
        tab = actionBar.newTab();
        tab.setText("Gallery");
        tab.setTabListener(new TabListener<PictureGaleryFragment>(this, "tab5",PictureGaleryFragment.class));
        actionBar.addTab(tab);
        
        // Create Fifth Tab
        tab = actionBar.newTab();
        tab.setText("WebService");
        tab.setTabListener(new TabListener<WebServiceFragment>(this, "tab6", WebServiceFragment.class));
        actionBar.addTab(tab);
        
        /*

        tab = actionBar.newTab();
        tab.setText("SeekBar");
        tab.setTabListener(new TabListener<SeekBarFragment>(this, "tab1", null));
        actionBar.addTab(tab);
        
        // Create Second Tab
        tab = actionBar.newTab();
        tab.setText("Sql");
        tab.setTabListener(new TabListener<SqlPageFragment>(this, "tab2", null));
        actionBar.addTab(tab);
 
        // Create Third Tab
        tab = actionBar.newTab();
        tab.setText("Click");
        tab.setTabListener(new TabListener<ClickShowFragment>(this, "tab3", null));
        actionBar.addTab(tab);
        
        // Create Third Tab
        tab = actionBar.newTab();
        tab.setText("Web");
        tab.setTabListener(new TabListener<WebViewerFragment>(this, "tab4",null));
        actionBar.addTab(tab);
        
        */
        
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
