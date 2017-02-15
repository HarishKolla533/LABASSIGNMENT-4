package com.example.harry.labassignment4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
TextView Uname,Paswrd;
    Button Login, Register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Uname= (TextView) findViewById(R.id.textView);
        Paswrd= (TextView) findViewById(R.id.textView2);
        Login= (Button) findViewById(R.id.button);
        Register=(Button) findViewById(R.id.button1);

        Login.setOnClickListener(this);
        Register.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                if(Uname.length()==0&& Paswrd.length()==0){

                    Toast.makeText(MainActivity.this,"Please enter the credentials",Toast.LENGTH_LONG).show();
                }
                else{
                    String Username=Uname.getText().toString();
                    String password=Paswrd.getText().toString();
                    Intent intent=new Intent(MainActivity.this,Speechtotext.class);
                    startActivity(intent);


                }
                break;
            case R.id.button1:
                Intent intent1=new Intent(MainActivity.this,Registration.class);
                startActivity(intent1);
                break;

        }






    }
}
