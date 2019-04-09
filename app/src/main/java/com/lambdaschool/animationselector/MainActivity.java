package com.lambdaschool.animationselector;

import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    Spinner   resourceSelector;
    boolean   isPlaying;
    ImageView buttonView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.image_view);
        isPlaying = false;

        resourceSelector = findViewById(R.id.image_selector);
        resourceSelector.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(isPlaying) {
                    setPlayButton(isPlaying);
                    isPlaying = false;
                }

                switch (position) {
                    case 0:
                        imageView.setImageDrawable(getDrawable(R.drawable.hourglass));
                        break;
                    case 1:
                        imageView.setImageDrawable(getDrawable(R.drawable.walking_duck));
                        break;
                    case 2:
                        imageView.setImageDrawable(getDrawable(R.drawable.gatsby));
                        break;
                    case 3:
                        imageView.setImageDrawable(getDrawable(R.drawable.toaster));
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        buttonView = findViewById(R.id.start_button);
        buttonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Drawable drawable = imageView.getDrawable();
                if (drawable instanceof AnimatedImageDrawable) {

                    final AnimatedImageDrawable animatedImageDrawable = (AnimatedImageDrawable) drawable;

                    if (animatedImageDrawable.isRunning()) {
                        animatedImageDrawable.stop();
                    } else {
                        animatedImageDrawable.start();
                    }

                } else if (drawable instanceof AnimationDrawable) {

                    final AnimationDrawable animationDrawable = (AnimationDrawable) drawable;

                    if (animationDrawable.isRunning()) {
                        animationDrawable.stop();
                    } else {
                        animationDrawable.start();
                    }
                }

                setPlayButton(isPlaying);
                isPlaying = !isPlaying;

            }
        });
    }

    private void setPlayButton(boolean isPlaying) {
        if (!isPlaying) {
            buttonView.setImageDrawable(getDrawable(R.drawable.avd_play_to_pause));
        } else {
            buttonView.setImageDrawable(getDrawable(R.drawable.avd_pause_to_play));
        }

        final Drawable buttonDrawable = buttonView.getDrawable();
        if (buttonDrawable instanceof AnimatedVectorDrawable) {
            ((AnimatedVectorDrawable) buttonDrawable).start();
        }
    }
}
