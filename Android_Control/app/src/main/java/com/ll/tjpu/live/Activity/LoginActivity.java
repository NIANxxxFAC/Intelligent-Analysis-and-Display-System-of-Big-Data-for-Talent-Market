package com.ll.tjpu.live.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ll.tjpu.live.R;

public class LoginActivity extends AppCompatActivity
{
    EditText username;
    EditText password;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = this.findViewById(R.id.et_username);
        password = this.findViewById(R.id.et_password);
        button = this.findViewById(R.id.login_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputName = username.getText().toString();  //这里想要获取账号名
                String inputPwd = password.getText().toString();   //这里想要获取密码

                if(inputName.equals("demo")&&inputPwd.equals("123")){   //账号密码的验证
                    Toast.makeText(LoginActivity.this,"登录成功！",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                }
                else{

                    Toast.makeText(LoginActivity.this,"你的账号名或密码是错误的！",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}
