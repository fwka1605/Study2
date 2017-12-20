package com.example.testappli;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.Menu;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.ImageView;
        import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText et_name;
    private TextView tv_name;
    private TextView tv_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonOk = (Button) findViewById(R.id.button_ok);
        //buttonOk.setOnClickListener(new OkButtonClickListener());

        buttonOk.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                EditText editText = (EditText) findViewById(R.id.editText);
                TextView textView = (TextView) findViewById(R.id.textView1);

                textView.setText(editText.getText());

            }
        });

        Button button1 = (Button) findViewById(R.id.button_1);
        button1.setOnClickListener(this);

        Button button2 = (Button) findViewById(R.id.button_2);
        button2.setOnClickListener(this);

        Button button3 = (Button) findViewById(R.id.button_3);
        button3.setOnClickListener(this);

        if(savedInstanceState!=null){
            String text = savedInstanceState.getString("text");
            tv_1.setText(text);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("text",tv_1.getText().toString());
    }

    @Override
    public void onClick(View v) {

        ImageView image = (ImageView) findViewById(R.id.imageView_droi1);

        switch (v.getId()){
            case R.id.button_1:
                image.setImageResource(R.drawable.android_logo);
                break;
            case R.id.button_2:
                image.setImageResource(R.drawable.android_logo_blue);
                break;
            case R.id.button_3:
                image.setImageResource(R.drawable.android_logo_red);
                break;
            default:
                image.setImageResource(R.drawable.android_logo);
        }
    }

    public void inputName(View v){
        EditText editTextName = (EditText)findViewById(R.id.editText_Name);
        TextView textViewName = (TextView)findViewById(R.id.textView_Name);

        textViewName.setText(editTextName.getText());
    }

    class OkButtonClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            EditText editText = (EditText) findViewById(R.id.editText);
            TextView textView = (TextView) findViewById(R.id.textView1);

            textView.setText(editText.getText());
        }
    }

}
