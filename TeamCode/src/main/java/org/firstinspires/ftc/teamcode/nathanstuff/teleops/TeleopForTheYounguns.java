package org.firstinspires.ftc.teamcode.nathanstuff.teleops;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.nathanstuff.Arm;
import org.firstinspires.ftc.teamcode.nathanstuff.Claw;
import org.firstinspires.ftc.teamcode.nathanstuff.Drivetrain;
import org.firstinspires.ftc.teamcode.nathanstuff.Peripherals;
import org.firstinspires.ftc.teamcode.nathanstuff.smartcontrols.SmartController;
import org.firstinspires.ftc.teamcode.nathanstuff.teleopmodules.BotOrientedDrive;
import org.firstinspires.ftc.teamcode.nathanstuff.teleopmodules.FieldOrientedDrive;
import org.firstinspires.ftc.teamcode.nathanstuff.teleopmodules.SimpleBucketArm;

import java.lang.reflect.Field;

@TeleOp(name="TeleOp For The Young'uns")
public class TeleopForTheYounguns extends OpMode {
    Arm arm;
    Claw claw;
    Drivetrain drivetrain;
    Peripherals peripherals;

    SmartController driverController;
    SmartController manipulatorController;

    FieldOrientedDrive fieldOrientedDrive;
    BotOrientedDrive botOrientedDrive;

    SimpleBucketArm simpleBucketArm;

    boolean grabComplete = true;
    boolean releaseComplete = true;

    boolean useFod = true;

    public void init() {
        arm = new Arm(hardwareMap);
        claw = new Claw(hardwareMap);
        drivetrain = new Drivetrain(hardwareMap);
        peripherals = new Peripherals(hardwareMap);

        driverController = new SmartController(gamepad1);
        manipulatorController = new SmartController(gamepad2);

        driverController.left_stick.setDeadzone(0.05f);

        fieldOrientedDrive = new FieldOrientedDrive(drivetrain, peripherals);
        botOrientedDrive = new BotOrientedDrive(drivetrain);

        simpleBucketArm = new SimpleBucketArm(arm, claw);

        arm.setArmPosition(0,0);
        claw.setClawPosition(0,0);
        claw.close();
    }

    public void loop() {
        driverController.think(gamepad1);
        manipulatorController.think(gamepad2);

        driverControls();
        manipulatorControls();
    }

    public void driverControls() {
        if (driverController.x.justPressed()) {
            useFod = !useFod;
        }
        if (driverController.y.justPressed()) {
            peripherals.imu.resetYaw();
        }

        double driveSpeedMultiplier = 1-(driverController.left_trigger.currentValue()*0.75);
        double driveSpeed = 0.8*driveSpeedMultiplier;
        double turnSpeed = 1;

        double driveX = driverController.left_stick.currentX()*driveSpeed;
        double driveY = driverController.left_stick.currentY()*driveSpeed;
        double turnValue = driverController.right_stick.currentX()*turnSpeed;

        if (useFod) {
            fieldOrientedDrive.drive(driveX, driveY, turnValue);
        } else {
            botOrientedDrive.drive(driveX, driveY, turnValue);
        }
    }

    public void manipulatorControls() {
        if (manipulatorController.a.justPressed() && simpleBucketArm.state == SimpleBucketArm.GrabState.UNENGAGED) {
            simpleBucketArm.engage();
        }
        if ((manipulatorController.a.justPressed() && simpleBucketArm.state == SimpleBucketArm.GrabState.GRABBING) || !grabComplete) {
            grabComplete = simpleBucketArm.grab();
        }
        if ((manipulatorController.a.justPressed() && simpleBucketArm.state == SimpleBucketArm.GrabState.DROPPING) || !releaseComplete) {
            releaseComplete = simpleBucketArm.release();
        }

        if (manipulatorController.b.justPressed()) {
            simpleBucketArm.disengage();
            grabComplete = true;
            releaseComplete = true;
        }

        if (manipulatorController.dpad_up.justPressed()) {
            simpleBucketArm.setDistance(simpleBucketArm.getDistance()+0.2);
        }
        if (manipulatorController.dpad_down.justPressed()) {
            simpleBucketArm.setDistance(simpleBucketArm.getDistance()-0.2);
        }
    }
}
