package com.example.intenttest;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bt_toSub = (Button) findViewById(R.id.button_toSub);

        bt_toSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent();
                intent.setClassName(getPackageName(),getPackageName()+".SubActivity");

                startActivity(intent);
            }
        });

        Button bt_toSub2 = (Button) findViewById(R.id.button_toSub2);
        bt_toSub2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClassName(getPackageName(),getPackageName()+".SubActivity");

                EditText et_message = (EditText) findViewById(R.id.editText_message);
                String message = et_message.getText().toString();
                intent.putExtra("message",message);

                startActivity(intent);
            }
        });

        Button bt_toSub3 = (Button) findViewById(R.id.button_toSub3);
        bt_toSub3.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClassName(getPackageName(),getPackageName()+".SubActivity");

                startActivityForResult(intent,0);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==0){
            if(resultCode== Activity.RESULT_OK){
                String button = data.getStringExtra("button_text");
                Toast.makeText(this,button+"ボタンが押されました",Toast.LENGTH_LONG).show();
            }
            else if(resultCode== Activity.RESULT_CANCELED){
                Toast.makeText(this,"キャンセルされました",Toast.LENGTH_LONG).show();

            }

        }
    }
}
