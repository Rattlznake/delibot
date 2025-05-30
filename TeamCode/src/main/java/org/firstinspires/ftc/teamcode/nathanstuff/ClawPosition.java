package org.firstinspires.ftc.teamcode.nathanstuff;

public class ClawPosition {
    double wristPitch;
    boolean useWristPitch;
    double wristRoll;
    boolean useWristRoll;

    public ClawPosition(double wristPitch, boolean useWristPitch, double wristRoll, boolean useWristRoll) {
        this.wristPitch = wristPitch;
        this.useWristPitch = useWristPitch;
        this.wristRoll = wristRoll;
        this.useWristRoll = useWristRoll;
    }

    public ClawPosition() {
        this.wristPitch = 0;
        this.useWristPitch = false;
        this.wristRoll = 0;
        this.useWristRoll = false;
    }

    // wrist pitch servo code
    public void setWristPitch(double wristPitch) {
        this.wristPitch = wristPitch;
        this.useWristPitch = true;
    }

    public void disableWristPitch() {
        this.useWristPitch = false;
    }

    // wrist roll servo code
    public void setWristRoll(double wristRoll) {
        this.wristRoll = wristRoll;
        this.useWristRoll = true;
    }

    public void disableWristRoll() {
        this.useWristRoll = false;
    }
}
