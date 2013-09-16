package com.example.firstproject;

import com.example.firstproject.variables.Degiskenler;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class InfoPage extends Activity{

	public InfoPage() {
		// TODO Auto-generated constructor stub
	}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.infopage);
        String ad = getIntent().getExtras().getString(Degiskenler.Ad);
        String soyad = getIntent().getExtras().getString(Degiskenler.Soyad);
        Toast.makeText(getApplicationContext(), ad + " , " + soyad, Toast.LENGTH_LONG).show();
    }

}
