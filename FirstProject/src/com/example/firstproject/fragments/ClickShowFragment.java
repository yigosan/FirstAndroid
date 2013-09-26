package com.example.firstproject.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.firstproject.R;

public class ClickShowFragment extends Fragment { 

	ImageView imv1 = null;
	ImageView imv2 = null;
	Button btn2 = null;
	View mMyView = null;
	
	public ClickShowFragment() {
		// TODO Auto-generated constructor stub
	}
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    	if(null == mMyView)
    	{
    		mMyView = inflater.inflate(R.layout.clicklayout, container, false);
     
	        imv1 = (ImageView)mMyView.findViewById(R.id.imageView1);
	        imv2 = (ImageView)mMyView.findViewById(R.id.imageView2);
	        btn2 = (Button)mMyView.findViewById(R.id.btnGetMenu);
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
    	}else{
    		container.removeView(mMyView);
    	}
        
        return mMyView;
    }
	
}
