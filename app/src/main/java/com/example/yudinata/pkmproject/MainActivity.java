package com.example.yudinata.pkmproject;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button photoButton = (Button) this.findViewById(R.id.takePhoto);
        photoButton.setOnClickListener(this);

        Button btnCanvas = (Button) this.findViewById(R.id.btn_canvas);
        btnCanvas.setOnClickListener(this);

        Button btnDrag = (Button) this.findViewById(R.id.btn_drag);
        btnDrag.setOnClickListener(this);

        Button btnDrawLine = (Button) this.findViewById(R.id.btn_draw_image);
        btnDrawLine.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {


        if (v.getId() == R.id.takePhoto){
            Intent intent = new Intent(this,PhotoActivity.class);
            startActivity(intent);
        }
        if (v.getId() == R.id.btn_canvas){
//            Toast.makeText(this,"wikwik",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this,DrawLineActivity.class);
            startActivity(intent);
        }
        if (v.getId() == R.id.btn_drag){
            Intent intent = new Intent(this,DragLine.class);
            startActivity(intent);
        }

        if (v.getId() == R.id.btn_draw_image){
            Intent intent = new Intent(this,PhotoDrawActivity.class);
            startActivity(intent);
        }
    }

}
