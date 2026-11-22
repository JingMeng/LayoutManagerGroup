package com.dingmouren.example.layoutmanagergroup.activity;


import android.annotation.TargetApi;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.dingmouren.example.layoutmanagergroup.MyApplication;
import com.dingmouren.example.layoutmanagergroup.R;

/**
 * Created by 閽夋煇浜? * github: https://github.com/DingMouRen
 * email: naildingmouren@gmail.com
 */


public class SkidRightActivity_2 extends AppCompatActivity {
    private ImageView mImgBg;
    private ImageView mImgGif;
    private TextView mTvTitle;
    private  int mImgPath;
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skid_2);
        mImgBg = findViewById(R.id.img_bg);
        mTvTitle = findViewById(R.id.tv_title);
        mImgGif = findViewById(R.id.img_gif);
        if (getIntent() != null){
            mImgPath = getIntent().getIntExtra("img",R.mipmap.skid_right_3);
            String title = getIntent().getStringExtra("title");
            mTvTitle.setText(title);
            Glide.with(this).load(mImgPath).asBitmap().diskCacheStrategy(DiskCacheStrategy.SOURCE).into(mImgBg);
           new Handler().postDelayed(new Runnable() {
               @Override
               public void run() {
                   Glide.with(SkidRightActivity_2.this).load(mImgPath).asGif().diskCacheStrategy(DiskCacheStrategy.SOURCE).into(mImgGif);
               }
           },1000);

        }
    }



    @Override
    public void onBackPressed() {
        mImgGif.setVisibility(View.INVISIBLE);
        super.onBackPressed();
    }
}

