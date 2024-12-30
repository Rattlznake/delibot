package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;
import org.firstinspires.ftc.teamcode.notstolencode.Devices;

import stolencode.FOD;

@TeleOp(group="Linear OpMode")
public class DelibotTeleopButFOD extends LinearOpMode {
    @Override public void runOpMode() {
        Devices dev = new Devices(hardwareMap);
        FOD fod = new FOD(dev);
        YawPitchRollAngles robotYPR;
        double joystickOrientation;


        waitForStart();

        while (opModeIsActive()) {
            robotYPR = dev.imu.getRobotYawPitchRollAngles();

            joystickOrientation = Math.atan2(gamepad1.right_stick_x,-gamepad1.left_stick_y);

            telemetry.addData("robotYaw",robotYPR.getYaw(AngleUnit.RADIANS));

            telemetry.addData("Joystick X",gamepad1.right_stick_x);
            telemetry.addData("Joystick Y",-gamepad1.right_stick_y);
            telemetry.addData("Joystick Radian Angle",joystickOrientation);
            telemetry.update();

            if (gamepad1.y) {
                fod.resetOrientation();
            }

            fod.FODDrive(-gamepad1.left_stick_y,gamepad1.left_stick_x, gamepad1.right_stick_x,-gamepad1.right_stick_y, 1);
        }
    }
}
