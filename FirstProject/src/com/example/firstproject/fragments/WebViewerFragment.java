package com.example.firstproject.fragments;

import com.example.firstproject.R;
import com.example.firstproject.WebDisplay;
import com.example.firstproject.variables.Degiskenler;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class WebViewerFragment  extends Fragment implements ActionBar.TabListener  {

	Button btn3 = null;
	TextView txturl = null;
	
private Fragment mFragment;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

    	View v = inflater.inflate(R.layout.webviewer, container, false);
        txturl = (TextView)v.findViewById(R.id.txtUrl);
        btn3 = (Button)v.findViewById(R.id.button3);
        btn3.setOnClickListener(new View.OnClickListener() {
        final Context c = getActivity().getApplicationContext();
    		@Override
    		public void onClick(View v) {
    			// TODO Auto-generated method stub
    			String url = txturl.getText().toString();
    			Intent i = new Intent();
    			i.putExtra(Degiskenler.URL, url);
    			i.setClass(c, WebDisplay.class);
    			startActivity(i);
    		}
    	});
        return v;
    }

    
	
	public WebViewerFragment() {
		// TODO Auto-generated constructor stub
	}

    public void onTabSelected(Tab tab, FragmentTransaction ft) {
        // TODO Auto-generated method stub
        mFragment = new WebViewerFragment();
        // Attach fragment1.xml layout
        ft.add(android.R.id.content, mFragment);
        ft.attach(mFragment);
    }
 
    public void onTabUnselected(Tab tab, FragmentTransaction ft) {
        // TODO Auto-generated method stub
        // Remove fragment1.xml layout
        ft.remove(mFragment);
    }
 
    public void onTabReselected(Tab tab, FragmentTransaction ft) {
        // TODO Auto-generated method stub
 
    }

}
