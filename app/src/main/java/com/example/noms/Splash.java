package com.example.noms;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Splash extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        openApp(true);


        //implements and starts animation
        ImageView vikingTitle = findViewById(R.id.logoSplash);


        //In transition: (alpha from 0 to 0.5)
        vikingTitle.setAlpha(0f);
        vikingTitle.setVisibility(View.VISIBLE);
        vikingTitle.animate()
                .alpha(1)
                .setDuration(400)
                .setListener(null);

//Out transition: (alpha from 0.5 to 0)
        vikingTitle.setAlpha(1f);
        vikingTitle.animate()
                .alpha(0f)
                .setDuration(3000)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        vikingTitle.setVisibility(View.GONE);
                    }
                });

        //    Glide for loading girls
//        ImageView mSea = findViewById(R.id.backView);
//
//        Glide.with(this)
//                .load("https://images.unsplash.com/photo-1565214975484-3cfa9e56f914?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1482&q=80")
////                .load(R.drawable.girl)
//                .transition(DrawableTransitionOptions.withCrossFade(10))
//                .centerCrop()
////                .placeholder(new ColorDrawable(this.getResources().getColor(R.color.fucsia_200)))
////                .circleCrop()
//                .into(mSea);


    }


    private void openApp(boolean locationPermission) {

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash
                        .this, MainActivity.class);
                startActivity(intent);
            }
        }, 3000);


    }
}

