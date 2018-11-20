package com.geekbrains.a1l2_acitivitybackstack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Button increaseCounterBtn;
    private Button toSecondActivityBtn;
    String TAG = "My log";

    private final String keyForCounter = "keyForCounter";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        setOnIncreaseCounterBtnClick();
        setOnToSecondActivityBtnClick();
        checkThatLaunchedInFirstTime(savedInstanceState);

    }

    private void checkThatLaunchedInFirstTime(Bundle savedInstanceState) {
        String instanceState;
        if (savedInstanceState == null){
            instanceState = "Первый запуск!";
        }
        else{
            instanceState = "Повторный запуск!";
        }
        Log.i(TAG, "- onCreate()");
        Toast.makeText(getApplicationContext(), instanceState + " - onCreate()",
                Toast.LENGTH_SHORT).show();
    }

    private void initViews() {
        textView = findViewById(R.id.textView);
        increaseCounterBtn = findViewById(R.id.increaseCounterBtn);
        toSecondActivityBtn = findViewById(R.id.toSecondActivityBtn);
    }

    private void setOnIncreaseCounterBtnClick() {
        increaseCounterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentValue = Integer.parseInt(textView.getText().toString());
                textView.setText(String.valueOf(++currentValue));
            }
        });
    }

    private void setOnToSecondActivityBtnClick() {
        toSecondActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart()");
        Toast.makeText(getApplicationContext(), "onStart()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onSaveInstanceState(Bundle saveInstanceState){
        saveInstanceState.putString(keyForCounter, textView.getText().toString());
        super.onSaveInstanceState(saveInstanceState);
        Log.i(TAG, "onSaveInstanceState()");
        Toast.makeText(getApplicationContext(), "onSaveInstanceState()",
                Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestoreInstanceState(Bundle saveInstanceState) {
        super.onRestoreInstanceState(saveInstanceState);
        String text = saveInstanceState.getString(keyForCounter);
        textView.setText(text);
        Log.i(TAG, "Повторный запуск!! - onRestoreInstanceState()");
        Toast.makeText(getApplicationContext(),
                "Повторный запуск!! - onRestoreInstanceState()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume()");
        Toast.makeText(getApplicationContext(), "onResume()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause()");
        Toast.makeText(getApplicationContext(), "onPause()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop()");
        Toast.makeText(getApplicationContext(), "onStop()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart()");
        Toast.makeText(getApplicationContext(), "onRestart()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy()");
        Toast.makeText(getApplicationContext(), "onDestroy()", Toast.LENGTH_SHORT).show();
    }

}
