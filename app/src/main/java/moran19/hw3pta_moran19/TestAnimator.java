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
    private int xVelocity = 0;
    private int yVelocity = 0;
    private int ballInitXPos = 90;
    private int ballInitYPos = 900;
    private int ballXPos;
    private int ballYPos;
    private int target1XPos = 300;
    private int target2XPos = 500;
    private int target1YPos = 250;
    private int target2YPos = 400;
    private boolean isFire = false;


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
     * The background color: white
     *
     * @return the background color onto which we will draw the image.
     */
    public int backgroundColor() {
        // create/return the background color
        return Color.rgb(255, 255, 255);
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
        /*xVelocity = (int) Math.cos(rotationAngle);
        yVelocity = (int) Math.sin(rotationAngle);
        ballXPos = ballInitXPos + xVelocity*count;
        ballYPos = ballInitYPos - yVelocity*count + 5*count*count;*/

        // Draw the ball in the correct position.
        Paint redPaint = new Paint();
        redPaint.setColor(Color.RED);


        g.save();

        if(isFire == true)
        {
            xVelocity = (int) Math.cos(rotationAngle);
            yVelocity = (int) Math.sin(rotationAngle);
            ballXPos = ballInitXPos + xVelocity*5*count;
            ballYPos = ballInitYPos - yVelocity*count;
            g.drawCircle(ballXPos, ballYPos,30,randPaint); //cannonBall

        }

        if(ballXPos > 2000)
        {
            isFire = false;
        }




        g.drawCircle(target1XPos+count,target1YPos+count,90,randPaint); //target1
        g.drawCircle(target2XPos-count,target2YPos-count,120, randPaint); //target2

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

        }
    }

    public Paint getRandPaint()
    {
        return randPaint;
    }

    public void setFireBoolean(boolean fire)
    {
        isFire = fire;
    }
}

