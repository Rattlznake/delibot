package org.firstinspires.ftc.teamcode.nathanstuff;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.robotcore.external.Telemetry;

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

            double leftStickY = -gamepad1.left_stick_y;

            double servoPower = 0.01;
            double dcMotorPower = 0.5;

            if (Math.abs(rightStickY) > 0.2) { // wrist pitch changing code
                devices.wristPitch.setPosition(wristPitchPos+(rightStickY/100));
            }
            if (Math.abs(rightStickX) > 0.2) { // wrist roll changing code
                devices.wristRoll.setPosition(wristRollPos+(rightStickX/100));
            }

            if (gamepad1.right_bumper) { // right claw ccw
                devices.rightClaw.setPosition(rightClawPos+servoPower);
            }
            if (gamepad1.right_trigger > 0.2) { // right claw cw
                devices.rightClaw.setPosition(rightClawPos-servoPower);
            }

            if (gamepad1.left_bumper) { // left claw ccw
                devices.leftClaw.setPosition(leftClawPos+servoPower);
            }
            if (gamepad1.left_trigger > 0.2) { // left claw cw
                devices.leftClaw.setPosition(leftClawPos-servoPower);
            }

            devices.slides.setMode(DcMotor.RunMode.RUN_USING_ENCODER); // set to constant rotation
            devices.wormGear.setMode(DcMotor.RunMode.RUN_USING_ENCODER); // set to constant rotation

            if (Math.abs(leftStickY) > 0.2) { // handle movement for worm gear (arm pitch)
                devices.wormGear.setPower(dcMotorPower*leftStickY);
            } else {
                devices.wormGear.setPower(0);
            }

            if (gamepad1.dpad_up) { // handle movement for slides (arm extension)
                devices.slides.setPower(dcMotorPower);
            } else if (gamepad1.dpad_down) {
                devices.slides.setPower(-dcMotorPower);
            } else {
                devices.slides.setPower(0);
            }

            devices.slides.setTargetPosition(devices.slides.getCurrentPosition());

            // dc motor telemetry
            telemetry.addData("Slide extension: ",slidesPos);
            telemetry.addData("Worm Gear Position: ",wormGearPos);

            // servo telemetry
            telemetry.addData("Wrist Pitch Servo Position: ",wristPitchPos);
            telemetry.addData("Wrist Roll Servo Position: ",wristRollPos);
            telemetry.addData("Right Claw Servo Pos: ",rightClawPos);
            telemetry.addData("Left Claw Servo Pos: ",leftClawPos);

            telemetry.update(); // post this data
        }
    }
}
