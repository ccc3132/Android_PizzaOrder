package com.example.a403.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText t1;
    EditText t2;
    EditText t3;
    Button button1;
    ImageView on;
    TextView t5;
    TextView t6;
    TextView t7;
    RadioButton r1;
    RadioButton r2;
    RadioGroup Ra1;
    CheckBox c1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    void init(){
        t1 = (EditText) findViewById(R.id.editText5);
        t2 =  (EditText) findViewById(R.id.editText6);
        t3 =  (EditText) findViewById(R.id.editText7);
        t5 = (TextView) findViewById(R.id.textView5) ;
        t6 = (TextView) findViewById(R.id.textView6);
        t7 = (TextView) findViewById(R.id.textView7);
        c1 = (CheckBox) findViewById(R.id.checkBox);
        on = (ImageView) findViewById(R.id.imageView2);
        r1 = (RadioButton) findViewById(R.id.radioButton);
        r2 = (RadioButton) findViewById(R.id.radioButton2);
        button1 = (Button) findViewById(R.id.button2);
        Ra1 = (RadioGroup) findViewById(R.id.radioGroup);

        Ra1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (r1.isChecked()) {
                    t7.setText("피클을 선택하셨습니다.");
                    on.setImageResource(R.mipmap.pickle);
                } else if (r2.isChecked()) {
                    t7.setText("소스를 선택하셨습니다.");
                    on.setImageResource(R.mipmap.source);
                }
            }
        });




        button1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                calc(1);
            }
        });
    }

        private void calc(int a) {
            if (t1.getText().length() == 0 || t2.getText().length() == 0) {
                Toast.makeText(getApplicationContext(), " 값을 넣지 않으였습니다..", Toast.LENGTH_SHORT).show();
                return;
            }
            int sum = 0;
            int result = 0;
            int num1 = Integer.parseInt(t1.getText().toString());
            int num2 = Integer.parseInt(t2.getText().toString());
            int num3 = Integer.parseInt(t3.getText().toString());

            switch (a) {
                case 1:
                    result = (num1 * 16000) + (num2 * 11000) + (num3 * 4000);
                    sum = num1 + num2 + num3;
                    break;
            }
            t5.setText("주문개수는" + sum);

            if(c1.isChecked()) {
                t6.setText("계산결과" + (result*0.7));
            }
            else
            {
                t6.setText("계산결과" + result);
            }
        }




}
