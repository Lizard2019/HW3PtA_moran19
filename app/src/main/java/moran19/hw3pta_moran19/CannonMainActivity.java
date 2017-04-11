package moran19.hw3pta_moran19;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class CannonMainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView aimText;
    private TextView hitOrMissText;
    private ImageButton downButton;
    private ImageButton upButton;
    private Button fire;
    private AnimationCanvas myCanvas;
    private int rotationAngle;
    private TestAnimator testAnim;
    private int redVal;
    private int greenVal;
    private int blueVal;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cannon_main);

        //initialize my variables
        aimText = (TextView) findViewById(R.id.aim);
        hitOrMissText = (TextView) findViewById(R.id.hitOrMiss);
        downButton = (ImageButton) findViewById(R.id.down);
        upButton = (ImageButton) findViewById(R.id.up);
        fire = (Button) findViewById(R.id.shoot);
        rotationAngle = 0;

        //register listeners
        downButton.setOnClickListener(this);
        upButton.setOnClickListener(this);
        fire.setOnClickListener(this);

        // Create an animation canvas and place it in the main layout
        testAnim = new TestAnimator();
        myCanvas = new AnimationCanvas(this, testAnim);
        LinearLayout mainLayout = (LinearLayout) this
                .findViewById(R.id.topLevelLayout);
        mainLayout.addView(myCanvas);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.up)
        {
            if(rotationAngle < 90)
            {
                rotationAngle = rotationAngle + 10;
            }
            testAnim.setRotationAngle(rotationAngle);
        }
        else if(v.getId() == R.id.down)
        {
            if(rotationAngle > 0)
            {
                rotationAngle = rotationAngle - 10;
            }
            testAnim.setRotationAngle(rotationAngle);
        }
        else if(v.getId() == R.id.shoot)
        {
            redVal = (int)(255*Math.random());
            greenVal = (int)(255*Math.random());
            blueVal = (int)(255*Math.random());

            testAnim.getRandPaint().setColor(Color.rgb(redVal, greenVal, blueVal));
            testAnim.setFireBoolean(true);
        }

    }

}
