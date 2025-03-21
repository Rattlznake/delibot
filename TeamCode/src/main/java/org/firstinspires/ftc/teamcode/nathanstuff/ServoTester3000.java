package org.firstinspires.ftc.teamcode.nathanstuff;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="Servo Tester 3000")
public class ServoTester3000 extends LinearOpMode {

    public void runOpMode() {
        Devices devices = new Devices(hardwareMap);

        double servoSpeed = 0.005;

        waitForStart();

        while (opModeIsActive()) {
            if (gamepad1.a) { // servo 1 cw -- left claw
                devices.leftClaw.setPosition(devices.leftClaw.getPosition()+servoSpeed);
            }
            if (gamepad1.dpad_down) { // servo 1 ccw
                devices.leftClaw.setPosition(devices.leftClaw.getPosition()-servoSpeed);
            }
            if (gamepad1.b) { // servo 2 cw -- right claw
                devices.rightClaw.setPosition(devices.rightClaw.getPosition()+servoSpeed);
            }
            if (gamepad1.dpad_right) { // servo 2 ccw
                devices.rightClaw.setPosition(devices.rightClaw.getPosition()-servoSpeed);
            }
            if (gamepad1.x) { // servo 3 cw -- wrist roll
                devices.wristRoll.setPosition(devices.wristRoll.getPosition()+servoSpeed);
            }
            if (gamepad1.dpad_left) { // servo 3 ccw
                devices.wristRoll.setPosition(devices.wristRoll.getPosition()-servoSpeed);
            }
            if (gamepad1.y) { // servo 4 cw -- wrist pitch
                devices.wristPitch.setPosition(devices.wristPitch.getPosition()+servoSpeed);
            }
            if (gamepad1.dpad_up) { // servo 4 ccw
                devices.wristPitch.setPosition(devices.wristPitch.getPosition()-servoSpeed);
            }
        }
    }
}