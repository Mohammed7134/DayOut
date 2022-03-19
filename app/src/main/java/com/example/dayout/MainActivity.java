package com.example.dayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private static final String CURRENT_INDEX = "CURRENT_INDEX";
    int[] mPictures = {
            R.drawable.beach,
            R.drawable.bike,
            R.drawable.museum,
            R.drawable.park,
            R.drawable.restaurant,
            R.drawable.running,
            R.drawable.shop,
            R.drawable.swimming,
            R.drawable.walking
    };
    int mCurrentIndex;
    ImageView imageView;
    Random random;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCurrentIndex = 0;
        imageView = findViewById(R.id.imageView);
        random = new Random();
    }
    public void displayRandomPicture(View view) {
        mCurrentIndex =random.nextInt(9);
        display();
    }
    public void display() {
        imageView.setImageResource(mPictures[mCurrentIndex]);
    }
    public void nextPicture(View view) {
        if (mCurrentIndex < 8) {
            imageView.setImageResource(mPictures[++mCurrentIndex]);
        } else {
            Toast.makeText(this, "وصلت إلى البداية", Toast.LENGTH_SHORT).show();
        }
    };
    public void previousPicture(View view) {
        if (mCurrentIndex > 0) {
            imageView.setImageResource(mPictures[--mCurrentIndex]);
        } else {
            Toast.makeText(this, "وصلت إلى النهاية", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(CURRENT_INDEX, mCurrentIndex);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mCurrentIndex = savedInstanceState.getInt(CURRENT_INDEX);
        display();
    }
}