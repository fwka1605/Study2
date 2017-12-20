package com.websarva.wings.android.hellosample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.KeyListener;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HelloSampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello_sample);

        Button btClick = (Button) findViewById(R.id.btClick);
        Button btClear = (Button) findViewById(R.id.btClear);

        HelloListener helloListener = new HelloListener();
        btClick.setOnClickListener( helloListener);
        btClear.setOnClickListener(helloListener);
    }

    private class HelloListener  implements View.OnClickListener{
        @Override
        public void onClick(View view){
            EditText input = (EditText) findViewById(R.id.etName);
            TextView output = (TextView) findViewById(R.id.tvOutput);

            int id=view.getId();

            if(id==R.id.btClick){
                String inputStr = input.getText().toString();
                output.setText(inputStr + "さん、こんにちは!");
            }
            else if (id==R.id.btClear){
                input.setText("");
                output.setText("");
            }
        }

    }
}
