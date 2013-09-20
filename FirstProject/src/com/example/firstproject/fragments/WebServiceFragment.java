package com.example.firstproject.fragments;

import java.io.IOException;

import org.ksoap2.serialization.SoapPrimitive;
import org.xmlpull.v1.XmlPullParserException;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.firstproject.R;
import com.example.firstproject.WebServiceWrapper;

public class WebServiceFragment extends Fragment{

	EditText txtInput;
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
    	btnSubmit = (Button)v.findViewById(R.id.button1);
    	final Context c = this.getActivity();
    	this.btnSubmit.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				/*
				WebServiceWrapper<SoapPrimitive> soapcall = new WebServiceWrapper<SoapPrimitive>("http://tempuri.org/CelciusToFahrenheit", "CelsiusToFahrenheit", "http://tempuri.org", "http://www.w3schools.com/webservices/tempconvert.asmx");
				soapcall.getRequest().addProperty("Celcius", txtInput.getText().toString());
				SoapPrimitive response;
				try {
					response = soapcall.Call();
					Toast.makeText(c, response.toString(), Toast.LENGTH_LONG).show();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (XmlPullParserException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch(Exception e) {
					e.printStackTrace();
				}
				*/
				
				WebServiceWrapper<SoapPrimitive> wc = new WebServiceWrapper<SoapPrimitive>(c,"http://tempuri.org/CelsiusToFahrenheit", "CelsiusToFahrenheit", "http://tempuri.org", "http://www.w3schools.com/webservices/tempconvert.asmx");
				wc.getRequest().addProperty("Celsius", txtInput.getText().toString());
				wc.execute();
				
				
				
			}
		});
    	
    	
    	return v;
    }

}
