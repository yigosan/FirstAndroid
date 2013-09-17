package com.example.firstproject;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.firstproject.database.DataAccess;
import com.example.firstproject.view.PersonListView;
import com.example.firstproject.vo.Person;

public class SqlPage extends Activity {

	EditText txtName;
	EditText txtSurname;
	Button btnInsert;
	Button btnSelect;
	Button btnUpdateFirstName;
	Button btnDeleteFirstName;
	ListView lstShow;
	DataAccess dbaccess;
	
	public SqlPage() {
		// TODO Auto-generated constructor stub
	}
	
	public Person GetPerson()
	{
		return new Person(txtName.getText().toString(), txtSurname.getText().toString());
	}
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sqlpage);
        
    	txtName = (EditText)findViewById(R.id.editText1);
    	txtSurname = (EditText)findViewById(R.id.editText02);
    	btnInsert = (Button)findViewById(R.id.button1);
    	btnSelect = (Button)findViewById(R.id.button2);
    	btnUpdateFirstName = (Button)findViewById(R.id.button3);
    	btnDeleteFirstName = (Button)findViewById(R.id.button4);
    	lstShow = (ListView)findViewById(R.id.listView1);
    	dbaccess = new DataAccess(this);
    	
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
				PersonListView personadapter = new PersonListView(getApplicationContext(),R.layout.personlayout,people);
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
    }

}
