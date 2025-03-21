package org.firstinspires.ftc.teamcode.nathanstuff;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="Motor Tester 3000")
public class MotorTester3000 extends LinearOpMode {

    public void runOpMode() {
        Devices devices = new Devices(hardwareMap);

        double drivetrainSpeed = 0.01;
        double wormGearSpeed = 0.01;
        double slidesSpeed = 0.01;

        waitForStart();

        while(opModeIsActive()) {
            // put code here
        }
    }
}
