package com.example.firstproject;

import java.io.IOException;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.SoapFault;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

public class WebServiceWrapper<T> extends AsyncTask<Void,Void,T> {

	protected String mSoap_Action;
	protected String mMethod_Name;
	protected String mNamespace;
	protected String mUrl;
	protected SoapSerializationEnvelope mSoapEnv;
	protected SoapObject mRequest;
	protected HttpTransportSE mAndroidHttpTransport;
	
	public WebServiceWrapper(String soapAction, String methodName, String namespace, String url) {
		this(soapAction, methodName, namespace,url,true,SoapEnvelope.VER11,true);
	}
	
	public WebServiceWrapper(String soapAction, String methodName, String namespace, String url, boolean isDotNet, int soapEnvelopeVersion, boolean debug) {
		this.mSoap_Action = soapAction;
		this.mMethod_Name = methodName;
		this.mNamespace = namespace;
		this.mUrl = url;
		this.mSoapEnv = new SoapSerializationEnvelope(soapEnvelopeVersion);
		this.mSoapEnv.dotNet = isDotNet;
		this.mRequest = new SoapObject(this.mNamespace, this.mMethod_Name);
		this.mSoapEnv.setOutputSoapObject(this.mRequest);
		this.mAndroidHttpTransport = new HttpTransportSE(this.mUrl);
		this.mAndroidHttpTransport.debug = debug;
	}
	
	public String getSoapAction(){return this.mSoap_Action;};
	public String getMethodName(){return this.mMethod_Name;};
	public String getNamespace(){return this.mNamespace;};
	public String getUrl(){return this.mUrl;};
	public boolean isDotNet(){return this.mSoapEnv.dotNet;}
	public SoapObject getRequest(){return this.mRequest;}


	@Override
	protected T doInBackground(Void... params) {
		T tt = null;
		try {
			this.mAndroidHttpTransport.call(this.mSoap_Action, this.mSoapEnv);
			tt = (T)this.mSoapEnv.getResponse();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XmlPullParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e){
			e.printStackTrace();
		}
		return tt;
	}

}
