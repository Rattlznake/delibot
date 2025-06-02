package org.firstinspires.ftc.teamcode.nathanstuff.teleops;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.nathanstuff.Arm;
import org.firstinspires.ftc.teamcode.nathanstuff.Claw;
import org.firstinspires.ftc.teamcode.nathanstuff.Drivetrain;
import org.firstinspires.ftc.teamcode.nathanstuff.Peripherals;

@TeleOp(name="Baby's First Regular OpMode")
public class BabysFirstRegularOpMode extends OpMode {
    Arm arm;
    Claw claw;
    Drivetrain drivetrain;
    Peripherals peripherals;

    public void init() {
        arm = new Arm(hardwareMap);
        claw = new Claw(hardwareMap);
        drivetrain = new Drivetrain(hardwareMap);
        peripherals = new Peripherals(hardwareMap);

        arm.setArmPosition(0,0);
        claw.setClawPosition(0,0);
        claw.close();
    }

    public void loop() {
        double leftStickX = gamepad1.left_stick_x;
        double leftStickY = -gamepad1.left_stick_y;
        double rightStickX = gamepad1.right_stick_x;

        if (gamepad1.left_stick_button) {
            peripherals.imu.resetYaw();
        }

        double botYaw = peripherals.imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS);

        double rotatedX = leftStickX * Math.cos(-botYaw) - leftStickY * Math.sin(-botYaw);
        double rotatedY = leftStickX * Math.sin(-botYaw) + leftStickY * Math.cos(-botYaw);

        rotatedX *= 1.1; // corrects for movement being imperfect

        double denominator = Math.max(Math.abs(rotatedY) + Math.abs(rotatedX) + Math.abs(rightStickX), 1);
        double flPower = (rotatedY + rotatedX + rightStickX) / denominator;
        double blPower = (rotatedY - rotatedX + rightStickX) / denominator;
        double frPower = (rotatedY - rotatedX - rightStickX) / denominator;
        double brPower = (rotatedY + rotatedX - rightStickX) / denominator;

        drivetrain.flMotor.setPower(flPower);
        drivetrain.frMotor.setPower(frPower);
        drivetrain.blMotor.setPower(blPower);
        drivetrain.brMotor.setPower(brPower);
    }
}
