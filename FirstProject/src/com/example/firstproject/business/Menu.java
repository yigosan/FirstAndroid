package com.example.firstproject.business;

import java.util.Vector;

import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;

public class Menu {
	
	private String mMenuName;
	private int mMenuVersion;
	

	
	
	public Vector<MenuItemBase> Categories = new Vector<MenuItemBase>();
	public Menu(){}
	
	public String getMenuName() { return this.mMenuName; }
	public void setMenuName(String val) { this.mMenuName = val; }
	
	public int getMenuVersion() {return this.mMenuVersion;}
	public void setMenuVersion(int val) { this.mMenuVersion = val; }
	
	public void BuildFromSoapResponse(SoapObject response)
	{
		this.setMenuName(((SoapPrimitive)response.getProperty("MenuName")).toString());
		this.setMenuVersion(Integer.parseInt(((SoapPrimitive)response.getProperty("MenuVersion")).toString()));
		SoapObject categories = (SoapObject)response.getProperty("Categories");
		System.out.println(response.getPropertyCount());	
	}
}
