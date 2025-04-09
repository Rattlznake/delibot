package org.firstinspires.ftc.teamcode.nathanstuff.teleops;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.nathanstuff.Devices;

@TeleOp(name="Motor Tester 3000")
public class MotorTester3000 extends LinearOpMode {

    public void runOpMode() {
        Devices devices = new Devices(hardwareMap);

        double drivetrainSpeed = 0.8;
        double wormGearSpeed = 0.8;
        double slidesSpeed = 0.8;

        devices.slides.setPower(0);
        devices.wormGear.setPower(0);
        devices.slides.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        devices.wormGear.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        waitForStart();

        while(opModeIsActive()) {
            // lt lb -> arm up/down
            // rt rb -> slides forward/back
            if (gamepad1.left_bumper) {
                devices.wormGear.setPower(wormGearSpeed);
            } else if (gamepad1.left_trigger > 0.2) {
                devices.wormGear.setPower(-wormGearSpeed);
            } else {
                devices.wormGear.setPower(0);
            }

            if (gamepad1.right_bumper) { 
                devices.slides.setPower(slidesSpeed);
            } else if (gamepad1.right_trigger > 0.2) {
                devices.slides.setPower(-slidesSpeed);
            } else {
                devices.slides.setPower(0);
            }

            if (gamepad1.a) {
                devices.flMotor.setPower(drivetrainSpeed);
            } else if (gamepad1.dpad_down) {
                devices.flMotor.setPower(-drivetrainSpeed);
            } else {
                devices.flMotor.setPower(0);
            }

            if (gamepad1.b) {
                devices.frMotor.setPower(drivetrainSpeed);
            } else if (gamepad1.dpad_right) {
                devices.frMotor.setPower(-drivetrainSpeed);
            } else {
                devices.frMotor.setPower(0);
            }

            if (gamepad1.y) {
                devices.brMotor.setPower(drivetrainSpeed);
            } else if (gamepad1.dpad_up) {
                devices.brMotor.setPower(-drivetrainSpeed);
            } else {
                devices.brMotor.setPower(0);
            }

            if (gamepad1.x) {
                devices.blMotor.setPower(drivetrainSpeed);
            } else if (gamepad1.dpad_left) {
                devices.blMotor.setPower(-drivetrainSpeed);
            } else {
                devices.blMotor.setPower(0);
            }
        }
    }
}
