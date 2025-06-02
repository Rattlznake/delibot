package org.firstinspires.ftc.teamcode.nathanstuff.smartcontrols;

import com.qualcomm.robotcore.util.ElapsedTime;

import java.util.concurrent.TimeUnit;

public class SmartButton {
    private boolean previousValue;
    private boolean currentValue;
    private int ticksHeld;
    private ElapsedTime timeHeld;

    public SmartButton(boolean buttonValue) {
        this.previousValue = false;
        this.currentValue = buttonValue;
        this.ticksHeld = 0;
        this.timeHeld = new ElapsedTime();
    }

    public boolean justPressed() {
        return !previousValue && currentValue;
    }

    public boolean justReleased() {
        return previousValue && !currentValue;
    }

    public boolean currentlyPressed() {
        return currentValue;
    }

    public boolean previouslyPressed() {
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

    public void think(boolean value) {
        previousValue = currentValue;
        currentValue = value;

        if (currentValue && previousValue) {
            ticksHeld++;
        } else if (!currentValue) {
            ticksHeld = 0;
            timeHeld.reset();
        }
    }
}
