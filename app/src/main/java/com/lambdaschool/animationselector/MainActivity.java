package com.lambdaschool.animationselector;

import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.image_view);
//        ((AnimatedImageDrawable)imageView.getDrawable()).start();
        imageView.setImageDrawable(getDrawable(R.drawable.walking_duck));
        ((AnimationDrawable)imageView.getDrawable()).start();
    }
}
