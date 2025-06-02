package org.firstinspires.ftc.teamcode.nathanstuff.smartcontrols;

import com.qualcomm.robotcore.util.ElapsedTime;

import java.util.concurrent.TimeUnit;

public class SmartTrigger {
    public float clickThreshold;
    private int ticksHeld;
    private ElapsedTime timeHeld;
    private float previousValue;
    private float currentValue;

    public SmartTrigger(float initialValue, float clickThreshold) {
        this.clickThreshold = clickThreshold;
        this.previousValue = 0;
        this.currentValue = initialValue;
        this.ticksHeld = 0;
        this.timeHeld = new ElapsedTime();
    }

    public boolean justPressed() {
        return currentValue >= clickThreshold && !(previousValue >= clickThreshold);
    }

    public boolean justReleased() {
        return previousValue >= clickThreshold && !(currentValue >= clickThreshold);
    }

    public boolean currentlyPressed() {
        return currentValue >= clickThreshold;
    }

    public boolean previouslyPressed() {
        return previousValue >= clickThreshold;
    }

    public float currentValue() {
        return currentValue;
    }

    public float previousValue() {
        return previousValue;
    }

    public int ticksHeld() {
        return ticksHeld;
    }

    public float timeHeldSeconds() {
        return timeHeld.time(TimeUnit.SECONDS);
    }

    public float timeHeldMilliseconds() {
        return timeHeld.time(TimeUnit.MILLISECONDS);
    }

    public void think(float value) {
        previousValue = currentValue;
        currentValue = value;

        if (currentValue >= clickThreshold && previousValue >= clickThreshold) {
            ticksHeld++;
        } else if (!(currentValue >= clickThreshold)) {
            ticksHeld = 0;
            timeHeld.reset();
        }
    }
}
