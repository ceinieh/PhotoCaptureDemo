package com.example.android.photocapturingdemo;

import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    // private GridView gridView;
  //  private GridViewAdapter gridAdapter;
 //   public static TypedArray [] prgmImages={R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4,R.drawable.image5,R.drawable.image6};
    private  ImageView img1;
    private  ImageView img2;
    private  ImageView img3;
    private  ImageView img4;
    private  ImageView img5;
    private  ImageView img6;
    private int imageWidth = 440;
    private int imageHieght = 440;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        img1 = (ImageView) findViewById(R.id.a_ImageView1);
        img2 = (ImageView) findViewById(R.id.a_ImageView2);
        img3 = (ImageView) findViewById(R.id.a_ImageView3);
        img4 = (ImageView) findViewById(R.id.a_ImageView4);
        img5 = (ImageView) findViewById(R.id.a_ImageView5);
        img6 = (ImageView) findViewById(R.id.a_ImageView6);

        Picasso.with(this)
                .load(R.drawable.image1)
                .resize(imageWidth, imageHieght)
                .into(img1);
        Picasso.with(this)
                .load(R.drawable.image2)
                .resize(imageWidth, imageHieght)
                .into(img2);
        Picasso.with(this)
                .load(R.drawable.image3)
                .resize(imageWidth, imageHieght)
                .into(img3);
        Picasso.with(this)
                .load(R.drawable.image4)
                .resize(imageWidth, imageHieght)
                .into(img4);
        Picasso.with(this)
                .load(R.drawable.image5)
                .resize(imageWidth, imageHieght)
                .into(img5);

        Picasso.with(this)
                .load(R.drawable.image6)
                .resize(imageWidth, imageHieght)
                .into(img6);


   }
}
