package com.example.administrator.nationaldrugs.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.nationaldrugs.Model.User;
import com.example.administrator.nationaldrugs.R;
import com.example.administrator.nationaldrugs.Webservice.WebserviceTest;

import java.util.List;

public class Login extends AppCompatActivity implements View.OnClickListener{
    private EditText et_name,et_password;
    private Button bn_login,bn_reg ,bn_update;
    private List<User>list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }
    private void initView(){
        et_name= (EditText) findViewById(R.id.et_name);
        et_password= (EditText) findViewById(R.id.et_password);
        bn_login= (Button) findViewById(R.id.bn_login);
        bn_reg= (Button) findViewById(R.id.bn_reg);
        bn_login.setOnClickListener(this);
        bn_reg.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        String name =et_name.getText().toString().trim();
        switch (v.getId()){
            case R.id.bn_login:
                list= WebserviceTest.getUser(name);
                if(list.isEmpty()){
                    Toast.makeText(Login.this,"登录失败",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(Login.this,"登录成功",Toast.LENGTH_SHORT).show();
                    Intent intent1=new Intent(Login.this,Query.class);
                    startActivity(intent1);
                }
                break;
            case R.id.bn_reg:
                Intent intent=new Intent(Login.this,Register.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    }

