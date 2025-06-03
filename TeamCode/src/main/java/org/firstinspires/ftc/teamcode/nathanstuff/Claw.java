package org.firstinspires.ftc.teamcode.nathanstuff;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Claw {
    public Servo leftClaw;
    public Servo rightClaw;
    public Servo wristRollServo;
    public Servo wristPitchServo;
    public boolean clawClosed = false;
    public double leftClawClosed = 0.40;
    public double rightClawClosed = 0.40;

    public void setPincherGap(double pincherGap) {
        leftClaw.setPosition(leftClawClosed+pincherGap);
        rightClaw.setPosition(rightClawClosed-pincherGap);
    }

    public void open() {
        this.leftClaw.setPosition(0.625);
        this.rightClaw.setPosition(0.335);

        this.clawClosed = false;
    }

    public void close() {
        this.leftClaw.setPosition(0.49);
        this.rightClaw.setPosition(0.49);

        this.clawClosed = true;
    }

    public void toggle() {
        if (this.clawClosed) {
            this.open();
        } else {
            this.close();
        }

    }

    public void setWristRoll(double wristRoll) { // wrapper for setPosition for wristRollServo
        wristRollServo.setPosition(wristRoll);
    }

    public void setWristPitch(double wristPitch) { // wrapper for setPosition for wristRollServo
        wristPitchServo.setPosition(wristPitch);
    }

    public void setClawPosition(double wristRoll, double wristPitch) {
        setWristRoll(wristRoll);
        setWristPitch(wristPitch);
    }

    public void setClawPosition(ClawPosition position) {
        if (position.useWristPitch) {
            setWristPitch(position.wristPitch);
        }
        if (position.useWristRoll) {
            setWristRoll(position.wristRoll);
        }
    }

    public Claw(HardwareMap hardwareMap) {
        this.leftClaw = hardwareMap.get(Servo.class, "LeftClaw");
        this.rightClaw = hardwareMap.get(Servo.class, "RightClaw");
        this.wristRollServo = hardwareMap.get(Servo.class, "WristRoll");
        this.wristPitchServo = hardwareMap.get(Servo.class, "WristPitch");

        this.close();
    }
}
