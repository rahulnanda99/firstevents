package com.example.firstevents;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {
    EditText e1, e2;
    Button b1, b2, b3;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = findViewById(R.id.editText);
        e2 = findViewById(R.id.editText2);
        b1 = findViewById(R.id.button);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        preferences = getSharedPreferences("jadu", Context.MODE_PRIVATE);
        editor = preferences.edit();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String location=e1.getText().toString();
                String value=e2.getText().toString();
                editor.putString("loc_key",location);
                editor.putString("value_key",value);
                editor.commit();
                Toast.makeText(MainActivity.this, "Record Updated", Toast.LENGTH_SHORT).show();
                e1.setText("");
                e2.setText("");

            }


        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              String loc=  preferences.getString("loc_key",null);
              String val=  preferences.getString("value_key",null);
                Toast.makeText(MainActivity.this, "Location:-"+loc+"\nValue:-"+val, Toast.LENGTH_SHORT).show();
            }
        });
        b3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //editor.clear();
                editor.remove("loc_key");
                editor.commit();


            }
        });


    }
}
