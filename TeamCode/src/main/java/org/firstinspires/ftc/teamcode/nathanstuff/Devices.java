package org.firstinspires.ftc.teamcode.nathanstuff;

/* Devices and names:
    Exp. Hub:
        Motor 1 name: Slides
        Motor 2 name: WormGear
        Servo 2 name: Servo1
        Servo 3 name: Servo2
        Servo 4 name: Servo3
        Servo 5 name: Servo4
        I2C Bus 1 Port 0: OdometryComputer
    Control Hub:
        Motor 0: BRMotor
        Motor 1: BLMotor
        Motor 2: FRMotor
        Motor 3: FLMotor
        I2C Bus 0 Port 0: imu
 */

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.hardware.Servo;

public class Devices {
    HardwareMap hardwareMap;

    public DcMotorEx slides;
    public DcMotorEx wormGear;

    public Servo leftClaw; // figure out what this actually does
    public Servo rightClaw; // figure out what this actually does
    public Servo wristRoll; // figure out what this actually does
    public Servo wristPitch; // figure out what this actually does

    public DcMotor flMotor;
    public DcMotor frMotor;
    public DcMotor blMotor;
    public DcMotor brMotor;

    public IMU imu;

    public Devices(HardwareMap hardwareMap) {
        this.hardwareMap = hardwareMap;

        this.slides = hardwareMap.get(DcMotorEx.class, "Slides");
        this.wormGear = hardwareMap.get(DcMotorEx.class, "WormGear");

        this.leftClaw = hardwareMap.get(Servo.class, "LeftClaw");
        this.rightClaw = hardwareMap.get(Servo.class, "RightClaw");
        this.wristRoll = hardwareMap.get(Servo.class, "WristRoll");
        this.wristPitch = hardwareMap.get(Servo.class, "WristPitch");

        this.flMotor = hardwareMap.get(DcMotor.class, "FLMotor");
        this.frMotor = hardwareMap.get(DcMotor.class, "FRMotor");
        this.blMotor = hardwareMap.get(DcMotor.class, "BLMotor");
        this.brMotor = hardwareMap.get(DcMotor.class, "BRMotor");

        this.imu = hardwareMap.get(IMU.class, "imu");
        imu.initialize(
             new IMU.Parameters(
                new RevHubOrientationOnRobot(
                        RevHubOrientationOnRobot.LogoFacingDirection.UP,
                        RevHubOrientationOnRobot.UsbFacingDirection.RIGHT
                )
             )
        );

        // the following code causes an error if the motors aren't set to a position. oops!
        //slides.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        //wormGear.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        flMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        blMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        brMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        slides.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        wormGear.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        flMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        blMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        brMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }
}