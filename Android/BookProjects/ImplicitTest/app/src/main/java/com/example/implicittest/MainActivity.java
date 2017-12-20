package com.example.implicittest;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText et_url = (EditText) findViewById(R.id.editText_url);
        Button bt_toWeb = (Button) findViewById(R.id.button_toWeb);

        bt_toWeb.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);

                String url = et_url.getText().toString();
                Uri uri = Uri.parse(url);

                intent.setData(uri);

                startActivity(intent);
            }
        });

        final EditText et_tel = (EditText) findViewById(R.id.editText_tel);
        Button bt_call = (Button) findViewById(R.id.button_call);

        bt_call.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();

                String tel = et_tel.getText().toString();
                Uri uri = Uri.parse("tel:"+tel);

                intent.setAction(Intent.ACTION_DIAL).setData(uri);

                startActivity(intent);
            }
        });

        imageView = (ImageView) findViewById(R.id.imageView);
        Button bt_getImage = (Button) findViewById(R.id.button_getImage);

        bt_getImage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();

                intent.setAction(Intent.ACTION_PICK);
                intent.setType("image/");

                startActivityForResult(intent,0);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==0){
            if(resultCode== Activity.RESULT_OK){
                try {
                    ContentResolver contentResolver = getContentResolver();
                    InputStream inputStream = contentResolver.openInputStream(data.getData());
                    Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                    inputStream.close();

                    imageView.setImageBitmap(bitmap);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch(IOException e){
                    e.printStackTrace();
                }

            }
        }
    }
}
