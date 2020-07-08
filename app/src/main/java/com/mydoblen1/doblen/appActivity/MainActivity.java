package com.mydoblen1.doblen.appActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.mydoblen1.doblen.R;

public class MainActivity extends AppCompatActivity {


    private ImageView ivStart;
    private TextView tvStart,tvstartemail;
    private static int delay=2000;
    private static int delay2=2000;
    private static int delay3=1000;

    Animation appear, fade, fade2,coming;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);




        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                setUpView();
                animationStart();
                handler();
            }
        },delay3);


    }

    private void handler() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                fade=AnimationUtils.loadAnimation(MainActivity.this,R.anim.startfade);
                ivStart.setAnimation(fade);
                ivStart.setVisibility(View.GONE);
                fade2=AnimationUtils.loadAnimation(MainActivity.this,R.anim.startfade2);
                tvStart.setAnimation(fade2);
                tvStart.setVisibility(View.GONE);
                tvstartemail.setAnimation(fade2);
                tvstartemail.setVisibility(View.GONE);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent=new Intent(MainActivity.this, Main2Activity.class);
                        Pair pair=new Pair<View,String>(tvstartemail,"email_name");
                        ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,pair);
                        startActivity(intent,options.toBundle());
                        finish();
                    }
                },delay2);

            }
        },delay);

    }

    private void animationStart() {
        tvStart.setVisibility(View.VISIBLE);
        tvstartemail.setVisibility(View.VISIBLE);
        appear=AnimationUtils.loadAnimation(MainActivity.this,R.anim.startappear);
        tvStart.setAnimation(appear);
        tvstartemail.setAnimation(appear);
        coming=AnimationUtils.loadAnimation(MainActivity.this,R.anim.startphotocoming);
        ivStart.setVisibility(View.VISIBLE);
        ivStart.setAnimation(coming);
    }

    private void setUpView() {
        ivStart=(ImageView)findViewById(R.id.ivStart);
        tvStart=(TextView)findViewById(R.id.tvStart);
        tvstartemail=(TextView)findViewById(R.id.tvstartemail);
    }

}
