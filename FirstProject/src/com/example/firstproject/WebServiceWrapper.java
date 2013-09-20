package com.example.firstproject;

import java.io.IOException;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

public class WebServiceWrapper<T> extends AsyncTask<Void,Void,T> {

	protected Context mC;
	protected String mSoap_Action;
	protected String mMethod_Name;
	protected String mNamespace;
	protected String mUrl;
	protected SoapSerializationEnvelope mSoapEnv;
	protected SoapObject mRequest;
	protected HttpTransportSE androidHttpTransport;
	protected T t;
	
	public WebServiceWrapper(Context c,String soapAction, String methodName, String namespace, String url) {
		this(c, soapAction, methodName, namespace,url,true,SoapEnvelope.VER11,true);
	}
	
	public WebServiceWrapper(Context c, String soapAction, String methodName, String namespace, String url, boolean isDotNet, int soapEnvelopeVersion, boolean debug) {
		this.mC = c;
		this.mSoap_Action = soapAction;
		this.mMethod_Name = methodName;
		this.mNamespace = namespace;
		this.mUrl = url;
		this.mSoapEnv = new SoapSerializationEnvelope(soapEnvelopeVersion);
		this.mSoapEnv.dotNet = isDotNet;
		this.mRequest = new SoapObject(this.mNamespace, this.mMethod_Name);
		mSoapEnv.setOutputSoapObject(this.mRequest);
		androidHttpTransport = new HttpTransportSE(this.mUrl);
		androidHttpTransport.debug = debug;
	}
	
	public String getSoapAction(){return this.mSoap_Action;};
	public String getMethodName(){return this.mMethod_Name;};
	public String getNamespace(){return this.mNamespace;};
	public String getUrl(){return this.mUrl;};
	public boolean isDotNet(){return this.mSoapEnv.dotNet;}
	public SoapObject getRequest(){return this.mRequest;}


	@SuppressWarnings("unchecked")
	@Override
	protected T doInBackground(Void... params) {
		try {
			this.androidHttpTransport.call(this.mSoap_Action, this.mSoapEnv);
			SoapPrimitive sp = (SoapPrimitive)this.mSoapEnv.getResponse();
			t = (T)sp;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XmlPullParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e){
			e.printStackTrace();
		}
		return t;
	}
	   @Override
	   protected void onPostExecute(T result) {
		   if(t != null)
			   Toast.makeText(this.mC, t.toString(), Toast.LENGTH_LONG).show();
		   else
			   Toast.makeText(this.mC, "Sonuc gelmedi", Toast.LENGTH_LONG).show();
	    }
	
}
