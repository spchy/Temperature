package com.example.erickz.temperature;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private static DecimalFormat df2 = new DecimalFormat(".##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button c_to_f_button = findViewById(R.id.c_to_f);
        Button f_to_c_button = findViewById(R.id.f_to_c);
        final TextView result_text_view = findViewById(R.id.result);
        final EditText input_ed_text = findViewById(R.id.input_editext);

        c_to_f_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String raw_in = input_ed_text.getText().toString();

                if(raw_in.isEmpty()) {
                    alert_input_valid();
                }
                else {
                    Double input = Double.valueOf(raw_in);
                    result_text_view.setText(cal_c_to_f(input));
                }
            }
        });

        f_to_c_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String raw_in = input_ed_text.getText().toString();

                if(raw_in.isEmpty()) {
                    alert_input_valid();
                }
                else {
                    Double input = Double.valueOf(raw_in);
                    result_text_view.setText(cal_f_to_c(input));
                }
            }
        });

    }

    public String cal_c_to_f(Double input){
        return df2.format(input*1.8+32.0);
    }

    public String cal_f_to_c(Double input){
        return df2.format((input-32.0)/1.8);
    }
    public void alert_input_valid(){
        Toast t = Toast.makeText(getApplicationContext(), R.string.input_some, Toast.LENGTH_LONG);
        t.show();
    }
}

