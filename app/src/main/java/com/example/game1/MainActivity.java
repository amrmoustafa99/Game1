package com.example.game1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {



    private String[] QUESTIONS={
            " تلت التلاته واحد !",
            "لوحيد القرن الافريقي قرن واحد؟",
            "كسوف الشمس هو وقوع القمر بين الشمس والقمر!",
            "الاسفنج نبات رخوي !",
            "اول دوله فازت بكاس العالم خمس مرات المانيا!",
            "يزداد حجم الماءاذا تجمد",

    };

    private static final boolean[] ANSWERS = {
            false,
            false,
            true,
            false,
            false,
            true,
           };

    private String[] ANSWERS_DETAILS={
            " تؤ انا وانت 😉",
                "قرنان"  ,
            "صحيح"  ,
            "حيوان بحري",
            "البرازيل" ,
            "صحيح"  ,
    };


    private String mCurrentQuestion, mCurrentAnswerDetail;
    private boolean mCurrentAnswer;

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView3);
        showRandom();

    }

    public  void showRandom(){

        Random random=new Random();
        int randomCurrent=random.nextInt(QUESTIONS.length);
        mCurrentQuestion=QUESTIONS[randomCurrent];
        mCurrentAnswerDetail=ANSWERS_DETAILS[randomCurrent];
        mCurrentAnswer=ANSWERS[randomCurrent];
        textView.setText(mCurrentQuestion);
    }


    public void ChangeQues(View view) {
        showRandom();
    }

    public void trueQues(View view) {

        if(mCurrentAnswer==true){
            Toast.makeText(this, "اجابه صحيحه", Toast.LENGTH_SHORT).show();
            showRandom();
        }
        else {
            Toast.makeText(this, "اجابه خاطئه", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(MainActivity.this, ModelAnswer.class);
            intent.putExtra("QuesAnswer", mCurrentAnswerDetail);
            startActivity(intent);
            showRandom();
        }
    }

    public void falseQues(View view) {
        if(mCurrentAnswer==false){
            Toast.makeText(this, "اجابه صحيحه", Toast.LENGTH_SHORT).show();
            showRandom();
        }
        else {
            Toast.makeText(this, "اجابه خاطئه", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(MainActivity.this, ModelAnswer.class);
            intent.putExtra("QuesAnswer", mCurrentAnswerDetail);
            startActivity(intent);
            showRandom();
        }

    }

    public void Share(View view) {

        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);

        String mString= textView.getText().toString();
        shareIntent.putExtra(Intent.EXTRA_TEXT, mString);
        shareIntent.setType("text/plain");
        startActivity(shareIntent);

    }
}