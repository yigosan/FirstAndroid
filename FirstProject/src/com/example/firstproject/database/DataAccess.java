package com.example.firstproject.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;;

public class DataAccess extends SQLiteOpenHelper{

	private final static String DBName = "Records";
	private final static int DBVersion = 2;
	
	public DataAccess(Context c) {
		// TODO Auto-generated constructor stub
		super(c,DBName,null,DBVersion);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("CREATE TABLE Records (Name TEXT, Surname TEXT);");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("Drop Table IF EXISTS Records;");
		onCreate(db);
	}

}
