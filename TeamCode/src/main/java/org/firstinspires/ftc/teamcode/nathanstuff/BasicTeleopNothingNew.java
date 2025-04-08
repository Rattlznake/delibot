package org.firstinspires.ftc.teamcode.nathanstuff;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="BasicTeleOpNothingNew")
public class BasicTeleopNothingNew extends LinearOpMode {

    public void runOpMode() {
        Devices devices = new Devices(hardwareMap);

        devices.slides.setPower(0);
        devices.wormGear.setPower(0);

        waitForStart();

        while(opModeIsActive()) {
            double leftStickX = gamepad1.left_stick_x;
            double leftStickY = -gamepad1.left_stick_y;
            double rightStickX = gamepad1.right_stick_x;

            double denominator = Math.max(Math.abs(leftStickY) + Math.abs(leftStickX) + Math.abs(rightStickX), 1);
            double flPower = (leftStickY + leftStickX + rightStickX) / denominator;
            double blPower = (leftStickY - leftStickX + rightStickX) / denominator;
            double frPower = (leftStickY - leftStickX - rightStickX) / denominator;
            double brPower = (leftStickY + leftStickX - rightStickX) / denominator;

            devices.flMotor.setPower(flPower);
            devices.frMotor.setPower(frPower);
            devices.blMotor.setPower(blPower);
            devices.brMotor.setPower(brPower);
        }
    }
}
