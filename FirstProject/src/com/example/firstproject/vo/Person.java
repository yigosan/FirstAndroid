package com.example.firstproject.vo;

import java.util.ArrayList;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.firstproject.database.DataAccess;

public final class Person {

	protected String _name;
	protected String _surname;
	
	public Person() {}
	
	public Person (String name, String surname){
		this._name = name;
		this._surname = surname;
	}
	
	public String getName(){return this._name;}
	public void setName(String name){this._name = name;}
	public String getSurname(){return this._surname;}
	public void setSurname(String surname){this._surname = surname;}

	public static void DBInsert(DataAccess dbaccess,Person person)
	{
		try
		{
			SQLiteDatabase db = dbaccess.getWritableDatabase();
			ContentValues cvs = new ContentValues();
			cvs.put("Name", person.getName());
			cvs.put("Surname", person.getSurname());
			db.insertOrThrow("Records", null, cvs);
		}
		finally
		{
			dbaccess.close();
		}
	}
	
	public static ArrayList<Person> DBSelect(DataAccess dbaccess)
	{
		try
		{
			SQLiteDatabase db = dbaccess.getReadableDatabase();
			String[] columns = {"Name","Surname"};
			Cursor cursor = db.query("Records", columns , null, null, null, null, null);
			ArrayList<Person> people = new ArrayList<Person>();		
			while(cursor.moveToNext())
			{
				String name = cursor.getString(cursor.getColumnIndex("Name"));
				String surname = cursor.getString(cursor.getColumnIndex("Surname"));
				people.add(new Person(name,surname));
			}
			return people;
		}
		finally
		{
			dbaccess.close();
		}
	}
	
	public static Person DBSelect(DataAccess dbaccess, String name)
	{
		Person person = null;		
		
		try
		{
			SQLiteDatabase db = dbaccess.getReadableDatabase();
			String[] columns = {"Name","Surname"};
			Cursor cursor = db.query("Records", columns , "Name=?", new String[] {name}, null, null, null);
			if(cursor.moveToNext())
			{
				String pname = cursor.getString(cursor.getColumnIndex("Name"));
				String psurname = cursor.getString(cursor.getColumnIndex("Surname"));
				person = new Person(pname,psurname);
			}
		}
		finally
		{
			dbaccess.close();
		}
		return person;
	}
	
	public static Person DBUpdate(DataAccess dbaccess, Person person)
	{
		String personname = person.getName();
		try
		{
			SQLiteDatabase db = dbaccess.getWritableDatabase();
			ContentValues cvs = new ContentValues();
			cvs.put("Surname", person.getSurname());
			db.update("Records", cvs, "Name=?", new String[] {person.getName()});
		}
		finally
		{
			dbaccess.close();
		}
		return Person.DBSelect(dbaccess, personname);
	}
	
	public static void DBDelete(DataAccess dbaccess, String name)
	{
		try
		{
			SQLiteDatabase db = dbaccess.getWritableDatabase();
			db.delete("Records", "Name=?", new String[] {name});
		}
		finally
		{
			dbaccess.close();
		}
	}
}
