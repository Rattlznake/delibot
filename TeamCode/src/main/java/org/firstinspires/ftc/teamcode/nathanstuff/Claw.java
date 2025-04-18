package org.firstinspires.ftc.teamcode.nathanstuff;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Claw {
    public Servo leftClaw;
    public Servo rightClaw;
    public Servo wristRollServo;
    public Servo wristPitchServo;

    public void setPincherGap(double pincherGap) {
        // TODO: implement this
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

    public Claw(HardwareMap hardwareMap) {
        this.leftClaw = hardwareMap.get(Servo.class, "LeftClaw");
        this.rightClaw = hardwareMap.get(Servo.class, "RightClaw");
        this.wristRollServo = hardwareMap.get(Servo.class, "WristRoll");
        this.wristPitchServo = hardwareMap.get(Servo.class, "WristPitch");
    }
}
