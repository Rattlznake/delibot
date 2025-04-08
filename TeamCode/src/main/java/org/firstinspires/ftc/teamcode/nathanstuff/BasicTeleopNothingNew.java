package org.firstinspires.ftc.teamcode.nathanstuff;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

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

            if (gamepad1.left_stick_button) {
                devices.imu.resetYaw();
            }

            double botYaw = devices.imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS);

            double rotatedX = leftStickX * Math.cos(-botYaw) - leftStickY * Math.sin(-botYaw);
            double rotatedY = leftStickX * Math.sin(-botYaw) + leftStickY * Math.cos(-botYaw);

            rotatedX *= 1.1;

            double denominator = Math.max(Math.abs(rotatedY) + Math.abs(rotatedX) + Math.abs(rightStickX), 1);
            double flPower = (rotatedY + rotatedX + rightStickX) / denominator;
            double blPower = (rotatedY - rotatedX + rightStickX) / denominator;
            double frPower = (rotatedY - rotatedX - rightStickX) / denominator;
            double brPower = (rotatedY + rotatedX - rightStickX) / denominator;

            devices.flMotor.setPower(flPower);
            devices.frMotor.setPower(frPower);
            devices.blMotor.setPower(blPower);
            devices.brMotor.setPower(brPower);
        }
    }
}
