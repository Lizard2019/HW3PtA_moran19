package moran19.hw3pta_moran19;

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

public class CannonMainActivity extends AppCompatActivity implements View.OnTouchListener{

    TextView aimText;
    TextView hitOrMissText;
    ImageView myCanon;
    ImageButton downButton;
    ImageButton upButton;
    Button fire;
    AnimationCanvas myCanvas;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cannon_main);

        //initialize my variables
        aimText = (TextView) findViewById(R.id.aim);
        hitOrMissText = (TextView) findViewById(R.id.hitOrMiss);
        myCanon = (ImageView) findViewById(R.id.canon);
        downButton = (ImageButton) findViewById(R.id.down);
        upButton = (ImageButton) findViewById(R.id.up);
        fire = (Button) findViewById(R.id.shoot);


        // Create an animation canvas and place it in the main layout
        Animator testAnim = new TestAnimator();
        myCanvas = new AnimationCanvas(this, testAnim);
        RelativeLayout mainLayout = (RelativeLayout) this
                .findViewById(R.id.topLevelLayout);
        mainLayout.addView(myCanvas);

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if(event.getActionMasked() == MotionEvent.ACTION_DOWN)
        {
            /*//updates seek bar values for each element, and updates text view
            for(int i = 1; i < 7; i++)
            {
                tempElement = surface.elementArray[i];
                tempColor = tempElement.getColor();

                if(tempElement.containsPoint((int)motionEvent.getX(), (int)motionEvent.getY()))
                {
                    isTouched = i;
                    surface.setIsTouched(i);
                    textView.setText(tempElement.getName());


                    redBar.setProgress((tempColor >> 16) & 255);
                    greenBar.setProgress((tempColor >> 8) & 255);
                    blueBar.setProgress(tempColor & 255);
                }
            }*/
        }
        myCanvas.invalidate();
        return true;
    }

}
