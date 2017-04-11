package moran19.hw3pta_moran19;

import android.graphics.*;
import android.view.MotionEvent;


/**
 * class that animates a ball repeatedly moving diagonally on
 * simple background
 *
 * @author Steve Vegdahl
 * @author Andrew Nuxoll
 * @version September 2012
 */
public class TestAnimator implements Animator {

    // instance variables
    private int count = 0; // counts the number of logical clock ticks
    private boolean goBackwards = false; // whether clock is ticking backwards
    private int rotationAngle;
    private Paint randPaint = new Paint();
    private int initXPos = 90;
    private int initYPos = 900;
    private int currXPos;
    private int currYPos;
    private int xVelocity = 0;
    private int yVelocity = 0;
    private boolean isFire;

    /**
     * Interval between animation frames: .03 seconds (i.e., about 33 times
     * per second).
     *
     * @return the time interval between frames, in milliseconds.
     */
    public int interval() {
        return 30;
    }

    /**
     * The background color: a light blue.
     *
     * @return the background color onto which we will draw the image.
     */
    public int backgroundColor() {
        // create/return the background color
        return Color.rgb(255, 255, 255);
    }

    /**
     * Tells the animation whether to go backwards.
     *
     * @param b true iff animation is to go backwards.
     */
    public void goBackwards(boolean b) {
        // set our instance variable
        goBackwards = b;
    }

    /**
     * Action to perform on clock tick
     *
     * @param g the graphics object on which to draw
     */
    public void tick(Canvas g) {
        // bump our count either up or down by one, depending on whether
        // we are in "backwards mode".
        count ++;

        xVelocity = (int) Math.cos(rotationAngle);
        yVelocity = (int) Math.sin(rotationAngle);

        // Draw the ball in the correct position.
        Paint redPaint = new Paint();
        redPaint.setColor(Color.RED);


        g.save();


        g.drawCircle((float) (100+ (xVelocity*count)),(float) (100- (yVelocity*count) + (count*count)),30, randPaint); //cannonBall



        g.drawCircle(300+count,250+count,90,randPaint); //target1
        g.drawCircle(500-count,400-count,120, randPaint); //target2

        g.rotate(-rotationAngle, 90, 900);
        g.drawCircle(90,900,90,redPaint);
        g.drawRect(90,850,200,950,redPaint);
        g.restore();
        //g.drawCircle(num, num, 60, redPaint);
    }

    public void setRotationAngle(int angle)
    {
        this.rotationAngle = angle;
    }

    public void setIsFireBoolean(boolean fireBoolean)
    {
        this.isFire = fireBoolean;
    }


    /**
     * Tells that we never pause.
     *
     * @return indication of whether to pause
     */
    public boolean doPause() {
        return false;
    }

    /**
     * Tells that we never stop the animation.
     *
     * @return indication of whether to quit.
     */
    public boolean doQuit() {
        return false;
    }

    /**
     * reverse the ball's direction when the screen is tapped
     */
    public void onTouch(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            goBackwards = !goBackwards;
        }
    }

    public Paint getRandPaint()
    {
        return randPaint;
    }
}

