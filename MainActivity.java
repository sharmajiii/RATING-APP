package com.sharmaji.rattingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout drawer;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);
        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer,toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        final CheckBox checkBox1=(CheckBox)findViewById(R.id.checkBox);
        final CheckBox checkBox2=(CheckBox)findViewById(R.id.checkBox2);
        checkBox1.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if(compoundButton.isChecked()==true){
                            checkBox2.setChecked(false);
                        }
                    }
                }
        );
        checkBox2.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if(compoundButton.isChecked()==true){
                            checkBox1.setChecked(false);
                        }
                    }
                }
        );
        Button button=(Button)findViewById(R.id.butt);
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(checkBox2.isChecked()){
                            Intent intent=new Intent(getApplicationContext(),Main2Activity.class);
                            startActivity(intent);

                        }
                        else{
                            if(checkBox1.isChecked()){
                                Intent intent=new Intent(getApplicationContext(),Main2Activity.class);
                                intent.putExtra("star",5);
                                startActivity(intent);

                            }
                            else {
                                Toast.makeText(getApplicationContext(),"PLEASE SELECT ONE",Toast.LENGTH_SHORT).show();
                            }
                        }

                    }
                }
        );
        NavigationView navigationView=findViewById(R.id.nav);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.home:
                Intent intent=new Intent(MainActivity.this,Main3Activity.class);
                startActivity(intent);
        }
        return true;
    }
}
