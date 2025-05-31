package org.firstinspires.ftc.teamcode.nathanstuff;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Claw {
    public Servo leftClaw;
    public Servo rightClaw;
    public Servo wristRollServo;
    public Servo wristPitchServo;
    // TODO: Fill these in with appropriate values
    public final double leftClawClosed = 0;
    public final double rightClawClosed = 0;

    public void setPincherGap(double pincherGap) {
        leftClaw.setPosition(leftClawClosed+pincherGap);
        rightClaw.setPosition(rightClawClosed-pincherGap);
    }

    public void open() {
        this.setPincherGap(.50); // TODO: Change this value to represent appropriate "open" claw distance
    }

    public void close() {
        this.setPincherGap(0); // TODO: Change this value to represent appropriate "closed" claw distance
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
    }
}
