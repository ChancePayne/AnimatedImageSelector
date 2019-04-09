package com.lambdaschool.animationselector;

import android.graphics.drawable.AnimatedImageDrawable;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.image_view);

        resourceSelector = findViewById(R.id.image_selector);
        resourceSelector.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String         selectedText = resourceSelector.getSelectedItem().toString();
                final String[] stringArray  = getResources().getStringArray(R.array.resource_list);

                if (selectedText.equals(stringArray[0])) {
                    imageView.setImageDrawable(getDrawable(R.drawable.hourglass));
                } else if (selectedText.equals(stringArray[1])) {
                    imageView.setImageDrawable(getDrawable(R.drawable.walking_duck));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        findViewById(R.id.start_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Drawable drawable = imageView.getDrawable();
                if(drawable instanceof AnimatedImageDrawable) {
                    ((AnimatedImageDrawable) drawable).start();
                } else if (drawable instanceof AnimationDrawable) {
                    ((AnimationDrawable) drawable).start();
                }
            }
        });


    }
}
