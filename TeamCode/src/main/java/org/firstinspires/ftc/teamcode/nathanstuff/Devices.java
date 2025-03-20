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

    public Servo servo1; // figure out what this actually does
    public Servo servo2; // figure out what this actually does
    public Servo servo3; // figure out what this actually does
    public Servo servo4; // figure out what this actually does

    public DcMotor flMotor;
    public DcMotor frMotor;
    public DcMotor blMotor;
    public DcMotor brMotor;

    public IMU imu;

    public Devices(HardwareMap hardwareMap) {
        this.hardwareMap = hardwareMap;

        this.slides = hardwareMap.get(DcMotorEx.class, "Slides");
        this.wormGear = hardwareMap.get(DcMotorEx.class, "WormGear");

        this.servo1 = hardwareMap.get(Servo.class, "Servo1");
        this.servo2 = hardwareMap.get(Servo.class, "Servo2");
        this.servo3 = hardwareMap.get(Servo.class, "Servo3");
        this.servo4 = hardwareMap.get(Servo.class, "Servo4");

        this.flMotor = hardwareMap.get(DcMotor.class, "FLMotor");
        this.frMotor = hardwareMap.get(DcMotor.class, "FRMotor");
        this.blMotor = hardwareMap.get(DcMotor.class, "BLMotor");
        this.brMotor = hardwareMap.get(DcMotor.class, "BRMotor");

        this.imu = hardwareMap.get(IMU.class, "imu");
        imu.initialize(
             new IMU.Parameters(
                new RevHubOrientationOnRobot(
                        LogoFacingDirection.UP,
                        UsbFacingDirection.RIGHT
                )
        ))
    }
}