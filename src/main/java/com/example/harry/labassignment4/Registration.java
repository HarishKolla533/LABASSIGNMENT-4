package com.example.harry.labassignment4;

/**
 * Created by harry on 2/15/2017.
 */



        import android.app.Activity;
        import android.content.Intent;
        import android.content.SharedPreferences;
        import android.os.PersistableBundle;
        import android.support.annotation.Nullable;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.CheckBox;
        import android.widget.EditText;

public class Registration extends Activity implements View.OnClickListener {
    EditText etuser,etpass,etphone,etemail,etadd;
    Button button;
    CheckBox checkBox;
    String name="My name";
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);


        etuser= (EditText) findViewById(R.id.etuname);
        etpass= (EditText) findViewById(R.id.etpwd);
        etphone= (EditText) findViewById(R.id.etnum);
        etemail= (EditText) findViewById(R.id.etid);
        etadd= (EditText) findViewById(R.id.etaddress);
        button= (Button) findViewById(R.id.button);
        checkBox= (CheckBox) findViewById(R.id.checkBox);
        button.setOnClickListener(this);
        sharedPreferences=getSharedPreferences(name,MODE_PRIVATE);
        String uname=sharedPreferences.getString("username","");
        String pwd=sharedPreferences.getString("password","");
        String num=sharedPreferences.getString("number","");
        String email=sharedPreferences.getString("email","");
        String address=sharedPreferences.getString("address","");
        if (uname.length()!=0||pwd.length()!=0){
            etuser.setText(uname);
            etpass.setText(pwd);
            etphone.setText(num);
            etemail.setText(email);
            etadd.setText(address);
            checkBox.setChecked(true);
        }

    }


    @Override

    public void onClick(View v) {

        String uname=etuser.getText().toString();
        String pwd=etpass.getText().toString();
        String num=etphone.getText().toString();
        String email=etemail.getText().toString();
        String address=etadd.getText().toString();
        boolean ischecked=checkBox.isChecked();
        SharedPreferences.Editor editor=sharedPreferences.edit();

        if (ischecked){
            editor.putString("username",uname);
            editor.putString("password",pwd);
            editor.putString("number",num);
            editor.putString("email",email);
            editor.putString("address",address);
            editor.commit();
        }
        else{
            editor.clear();
            editor.commit();
        }
        Intent intent=new Intent(Registration.this,Speechtotext.class);
        startActivity(intent);
    }
}
