package org.firstinspires.ftc.teamcode.nathanstuff;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="BasicTeleopNothingNew")
public class BasicTeleopNothingNew extends LinearOpMode {

    public void runOpMode() {
        Devices devices = new Devices(hardwareMap);

        waitForStart();

        while(opModeIsActive()) {

        }
    }
}
