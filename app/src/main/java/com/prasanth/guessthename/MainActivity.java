package com.prasanth.guessthename;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public void choosech(View view)
    {
       if(view.getTag().toString().equals(Integer.toString(correct)))
       {
           Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
       }
       else {
           Toast.makeText(getApplicationContext(), "INCorrect Tryagain", Toast.LENGTH_SHORT).show();
       }

    }





    ImageView imageView;
    Button button;

    Random r;
    //ArrayList<String> celnames=new ArrayList<String>();
     String[] ans=new String[4];

    int choose=0;
     int correct;
    Integer[] images={
            R.drawable.kushina,
            R.drawable.gaara,
            R.drawable.pain,
            R.drawable.hinata,
            R.drawable.ino,
            R.drawable.itachi,
            R.drawable.kakashi,
            R.drawable.sakura,
            R.drawable.sasuke,
            R.drawable.madara,
            R.drawable.rin,
            R.drawable.tenten
    };
    String name[]={"Kushina","Gaara","Pain","Hinata","Ino","Itachi","Kakashi","Sakura","Sasuke","Madara","Rin","TenTen"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView =(ImageView) findViewById(R.id.imageView3);
        button =(Button) findViewById(R.id.button5);

        r=new Random();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // imageView.setImageResource(images[r.nextInt(images.length)]);
                Random ra=new Random();
                choose=ra.nextInt(images.length);
                Log.i("index"," "+choose);
                imageView.setImageResource(images[choose]);

               // String as= images[choose].toString();
                ///Log.i("check","welcome"+as);
                Button button0=(Button) findViewById(R.id.button1);
                Button button1=(Button) findViewById(R.id.button2);
                Button button2=(Button) findViewById(R.id.button3);
                Button button3=(Button) findViewById(R.id.button4);

                //button.setText(name[choose]);
                LinkedHashSet<String> LHS = new LinkedHashSet<>(4);
                correct = ra.nextInt(4);
                HashSet<Integer> ch = new HashSet<>();
                int incorrect; int c2=0;

                for(int i=0;c2<4;)
                {
                    if(i==correct && !ch.contains(i)) {
                       /// ans[i] = name[choose];ch.add(correct);
                        LHS.add(name[choose]);
                        i++;
                    }

                    else
                    {
                        incorrect=ra.nextInt(name.length);
                        while(incorrect==choose)
                        {
                            incorrect=ra.nextInt(name.length);
                        }
                        if(!LHS.contains(incorrect) && !ch.contains(incorrect))
                        {
                            LHS.add(name[incorrect]);
                          //  ans[i] = name[incorrect];
                            ch.add(incorrect);
                            i++;
                        }
                    }
                    c2++;

                }
                String[] LHSArray = new String[LHS.size()];
                LHSArray = LHS.toArray(LHSArray);
                ans[0]=LHSArray[0];ans[1]=LHSArray[1];ans[2]=LHSArray[2];ans[3]=LHSArray[3];

                button0.setText(ans[0]);
                button1.setText(ans[1]);
                button2.setText(ans[2]);
                button3.setText(ans[3]);


            }
        });

    }

}