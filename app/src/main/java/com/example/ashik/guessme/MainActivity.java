package com.example.ashik.guessme;



import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int count=1,myNumber;
    EditText number;
    ImageView in_01,in_02,in_03;

    public int getRandNumber(){
        Random rand = new Random();
        int  n = rand.nextInt(25) + 1;
        return n;
    }
    public void tostDispaly(String s){
        Toast.makeText(MainActivity.this,s,Toast.LENGTH_LONG).show();
    }
    public void reset(){

        count=1;
        myNumber=getRandNumber();
        tostDispaly("TRY AGAIN PLACE !!!!");
        in_01.setImageResource(0);
        in_02.setImageResource(0);
        in_03.setImageResource(0);


    }
    public void go(int a){

            if (a>myNumber){

                if(count==1){
                    in_01.setImageResource(R.drawable.a);
                    count++;
                    tostDispaly("Your Number Higher Than My Number");
                }
                else if(count==2){
                    in_02.setImageResource(R.drawable.a);
                    count++;
                    tostDispaly("Your Number Higher Than My Number");
                }
                else {
                    in_03.setImageResource(R.drawable.a);
                    tostDispaly(" SORRY!!\nMy Number is : "+String.valueOf(myNumber));
                    reset();
                }
            }
            else if (a<myNumber){

                 if(count==1){
                    in_01.setImageResource(R.drawable.a);
                    count++;
                     tostDispaly("Your Number Lower Than My Number");
                }
                else if(count==2){
                    in_02.setImageResource(R.drawable.a);
                    count++;
                     tostDispaly("Your Number Lower Than My Number");
                }
                 else {
                     in_03.setImageResource(R.drawable.a);

                     final Handler handler = new Handler();
                     handler.postDelayed(new Runnable() {
                         @Override
                         public void run() {
                             //Do something after 100ms
                             tostDispaly("SORRY!!\nMy Number is : "+String.valueOf(myNumber));
                             reset();
                         }
                     }, 2500);

                 }


            }
            else{
                tostDispaly("YES THAT IS MY NUMBER");
                reset();
            }

    }


    public void machNumber(View view){
        number= (EditText) findViewById(R.id.etNumber);
        String s= String.valueOf(number.getText());
        int intNumber= Integer.parseInt(s);
        go(intNumber);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        in_01= (ImageView) findViewById(R.id.iv_01);
        in_02= (ImageView) findViewById(R.id.iv_02);
        in_03= (ImageView) findViewById(R.id.iv_03);
        myNumber=getRandNumber();



    }
}
