package com.example.firstproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.firstproject.variables.Degiskenler;

public class MainActivity extends Activity implements IColorProvider{

	SeekBar sb1 = null;
	SeekBar sb2 = null;
	SeekBar sb3 = null;
	RelativeLayout rl1 = null;
	int _red = 0;
	int _blue = 0;
	int _green =0;
	ImageView imv1 = null;
	ImageView imv2 = null;
	Button btn1 = null;
	Button btn2 = null;
	Button btn3 = null;
	Button btn4 = null;
	TextView txturl = null;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        sb1 = (SeekBar)findViewById(R.id.seekBar1);
        sb2 = (SeekBar)findViewById(R.id.seekBar2);
        sb3 = (SeekBar)findViewById(R.id.seekBar3);
        rl1 = (RelativeLayout)findViewById(R.id.background);
        imv1 = (ImageView)findViewById(R.id.imageView1);
        imv2 = (ImageView)findViewById(R.id.imageView2);
        btn1 = (Button)findViewById(R.id.button1);
        btn2 = (Button)findViewById(R.id.button2);
        btn3 = (Button)findViewById(R.id.button3);
        btn4 = (Button)findViewById(R.id.button4);
        imv1.setVisibility(View.INVISIBLE);
        imv2.setVisibility(View.INVISIBLE);
        txturl = (TextView)findViewById(R.id.txtUrl);
        
        btn4.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(getApplicationContext(),SqlPage.class));
			}
		});
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
				sb1.setMax(255);
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
				sb2.setMax(255);
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
				sb3.setMax(255);
				this._colorProvider.setGreen(progress);
				
			}
		});
        
        // little dummy note
    }

    protected void updateBackground()
    {
    	int oran = android.graphics.Color.rgb(this._red, this._green, this._blue);
    	rl1.setBackgroundColor(oran);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
    	super.onCreateOptionsMenu(menu);    	
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    
	public int getRed(){return this._red;}
	public void setRed(int val) {this._red = val;this.updateBackground();}
	public int getBlue(){return this._blue;}
	public void setBlue(int val){this._blue = val;this.updateBackground();}
	public int getGreen(){return this._green;}
	public void setGreen(int val){this._green = val;this.updateBackground();}
    
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch(item.getItemId())
		{
			case R.id.menuitem1 : System.exit(0); return true;
			case R.id.menuitem2 : startActivity(new Intent(getApplicationContext(),SqlPage.class)); return true;
		}
		return false;
	}
}
