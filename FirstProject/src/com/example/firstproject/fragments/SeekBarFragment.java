package com.example.firstproject.fragments;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.SeekBar;

import com.example.firstproject.IColorProvider;
import com.example.firstproject.OnSeekBarChangeListener_withReference;
import com.example.firstproject.R;

public class SeekBarFragment extends Fragment implements IColorProvider { //implements ActionBar.TabListener, IColorProvider  {

	RelativeLayout rl1 = null;
	
	int _red = 0;
	int _blue = 0;
	int _green =0;
	
	SeekBar sb1 = null;
	SeekBar sb2 = null;
	SeekBar sb3 = null;
	
	public SeekBarFragment(){
		// TODO Auto-generated constructor stub
	}
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    	View v = inflater.inflate(R.layout.seekbarlayout, container, false);
    	sb1 = (SeekBar)v.findViewById(R.id.seekBar1);
        sb2 = (SeekBar)v.findViewById(R.id.seekBar2);
        sb3 = (SeekBar)v.findViewById(R.id.seekBar3);
        rl1 = (RelativeLayout)v.findViewById(R.id.background);
        
        sb1.setMax(255);
        sb2.setMax(255);
        sb3.setMax(255);
        
        sb1.setOnSeekBarChangeListener(new OnSeekBarChangeListener_withReference(this) {
			 
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				// TODO Auto-generated method stub
				this._colorProvider.setRed(progress);
				
			}
		});
        
        sb2.setOnSeekBarChangeListener(new OnSeekBarChangeListener_withReference(this) {
			 
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				// TODO Auto-generated method stub
				this._colorProvider.setBlue(progress);
				
			}
		});
        
        sb3.setOnSeekBarChangeListener(new OnSeekBarChangeListener_withReference(this) {
			 
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				// TODO Auto-generated method stub
				this._colorProvider.setGreen(progress);
				
			}
		});
        
        if(null != savedInstanceState)
        {
        	int red = savedInstanceState.getInt("SeekBarRed",0);
        	int blue = savedInstanceState.getInt("SeekBarBlue");
        	int green = savedInstanceState.getInt("SeekBarGreen");
        	this.setRed(red);
        	this.setBlue(blue);
        	this.setGreen(green);
        }
        return v;
    }
    
    @Override
    public void onSaveInstanceState(Bundle outState) {
    	super.onSaveInstanceState(outState);
        outState.putInt("SeekBarRed", sb1.getProgress());
        outState.putInt("SeekBarBlue", sb2.getProgress());
        outState.putInt("SeekBarGreen", sb3.getProgress());
    }
    
    protected void updateBackground()
    {
    	int oran = android.graphics.Color.rgb(this._red, this._green, this._blue);
    	rl1.setBackgroundColor(oran);
    }
    
	public int getRed(){return this._red;}
	public void setRed(int val) {this._red = val;this.updateBackground();}
	public int getBlue(){return this._blue;}
	public void setBlue(int val){this._blue = val;this.updateBackground();}
	public int getGreen(){return this._green;}
	public void setGreen(int val){this._green = val;this.updateBackground();}

}
