package org.firstinspires.ftc.teamcode.nathanstuff;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Arm {
    public DcMotorEx slides; // TODO: Enforce maximum and minimum slides distance?
    public DcMotorEx wormGear;

    public void setArmExtension(int extension) {
        slides.setTargetPosition(extension);
        if (slides.getMode() != DcMotor.RunMode.RUN_TO_POSITION) {
            slides.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        }
    }

    public void setWormGearAngle(int rotation) {
        wormGear.setTargetPosition(rotation);
        if (wormGear.getMode() != DcMotor.RunMode.RUN_TO_POSITION) {
            wormGear.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        }
    }

    public void setArmPosition(int armExtension, int wormGearRotation) {
        this.setArmExtension(armExtension);
        this.setWormGearAngle(wormGearRotation);
    }

    public void setArmPosition(ArmPosition position) {
        if (position.useSlides) {
            this.setArmExtension(position.slides);
        }
        if (position.useWormGear) {
            this.setWormGearAngle(position.wormGear);
        }
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
