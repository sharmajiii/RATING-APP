package com.sharmaji.rattingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class Main2Activity extends AppCompatActivity {
    LinearLayout linearLayout1;
    Calendar calander;
    SimpleDateFormat simpleDateFormat;
    coll coll;
    int h=0;

    @Override
    public void onBackPressed() {
        linearLayout1=(LinearLayout)findViewById(R.id.ttyy);
        LinearLayout.LayoutParams params=(LinearLayout.LayoutParams)linearLayout1.getLayoutParams();
        params.setMargins(0,0,0,0);
        super.onBackPressed();
        linearLayout1.setLayoutParams(params);
    }

    @SuppressLint({"ResourceAsColor", "ResourceType"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        coll=new coll(this);
        LinearLayout linearLayout=(LinearLayout) findViewById(R.id.tty);

        Intent intent=getIntent();
        final int a=intent.getIntExtra("star",0);

        Button button;

        /*for(int i =0; i <=9; i++){
            button=new Button(this);
            LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(0,0,25,0);
            button.setLayoutParams(params);
            button.getLayoutParams().width=100;
            button.setId(i);
            final Button finalButton = button;
            button.setOnClickListener(
                    new View.OnClickListener() {
                        @SuppressLint({"ResourceAsColor"})
                        @Override
                        public void onClick(View view) {
                            int a = view.getId();
                            for(int i = 0; i<= a; i++){
                                Button button1=(Button)findViewById(i);
                                button1.setBackgroundColor(R.color.colorPrimary);

                            }

                        }
                    }
            );


            linearLayout.addView(button);

        }*/
        final Toast toast=new Toast(getBaseContext());
        final LinearLayout ll=new LinearLayout(getBaseContext());
        ll.setOrientation(LinearLayout.HORIZONTAL);
        final ImageView imageView=new ImageView(getBaseContext());
        //imageView.setImageResource(R.drawable.onw);
        ll.addView(imageView);
        toast.setView(ll);
        toast.setDuration(Toast.LENGTH_SHORT);
        //toast.show();






        final TextView textView=(TextView)findViewById(R.id.mytext);
        RatingBar ratingBar=(RatingBar)findViewById(R.id.ratingBar2);
        if(a>0){
            linearLayout1=(LinearLayout)findViewById(R.id.ttyy);
            LinearLayout.LayoutParams params=(LinearLayout.LayoutParams)linearLayout1.getLayoutParams();
            params.setMargins(200,0,0,0);
            ratingBar.setNumStars(5);
            ratingBar.setStepSize(1);
            linearLayout1.setLayoutParams(params);
                   }
        ratingBar.setOnRatingBarChangeListener(
                new RatingBar.OnRatingBarChangeListener() {
                    @Override
                    public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                        if(toast!=null){
                            toast.cancel();
                        }
                        h= (int) v;
                        final Toast toast=new Toast(getBaseContext());
                        final LinearLayout ll=new LinearLayout(getBaseContext());
                        ll.setOrientation(LinearLayout.HORIZONTAL);
                        final ImageView imageView=new ImageView(getBaseContext());
                        //imageView.setImageResource(R.drawable.onw);
                        ll.addView(imageView);
                        toast.setView(ll);
                        toast.setDuration(Toast.LENGTH_SHORT);
                        //toast.show();

                        textView.setText("RATING :"+" "+v);
                        if(a==5){
                            if(v==1.0){
                                imageView.setImageResource(R.drawable.vbad);
                                toast.show();

                            }
                            if(v==2.0){
                                imageView.setImageResource(R.drawable.bad);
                                toast.show();

                            }
                            if(v==3){
                                imageView.setImageResource(R.drawable.ok);
                                toast.show();

                            }
                            if(v==4){
                                imageView.setImageResource(R.drawable.good);
                                toast.show();

                            }
                            if(v==5){
                                imageView.setImageResource(R.drawable.best);
                                toast.show();

                            }
                        }
                        else{
                            if(v==1.0 || v==2.0){
                                imageView.setImageResource(R.drawable.vbad);
                                toast.show();

                            }
                            if(v==3.0 || v==4.0){
                                imageView.setImageResource(R.drawable.bad);
                                toast.show();

                            }
                            if(v==5.0 ){
                                imageView.setImageResource(R.drawable.ok);
                                toast.show();

                            }
                            if(v==6.0 || v==7.0){
                                imageView.setImageResource(R.drawable.good);
                                toast.show();

                            }
                            if(v==8.0 || v==9.0){
                                imageView.setImageResource(R.drawable.best);
                                toast.show();

                            }

                        }


                    }
                }
        );
        Button button1=(Button)findViewById(R.id.mybutton);
        button1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        final String datee=new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
                        calander = Calendar.getInstance();
                        simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
                        String time = simpleDateFormat.format(calander.getTime());
                        String c=String.valueOf(h);
                        boolean x=coll.insert(datee,time,c);
                        if(x==true && h>0){
                            Toast.makeText(getApplicationContext(),"SUCCESSFULLY SAVED",Toast.LENGTH_SHORT).show();

                        }
                        else{
                            if(h==0){
                                Toast.makeText(getApplicationContext(),"RATE FIRST",Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Toast.makeText(getApplicationContext(),"Failed",Toast.LENGTH_SHORT).show();
                            }

                        }



                    }
                }
        );





    }
}






