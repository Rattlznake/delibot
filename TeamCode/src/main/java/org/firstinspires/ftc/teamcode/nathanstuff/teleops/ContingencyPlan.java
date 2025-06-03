package org.firstinspires.ftc.teamcode.nathanstuff.teleops;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.nathanstuff.Arm;
import org.firstinspires.ftc.teamcode.nathanstuff.Claw;
import org.firstinspires.ftc.teamcode.nathanstuff.Drivetrain;
import org.firstinspires.ftc.teamcode.nathanstuff.Peripherals;
import org.firstinspires.ftc.teamcode.nathanstuff.smartcontrols.SmartController;
import org.firstinspires.ftc.teamcode.nathanstuff.teleopmodules.BotOrientedDrive;
import org.firstinspires.ftc.teamcode.nathanstuff.teleopmodules.FieldOrientedDrive;

// CONTINGENCY PLAN TELEOP
// just in case writing the fun arm code doesn't work out

@TeleOp(name="Contingency Plan")
public class ContingencyPlan extends OpMode {
    // robot parts //
    Arm arm;
    Claw claw;
    Drivetrain drivetrain;
    Peripherals peripherals;

    // teleop modules //
    BotOrientedDrive botOrientedDrive;
    FieldOrientedDrive fieldOrientedDrive;

    // controllers //
    SmartController driverController;
    SmartController manipulatorController;

    boolean useFod = true;


    public void init() {
        arm = new Arm(hardwareMap);
        claw = new Claw(hardwareMap);
        drivetrain = new Drivetrain(hardwareMap);
        peripherals = new Peripherals(hardwareMap);

        botOrientedDrive = new BotOrientedDrive(drivetrain);
        fieldOrientedDrive = new FieldOrientedDrive(drivetrain, peripherals);

        driverController = new SmartController(gamepad1);
        manipulatorController = new SmartController(gamepad2);

        arm.slides.setPower(1);
        arm.slides.setTargetPosition(0);

        arm.wormGear.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        claw.setWristRoll(0.95);
    }

    public void loop() {
        driverController.think(gamepad1);
        manipulatorController.think(gamepad2);

        driverControls();
        manipulatorControls();
    }

    public void driverControls() {
        SmartController controller = driverController;

        if (controller.x.justPressed()) useFod = !useFod;
        if (controller.y.justPressed()) peripherals.imu.resetYaw();

        // brake value, left trigger slows down bot depending on amount pressed
        double driveSpeedMultiplier = 1-(controller.left_trigger.currentValue()*0.75);
        double driveSpeed = 0.8*driveSpeedMultiplier;
        double turnSpeed = 1;

        double driveX = controller.left_stick.currentX()*driveSpeed;
        double driveY = controller.left_stick.currentY()*driveSpeed;
        double turnValue = controller.right_stick.currentX()*turnSpeed;

        if (useFod) {
            fieldOrientedDrive.drive(driveX, driveY, turnValue);
        } else {
            botOrientedDrive.drive(driveX, driveY, turnValue);
        }
    }

    public void manipulatorControls() {
        SmartController controller = manipulatorController;

        // pitch & roll servo controls
        double wristPower = 0.01;

        double pitchNew = claw.wristPitchServo.getPosition() + (wristPower * controller.right_stick.currentY());
        claw.setWristPitch(pitchNew);

        double rollNew = claw.wristRollServo.getPosition() + (wristPower * controller.right_stick.currentX());
        claw.setWristRoll(rollNew);

        telemetry.addData("pitch servo: ",claw.wristPitchServo.getPosition());
        telemetry.addData("roll servo: ",claw.wristRollServo.getPosition());

        telemetry.addData("stick x: ",controller.right_stick.pureCurrentX());
        telemetry.addData("stick y: ",controller.right_stick.pureCurrentY());

        // slides
        int slidesMaxExtension = 2094;

        int newSlidesPosition = (int) -(slidesMaxExtension * controller.right_trigger.currentValue());
        arm.setArmExtension(newSlidesPosition);

        telemetry.addData("Right Trigger Value:",controller.right_trigger.currentValue());
        telemetry.addData("Desired Slides Position:",newSlidesPosition);

        // worm gear
        double wormGearPower = 0.8;

        arm.wormGear.setPower(wormGearPower * -controller.left_stick.currentY());
        arm.wormGear.setTargetPosition(arm.wormGear.getCurrentPosition());

        // claw controls
        if (controller.a.justPressed() || controller.right_bumper.justPressed()) {
            claw.toggle();
        }
    }
}
