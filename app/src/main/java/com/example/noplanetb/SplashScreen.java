package com.example.noplanetb;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.mikhaellopez.circularimageview.CircularImageView;
public class SplashScreen extends Activity {
    @RequiresApi(api = Build.VERSION_CODES.O)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        TextView tvNoPlanet=(TextView)findViewById(R.id.tvNoPlanetB);
        TextView tvSlogan=(TextView)findViewById(R.id.tvSlogan);
        CircularImageView civRocket = (CircularImageView)findViewById(R.id.civRocket);

        Glide.with(this)
                .load(R.drawable.rocketlogo)
                .apply(new RequestOptions()

//                        .override(50, 50)
                                .centerCrop()
                                .diskCacheStrategy(DiskCacheStrategy.ALL)
                )
                .into(civRocket);

        Animation animacion = AnimationUtils.loadAnimation(this, R.anim.fadein);

        tvNoPlanet.startAnimation(animacion);
        tvSlogan.startAnimation(animacion);
        civRocket.startAnimation(animacion);


        openApp(true);
    }


    private void openApp(boolean locationPermission) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen
                        .this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, 5000);
    }
}
