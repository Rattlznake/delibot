package org.firstinspires.ftc.teamcode.nathanstuff.teleopmodules;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.nathanstuff.Drivetrain;
import org.firstinspires.ftc.teamcode.nathanstuff.Peripherals;

public class FieldOrientedDrive {
    private Drivetrain drivetrain;
    private Peripherals peripherals;

    public void drive(double driveX, double driveY, double turnValue) {
        double botYaw = peripherals.imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS);

        double rotatedX = driveX * Math.cos(-botYaw) - driveY * Math.sin(-botYaw);
        double rotatedY = driveX * Math.sin(-botYaw) + driveY * Math.cos(-botYaw);

        rotatedX *= 1.1; // corrects for movement being imperfect

        double denominator = Math.max(Math.abs(rotatedY) + Math.abs(rotatedX) + Math.abs(turnValue), 1);
        double flPower = (rotatedY + rotatedX + turnValue) / denominator;
        double blPower = (rotatedY - rotatedX + turnValue) / denominator;
        double frPower = (rotatedY - rotatedX - turnValue) / denominator;
        double brPower = (rotatedY + rotatedX - turnValue) / denominator;

        drivetrain.flMotor.setPower(flPower);
        drivetrain.frMotor.setPower(frPower);
        drivetrain.blMotor.setPower(blPower);
        drivetrain.brMotor.setPower(brPower);
    }

    public FieldOrientedDrive(Drivetrain drivetrain, Peripherals peripherals) {
        this.drivetrain = drivetrain;
        this.peripherals = peripherals;
    }
}
