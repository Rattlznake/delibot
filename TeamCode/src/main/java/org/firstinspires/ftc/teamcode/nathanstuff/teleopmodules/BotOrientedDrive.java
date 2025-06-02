package org.firstinspires.ftc.teamcode.nathanstuff.teleopmodules;

import org.firstinspires.ftc.teamcode.nathanstuff.Drivetrain;

public class BotOrientedDrive {
    private Drivetrain drivetrain;
    
    public void drive(double driveX, double driveY, double turnValue) {
        double denominator = Math.max(Math.abs(driveY) + Math.abs(driveX) + Math.abs(turnValue), 1);
        double flPower = (driveY + driveX + turnValue) / denominator;
        double blPower = (driveY - driveX + turnValue) / denominator;
        double frPower = (driveY - driveX - turnValue) / denominator;
        double brPower = (driveY + driveX - turnValue) / denominator;
        
        drivetrain.flMotor.setPower(flPower);
        drivetrain.frMotor.setPower(frPower);
        drivetrain.blMotor.setPower(blPower);
        drivetrain.brMotor.setPower(brPower);
    }

    public BotOrientedDrive(Drivetrain drivetrain) {
        this.drivetrain = drivetrain;
    }
}
