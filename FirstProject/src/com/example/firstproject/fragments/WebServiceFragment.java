package com.example.firstproject.fragments;

import org.ksoap2.serialization.SoapPrimitive;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.firstproject.R;
import com.example.firstproject.WebServiceWrapper;

public class WebServiceFragment extends Fragment{

	EditText txtInput;
	TextView lblResult;
	Button btnSubmit;
	
	public WebServiceFragment()  {
		// TODO Auto-generated constructor stub
	}
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

    	View v = inflater.inflate(R.layout.webservicelayout, container, false);
    	txtInput = (EditText)v.findViewById(R.id.editText1);
    	lblResult = (TextView)v.findViewById(R.id.textView1);
    	btnSubmit = (Button)v.findViewById(R.id.button1);
    	this.btnSubmit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				WebServiceWrapper<SoapPrimitive> wsr;
				wsr= new WebServiceWrapper<SoapPrimitive>("http://tempuri.org/CelsiusToFahrenheit", 
														  "CelsiusToFahrenheit", 
														  "http://tempuri.org/", 
														  "http://www.w3schools.com/webservices/tempconvert.asmx") 
				{   
					@Override 
					public void onPostExecute(SoapPrimitive result) {
				 	   if(result != null)
						   lblResult.setText(result.toString() + " Fahrenheit.");
					   else
						   lblResult.setText("Sonuc gelmedi");
				    }
				};
				wsr.getRequest().addProperty("Celsius", txtInput.getText().toString());
				wsr.execute();
			}
			
		});
    	
    	
    	return v;
    }

}
