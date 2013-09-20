package com.example.firstproject.view;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.firstproject.vo.Person;
import com.example.firstproject.*;

public class PersonListView extends ArrayAdapter<Person> {

    private Context context;
    private int _viewResourceId;
    
    public PersonListView(Context context, int viewResourceId, List<Person> people) {
        super(context, viewResourceId, people);
        this.context = context;
        this._viewResourceId = viewResourceId;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(_viewResourceId, null);
        }

        Person person = getItem(position);
        if (person != null) {
            // My layout has only one TextView
            TextView txtName = (TextView) convertView.findViewById(R.id.listitemname);
            txtName.setText(person.getName());
            TextView txtSurname = (TextView) convertView.findViewById(R.id.listitemsurname);
            txtSurname.setText(person.getSurname());
         }

        return convertView;
    }
}