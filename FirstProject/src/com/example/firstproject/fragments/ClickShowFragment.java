package com.example.firstproject.fragments;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.firstproject.R;

public class ClickShowFragment extends Fragment { //implements ActionBar.TabListener {

	ImageView imv1 = null;
	ImageView imv2 = null;
	Button btn2 = null;
	
    private Fragment mFragment;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.clicklayout, container, false);
     
        imv1 = (ImageView)v.findViewById(R.id.imageView1);
        imv2 = (ImageView)v.findViewById(R.id.imageView2);
        btn2 = (Button)v.findViewById(R.id.button2);
        imv1.setVisibility(View.INVISIBLE);
        imv2.setVisibility(View.INVISIBLE);
        
        imv1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				imv2.setVisibility(View.VISIBLE);
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
        
        return v;
    }
	
	public ClickShowFragment() {
		// TODO Auto-generated constructor stub
	}

/*
    public void onTabSelected(Tab tab, FragmentTransaction ft) {
        // TODO Auto-generated method stub
    	mFragment = new ClickShowFragment();
        // Attach fragment1.xml layout
        ft.replace(android.R.id.content, mFragment);
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
*/
}
