package com.example.android.photocapturingdemo;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.graphics.drawable.PictureDrawable;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private Button captureBtn;
    private ImageView imageView;
    private boolean sentNotificationFlag = false;
    private static final int CAMERA_REQUEST = 1000;
    int mNotificationId = 001;
    private NotificationCompat.Builder mBuilder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        captureBtn = (Button) findViewById(R.id.a_Take_Picture_btn);
        imageView = (ImageView) findViewById(R.id.a_ImageViewer);
        mBuilder = new NotificationCompat.Builder(this);
        mBuilder.setSmallIcon(R.drawable.notification_icon);
        mBuilder.setContentTitle("Notification Alert, Click Me!");
        mBuilder.setContentText("Hi, going to the background!");

        captureBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(takePictureIntent, CAMERA_REQUEST);
                }
           }
        });

     }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(photo);
        }
    }



    @Override
    protected void onStart() {
        super.onStart();
        sentNotificationFlag = true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        sentNotificationFlag = true;
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(sentNotificationFlag){
            sendNotification();
        }
    }
    private void sendNotification(){
        NotificationManager mNotifyMgr =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        mNotifyMgr.notify(mNotificationId, mBuilder.build());
    }

}
