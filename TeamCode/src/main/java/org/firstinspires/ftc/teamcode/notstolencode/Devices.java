package org.firstinspires.ftc.teamcode.notstolencode;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.hardware.Servo;

public class Devices {
    public DcMotorEx FLMotor;
    public DcMotorEx FRMotor;
    public DcMotorEx BLMotor;
    public DcMotorEx BRMotor;

    public DcMotorEx ArmMotor;
    public Servo ArmServo;

    public IMU imu;

    public Devices(HardwareMap hardwareMap) {
        FLMotor = hardwareMap.get(DcMotorEx.class, "FLMotor");
        FRMotor = hardwareMap.get(DcMotorEx.class, "FRMotor");
        BLMotor = hardwareMap.get(DcMotorEx.class, "BLMotor");
        BRMotor = hardwareMap.get(DcMotorEx.class, "BRMotor");

        ArmMotor = hardwareMap.get(DcMotorEx.class, "ArmMotor");
        ArmServo = hardwareMap.get(Servo.class,"ArmServo");

        imu = hardwareMap.get(IMU.class, "imu");
        imu.initialize(new IMU.Parameters(
                new RevHubOrientationOnRobot(
                        RevHubOrientationOnRobot.LogoFacingDirection.UP,
                        RevHubOrientationOnRobot.UsbFacingDirection.FORWARD
                )
        ));

        FLMotor.setDirection(DcMotorEx.Direction.FORWARD);
        FRMotor.setDirection(DcMotorEx.Direction.REVERSE);
        BLMotor.setDirection(DcMotorEx.Direction.FORWARD);
        BRMotor.setDirection(DcMotorEx.Direction.REVERSE);

        FLMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        FRMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BLMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BRMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        ArmMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }
}
