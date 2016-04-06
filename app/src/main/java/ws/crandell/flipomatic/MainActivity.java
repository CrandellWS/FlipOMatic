package ws.crandell.flipomatic;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        flipShow();
    }
    private static Random rnd = new Random();

    public static boolean getRandomBoolean() {
        return rnd.nextBoolean();
    }

    public static void main(String[] args) {
        System.out.println(getRandomBoolean());
    }
    final Handler handler = new Handler();
//from http://stackoverflow.com/a/18442080/1815624
    private void flipShow() {
//
        final ImageView imageshow = (ImageView) findViewById(R.id.imgshow);
        final ImageView imagebtn = (ImageView) findViewById(R.id.imgbtn);
        handler.removeCallbacksAndMessages(null);
        imageshow.setImageResource(0);

        final Animation fade = new AlphaAnimation(1, 0);
        //Do something after 100ms
        fade.setStartOffset(1000);
        fade.setDuration(1500);

        fade.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {

                imageshow.setImageResource(0);
                animation.setFillAfter(true);
            }
        });


        imagebtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                v.clearAnimation();
                imageshow.setImageResource(0);
                if (getRandomBoolean()) {
                    imageshow.setImageResource(R.drawable.left);
                } else {
                    imageshow.setImageResource(R.drawable.right);
                }

                imageshow.startAnimation(fade);
            }
        });
    }

}

