package com.upiita.graficas2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        GraficasView graficas = new GraficasView(this);
        setContentView(graficas);
    }
    private class GraficasView extends View{

        public GraficasView(Context context) {
            super(context);
        }
        @Override
        protected void onDraw(Canvas canvas){
            super.onDraw(canvas);
            Paint paint = new Paint();
            paint.setColor(Color.BLUE);
            canvas.drawPaint(paint);

            paint.setColor(Color.RED);
            paint.setStrokeWidth(3);
            paint.setTextSize(40);

            int ancho = canvas.getWidth();
            int alto = canvas.getHeight();

            for (int n = 0; n < alto; n+=50) {
                canvas.drawLine(0,n,ancho,n,paint);
                canvas.drawText(""+n,ancho-100,n,paint);
            }

            paint.setColor(Color.BLACK);
            paint.setTextSize(60);
            paint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText("Texto alineado al centro",ancho/2,150,paint);

            paint.setTextAlign(Paint.Align.LEFT);
            canvas.drawText("Texto alineado a la izquierda",ancho/2,250,paint);

            paint.setTextAlign(Paint.Align.RIGHT);
            canvas.drawText("Texto alineado a la derecha",ancho/2,350,paint);

            paint.setTextAlign(Paint.Align.LEFT);
            paint.setTextSkewX(-0.4f);
            canvas.drawText("Texto sesgado 0.4",20,450,paint);

            paint.setTextSkewX(0f);
            paint.setTextScaleX(2.0f);
            canvas.drawText("Texto Escalado",20,550,paint);

            paint.setTextSkewX(-2.0f);
            canvas.drawText("Texto Escalado -2.0",ancho-20,650,paint);

            paint.setTextSkewX(-0.5f);
            canvas.drawText("Texto Escalado -0.5",ancho/2,750,paint);

            paint.setTextSkewX(0.5f);
            canvas.drawText("Texto Escalado -0.5",ancho/2,850,paint);
            paint.setTextScaleX(1f);

            paint.setAntiAlias(true);
            paint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText("Texto normal",ancho/2,950,paint);


            paint.setTypeface(Typeface.MONOSPACE);
            canvas.drawText("Texto Sans Serif",ancho/2,1050,paint);

            paint.setTextSize(200);
            String texto = new String(Character.toChars(0x270D));
            canvas.drawText(texto,ancho/2,1350,paint);

        }
    }
}
