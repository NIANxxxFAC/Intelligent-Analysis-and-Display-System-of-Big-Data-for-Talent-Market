package com.ll.tjpu.live.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.ll.tjpu.live.R;

import com.ll.tjpu.live.util.HttpTread;
import com.ll.tjpu.live.util.SpinnerTable;



public class TableActivity extends AppCompatActivity  {
    SpinnerTable spinnerTable = new SpinnerTable();
    static Toast toast = null;
    Spinner sp1;
    Spinner sp2;
    Spinner sp3;
    Spinner sp4;
    Spinner sp5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);

        Toolbar myToolbar =findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        Button btn = findViewById(R.id.btn_login);
        sp1 = findViewById(R.id.wage_Table);
        sp2 = findViewById(R.id.style_Table);
        sp3 = findViewById(R.id.sex_Table);
        sp4 = findViewById(R.id.character_Table);
        sp5 = findViewById(R.id.type_Table);
        spinnerTable.setNumber(sp1.getSelectedItem().toString());
        spinnerTable.setStyle(sp2.getSelectedItem().toString());
        spinnerTable.setSex(sp3.getSelectedItem().toString());
        spinnerTable.setCharacher(sp4.getSelectedItem().toString());
        spinnerTable.setType(sp5.getSelectedItem().toString());

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onLogin(v);
                Toast.makeText(TableActivity.this,"发送成功",Toast.LENGTH_SHORT).show();

            }
        });

    }
        public void onLogin(View v)
        {
            String url="http://192.168.43.89:8080/FuChuang/formInfo";
            new HttpTread(url,sp1.getSelectedItem().toString(),sp2.getSelectedItem().toString(),sp3.getSelectedItem().toString(),sp4.getSelectedItem().toString(),sp5.getSelectedItem().toString()).start();
        }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
