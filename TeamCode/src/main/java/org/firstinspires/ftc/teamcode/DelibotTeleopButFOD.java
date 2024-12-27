package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.notstolencode.Devices;

import stolencode.FOD;

@TeleOp(group="Linear OpMode")
public class DelibotTeleopButFOD extends LinearOpMode {
    @Override public void runOpMode() {
        Devices dev = new Devices(hardwareMap);
        FOD fod = new FOD(dev);

        waitForStart();

        while (opModeIsActive()) {

            if (gamepad1.y) {
                fod.resetOrientation();
            }

            fod.FODDrive(gamepad1.left_stick_y,gamepad1.left_stick_x, gamepad1.right_stick_x,1);
        }
    }
}
