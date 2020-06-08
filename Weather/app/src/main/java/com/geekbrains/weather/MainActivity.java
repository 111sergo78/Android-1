package com.geekbrains.weather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements WeatherValue{

    private TextView textView;
    private TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        setWeatherValue();

    }

    private void initViews(){
        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
    }

    public void setWeatherValue(){
        textView2.setText(getMoskow());
    }

    @Override
    public String getMoskow() {
        return "Москва, 21 градус, ясно";
    }
}
