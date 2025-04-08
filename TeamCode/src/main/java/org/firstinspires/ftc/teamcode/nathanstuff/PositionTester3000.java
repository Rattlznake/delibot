package org.firstinspires.ftc.teamcode.nathanstuff;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="Position Tester 3000")
public class PositionTester3000 extends LinearOpMode {

    public void runOpMode() {
        Devices devices = new Devices(hardwareMap);

        waitForStart();

        while(opModeIsActive()) {
            int slidesPos = devices.slides.getCurrentPosition();
            int wormGearPos = devices.wormGear.getCurrentPosition();

            double wristPitchPos = devices.wristPitch.getPosition();
            double wristRollPos = devices.wristRoll.getPosition();
            double rightClawPos = devices.rightClaw.getPosition();
            double leftClawPos = devices.leftClaw.getPosition();

            double rightStickX = gamepad1.right_stick_x;
            double rightStickY = -gamepad1.right_stick_y;

            if (Math.abs(rightStickY) > 0.2) {
                devices.wristPitch.setPosition(wristPitchPos+(rightStickY/100));
            }
            if (Math.abs(rightStickX) > 0.2) {
                devices.wristRoll.setPosition(wristRollPos+(rightStickX/100));
            }
        }
    }
}
