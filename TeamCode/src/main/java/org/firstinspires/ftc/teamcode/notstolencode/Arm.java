package org.firstinspires.ftc.teamcode.notstolencode;

import com.qualcomm.robotcore.hardware.Gamepad;

public class Arm {
    Devices dev;
    Gamepad gamepad;
    public Arm(Devices devices, Gamepad gpad) {
        this.dev = devices;
        this.gamepad = gpad;
    }
}
