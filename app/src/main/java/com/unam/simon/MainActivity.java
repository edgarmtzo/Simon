package com.unam.simon;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Handler mHandler=new Handler();

    ConstraintLayout cuadro1,cuadro2,cuadro3, cuadro4;
    Button botonstart;
    TextView cuadrotexto;
    int i;
    int intento=0;
    int rdm;
    int suma;
    int suma1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MediaPlayer tono= MediaPlayer.create(this, R.raw.not);
        final MediaPlayer tono1=MediaPlayer.create(this,R.raw.not1);
        final MediaPlayer tono2=MediaPlayer.create(this,R.raw.not2);
        final MediaPlayer tono3=MediaPlayer.create(this,R.raw.not3);
        final MediaPlayer tono4=MediaPlayer.create(this,R.raw.sfail);

        cuadro1 = (ConstraintLayout) findViewById(R.id.cuadro1);
        cuadro2 = (ConstraintLayout) findViewById(R.id.cuadro2);
        cuadro3 = (ConstraintLayout) findViewById(R.id.cuadro3);
        cuadro4 = (ConstraintLayout) findViewById(R.id.cuadro4);
        botonstart=(Button)findViewById(R.id.botonstart);
        cuadrotexto=(TextView)findViewById(R.id.cuadrotexto);

        cuadro1.setBackgroundColor(Color.BLACK);
        cuadro2.setBackgroundColor(Color.BLACK);
        cuadro3.setBackgroundColor(Color.BLACK);
        cuadro4.setBackgroundColor(Color.BLACK);

        cuadro1.setOnClickListener(new View.OnClickListener() {
            public Runnable fun3 =new Runnable() {
                @Override
                public void run() {
                    cuadro1.setBackgroundColor(Color.BLACK);
                    cuadro2.setBackgroundColor(Color.BLACK);
                    cuadro3.setBackgroundColor(Color.BLACK);
                    cuadro4.setBackgroundColor(Color.BLACK);
                }
            };
            @Override
            public void onClick(View v) {
                cuadro1.setBackgroundColor(Color.RED);
                tono.start();
                suma1=suma1+1;
                mHandler.postDelayed(fun3, 500);
            }
        });
        cuadro2.setOnClickListener(new View.OnClickListener() {
            public Runnable fun3 =new Runnable() {
                @Override
                public void run() {
                    cuadro1.setBackgroundColor(Color.BLACK);
                    cuadro2.setBackgroundColor(Color.BLACK);
                    cuadro3.setBackgroundColor(Color.BLACK);
                    cuadro4.setBackgroundColor(Color.BLACK);
                }
            };
            @Override
            public void onClick(View v) {
                cuadro2.setBackgroundColor(Color.BLUE);
                tono1.start();
                suma1=suma1+2;
                mHandler.postDelayed(fun3, 500);
            }
        });
        cuadro3.setOnClickListener(new View.OnClickListener() {
            public Runnable fun3 =new Runnable() {
                @Override
                public void run() {
                    cuadro1.setBackgroundColor(Color.BLACK);
                    cuadro2.setBackgroundColor(Color.BLACK);
                    cuadro3.setBackgroundColor(Color.BLACK);
                    cuadro4.setBackgroundColor(Color.BLACK);
                }
            };
            @Override
            public void onClick(View v) {
                cuadro3.setBackgroundColor(Color.YELLOW);
                tono2.start();
                suma1=suma1+3;
                mHandler.postDelayed(fun3, 500);
            }
        });
        cuadro4.setOnClickListener(new View.OnClickListener() {
            public Runnable fun3 =new Runnable() {
                @Override
                public void run() {
                    cuadro1.setBackgroundColor(Color.BLACK);
                    cuadro2.setBackgroundColor(Color.BLACK);
                    cuadro3.setBackgroundColor(Color.BLACK);
                    cuadro4.setBackgroundColor(Color.BLACK);
                }
            };
            @Override
            public void onClick(View v) {
                cuadro4.setBackgroundColor(Color.GREEN);
                tono3.start();
                suma1=suma1+4;
                mHandler.postDelayed(fun3, 500);
            }
        });

        botonstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                botonstart.setText("CHECK");
                i=1;
                mHandler.postDelayed(fun1, 1500);
                if (suma1==suma) {
                    intento=intento+1;
                }
                else {
                    cuadrotexto.setText("PERDISTE");
                    tono4.start();
                    i=1;
                    intento=0;
                    suma=0;
                    suma1=0;
                }
            }

            public Runnable fun1 =new Runnable() {
                @Override
                public void run() {
                    rdm = (int) (Math.random() * 4) + 1;
                    switch (rdm){
                        case 1:
                            cuadro1.setBackgroundColor(Color.RED);
                            tono.start();
                            mHandler.postDelayed(fun2, 1500);
                            suma=suma+rdm;
                            i=i+1;
                            break;
                        case 2:
                            cuadro2.setBackgroundColor(Color.BLUE);
                            tono1.start();
                            mHandler.postDelayed(fun2, 1500);
                            suma=suma+rdm;
                            i=i+1;
                            break;
                        case 3:
                            cuadro3.setBackgroundColor(Color.YELLOW);
                            tono2.start();
                            mHandler.postDelayed(fun2, 1500);
                            suma=suma+rdm;
                            i=i+1;
                            break;
                        case 4:
                            cuadro4.setBackgroundColor(Color.GREEN);
                            tono3.start();
                            mHandler.postDelayed(fun2, 1500);
                            suma=suma+rdm;
                            i=i+1;
                            break;
                        default:
                            cuadrotexto.setText("Error");
                    }
                }
            };

            public Runnable fun2 =new Runnable() {
                @Override
                public void run() {
                    cuadro1.setBackgroundColor(Color.BLACK);
                    cuadro2.setBackgroundColor(Color.BLACK);
                    cuadro3.setBackgroundColor(Color.BLACK);
                    cuadro4.setBackgroundColor(Color.BLACK);
                    if (i<=intento){
                        mHandler.postDelayed(fun1, 1500);
                    }
                    else {
                        cuadrotexto.setText("JUGANDO NIVEL "+intento);
                    }
                }
            };

            public Runnable fun3 =new Runnable() {
                @Override
                public void run() {
                    cuadro1.setBackgroundColor(Color.BLACK);
                    cuadro2.setBackgroundColor(Color.BLACK);
                    cuadro3.setBackgroundColor(Color.BLACK);
                    cuadro4.setBackgroundColor(Color.BLACK);
                }
            };
        });
    }
}