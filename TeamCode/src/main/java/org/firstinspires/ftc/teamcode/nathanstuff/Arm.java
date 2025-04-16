package org.firstinspires.ftc.teamcode.nathanstuff;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;

public class Arm {
    private DcMotorEx slides;
    private DcMotorEx wormGear;

    private Servo leftClaw;
    private Servo rightClaw;
    private Servo wristRoll;
    private Servo wristPitch;

    public void setSlidesPosition(int extension, double power) {
        slides.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        slides.setPower(power);
        slides.setTargetPosition(extension);
        return;
    }

    public void setSlidesPower(double power) {
        slides.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        slides.setPower(power);
        return;
    }

    public void setWormGearPosition(int rotation, double power) {
        wormGear.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        wormGear.setPower(power);
        wormGear.setTargetPosition(rotation);
        return;
    }

    public void setWormGearPower(double power) {
        wormGear.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        wormGear.setPower(power);
        return;
    }

    public void moveToPosition(ArmPosition desiredPosition) {

    }
}
