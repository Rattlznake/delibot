package org.firstinspires.ftc.teamcode.nathanstuff;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Arm {
    public DcMotorEx slides;
    public DcMotorEx wormGear;

    public void setArmExtension(int extension) {
        if (slides.getMode() != DcMotor.RunMode.RUN_TO_POSITION) {
            slides.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        }
        slides.setTargetPosition(extension);
        return;
    }

    public void setWormGearAngle(int rotation) {
        if (wormGear.getMode() != DcMotor.RunMode.RUN_TO_POSITION) {
            wormGear.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        }
        wormGear.setTargetPosition(rotation);
        return;
    }

    public void setArmPosition(int armExtension, int wormGearRotation) {
        this.setArmExtension(armExtension);
        this.setWormGearAngle(wormGearRotation);
    }

    public void runToPosition(ArmPosition position) {
        // TODO: Write code to run arm to a position
    }

    public Arm(HardwareMap hardwareMap) {
        this.slides = hardwareMap.get(DcMotorEx.class, "Slides");
        this.wormGear = hardwareMap.get(DcMotorEx.class, "WormGear");

        slides.setTargetPosition(0);
        wormGear.setTargetPosition(0);
        slides.setPower(0);
        slides.setPower(0);
        slides.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        wormGear.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        slides.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        wormGear.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }
}
