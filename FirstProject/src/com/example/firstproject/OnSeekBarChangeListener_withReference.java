package com.example.firstproject;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class OnSeekBarChangeListener_withReference implements
		OnSeekBarChangeListener {
	
	protected IColorProvider _colorProvider;

	public OnSeekBarChangeListener_withReference(IColorProvider colorProvider) {
		// TODO Auto-generated constructor stub
		this._colorProvider = colorProvider;
	}

	@Override
	public void onProgressChanged(SeekBar seekBar, int progress,
			boolean fromUser) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		
	}

}
