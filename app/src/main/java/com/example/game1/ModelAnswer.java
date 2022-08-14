package com.example.game1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ModelAnswer extends AppCompatActivity {


    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_model_answer);
        textView=findViewById(R.id.textView3);
        String answer=getIntent().getStringExtra("QuesAnswer");
        if(answer!=null){
            textView.setText(answer);
        }
    }

    public void back(View view) {
        finish();
    }
}