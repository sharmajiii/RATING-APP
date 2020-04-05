package com.sharmaji.rattingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Main3Activity extends AppCompatActivity {
    coll coll=new coll(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ArrayList<String> abc=new ArrayList<String>();
        ArrayList<String> a=coll.getvalue1();
        ArrayList<String> b=coll.getvalue2();
        ArrayList<String> c=coll.getvalue3();
        for(int i=0;i<a.size();i++){
            String bc="Date & Time :"+a.get(i)+" "+b.get(i)+"  ::  "+"RATING"+" : "+c.get(i);
            abc.add(bc);
        }

        ArrayAdapter listAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,abc);
        ListView listView=(ListView)findViewById(R.id.mylist);
        listView.setAdapter(listAdapter);

    }
}
