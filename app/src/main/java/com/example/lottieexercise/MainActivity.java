package com.example.lottieexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @BindView(R.id.numberCountTextViewId)
    TextView numberCountTextView;

    @BindView(R.id.lottieAnimation_viewId)
    LottieAnimationView lottieAnimationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO Binding Butter knife
        ButterKnife.bind(this);


    }

    public void onClick(View view) {
        CountDownTimer countDownTimer = new CountDownTimer(5000+100,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                String string = String.valueOf((int) (millisUntilFinished / 1000));
                numberCountTextView.setText(string);
            }

            @Override
            public void onFinish() {
                numberCountTextView.setVisibility(View.GONE);
                lottieAnimationView.setVisibility(View.VISIBLE);
            }
        };

        countDownTimer.start();
    }




    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        Handler handler = new Handler();

        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                // Enter into the run method after 8000 MilliSecond or 8 second
                Toast.makeText(MainActivity.this, "run before"  +doubleBackToExitPressedOnce, Toast.LENGTH_SHORT).show();
                doubleBackToExitPressedOnce=false;
                Toast.makeText(MainActivity.this, "run after  "+doubleBackToExitPressedOnce, Toast.LENGTH_SHORT).show();
            }
        }, 8000);

        //Toast.makeText(MainActivity.this, "run out  "+doubleBackToExitPressedOnce, Toast.LENGTH_SHORT).show();
    }
}
