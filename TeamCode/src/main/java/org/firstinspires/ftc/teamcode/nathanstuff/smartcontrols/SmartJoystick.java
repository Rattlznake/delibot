package org.firstinspires.ftc.teamcode.nathanstuff.smartcontrols;

public class SmartJoystick {
    float currentX;
    float currentY;
    float previousX;
    float previousY;
    float deadzone;

    public SmartJoystick(float x, float y, float deadzone) {
        this.previousX = 0;
        this.previousY = 0;
        this.currentX = x;
        this.currentY = -y;
        this.deadzone = deadzone;
    }

    public float pureCurrentX() {
        return currentX;
    }

    public float pureCurrentY() {
        return currentY;
    }

    public float currentX() {
        return (Math.abs(currentX) >= deadzone) ? currentX : 0;
    }

    public float currentY() {
        return (Math.abs(currentY) >= deadzone) ? currentY : 0;
    }

    public float purePreviousX() {
        return previousX;
    }

    public float purePreviousY() {
        return previousY;
    }

    public float previousX() {
        return (Math.abs(previousX) >= deadzone) ? previousX : 0;
    }

    public float previousY() {
        return (Math.abs(previousY) >= deadzone) ? previousY : 0;
    }

    public void setDeadzone(float newDeadzone) {
        deadzone = newDeadzone;
    }
    public void think(float x, float y) {
        this.previousX = currentX;
        this.previousY = currentY;
        this.currentX = x;
        this.currentY = -y;
    }
}
