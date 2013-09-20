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
import android.widget.CheckBox;
import android.widget.TextView;
import android.net.Uri;

public class WebViewerFragment  extends Fragment { // implements ActionBar.TabListener  {

	Button btn3 = null;
	TextView txturl = null;
	CheckBox chbbrowser = null;

	public WebViewerFragment() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

    	View v = inflater.inflate(R.layout.webviewer, container, false);
        txturl = (TextView)v.findViewById(R.id.txtUrl);
        btn3 = (Button)v.findViewById(R.id.button3);
        chbbrowser = (CheckBox)v.findViewById(R.id.chbUseBrowser);
        final boolean useinternal = chbbrowser.isChecked();
        final Context c = getActivity().getApplicationContext();
        btn3.setOnClickListener(new View.OnClickListener() {
        	@Override
        	public void onClick(View v) {
			// TODO Auto-generated method stub
        		String url = txturl.getText().toString();
        		if(!url.toLowerCase().startsWith("http://")) url = "http://" + url;
        		// This will not work, chbbrowser check is done at load time, but click will happen afterwards.
        		// We need an interface to get chbbrowser status at the time of click (Like in SqlPageFragment example.
        		if(useinternal)
        		{
        			Intent i = new Intent();
        			i.putExtra(Degiskenler.URL, url);
        			i.setClass(c, WebDisplay.class);
        			startActivity(i);
        		}else
        		{
        			Uri site = Uri.parse(url);
        			Intent i2 = new Intent(Intent.ACTION_VIEW,site);
        			startActivity(i2);
        		}
        	}
    	});
        return v;
    }

}
