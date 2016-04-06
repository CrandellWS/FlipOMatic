package ws.crandell.flipomatic;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

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
        final ImageView imageview = (ImageView) findViewById(R.id.imgbtn);
        imageview.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if(getRandomBoolean()) {
                    imageshow.setImageResource(R.drawable.left);
                } else {
                    imageshow.setImageResource(R.drawable.right);
                }

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //Do something after 100ms
                        imageshow.setImageResource(0);
                    }
                }, 1500);
            }
        });
    }


}

