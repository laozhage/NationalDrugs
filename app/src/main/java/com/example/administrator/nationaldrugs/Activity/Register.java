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

public class Register extends AppCompatActivity implements View.OnClickListener {
    private EditText et_name,et_password;
    private Button bn_login,bn_reg;
    private List<User>list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
    }
    private void initView(){
        et_name= (EditText) findViewById(R.id.et_name);
        et_password= (EditText) findViewById(R.id.et_password);
        bn_login= (Button) findViewById(R.id.denlv);
        bn_reg= (Button) findViewById(R.id.zhuche);
        bn_login.setOnClickListener(this);
        bn_reg.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.denlv:
                Intent intent=new Intent(Register.this,Login.class);
                startActivity(intent);
                break;
            case R.id.zhuche:
                User user=new User();
                user.setuserid(et_name.getText().toString().trim());
                user.setpwd(et_password.getText().toString().trim());
                list= WebserviceTest.addUser(user);
                        if(list.isEmpty()){
                            Toast.makeText(Register.this,"注册失败",Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(Register.this,"注册成功",Toast.LENGTH_SHORT).show();
                        }
                break;
            default:
                break;
                    }
        }
    }

