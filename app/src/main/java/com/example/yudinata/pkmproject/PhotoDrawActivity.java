package com.example.yudinata.pkmproject;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class PhotoDrawActivity extends AppCompatActivity implements View.OnTouchListener,View.OnClickListener{

    ImageView imageView;
    Bitmap bitmap;
    Canvas canvas;
    Paint paint;
    int width, height;
    float downx = 0, downy = 0, upx = 0, upy = 0;
    Button addLine ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_draw);

        imageView = (ImageView) this.findViewById(R.id.imageView);
        addLine = (Button) findViewById(R.id.add_line);
        addLine.setOnClickListener( this);

//        Display currentDisplay = getWindowManager().getDefaultDisplay();
//        float dw = currentDisplay.getWidth();
//        float dh = currentDisplay.getHeight();
//
//        bitmap = Bitmap.createBitmap((int) dw, (int) dh,
//                Bitmap.Config.ARGB_8888);
//        canvas = new Canvas(bitmap);
//        paint = new Paint();
//        paint.setColor(Color.GREEN);
//        imageView.setImageBitmap(bitmap);

        imageView.setOnTouchListener(this);
    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        width=imageView.getWidth();
        height=imageView.getHeight();
    }

    @Override
    public void onClick(View v) {
        if(v.equals(addLine)){
            bitmap = Bitmap.createBitmap((int) width, (int) height,Bitmap.Config.ARGB_8888);
            canvas = new Canvas(bitmap);
            paint = new Paint();
            paint.setColor(Color.BLACK);
            imageView.setImageBitmap(bitmap);
            imageView.setOnTouchListener(this);
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                downx = event.getX();
                downy = event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                upx = event.getX();
                upy = event.getY();
                canvas.drawLine(downx, downy, upx, upy, paint);
                imageView.invalidate();
                break;
            case MotionEvent.ACTION_CANCEL:
                break;
            default:
                break;
        }
        return true;
    }


}
