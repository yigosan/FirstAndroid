package com.example.firstproject.fragments;

import java.util.List;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.firstproject.R;
import com.example.firstproject.database.DataAccess;
import com.example.firstproject.view.PersonListView;
import com.example.firstproject.vo.Person;

public class SqlPageFragment extends android.app.Fragment { //implements ActionBar.TabListener {

	EditText txtName;
	EditText txtSurname;
	Button btnInsert;
	Button btnSelect;
	Button btnUpdateFirstName;
	Button btnDeleteFirstName;
	ListView lstShow;
	DataAccess dbaccess;
	View mMyView;

	public SqlPageFragment(){
		// TODO Auto-generated constructor stub
	}
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
     
    	if (mMyView == null) {
    		mMyView = inflater.inflate(R.layout.sqlpage, container, false);
    	
	    	txtName = (EditText)mMyView.findViewById(R.id.editText1);
	    	txtSurname = (EditText)mMyView.findViewById(R.id.editText02);
	    	btnInsert = (Button)mMyView.findViewById(R.id.button1);
	    	btnSelect = (Button)mMyView.findViewById(R.id.btnGetMenu);
	    	btnUpdateFirstName = (Button)mMyView.findViewById(R.id.button3);
	    	btnDeleteFirstName = (Button)mMyView.findViewById(R.id.button4);
	    	lstShow = (ListView)mMyView.findViewById(R.id.listView1);
	    	dbaccess = new DataAccess(this.getActivity());
	    	final Context c = this.getActivity().getApplicationContext();
	    	
	    	btnDeleteFirstName.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Person.DBDelete(dbaccess, txtName.getText().toString());
				}
			});
	    	
	    	btnUpdateFirstName.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Person newPerson = Person.DBUpdate(dbaccess, new Person(txtName.getText().toString(), txtSurname.getText().toString()));
					if(null != newPerson)
					{
						txtName.setText(newPerson.getName());
						txtSurname.setText(newPerson.getSurname());
					}
				}
			});
	    	
	    	btnInsert.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Person.DBInsert(dbaccess,new Person(txtName.getText().toString(), txtSurname.getText().toString()));
				}
			});
	    	
	    	btnSelect.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					List<Person> people = Person.DBSelect(dbaccess);
					PersonListView personadapter = new PersonListView(c,R.layout.personlayout,people);
					lstShow.setAdapter(personadapter);
					lstShow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
	
						@Override
						public void onItemClick(AdapterView<?> arg0, View arg1,
								int position, long id) {
							Person person = (Person)arg0.getAdapter().getItem(position);
							if(null != person)
							{
								txtName.setText(person.getName());
								txtSurname.setText(person.getSurname());
							}
						}
					});
				}
			});
        } else {
            container.removeView(mMyView);
        }

    	return mMyView;
    }
}
