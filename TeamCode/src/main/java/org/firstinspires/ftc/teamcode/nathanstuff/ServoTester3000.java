package org.firstinspires.ftc.teamcode.nathanstuff;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="Servo Tester 3000")
public class ServoTester3000 extends LinearOpMode {

    // A: Servo1 clockwise
    // dpad down: Servo1 counter-clockwise
    // B: Servo2 clockwise
    // dpad right: Servo2 counter-clockwise
    // X: Servo3 clockwise
    // dpad left: Servo3 counter-clockwise
    // Y: Servo4 clockwise
    // dpad up: Servo4 counter-clockwise
    public void runOpMode() {
        Devices dev = new Devices(hardwareMap);

        double servoSpeed = 0.005;

        waitForStart();

        while (opModeIsActive()) {
            if (gamepad1.a) { // servo 1 cw -- left claw
                dev.leftClaw.setPosition(dev.leftClaw.getPosition()+servoSpeed);
            }
            if (gamepad1.dpad_down) { // servo 1 ccw
                dev.leftClaw.setPosition(dev.leftClaw.getPosition()-servoSpeed);
            }
            if (gamepad1.b) { // servo 2 cw -- right claw
                dev.rightClaw.setPosition(dev.rightClaw.getPosition()+servoSpeed);
            }
            if (gamepad1.dpad_left) { // servo 2 ccw
                dev.rightClaw.setPosition(dev.rightClaw.getPosition()-servoSpeed);
            }
            if (gamepad1.x) { // servo 3 cw -- wrist roll
                dev.wristRoll.setPosition(dev.wristRoll.getPosition()+servoSpeed);
            }
            if (gamepad1.dpad_right) { // servo 3 ccw
                dev.wristRoll.setPosition(dev.wristRoll.getPosition()-servoSpeed);
            }
            if (gamepad1.y) { // servo 4 cw -- wrist pitch
                dev.wristPitch.setPosition(dev.wristPitch.getPosition()+servoSpeed);
            }
            if (gamepad1.dpad_up) { // servo 4 ccw
                dev.wristPitch.setPosition(dev.wristPitch.getPosition()-servoSpeed);
            }
        }
    }
}