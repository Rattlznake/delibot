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
            double rightStickX = gamepad1.right_stick_x;
            double rightStickY = -gamepad1.right_stick_y;
            double leftStickX = gamepad1.left_stick_x;

            double denominator = Math.max(Math.abs(rightStickY) + Math.abs(rightStickX) + Math.abs(leftStickX), 1);
            double flPower = (rightStickY + rightStickX + leftStickX) / denominator;
            double frPower = (rightStickY - rightStickX + leftStickX) / denominator;
            double blPower = (rightStickY - rightStickX - leftStickX) / denominator;
            double brPower = (rightStickY + rightStickX - leftStickX) / denominator;

            devices.flMotor.setPower(flPower);
            devices.frMotor.setPower(frPower);
            devices.blMotor.setPower(blPower);
            devices.brMotor.setPower(brPower);
        }
    }
}
